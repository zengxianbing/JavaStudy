package com.zxb.guava3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class TestLoadingCache {

	@Test
	public void TestLoadingCache() throws ExecutionException{
		LoadingCache<String,String> cacheBuilder=CacheBuilder.newBuilder()
         .build(new CacheLoader<String,String>(){

			@Override
			public String load(String key) throws Exception {
				String strProValue="hello"+key+"!";
				
				
				return strProValue;
				
				
			}
        	 
         });
		
		
		System.out.println("jerry value:"+cacheBuilder.apply("jerry"));
		System.out.println("jerry value:"+cacheBuilder.get("jerry"));
		System.out.println("peida value:"+cacheBuilder.get("peida"));
		System.out.println("peida value:"+cacheBuilder.apply("peida"));
		System.out.println("lisa value:"+cacheBuilder.apply("lisa"));

		cacheBuilder.put("harry", "ssss");
		System.out.println("harry value:"+cacheBuilder.get("harry"));
		
	}
	
	@Test
	public void testcallableCache() throws ExecutionException{
		Cache<String,String> cache=CacheBuilder.newBuilder().maximumSize(1000).build();
		String resultVal=cache.get("jerry", new Callable<String>(){

			@Override
			public String call() throws Exception {

				String strPorValue="hello"+"jerry"+"!";
				return strPorValue;
			}
			
		});
		
		System.out.println("jerry value:"+resultVal);
		
		resultVal=cache.get("peida", new Callable<String>(){

			@Override
			public String call() throws Exception {
			 
				String strProValue="hello"+"peida"+"!";
				return  strProValue;
			}
			
		});
		
		
		
		System.out.println("peida value:"+resultVal);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	
//	public <K,V> LoadingCache<K,V> cached(CacheLoader<K,V> cachelOader)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
