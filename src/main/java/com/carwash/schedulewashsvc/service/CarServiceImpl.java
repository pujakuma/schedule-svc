package com.carwash.schedulewashsvc.service;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.schedulewashsvc.model.Car;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

public class CarServiceImpl implements CarService {
	
	@Autowired
	private GridFsTemplate gridFsTemplate;

	@Autowired
	private GridFsOperations operations;

	/*public String addPhoto(String model, MultipartFile file) throws IOException {
		Car car = new Car(model);
		car.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		car = repo.insert(car);
		return car.getId();
	}

	public Car getPhoto(String id) {
		return repo.findById(id).get();
	}*/

	public Car getPhoto(String id) throws IllegalStateException, IOException {
		GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		Car car = new Car();
		car.setModel(file.getMetadata().get("title").toString());
		car.setImage(operations.getResource(file).getInputStream());
		return car;
	}

	public String addPhoto(String model, MultipartFile file) throws IOException {
		DBObject metaData = new BasicDBObject();
		metaData.put("type", "image");
		metaData.put("model", model);
		ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getName(), file.getContentType(), metaData);
		return id.toString();
	}

}
