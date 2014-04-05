
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.*;

public class Main {

    public static void main (String[] args){

        System.out.println("mongoConnect App.");

        try {

            MongoClient mongoClient = new MongoClient( "10.29.210.41" , 27017 );
            DB db = mongoClient.getDB( "javaDB" );
            //boolean auth = db.authenticate(myUserName, myPassword);


            /**
             * Printing collections
             */
            System.out.println("\n Listing all collections");
            Set<String> colls = db.getCollectionNames();

            for (String s : colls) {
                System.out.println(s);
            }


            /**
             * get  collection data
             */

            DBCollection namesC = db.getCollection("names");
            DBObject namesO = namesC.findOne();
            System.out.println("\n Get collection data");
            System.out.println(namesO);


            /**
             * Insert json to a collection
             */
            BasicDBObject myJson = new BasicDBObject("name","Arthur").
                                    append("lastname", "Rimbaud");

            System.out.println(myJson);
            //namesC.insert(myJson);


            /**
             * get all documents
             */
            System.out.println("\n Get all documents from a collection");
            DBCursor namesCur = namesC.find();
            try{
                while (namesCur.hasNext()){
                    System.out.println(namesCur.next());
                }
            }finally {
                namesCur.close();
            }



        } catch (UnknownHostException e) {
            System.err.println("Connection failed: " + e);
        }

    }


} //Class Main
