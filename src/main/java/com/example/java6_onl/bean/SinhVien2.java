package com.example.java6_onl.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVien2 {
    private String name;
    private String sex;
    private Integer age;
    private Contact contact;
    private List subjects;
}
