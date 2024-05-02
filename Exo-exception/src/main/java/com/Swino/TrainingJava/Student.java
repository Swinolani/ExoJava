package com.Swino.TrainingJava;

public class Student{
    private String stuName;
    private int stuAge;

    public Student(String stuName, int stuAge) throws InvalidAgeException{
        this.stuName = stuName;
        if(stuAge>=0){
        this.stuAge = stuAge;

        }else{
            throw new InvalidAgeException();
        }
    }

    public String getStuName() {
        return stuName;
    }

    public int getStuAge() {
        return stuAge;
    }
}
