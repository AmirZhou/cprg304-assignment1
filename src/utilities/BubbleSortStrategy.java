package utilities;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortStrategy<T> implements SortingStrategy<T> {
	
	@Override
	public T[] sort(T[] arr, Comparator<? super T> comparator) {
		
		if( arr == null || comparator == null) {
			throw new IllegalArgumentException("Array and Comparator must not be null");
		}
		
		if (arr.length == 1) {
			return arr;
		}
		
		T[] result = Arrays.copyOf(arr, arr.length);
		
		for(int k = 1; k < result.length ; k ++) {
			
			for (int i = 0; i < result.length - k; i ++) {
				int cmpareResult = comparator.compare(result[i], result[i+1]);
				if (cmpareResult < 0) {
					T temp = result[i];
					result[i] = result[i+1];
					result[i+1] = temp;
				}
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "Bubble Sort Strategy";
	}
}
