package ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SimpleThreadPool extends Thread{
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		IntStream.range(0, 10).forEach( n -> executor.execute( ()->
		{
			try {
				TimeUnit.MILLISECONDS.sleep(300);
				String threadName = Thread.currentThread().getName();
				System.out.println("Hello "+threadName);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		})
		);

	}

}
