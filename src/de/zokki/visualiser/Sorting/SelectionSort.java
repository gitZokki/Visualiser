package de.zokki.visualiser.Sorting;

import java.awt.Color;

import de.zokki.visualiser.Utils.Column;

public class SelectionSort extends AbstractSorter {

    public SelectionSort() {
	super();
    }

    @Override
    public void run() {
	for (int i = 0; i < columns.size(); i++) {
	    columns.get(i).setColor(Color.BLUE);
	    int swapIndex = i;
	    for (int j = i + 1; j < columns.size(); j++) {
		Column black = columns.get(j);
		Column swap = columns.get(swapIndex);
		black.setColor(Color.BLACK);
		if (black.getPercentageHeight() < swap.getPercentageHeight()) {
		    swapIndex = j;
		}
		sleep();
		black.setColor(Color.RED);
	    }
	    swap(i, swapIndex);

	    columns.get(i).setColor(Color.RED);
	}
	finished();
    }

}
