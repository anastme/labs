package laba3;
import java.util.Arrays;
public class Radix1 {
	

	    public static void radixSort(int[] arr) {
	        if (arr == null || arr.length == 0) {
	            return;
	        }

	        int max = Arrays.stream(arr).max().getAsInt();
	        for (int exp = 1; max / exp > 0; exp *= 10) {
	            countingSort(arr, exp);
	        }
	    }

	    private static void countingSort(int[] arr, int exp) {
	        int n = arr.length;
	        int[] ans = new int[n];
	        int[] cur = new int[10];

	        for (int i = 0; i < n; i++) {
	            cur[(arr[i] / exp) % 10]++;
	        }

	        for (int i = 1; i < 10; i++) {
	            cur[i] += cur[i - 1];
	        }

	        for (int i = n - 1; i >= 0; i--) {
	            ans[cur[(arr[i] / exp) % 10] - 1] = arr[i];
	            cur[(arr[i] / exp) % 10]--;
	        }

	        System.arraycopy(ans, 0, arr, 0, n);
	    }
	}

