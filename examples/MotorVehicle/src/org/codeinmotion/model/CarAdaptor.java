/**
 * converter  DBObject << -- >> FilmObject
 */

package org.codeinmotion.model;

import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class CarAdaptor {


	
	public static final DBObject toDBObject(Car film) {
		 
		 DBObject filmObj = new BasicDBObject();
		 
		 if(film.get_id() != null){
			 
			 ObjectId  Id = new ObjectId(film.get_id()); 			 
			 filmObj = new BasicDBObject("_id",Id).append( "name", film.getName());
			 
		 }
		 else{
			 
			 ObjectId newId = new ObjectId();		 
			 filmObj = new BasicDBObject("_id",newId).append( "name", film.getName());
		 }
		 
		 
		 
		 return filmObj;
		 
	 }
	
	
	
	public static final Car tofilm(DBObject filmDBObject){
		
		Car film =  new Car();
		
		film.set_id(filmDBObject.get("_id").toString());
		film.setName(filmDBObject.get("name").toString());
		
		
		return film;
	}
	 
	 	 

}
