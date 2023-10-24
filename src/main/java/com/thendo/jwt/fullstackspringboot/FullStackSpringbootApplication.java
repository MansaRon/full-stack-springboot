package com.thendo.jwt.fullstackspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@SpringBootApplication
public class FullStackSpringbootApplication {

	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 5, 10, 15, 19, 25, 30};
		// reverseArray(arr);
		// reverseWords("Thendo");
		// primeNumbers(arr);
		// hashMap();
		SpringApplication.run(FullStackSpringbootApplication.class, args);
	}

	public static String reverseWords(String word) {
		String words = "";
		char characters;

		for (int i = 0; i < word.length(); i++) {
			characters = word.charAt(i);
			words = words + characters;
		}
		System.out.println(words);
		return words;
	}

	public static void reverseArray(int[] numbers) {
		Collections.reverse(Arrays.asList(numbers));
		// System.out.println(Collections.reverse(Arrays.asList(numbers)));
	}

	public static void primeNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i + " are the prime numbers in the array.");
			}
		}
	}

	public static void hashMap() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("a", 1);
		hashMap.put("b", 2);
		hashMap.put("c", 3);
		hashMap.put("d", 4);

		System.out.println(hashMap);
	}

}
