package de.zokki.visualiser.Sorting;

import java.util.ArrayList;

import de.zokki.visualiser.Utils.Column;

public class MergeSort extends AbstractSorter {

    public MergeSort() {
	super();
    }

    @Override
    public void run() {
	sort(columns);
	finished();
    }

    private ArrayList<Column> sort(ArrayList<Column> columns) {
	int size = columns.size();
	if (size <= 1) {
	    return columns;
	} else {
	    ArrayList<Column> left = new ArrayList<Column>(columns.subList(0, size / 2));
	    ArrayList<Column> right = new ArrayList<Column>(columns.subList(size / 2, size));

	    left = sort(left);
	    right = sort(right);
	    return merge(left, right);
	}
    }

    private ArrayList<Column> merge(ArrayList<Column> left, ArrayList<Column> right) {
	int start = columns.indexOf(left.get(0));
	ArrayList<Column> sorted = new ArrayList<Column>();

	while (!left.isEmpty() && !right.isEmpty()) {
	    if (left.get(0).getPercentageHeight() <= right.get(0).getPercentageHeight()) {
		sorted.add(left.get(0));
		left.remove(0);
	    } else {
		sorted.add(right.get(0));
		right.remove(0);
	    }
	}
	while (!left.isEmpty()) {
	    sorted.add(left.get(0));
	    left.remove(0);
	}
	while (!right.isEmpty()) {
	    sorted.add(right.get(0));
	    right.remove(0);
	}

	for (Column column : sorted) {
	    columns.set(start++, column);
	    sleep();
	}

	return sorted;
    }
}