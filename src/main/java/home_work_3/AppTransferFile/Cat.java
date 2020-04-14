package home_work_3.AppTransferFile;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info(){
        System.out.println(name + " " + age + " " + paws);
    }
}
