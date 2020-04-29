package home_work_8;

public class SpiralArray {

    static int size = 7;
    static int[][] array = new int[size][size];
    static int vectorV = 0;
    static int vectorH = 0;
    static int v = 0;
    static int h = 0;

    public static void main (String[] args){

        for (int i = 1; i <= array.length*array.length; i++) {
            while(true) {
                if (v + vectorV > -1 && v + vectorV < array.length && h + vectorH > -1 && h + vectorH < array.length) {
                    if (array[v + vectorV][h + vectorH]==0) {
                        v += vectorV;
                        h += vectorH;
                        array[v][h] = i;
                        break;
                    } else {
                        SwapDirection();
                    }
                }else{
                    SwapDirection();
                }
            }
        }
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                System.out.print(" [ " + array[y][x] + " ] ");
            }
            System.out.println();
        }
    }

    public static void SwapDirection () {

        if(vectorV == 0 && vectorH == 0){
            vectorV = 0;
            vectorH = 1;
            return;
        } else if(vectorV == 0 && vectorH == 1){
            vectorV = 1;
            vectorH = 0;
            return;
        } else if(vectorV == 1 && vectorH == 0){
            vectorV = 0;
            vectorH = -1;
            return;
        } else if(vectorV == 0 && vectorH == -1){
            vectorV = -1;
            vectorH = 0;
            return;
        } else if(vectorV == -1 && vectorH == 0){
            vectorV = 0;
            vectorH = 1;
            return;
        }
    }
}
