package com.zxb.Concurrency.cookbook;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPoolExecutor   extends ScheduledThreadPoolExecutor{

	//14. 实现类的构造函数，只要调用它的父类的构造函数。
	public MyScheduledThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
	}

	//15. 实现方法 decorateTask()。它接收将要被运行的 Runnable 对象和将运行 Runnable 对象的 RunnableScheduledFuture 任务作为参数。使用这些对象来构造来创建并返回 MyScheduledTask 任务。
	@Override
	//译者：前面那个<V>是打错吧多余的吧？
	protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
		MyScheduledTask<V> myTask=new MyScheduledTask<V>(runnable, null, task,this);
		return myTask;
	}

	//16. 覆盖方法 scheduledAtFixedRate()。调用它的父类的方法，调用它的父类的方法，  method. Call the method of its parent class, convert the returned object into a MyScheduledTask object, and establish the period of that task using the setPeriod() method.

	@Override
	//译者：不知道怎么出现？号的。应该是V。
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		ScheduledFuture<?> task= super.scheduleAtFixedRate(command, initialDelay, period, unit);
		MyScheduledTask<?> myTask=(MyScheduledTask<?>)task;
		myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period,unit));
		return task;
	}
}
