package de.zokki.visualiser.Sorting;

import java.awt.Color;

public class InsertionSort extends AbstractSorter {

    public InsertionSort() {
	super();
    }
    
    @Override
    public void run() {
	for (int i = 1; i < columns.length; i++) {
	    double tempPercentage = columns[i].getPercentageHeight();
	    int j = i;
	    while (j > 0 && columns[j - 1].getPercentageHeight() > tempPercentage) {
		columns[j].setColor(Color.BLUE);
		columns[j].setPercentageHeight(columns[j - 1].getPercentageHeight());
		j--;
		sleep();
	    }
	    columns[j].setColor(Color.BLACK);

	    columns[j].setPercentageHeight(tempPercentage);
	    resetColor();
	}
	finished();
    }
}
