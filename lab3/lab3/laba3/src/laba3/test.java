package laba3;
	import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;

public class test {

	    @Test
	    public void testRadixSort() {
	        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
	        Radix.radixSort(arr);
	        assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, arr);
	    }

	    @Test
	    public void testRadixSortWithNegativeNumbers() {
	        int[] arr = {170, -45, 75, -90, 802, -24, 2, 66};
	        Radix.radixSort(arr);
	        assertArrayEquals(new int[]{-90, -45, -24, 2, 66, 75, 170, 802}, arr);
	    }

	    @Test
	    public void testRadixSortWithDuplicates() {
	        int[] arr = {170, 45, 75, 45, 802, 24, 2, 66};
	        Radix.radixSort(arr);
	        assertArrayEquals(new int[]{2, 24, 45, 45, 66, 75, 170, 802}, arr);
	    }

	    @Test
	    public void testRadixSortWithEmptyArray() {
	        int[] arr = {};
	        Radix.radixSort(arr);
	        assertArrayEquals(new int[]{}, arr);
	    }

	    @Test
	    public void testRadixSortWithNullArray() {
	        int[] arr = null;
	        Radix.radixSort(arr);
	        assertNull(arr);
	    }
	}

