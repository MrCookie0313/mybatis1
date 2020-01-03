package com.cookie.mybatis.service;

import com.cookie.mybatis.model.Person;

import java.io.*;

public class TestPersonSerialize {

    public static void main(String[] args) throws Exception {
//        serializePerson();
        Person p = deserializePerson();
        System.out.println(p.getName()+";"+p.getAge());
        
        
    }
    
    private static void serializePerson() throws FileNotFoundException, IOException {
        Person person = new Person();
        person.setName("测试实例");
        person.setAge(25);
        person.setSex("male");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("D:/person.txt")));
        oo.writeObject(person);
        System.out.println("序列化成功");
        oo.close();
    }
    
    private static Person deserializePerson() throws IOException, Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("反序列化成功");
        return person;
    }
}
