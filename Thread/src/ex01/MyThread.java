package ex01;

public class MyThread extends Thread{
	public void run() {
		MyThread t1 = new MyThread();
		t1.start();
	}
}
