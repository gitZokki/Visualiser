package de.zokki.visualiser.Sorting;

import java.awt.Color;

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
	    columns[n].setColor(nColor);
	    for (int i = columns.length - 2; i >= n; i--) {
		columns[i].setColor(Color.BLACK);
		columns[i + 1].setColor(Color.BLUE);
		if (columns[i].getPercentageHeight() > columns[i + 1].getPercentageHeight()) {
		    swap(i, i + 1);
		    swapped = true;
		    columns[i].setColor(Color.GREEN);
		    columns[i + 1].setColor(Color.GREEN);
		}
		sleep();
		columns[i].setColor(Color.RED);
		columns[i + 1].setColor(Color.RED);
	    }
	    columns[n].setColor(Color.RED);
	    n++;
	} while (swapped);
	finished();
    }
}
