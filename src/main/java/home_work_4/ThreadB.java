package home_work_4;

public class ThreadB extends Thread{
    OutMess mess;

    ThreadB(OutMess mess){
        this.mess = mess;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            mess.out('B');
        }
    }
}
