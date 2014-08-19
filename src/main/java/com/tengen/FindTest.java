package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by askos on 19/08/14.
 */
public class FindTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB coursedb = client.getDB("course");
        DBCollection collection = coursedb.getCollection("findTest");
        collection.drop();

        for(int i=0;i<10;i++){
            collection.insert(new BasicDBObject("x", new Random().nextInt(100)));
        }

        DBObject doc = new BasicDBObject().append("x",1);
        DBObject doc2 = new BasicDBObject().append("x",2);


        System.out.println("Find one:");
        DBObject one = collection.findOne();
        System.out.println(one);
        System.out.println("\nFind all:");
        DBCursor cursor = collection.find();
        try {
            while (cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        }finally {
            cursor.close();
        }
        System.out.println("\nCount:");
        long count = collection.count();
        System.out.println(count);

    }
}
