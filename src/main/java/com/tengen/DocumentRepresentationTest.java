package com.tengen;

import com.mongodb.BasicDBObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by askos on 19/08/14.
 */
public class DocumentRepresentationTest {
    public static void main(String[] args) {
        BasicDBObject doc = new BasicDBObject();
        doc.put("username","askos");
        doc.put("birthdate",new Date(10/9/1992));
        doc.put("languages", Arrays.asList("greek","albanian","english"));
        doc.put("address",new BasicDBObject("street","kydonion").append("number",15));
    }

    }