package de.zokki.visualiser.Sorting;

import java.awt.Color;

import de.zokki.visualiser.GUI.Column;

public class Sort extends AbstractSorter {
    
    public Sort() {
	super();
    }
    
    @Override
    public void run() {
	for (int i = 0; i < columns.length; i++) {
	    columns[i].setColor(Color.BLUE);
	    for (int j = i + 1; j < columns.length; j++) {
		columns[j].setColor(Color.BLACK);
		if (columns[i].getPercentageHeight() > columns[j].getPercentageHeight()) {
		    swap(i, j);
		}
		sleep();
		columns[j].setColor(Color.RED);
		Column.setColumns(columns);
	    }
	    columns[i].setColor(Color.RED);
	}
    }
}
