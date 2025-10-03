package com.tka;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Person1{
    protected String name;
    protected int age;

    abstract void displayInfo();
}
class Student1 extends Person1{
    private int id;
    private double marks;

    public Student1(String name, int age, int id, double marks) {
        this.id = id;
        if(marks>=0 && marks<=100){
        this.marks = marks;
        }else{
            System.out.println("please enter marks under 0 to 100 ");
        }
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if(marks >= 0 && marks <= 100) {
            this.marks = marks;
        }else{
            System.out.println("Invalid Marks");
            this.marks = 0;
        }
    }

    @Override
    void displayInfo() {
        System.out.println("id : " +id+ "  Student name : " +name+ ", age : " +age+ ", marks : " +marks);
    }
}

class Teacher1 extends Person1{
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher1(String subject, String name, int age) {
            this.subject = subject;
            this.name = name;
            this.age = age;
    }

    @Override
    void displayInfo() {
        System.out.println("Teacher name : " +name+ ", Age : " +age+ ", Subject : " +subject);
    }
}

public class StudentMangement1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student1> students = new ArrayList<>();
        Teacher1 t = new Teacher1("DSA", "Jay" , 29);
        t.displayInfo();
        int choice;

        do{
            System.out.println("\n 1. Add Student");
            System.out.println(" 2. Show All Student");
            System.out.println(" 3. Show Topper Among Student");
            System.out.println(" 4. Exit ");
            System.out.println("Enter choice ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("ID : ");
                    int id = sc.nextInt();

                    System.out.println("Name : ");
                    String name = sc.next();

                    System.out.println("Age : ");
                    int age = sc.nextInt();

                    System.out.println("Marks : ");
                    double marks = sc.nextDouble();
                    Student1 s = new Student1(name, age, id, marks);
                    s.setMarks(marks);
                    students.add(s);
                    System.out.println("Added successfully ");
                    break;

                case 2:
                    System.out.println("\n All Student");
                    for (Student1 st : students) {
                        st.displayInfo();
                    }
                    break;

                case 3:
                    System.out.println("\n Top Student");
                    Student1 top = null;
                    if (students.isEmpty()) {
                        System.out.println("No Student present");
                    } else {
                        top = students.get(0);
                        for (Student1 st : students) {
                            if (st.getMarks() > top.getMarks()) {
                                top = st;
                            }
                        }
                    }
                    System.out.println("\n Top Student");
                    top.displayInfo();
                    break;
                case 4:
                    System.out.println("Existing ...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

            }while(choice != 4);
sc.close();
        }
    }

