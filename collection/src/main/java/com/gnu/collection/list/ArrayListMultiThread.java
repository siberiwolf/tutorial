package com.gnu.collection.list;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuejiawei@lohogames.com on 2017-07-18
 */
public class ArrayListMultiThread
{
	public static void main(String[] args)
		throws InterruptedException
	{
		AtomicInteger finishedThreadNum = new AtomicInteger(0);
		int threadNum = 50000;

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < threadNum; i++)
		{
			int temp = i;
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					list.add(temp);
					finishedThreadNum.incrementAndGet();
				}
			}).start();
		}

		while (finishedThreadNum.get() < threadNum) {
			Thread.sleep(100);
		}
		System.out.println(list.size());
		Gson gson = new Gson();
		System.out.println(gson.toJson(list));
	}
}
