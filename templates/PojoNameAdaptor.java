package packagePath;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PojoNameAdaptor {

	
	
	public static final DBObject toDBObject(PojoName pojoObjectName) {
		 
		 DBObject pojoObjectNameObj = new BasicDBObject();
		 
		 if(pojoObjectName.get_id() != null){
			 
			 //DBObject 
			 pojoObjectNameObj = new BasicDBObject("_id",pojoObjectName.get_id()).append( "name", pojoObjectName.getName());
			 
		 }
		 else{
			 //DBObject 
			 pojoObjectNameObj = new BasicDBObject( "name", pojoObjectName.getName());
		 }
		 
		 
		 
		 return pojoObjectNameObj;
		 
	 }
	
	
	
	public static final PojoName toPojoName(DBObject pojoObjectNameDBObject){
		
		PojoName pojoObjectName =  new PojoName();
		
		pojoObjectName.set_id(pojoObjectNameDBObject.get("_id").toString());
		pojoObjectName.setName(pojoObjectNameDBObject.get("name").toString());
		
		
		return pojoObjectName;
	}
	 
	 	 

}
