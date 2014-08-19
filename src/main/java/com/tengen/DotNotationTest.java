package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by askos on 19/08/14.
 */
public class DotNotationTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("course");
        DBCollection lines = db.getCollection("DotNotationTest");
        lines.drop();
        Random rand = new Random();

        // insert 10 lines with random start and end points
        for (int i = 0; i < 10; i++) {
            lines.insert(
                    new BasicDBObject("_id", i)
                            .append("start",
                                    new BasicDBObject("x", rand.nextInt(90) + 10)
                                            .append("y", rand.nextInt(90) + 10)
                            )
                            .append("end",
                                    new BasicDBObject("x", rand.nextInt(90) + 10)
                                            .append("y", rand.nextInt(90) + 10)
                            )
            );
        }

        QueryBuilder builder = QueryBuilder.start("start.x").greaterThan(50);

        DBCursor cursor = lines.find(builder.get(),
                new BasicDBObject("start.y", true).append("_id", false));

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
