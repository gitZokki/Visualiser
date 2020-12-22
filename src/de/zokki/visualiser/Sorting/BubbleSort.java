package de.zokki.visualiser.Sorting;

import de.zokki.visualiser.Utils.Column;

public class BubbleSort extends AbstractSorter {

    public BubbleSort() {
	super();
    }

    @Override
    public void run() {
	boolean swapped = false;
	int n = 0;
	do {
	    columns.get(n).setColor(standingColumn);
	    swapped = false;
	    for (int i = columns.size() - 2; i >= n; i--) {
		Column movingFirst = columns.get(i);
		Column movingSecond = columns.get(i + 1);
		movingFirst.setColor(movingColumn);
		movingSecond.setColor(movingColumn);
		if (movingFirst.getPercentageHeight() > movingSecond.getPercentageHeight()) {
		    swap(i, i + 1);
		    swapped = true;
		    movingFirst.setColor(swappedColumn);
		    movingSecond.setColor(swappedColumn);
		}
		sleep();
		movingFirst.setColor(standardColumn);
		movingSecond.setColor(standardColumn);
	    }
	    columns.get(n).setColor(finisedColumn);
	    n++;
	} while (swapped);
	finished();
    }
}
