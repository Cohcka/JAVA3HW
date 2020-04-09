package home_work_1;

public class Cat {
    String name;
    String color;
    int age;

    public Cat (String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString (){
        return name;
    }
}
