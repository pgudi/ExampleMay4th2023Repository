package com.sgtesting.threaddemo;
class MyClass1 implements Runnable
{
	public void run()
	{
		showEvenNumbers();
	}
	
	synchronized void showEvenNumbers()
	{
		try
		{
			System.out.println("Display of Even Numbers...");
			for(int i=20;i<=40;i++)
			{
				if(i%2==0)
				{
					System.out.println(Thread.currentThread().getName()+" Displays Even Number :"+i);
					Thread.sleep(1000);
				}
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
public class ThreadDemo1 {
	public static void main(String[] args) {
		MyClass1 job=new MyClass1();
		
		Thread t1=new Thread(job);
		Thread t2=new Thread(job);

		t1.setName("alpha");
		t2.setName("omega");
		t1.start();
		t2.start();
	}

}
