import java.util.ArrayList;
import java.util.Iterator;

public class Box{
    String name;
    String fruitsInBox;
    ArrayList<Fruit> list = new ArrayList<Fruit>();

    public Box(String name){
        this.name = name;
    }

    public String getFruitsInBox(){
        return this.fruitsInBox;
    }

    public void addFruit(Fruit fruit){
        if (fruitsInBox == null){
            fruitsInBox = fruit.getName();
            list.add(fruit);
        }else if(fruit.getName() == fruitsInBox){
            list.add(fruit);
        }else{
            System.out.println("Impossible to add fruit");
        }
    }

    public void interlard(Box box){
        if(box.getFruitsInBox() == this.getFruitsInBox() || box.getFruitsInBox() == null){
            Iterator<Fruit> fruitIterator = list.iterator();
            while(list.iterator().hasNext()) {
                box.addFruit(fruitIterator.next());
                fruitIterator.remove();
            }
            fruitsInBox = null;
        } else {
            System.out.println("It is impossible to pour");
        }
    }

    public float getWeight(){
        float weight = 0;
        for(Fruit i : list){
            weight += i.getWeight();
        }
        return weight;
    }

    public boolean compare (Box box){
        return (this.getWeight() == box.getWeight());
    }
}
