package ex01;

public class MyThread2 implements Runnable {
	@Override
	public void run() {
//		Runnable r = new MyThread2();
		Thread t2 = new Thread();
		t2.start();
		
	}
}
