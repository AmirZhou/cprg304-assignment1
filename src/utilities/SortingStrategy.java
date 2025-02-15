package utilities;

import java.util.Comparator;

/**
 * This is the interface for all sorting algorithms in this assignment.
 * 
 * @author Yue (Amir) Zhou
 * @version 0.1
 * @since 2025 
 */
public interface SortingStrategy<T> {
	
	public abstract T[] sort(T[] arr, Comparator<? super T> comparator);
}

