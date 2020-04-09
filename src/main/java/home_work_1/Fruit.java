package home_work_1;

public abstract class Fruit {
    float weight;
    String name;

    public Fruit(String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public float getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }
}
