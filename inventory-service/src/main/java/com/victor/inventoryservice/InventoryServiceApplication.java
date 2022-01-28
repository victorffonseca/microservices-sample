package com.victor.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication
public class InventoryServiceApplication {

	static int[] myArray = {1,2,1,3,3,1,2,1,5,1};

	public static void main(String[] args) {
		//SpringApplication.run(InventoryServiceApplication.class, args);

		Arrays.sort(myArray);

		for(int i = 1; i <= myArray[myArray.length - 1]; i++){
			System.out.print(i + ": ");
			for (int j : myArray) {
				if (i == j) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
