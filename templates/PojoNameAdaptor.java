/**
 * converter  DBObject << -- >> FilmObject
 */

package packagePath;

import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PojoNameAdaptor {


	
	public static final DBObject toDBObject(PojoName film) {
		 
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
	
	
	
	public static final PojoName tofilm(DBObject filmDBObject){
		
		PojoName film =  new PojoName();
		
		film.set_id(filmDBObject.get("_id").toString());
		film.setName(filmDBObject.get("name").toString());
		
		
		return film;
	}
	 
	 	 

}
