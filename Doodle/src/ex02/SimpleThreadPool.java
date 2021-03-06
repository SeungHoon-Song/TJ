package ex02;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Future<Integer> future = executor.submit(() -> {
			TimeUnit.MILLISECONDS.sleep(2000);
			int result = integers.stream().mapToInt(i -> i.intValue()).sum();
			return result;
		});

		try {
			Integer result = future.get();
			System.out.println("result: " + result);
			executor.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
