package com.springpoc.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

//Main.java
public class Main {
    static Person methodCall(String name){

        return new Person(s);
    }
    public static void main(String[] args) {
        //make a random String generator method with any length
          Random random=new Random();

        //make an arrangement in these classes where you can count the numebr of objects created.
        List<String> list= Arrays.asList("Ram","Ravi","mahesh");
       long num= list.stream().map(x->x.length()>10).count();
       System.out.println(num);
        //make 50 objects of Person class and 60 objects of Admin class

       String name="";

        for(int i=0;i<50;i++){
            Main.methodCall(name);
        }
        for(int i=0;i<60;i++){
            Main.methodCall(name);
        }

        Admin admin=new Admin("Hello");
    }
}


class Person{
    String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Admin extends Person{
    String dept;

    public String getDept() {
        return dept;
    }

    public Admin(String name) {
        super(name);
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

//    public Admin() {
//        super(name);
//    }


}
