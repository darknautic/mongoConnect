package org.codeinmotion.model;


import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.*;
import org.bson.types.ObjectId;


public class Database {
 
   
    private String hostname;
    private int port;
    private String dbName;
    private DB db = null;
    private MongoClient mongoClient = null;


    public Database(){
    }


    public Database(String hostname, int port,String dbName){
    	//TODO set user & password for secure reasons
    	this.hostname=hostname;
    	this.port=port;
    	this.dbName=dbName;
    }


    public void connect() throws Exception {   
    	 mongoClient = new MongoClient(hostname,port);
		 db = mongoClient.getDB(dbName);		 
		 /* useful for multiple host in HA Architecture*/
		 //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    
    }
    

    public void close(){
        mongoClient.close();
        
    }

    
    
    
    public  void getService(){    	
		/** If you want to use another database services in the runtime you must create another getService2,3,4.. methods*/
    	
    	 try {
			mongoClient = new MongoClient("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 db = mongoClient.getDB("testDB");

		 
    }
    
    
    public void insert(String collectionName, DBObject newDocument){
    	DBCollection collection = db.getCollection(collectionName);
    	collection.insert(newDocument);
    	
    }
    
    public void insert(String collectionName, List<DBObject> newDocuments){
    	DBCollection collection = db.getCollection(collectionName);
    	collection.insert(newDocuments);
    	
    }
    
    
    public void update(String collectionName,DBObject update){    	
    	DBCollection collection = db.getCollection(collectionName);
    	DBObject query = new BasicDBObject("_id", update.get("_id"));		                            
    	//collection.findAndModify(query, update);    	
    	collection.update(query, update);
    	
    }
 
    
    public void delete(String collectionName,DBObject document) {    
    	DBCollection collection = db.getCollection(collectionName);
    	collection.remove(document);
    	
    }
    
    
    
    public DBObject loadDocument(String id, String collectionName) throws MongoException{    	
    	DBCollection collection = db.getCollection(collectionName);
    	DBObject query =  new BasicDBObject("_id",new ObjectId(id));
    	DBObject doc =  new BasicDBObject();    	
    	doc = collection.findOne(query);	    	    	
    	return doc;
    	
    }
 
    
    
    /* In MongoDB we query by example(it is a document DB), 
     * building up a document that looks like the document we are looking for.*/
    
    //public  List<Map<String,Object>>runQuery(Map<String,Object> query,String collectionName){
    public  List<DBObject>runQuery(DBObject query,DBObject fields,String collectionName){    	
    	List<DBObject> resultSet =  new ArrayList<DBObject>();    	
    	DBCollection collection = db.getCollection(collectionName);
    	DBCursor cursor = collection.find(query,fields);
    	//DBObject q =  new BasicDBObject("name","Audi");
    	//DBCursor cursor = collection.find(q);
    	
    	//List obj = collection.find( query ).skip( 1000 ).limit( 100 ).toArray();
    	 
    	while( cursor.hasNext() ){
    		 resultSet.add(cursor.next());
    	}    	    
    	    	
    	return resultSet;
    	
    }
    
    
    
    
    public static List<String> stringFormattedToStringList(String s) {
        //public static List<String> stringFormattedToStringList(String s) {
            List<String> result = new ArrayList<String>();
            List<String> aux;
            aux =  Arrays.asList(s.substring(1,s.length()-1).replaceAll("\"", "").split(","));
            // .substring  removes the first an last characters from the string ('[' & ']')
            // .replaceAll removes all quotation marks from the string (replaces with empty string)
            // .split brakes the string into a string array on commas (omitting the commas)
            // Arrays.asList converts the array to a List
            /**
             * Example of string that handle
             * [ "auto 1", "auto 2", "auto 3"]
             *
             */

            for(int i=0;i<aux.size() ; i++) {
                result.add(aux.get(i).trim()); //.trim() - clean extra white spaces
            }

            return result;
            
        }

	       
	
	
}
