package com.practices.concepts.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class BasicsCompletableFeature {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// Default constructor
		CompletableFuture<String> cf1 = new CompletableFuture<String>();
		cf1.complete("Hello");
		String result1 = cf1.get();
		System.out.println(result1);
		
		
		// Empty return type
		CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
		    try {
				Thread.sleep(2000);
				System.out.println("Just an empty CompletableFuture");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		// with return type
		CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
			return "Returning String Type";
		});
		
		System.out.println(cf3.get());
		
		// If we not use this line, then cf2 will be terminated without complete execution
		System.out.println(cf2.get());
		
		// with return type
		CompletableFuture<String> cf4 = CompletableFuture.supplyAsync(() -> {
			return "Returning String Type";
		});
		
		var thenApplyCallback = cf4.thenApply(val -> val + " from then apply callback");
		System.out.println(thenApplyCallback.get());
		
		CompletableFuture<String> cf5 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "Returning String Type";
		});

		cf5.thenAccept(val -> System.out.println(val + " from then accept callback"));
		cf5.thenRun(() -> System.out.println("No access to response from then run callback"));
		
		cf5.get();
	}

}
