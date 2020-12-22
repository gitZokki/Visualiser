package de.zokki.visualiser.Sorting;

import de.zokki.visualiser.Utils.Column;

public class SelectionSort extends AbstractSorter {

    public SelectionSort() {
	super();
    }

    @Override
    public void run() {
	for (int i = 0; i < columns.size(); i++) {
	    Column standing = columns.get(i);
	    standing.setColor(standingColumn);
	    
	    int swapIndex = i;
	    for (int j = i + 1; j < columns.size(); j++) {
		Column moving = columns.get(j);
		Column swap = columns.get(swapIndex);
		moving.setColor(movingColumn);
		if (moving.getPercentageHeight() < swap.getPercentageHeight()) {
		    swapIndex = j;
		}
		sleep();
		moving.setColor(standardColumn);
	    }
	    swap(i, swapIndex);
	    columns.get(i).setColor(finisedColumn);
	    
	    standing.setColor(standardColumn);
	}
	finished();
    }

}
