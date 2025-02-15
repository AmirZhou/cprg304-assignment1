package utilities;

import java.util.Arrays;
import java.util.Comparator;



/**
 * MergeSort:
 * 
 * How it works: 
 * 1. Merge two sorted half, so that it doesn't need to backtrack,
 * and only needs to compare the current first element.
 * 2. A single element is already sorted.
 * 
 * How it's implemented:
 * 1. split the array into half, and apply merge sort on both of them.
 * @param <T>
 */
public class MergeSortStrategy<T> implements SortingStrategy<T> {
	
	@Override
	public T[] sort(T[] arr, Comparator<? super T> comparator) {
		
		T[] result = Arrays.copyOf(arr, arr.length);
		
		mergeSort(result, comparator);
		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	private void mergeSort(T[] arr, Comparator<? super T> comparator) {
		
		// assume this mergeSort returns a sorted array
		// if it splits it into two 
		// apply merge sort on both of them, so that they are sorted.	
		// merge both together, so that the array is sorted.

		if (arr.length > 1) {
			int m = arr.length / 2;
			
			T[] arr1 = (T[]) new Object[m];
			System.arraycopy(arr, 0, arr1, 0, m);
			mergeSort(arr1, comparator);
			
			T[] arr2 = (T[]) new Object[arr.length - m];
			System.arraycopy(arr, m, arr2, 0, arr.length -m);
			mergeSort(arr2, comparator);			

			merge(arr1, arr2, arr, comparator);
		}
	}
	
	
	private void merge(T[] arr1, T[] arr2, T[] arr3, Comparator<? super T> comparator) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		// case 1, both in range, compare and apply
		while (i < arr1.length && j < arr2.length) {
			if (comparator.compare(arr1[i], arr2[j]) > 0) {
				arr3[k++] = arr1[i++];
			} else {
				arr3[k++] = arr2[j++];
			}
		}
		
		// case 2 and 3, one of them run out range, apply the rest from the other one		
		while (i < arr1.length) {
			arr3[k++] = arr1[i++];
		}
		
		while (j < arr2.length) {
			arr3[k++] = arr2[j++];
		}
	}
	
}
