package utilities;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSortStrategy<T> implements SortingStrategy<T> {
	
	@Override
	public T[] sort(T[] arr, Comparator<? super T> comparator) {
		
		if( arr == null || comparator == null) {
			throw new IllegalArgumentException("Array and Comparator must not be null");
		}
		if (arr.length == 1) {
			return arr;
		}
		
		T[] result = Arrays.copyOf(arr, arr.length);
		for (int i = 1; i < arr.length; i++) {
			
			for (int j = 0; j < i; j ++) {
				if (comparator.compare(result[j], result[i]) < 0) {
					// store current 
					T temp = result[i];
					// shift the part
					System.arraycopy(result, j, result, j+1, i-j);
					// insert into j-1
					result[j] = temp;
				}
				// don't do anything if nothing happened in the for loop.
				// since result[i] is in its right position, currently
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "Insertion Sort Strategy";
	}
}
