package mySsm;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test1 implements Runnable{
	
	private ThreadLocal<Student> threadLocal=new ThreadLocal<Student>(){

		@Override
		protected Student initialValue() {
			Random random = new Random();
	        int age = random.nextInt(100);
			Student s =new Student();
			s.setId(age);
			s.setName("name"+age);
			return s;
		}
		
	};
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--"+threadLocal.get());
	}
	public static void main(String[] args) {
		Test1 t =new Test1();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(t);
		}
		exec.shutdown();
//		new Thread(t,"A").start();
//		new Thread(t,"B").start();
//		new Thread(t,"C").start();
	}

}

class Student {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}