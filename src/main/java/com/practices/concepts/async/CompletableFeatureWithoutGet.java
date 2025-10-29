package com.practices.concepts.async;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFeatureWithoutGet {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// with return type
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Returning String Type-1";
		});
		
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Returning String Type-2";
		});
		
		var list = Arrays.asList(cf1, cf2).toArray();
		
//		CompletableFuture<Void> allCF = CompletableFuture.allOf(list);
		

		
	}

}
