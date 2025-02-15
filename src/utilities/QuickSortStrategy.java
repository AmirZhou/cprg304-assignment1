package utilities;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSortStrategy<T> implements SortingStrategy<T> {
	
	
	@Override
	public T[] sort(T[] arr, Comparator<? super T> comparator) {
		
		T[] result = Arrays.copyOf(arr, arr.length);
		quickSort(result, 0, result.length -1, comparator);
		
		return result;
	}
	
	
	private void quickSort(T[] arr, int l, int r, Comparator<? super T> comparator) {
		if (r > l) {
			int m = hoaresPartition(arr, l, r, comparator);
		
			quickSort(arr, l, m, comparator);
			quickSort(arr, m + 1, r, comparator);
		}
	}
	
	
	private int hoaresPartition(T[] arr, int l, int r, Comparator<? super T> comparator) {
		
		// select a pivot, in this case let it be the middle one
		T pivot = arr[(r - l) / 2 + l];
		
		// Two pointers
		int i = l;
		int j = r;
		
		while (true) {
			
			while (comparator.compare(arr[i], pivot) > 0) {
				i ++;
			}
			
			while (comparator.compare(arr[j], pivot) < 0) {
				j --;
			}

			// if j already less than i, it won't swap.
			if (j <= i ) {
				return j;
			}
			
			// swap
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			// after the swap, current i and j are in correct side, and we ++i and --j
			i ++;
			j --;
		}
	}
	
	@Override
	public String toString() {
		return "Quick Sort Strategy";
	}
}
