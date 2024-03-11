package com.example.java6_onl.appB1;

import com.example.java6_onl.bean.SinhVien2;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson2 {
    public static void main(String[] args) throws IOException {
        demo5();
    }

    private static void demo5() throws IOException {
        Map<String,Object> contact = new HashMap<>();
        contact.put("email","mapday@gmail.com");
        contact.put("phone","035888339");

        List subjects = Arrays.asList("Toan","Khoa hoc");

        Map<String,Object> student = new HashMap<>();
        student.put("name","hihi");
        student.put("sex","Ngao");
        student.put("age",12);
        student.put("contact",contact);
        student.put("subjects",subjects);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out,student);


    }

    //Tao ra du lieu Json = JsonNode
    private static void demo4() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode student = mapper.createObjectNode();
        student.put("name","toi la ai trong e ?");
        student.put("sex","Nam");
        student.put("age",19);

        ObjectNode contact = student.putObject("contact");
        contact.put("email","sonbuidr07 nhe");
        contact.put("phone","999999");

        ArrayNode subjects = student.putArray("subjects");
        subjects.add("Toan");
        subjects.add("Van");

        String json = mapper.writeValueAsString(student);
        mapper.writeValue(System.out,student);
        //or..
        mapper.writeValue(new File("C:\\Users\\PC\\hihi.json"),student);



    }

    //Demo 3 dung class mo ta
    private static void demo3() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SinhVien2 sinhVien2 = objectMapper.readValue(new File("C:\\Users\\PC\\IdeaProjects\\Java6_1\\src\\main\\resources\\data2.json"),SinhVien2.class);

        System.out.println(sinhVien2.getName());
        System.out.println(sinhVien2.getSubjects());
        System.out.println(sinhVien2.getContact().getEmail());

        List list = sinhVien2.getSubjects();
        list.stream().forEach(
                n-> System.out.println(n)
        );
    }
    //Demo1,2 dung map
    private static void demo2() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> list =objectMapper.readValue(new File("C:\\Users\\PC\\IdeaProjects\\Java6_1\\src\\main\\resources\\data2.json"),List.class);
        list.stream().forEach(
                n-> System.out.println(n.get("name"))
        );



    }

    //Demo1,2 dung map
    private static void demo1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String , Object> map = objectMapper.readValue(new File("C:\\Users\\PC\\IdeaProjects\\Java6_1\\src\\main\\resources\\data.json"),Map.class);
        System.out.println(map.get("contact"));

       //Contact : email,..
        Map<String,Object> map1 = (Map<String, Object>) map.get("contact");
        System.out.println(map1.get("email"));

        //
        List<String> list = (List<String>) map.get("subjects");
        list.stream().forEach(
                n-> System.out.println(n)
        );


    }
}
