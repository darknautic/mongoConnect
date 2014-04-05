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

            Set<String> colls = db.getCollectionNames();

            for (String s : colls) {
                System.out.println(s);
            }


        } catch (UnknownHostException e) {
            System.err.println("Connection failed: " + e);
        }

    }


} //Class Main
