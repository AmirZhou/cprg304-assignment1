package utilities;
import java.util.Arrays;
import java.util.Comparator;

public class SelectionSortStrategy<T> implements SortingStrategy<T> {
	
	public T[] sort(T[] arr, Comparator<? super T> comparator) {
		
		if( arr == null || comparator == null) {
			throw new IllegalArgumentException("Array and Comparator must not be null");
		}
		if (arr.length == 1) {
			return arr;
		}
		
		T[] result = Arrays.copyOf(arr, arr.length);
		
		// find the largest element and SWAP it with the first element, util only one element remains
		
		for (int i = 0; i < result.length -1; i ++) {
			
			// find the max in the remaining
			int max = i;
			for (int j = i; j < result.length; j++ ) {
				//find the largest here
				if (comparator.compare(result[j], result[max]) > 0) {
					max = j;
				}
			}
			
			// swap max and the [i]
			if(max != i) {
				T temp = result[max];
				
				// shift result[i::max-1] to result[i+1::max]
				System.arraycopy(result, i, result, i+1, max-i);
				
				result[i] = temp;
			}
		}		
		return result;
	}
	
	@Override
	public String toString() {
		return "Selection Sort Strategy";
	}
}
