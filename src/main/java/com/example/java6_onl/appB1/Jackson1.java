package com.example.java6_onl.appB1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson1 {
    public static void main(String[] args) throws IOException {
        demo1();
    }

    private static void demo1() throws IOException {
        String json = "{\n" +
                "           \"name\":\"Son cao bui\",\n" +
                "           \"sex\": \"Nam\",\n" +
                "           \"age\" : 22,\n" +
                "           \"contact\":{\n" +
                "               \"email\":\"sonbuidr07@gmail.com\",\n" +
                "               \"phone\" : \"0941299095\"\n" +
                "           },\n" +
                "           \"subjects\": [\"Java6\",\"Java5\"]\n" +
                "       }";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\PC\\IdeaProjects\\Java6_1\\src\\main\\resources\\data2.json"));
//
//        System.out.println(jsonNode.get("name").asText());
//        System.out.println(jsonNode.get("contact").get("email").asText());
//        System.out.println(jsonNode.findValue("phone").asText());

        jsonNode.iterator().forEachRemaining(
                a-> {
                    System.out.println("Name" +a.get("name").asText());
                }
        );
    }
}
