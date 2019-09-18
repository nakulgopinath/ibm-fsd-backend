package service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class ThreadExecutorEg {

	public ThreadExecutorEg() {
		// TODO Auto-generated constructor stub
	}
	
	public class Sample implements Callable<String>{
	
		public String call() throws Exception {
			
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			try {
				System.out.println(Thread.currentThread().getName() + " -->going to sleep");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			} catch (InterruptedException e) {
				//throw new MyException();
			}
			System.out.println(Thread.currentThread().getName() + " -->Stop thread");
		
	
			return "Sample";
		
		
		
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		

	ThreadExecutorEg teg = new ThreadExecutorEg(); 
	Callable<String> c1 = teg.new Sample();
	
	ExecutorService e = Executors.newFixedThreadPool(1);
	
	Future f =  e.submit(c1);
	
	while(!f.isDone())
	{
		String s =null;
		s=(String) f.get();
		System.out.println(s);
		System.out.print("Execution Done");
		e.shutdown();

	

	}
	}

}
