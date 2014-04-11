package com.projectC;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by austsa01 on 10/04/2014.
 */
public class stockC {

    public int _offset;

    public stockC(){}

    public int riseBy(int i ){
        int result = 0;
        result = i + _offset;
        return result;
    }


    public Set<String> collectionList(String dbName){

        Set<String> theList = new HashSet<String>();


        try{
            MongoClient mongoClient = new MongoClient("10.29.210.41",27017);
            DB db = mongoClient.getDB(dbName);
            theList = db.getCollectionNames();


        }
        catch (UnknownHostException e){
            System.err.println("Connection failed: " + e);
        }





        return theList;

    }




}
