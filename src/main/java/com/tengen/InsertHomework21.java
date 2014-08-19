package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by askos on 19/08/14.
 */
public class InsertHomework21 {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient client = new MongoClient();
        DB coursedb = client.getDB("students");
        DBCollection collection = coursedb.getCollection("grades");
        QueryBuilder builder = QueryBuilder.start("type").is("exam")
                .and("score").greaterThanEquals(65);
        DBObject query = new BasicDBObject("score",new BasicDBObject("&gte",65)).append("type", "exam");
        DBCursor cursor = collection.find(builder.get())
                .sort(new BasicDBObject("score", 1));
        try {
            while (cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        } finally {
            cursor.close();
        }

    }
}
