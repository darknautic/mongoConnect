package packagePath;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PojoNamesHandler {


	
	 
	 public static void create(PojoName pojoObjectName){  
	
		 Database db =  new Database();
		 db.getService();	
		 
		 /*stuff to do when create, call methods from Database.java class*/
		 db.insert("dbCollection",PojoNameAdaptor.toDBObject(pojoObjectName));		 
		 db.close();
		 
	 }
	 
	 
	 
	 private static  List<PojoName> getDocuments(DBObject query,DBObject fields){
		 
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
		 
		 List<DBObject> pojoObjectNameDBObjectList = new ArrayList<DBObject>();
		 List<PojoName> pojoObjectNameList =  new ArrayList<PojoName>();

		 
		 pojoObjectNameDBObjectList = db.runQuery(query,fields,"dbCollection");
		 
		 for(DBObject dbObject : pojoObjectNameDBObjectList){
			 pojoObjectNameList.add(PojoNameAdaptor.toPojoName(dbObject));
		 }
		 
		 db.close();
		 
		 		 
		 return pojoObjectNameList;
	     
	 }
	 
	 
	 
	 public static List<PojoName> getAllDocuments(){
		 
		 DBObject query =  new BasicDBObject();
		 DBObject fields =  new BasicDBObject();		 
		 return  getDocuments(query,fields); 
		 
		 /*
		  * how to :
		  *  for (PojoName pojoObjectName : PojoNamesHandler.getAllDocuments())
		  *  {
		  * 	pojoObjectName.print();
		  *  }
		  * */
		 		 
	 }
	 
	 


	
}
