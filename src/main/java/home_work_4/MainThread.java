package home_work_4;

public class MainThread {
    public static void main(String[] args) {
        OutMess out = new OutMess();

        ThreadA threadA = new ThreadA(out);
        threadA.start();
        ThreadB threadB = new ThreadB(out);
        threadB.start();
        ThreadC threadC = new ThreadC(out);
        threadC.start();
    }
}
