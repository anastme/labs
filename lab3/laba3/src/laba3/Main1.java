package laba3;

import laba3.Radix1;

public class Main1 {
		    public static void main(String[] args) {
	        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

	        Radix1.radixSort(arr);

	        System.out.println("Sorted array:");
	        for (int i : arr) {
	            System.out.print(i + " ");
	        }
	    }
	}

