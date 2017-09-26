package com.gnu.collection.list;

import com.gnu.collection.pojo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siberiwolf@hotmail.com on 2017-06-27
 */
public class ArrayListDemo {
    public static void main(String args[]){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三"));
        list.add(new Student(2, "李四"));

        // shadow copy, list != copy, list[0] == copy[0]
        ArrayList<Student> copy = (ArrayList<Student>) list.clone();
        System.out.println(list == copy);
        System.out.println(list.get(0) == copy.get(0));
    }


}
