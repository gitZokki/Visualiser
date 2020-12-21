package de.zokki.visualiser.Sorting;

import java.awt.Color;

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
		Column blue = columns.get(j);
		blue.setColor(Color.BLUE);
		blue.setPercentageHeight(columns.get(j - 1).getPercentageHeight());
		j--;
		sleep();
	    }
	    columns.get(j).setColor(Color.BLACK);

	    columns.get(j).setPercentageHeight(tempPercentage);
	    resetColor();
	}
	finished();
    }
}
