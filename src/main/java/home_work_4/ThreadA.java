package home_work_4;

public class ThreadA extends Thread {
    OutMess mess;

    ThreadA(OutMess mess){
        this.mess = mess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            mess.out('A');
        }
    }
}
