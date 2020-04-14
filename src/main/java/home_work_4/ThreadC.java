package home_work_4;

public class ThreadC extends Thread {
    OutMess mess;

    ThreadC(OutMess mess){
        this.mess = mess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            mess.out('C');
        }
    }
}
