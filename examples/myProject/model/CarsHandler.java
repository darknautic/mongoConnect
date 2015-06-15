/**
 *  working with database classes and not mix our main class with db methods in this class
 */

package org.codeinmotion.model;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


public class CarsHandler {

	
	 
	 public static String create(Car film){
		 Database db =  new Database();
		 db.getService();			 
		 
		 /*stuff to do when create is called , use methods from Database.java class*/
		 DBObject doc =  new BasicDBObject();
		 doc = CarAdaptor.toDBObject(film);
		 db.insert("films",doc);		 
		 db.close();		 
		 return doc.get("_id").toString();
		 
	 }
	 
	 
	 public static void update(Car film){		 
		 Database db =  new Database();
		 db.getService();		 
		 db.update("films",CarAdaptor.toDBObject(film));
		 db.close();
		 
	 }
	 
	 
	 public static void delete(Car film){		 
		 Database db =  new Database();
		 db.getService();	
		 db.delete("films",CarAdaptor.toDBObject(film));
		 db.close();
		 
	 }
	 
	 	 
	 public static Car load(String id){		 
		 Database db =  new Database();
		 db.getService();			
		 DBObject doc =  new BasicDBObject();
	
		 try{
			 doc = db.loadDocument(id, "films");			 
			 return CarAdaptor.tofilm(doc);
			 
		 } catch(Exception e){
			 System.err.println("filmsHandler : load - document not found " + id );
			 Car film =  new Car() ;
			 return film;
			 
		 } finally{
			 db.close();
			 
		 }
		 
	
	 }
	 
	 private static  List<Car> getDocuments(DBObject query,DBObject fields){		 
		 /**
		  * The inputs are dbObjects that's why is private , not mix this DB classes 
		  * in other projects classes.
		  * 
		  * How to use it.
		  * 
		  * DBObject query =  new BasicDBObject("name","AlfaRomeo");
		 	DBObject fields =  new BasicDBObject("cars",1).append("_id", 0);		 
		 	getDocuments(query,fields).get(0).print();
		 
		  */
		 
		 Database db =  new Database();
		 db.getService();
		 
		 List<DBObject> filmDBObjectList = new ArrayList<DBObject>();
		 List<Car> filmList =  new ArrayList<Car>();

		 
		 filmDBObjectList = db.runQuery(query,fields,"films");
		 
		 for(DBObject dbObject : filmDBObjectList){
			 filmList.add(CarAdaptor.tofilm(dbObject));
		 }
		 
		 db.close();		 		 
		 return filmList;
	     
	 }
	 
	 
	 
	 public static List<Car> getAllDocuments(){		 
		 DBObject query =  new BasicDBObject();
		 DBObject fields =  new BasicDBObject();		 
		 return  getDocuments(query,fields); 		 
		 /*
		  * how to :
		  *  for (film film : filmsHandler.getAllDocuments())
		  *  {
		  * 	film.print();
		  *  }
		  * */
		 		 
	 }
	 
	 
	
}
