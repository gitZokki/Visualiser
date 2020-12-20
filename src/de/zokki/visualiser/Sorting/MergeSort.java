package de.zokki.visualiser.Sorting;

import java.util.Arrays;

import de.zokki.visualiser.GUI.Column;

public class MergeSort extends AbstractSorter {

    public MergeSort() {
	super();
    }

    @Override
    public void run() {
	sort(columns);
	finished();
    }

    Column[] sort(Column[] arr) {
	int size = arr.length;
	if (size > 1) {
	    int mid = size / 2;
	    Column[] left = Arrays.copyOfRange(arr, 0, mid);
	    left = sort(left);
	    Column[] right = Arrays.copyOfRange(arr, mid, size);
	    right = sort(right);
	    arr = merge(left, right);
	}
	return arr;
    }

    Column[] merge(Column[] left, Column[] right) {
	int leftSize = left.length;
	int rightSize = right.length;
	Column[] arr = new Column[leftSize + rightSize];
	int i = 0, leftIndex = 0, rightIndex = 0;
	while (leftIndex < leftSize && rightIndex < rightSize) {
	    if (left[leftIndex].getPercentageHeight() < right[rightIndex].getPercentageHeight()) {
		arr[i++] = left[leftIndex++];
	    } else {
		arr[i++] = right[rightIndex++];
	    }
	}
	while (leftIndex < leftSize) {
	    arr[i++] = left[leftIndex++];
	}
	while (rightIndex < rightSize) {
	    arr[i++] = right[rightIndex++];
	}
	return arr;
    }
}
