package com.example.java6_onl.appB1;


import com.example.java6_onl.SinhVienInterface;
import com.example.java6_onl.bean.SinhVien;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambada implements SinhVienInterface {
    static List<SinhVien> lstSv = Arrays.asList(
            new SinhVien("Son cao", true, 20),
            new SinhVien("Son cao 1", false, 18),
            new SinhVien("Son cao 2", true, 17),
            new SinhVien("Son cao 3", false, 24)
    );
    public static void main(String[] args){
        demo1();
    }

    private static void demo3() {
        SinhVienInterface a = x -> {
            System.out.println(x);
        };
        a.a1(700);
    }

    private static void demo2() {
        Collections.sort(lstSv,(a,b)->a.getName().compareTo(b.getName()));
        lstSv.forEach(n->{
            System.out.println(n.getName());
            System.out.println(n.getAge());

        });

    }

    private static void demo1() {

        lstSv.stream().forEach((n)->{
            System.out.println("ten :"  +n.getName());
            System.out.println("tuoi :" +n.getAge());
        });
    }

    public static void demo(){
        List<Integer> list = Arrays.asList(1,2,3);
        list.forEach((n)->{System.out.println(n);});
    }


    @Override
    public void a1(int b) {
    }
}
