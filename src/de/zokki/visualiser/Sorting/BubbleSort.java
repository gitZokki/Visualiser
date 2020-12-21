package de.zokki.visualiser.Sorting;

import java.awt.Color;

import de.zokki.visualiser.Utils.Column;

public class BubbleSort extends AbstractSorter {

    public BubbleSort() {
	super();
    }

    @Override
    public void run() {
	Color nColor = new Color(255, 150, 150);
	boolean swapped = false;
	int n = 0;
	do {
	    swapped = false;
	    columns.get(n).setColor(nColor);
	    for (int i = columns.size() - 2; i >= n; i--) {
		Column black = columns.get(i);
		Column blue = columns.get(i + 1);
		black.setColor(Color.BLACK);
		blue.setColor(Color.BLUE);
		if (black.getPercentageHeight() > blue.getPercentageHeight()) {
		    swap(i, i + 1);
		    swapped = true;
		    black.setColor(Color.GREEN);
		    blue.setColor(Color.GREEN);
		}
		sleep();
		black.setColor(Color.RED);
		blue.setColor(Color.RED);
	    }
	    columns.get(n).setColor(Color.RED);
	    n++;
	} while (swapped);
	finished();
    }
}
