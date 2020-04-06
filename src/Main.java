import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        Cat cat1 = new Cat("Barsik", "Black", 5);
        Cat cat2 = new Cat("Tom", "Rainbow", 1);
        Cat[] cats = {cat1, cat2};

        //Task_1
        System.out.println("\nTask_1");
        System.out.println(cats[0].name + " " + cats[1].name);
        Swapper(cats, 0,1);
        System.out.println(cats[0].name + " " + cats[1].name);

        //Task_2
        System.out.println("\nTask_2");
        ArrayList arrayList;
        arrayList = ArrToList(cats);

        //Task_3_a,b,c,g
        Apple a = new Apple();
        Orange o = new Orange();
        Box box1 = new Box("Box 1");
        for (int i = 0; i < 3; i++) {
            box1.addFruit(o);
        }
        box1.addFruit(a);
        System.out.println("\nBox 1 weight: " + box1.getWeight());

        Box box2 = new Box("Box 2");
        for (int i = 0; i < 5; i++) {
            box2.addFruit(a);
        }
        box2.addFruit(o);
        box2.addFruit(a);
        System.out.println("\nBox 2 weight: " + box2.getWeight());


        //Task_3_d,e
        System.out.println("\nWeight box1 = weight box2? " + box1.compare(box2));

        //Task_3_f
        Box box3 = new Box("Box 3");
        //box3.addFruit(a); // Кейс, когда в корзине уже есть яблоко, а мы хотим пересыпать туда апельсины
        box3.addFruit(o); // Кейс, когда в корзине уже есть апельсин, и мы хотим пересыпать туда апельсины
        System.out.println("Box 1 weight: " + box1.getWeight());
        System.out.println("Box 3 weight: " + box3.getWeight());
        box1.interlard(box3);
        System.out.println("After interland:");
        System.out.println("Box 1 weight: " + box1.getWeight());
        System.out.println("Box 3 weight: " + box3.getWeight());
    }

    public static <T> void Swapper(T[] array, int pos1, int pos2) {
        T obj1 = array[pos1];
        T obj2 = array[pos2];
        array[pos1] = obj2;
        array[pos2] = obj1;
    }

    public static <T> ArrayList<T> ArrToList (T[] array){
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        for(T i : list){
            System.out.println(i);
        }
        return list;
    }
}


