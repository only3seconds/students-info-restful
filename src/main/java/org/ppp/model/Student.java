package org.ppp.model;

public class Student {
    private int id;
    private String studentNum;
    private String studentName;
    private int gender;
    private int age;
    private String address;
    private String major;
    private int deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentNum + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
