package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by askos on 19/08/14.
 */
public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB coursedb = client.getDB("course");
        DBCollection collection = coursedb.getCollection("insertTest");

        DBObject doc = new BasicDBObject().append("x",1);
        DBObject doc2 = new BasicDBObject().append("x",2);


        System.out.println(doc);
        collection.insert(Arrays.asList(doc,doc2));
        System.out.println(doc);

    }
}
