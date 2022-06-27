package com.example.tareq;

import java.util.ArrayList;
import java.util.List;

public class  Student {
    public static final String SEIP = "SEIP";
    public static final String PAID = "PAID";
    private String name;
    private  String courseType;
    private  String courseName;


    public Student(String name, String courseType, String courseName) {
        this.name = name;
        this.courseType = courseType;
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public static List<String > paidCourseList = new ArrayList<>();
    public static List<String > seipCourseList = new ArrayList<>();
    public static List<Student > studentList = new ArrayList<>();

    static {

        paidCourseList.add("Master Flutter on Android and ioS");
        paidCourseList.add("Professional android App development with JAva");
        paidCourseList.add("Professional Android App development with kotlin ");
        paidCourseList.add("Web development Using Laravel and Vue");
        paidCourseList.add("Graphics Design");
        paidCourseList.add("Mobile Application Development Android");
        seipCourseList.add("Microsoft Office");
        seipCourseList.add("Basic Computer");
        seipCourseList.add("Android");
        seipCourseList.add("Microsoft Word");
        seipCourseList.add("Server administration");
    }
}
