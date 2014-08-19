package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by askos on 19/08/14.
 */
public class Homework22 {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient client = new MongoClient();
        DB coursedb = client.getDB("students");
        DBCollection collection = coursedb.getCollection("grades");

        QueryBuilder builder = QueryBuilder.start("type").is("homework");
        DBCursor cursor = collection.find(builder.get())
                .sort(new BasicDBObject("student_id", 1).append("score",1));
        Object count=5000;
        try {
            while (cursor.hasNext()) {
                DBObject cur = cursor.next();

                if (count.equals(cur.get("student_id"))){


                }
                else{
                    collection.remove(cur);
                    System.out.println(cur.get("student_id"));
                    System.out.println(cur.get("score"));
                }
                count=cur.get("student_id");

            }
        } finally {
            cursor.close();
        }


    }
}
