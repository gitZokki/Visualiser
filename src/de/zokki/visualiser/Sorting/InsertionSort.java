package de.zokki.visualiser.Sorting;

import de.zokki.visualiser.Utils.Column;

public class InsertionSort extends AbstractSorter {

    public InsertionSort() {
	super();
    }
    
    @Override
    public void run() {
	for (int i = 1; i < columns.size(); i++) {
	    double tempPercentage = columns.get(i).getPercentageHeight();
	    int j = i;
	    while (j > 0 && columns.get(j - 1).getPercentageHeight() > tempPercentage) {
		Column column = columns.get(j);
		column.setColor(movingColumn);
		column.setPercentageHeight(columns.get(j - 1).getPercentageHeight());
		j--;
		sleep();
		column.setColor(standingColumn);
	    }
	    
	    columns.get(j).setPercentageHeight(tempPercentage);
	    resetColor(j, i);
	}
	finished();
    }
}
