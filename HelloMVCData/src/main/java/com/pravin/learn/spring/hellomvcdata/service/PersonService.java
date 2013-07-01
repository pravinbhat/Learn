package com.pravin.learn.spring.hellomvcdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.pravin.learn.spring.hellomvcdata.model.Person;

@Repository
public class PersonService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "person";

	public void addPerson(Person person) {
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}       
		person.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(person, COLLECTION_NAME);
	}

	public List<Person> listPerson() {
		return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
	}

	public List<Person> searchPerson(String key) {
		Pattern patrn = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
		BasicDBObject query = new BasicDBObject("name", patrn);

		DBCursor cursor = mongoTemplate.getCollection(COLLECTION_NAME).find(query);
		
		List<Person> personList = new ArrayList<Person>();
		while (cursor.hasNext()) {
			DBObject dbObj = cursor.next();
			Person foo = mongoTemplate.getConverter().read(Person.class, dbObj);  
			personList.add((foo) );
		}
		
		return personList;
	}

	public void deletePerson(Person person) {
		mongoTemplate.remove(person, COLLECTION_NAME);
	}

	public void updatePerson(Person person) {
		mongoTemplate.insert(person, COLLECTION_NAME);      
	}
}
