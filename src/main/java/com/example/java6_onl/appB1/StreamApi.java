package com.example.java6_onl.appB1;
import com.example.java6_onl.bean.SinhVien;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    static List<SinhVien> lstSv = Arrays.asList(
            new SinhVien("son cao", true, 20),
            new SinhVien("Son cao 1", false, 18),
            new SinhVien("Son cao 2", true, 17),
            new SinhVien("son cao 3", false, 24)
    );

    public static void main(String[] args) {
        demo5();
    }

    private static void demo5() {
        List<SinhVien> list =
                lstSv.stream()
                        .filter(n->n.getAge()>19)
                        .toList();
        System.out.println(list);
    }

    private static void demo4() {
        double diemTB =
                lstSv.stream()
                        .filter(n->n.getAge()>5)
                        .mapToDouble(n->n.getAge())
                        .average().getAsDouble();
        System.out.println("Tuoi tb : " + diemTB);

        double tongDiem =
                lstSv.stream()
                        .mapToDouble(n->n.getAge())
                        .sum();
        System.out.println("Tong diem : " + tongDiem);

        int min = lstSv.stream()
                .mapToInt(n-> n.getAge())
                .min().getAsInt();
        System.out.println("Min la : " + min);

        boolean a = lstSv.stream()
                .allMatch(n->n.getAge()>10);
        System.out.println("Ket qua >18 : " + a);

        SinhVien sinhVien = lstSv.stream()
                .reduce(lstSv.get(0),(MIN,b) -> MIN.getAge()<b.getAge()?MIN:b);
        System.out.println(sinhVien);
    }

    private static void demo3() {
        List<SinhVien> a = lstSv.stream()
                .filter(n -> n.getAge() > 19)
                .peek(n -> n.setName(n.getName().toUpperCase()))
                .collect(Collectors.toList());

        a.stream().forEach(n ->
                System.out.println(n)
        );
    }

    private static void demo2() {
        List<Double> list = Arrays.asList(2.0, 3.1, 4.2);
        List<Double> b =
                list.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> Math.sqrt(n))
                        .peek(n -> System.out.println(n))
                        .collect(Collectors.toList());
    }

    private static void demo1() {
        Stream<Integer> stream = Stream.of(1, 2, 9, 8);
        stream.forEach(n -> {
            System.out.println(n);
        });
        List<Integer> list = Arrays.asList(3, 4, 2, 1);
        list.forEach(n -> System.out.println(n));
    }
}
