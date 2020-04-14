package home_work_4;

public class OutMess {

    char nextChar = 'A';

    synchronized public void out(char C){
        try {
            while(nextChar != C){
            wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(C);
        switch(C){
            case('A'):
                nextChar = 'B';
                break;
            case('B'):
                nextChar = 'C';
                break;
            case('C'):
                nextChar = 'A';
                break;
        }
        notifyAll();
    }
}
