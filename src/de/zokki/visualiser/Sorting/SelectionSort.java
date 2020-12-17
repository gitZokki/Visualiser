package de.zokki.visualiser.Sorting;

import java.awt.Color;

import de.zokki.visualiser.GUI.Column;

public class SelectionSort extends AbstractSorter {

    public SelectionSort() {
	super();
    }

    @Override
    public void run() {
	for (int i = 0; i < columns.length; i++) {
	    columns[i].setColor(Color.BLUE);
	    int swapIndex = i;
	    for (int j = i + 1; j < columns.length; j++) {
		columns[j].setColor(Color.BLACK);
		if (columns[j].getPercentageHeight() < columns[swapIndex].getPercentageHeight()) {
		    swapIndex = j;
		}
		sleep();
		columns[j].setColor(Color.RED);
		Column.setColumns(columns);
	    }
	    swap(i, swapIndex);

	    columns[i].setColor(Color.RED);
	}
    }

}
