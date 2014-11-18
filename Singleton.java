package conversion.into.different.forms.controller;

public class Singleton{
	
private static volatile Singleton _instance; //volatile variable

public static Singleton getInstance(int priorityCount) throws InterruptedException{

	Thread.currentThread().setPriority(++priorityCount);
   if(_instance == null){
            synchronized(Singleton.class){
              if(_instance == null)
              _instance = new Singleton();
              System.out.println("holds lock======"+Thread.holdsLock(_instance));
              System.out.println("instance is created now");
              Thread.currentThread().yield();
            }

   }else{
	   System.out.println("holds lock in else condition====="+Thread.holdsLock(_instance));
	   System.out.println("instance is already created by above if condition");
   }
   return _instance;
	}
}

