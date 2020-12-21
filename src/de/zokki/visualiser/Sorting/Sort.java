package de.zokki.visualiser.Sorting;

import java.awt.Color;

import de.zokki.visualiser.Utils.Column;

public class Sort extends AbstractSorter {
    
    public Sort() {
	super();
    }
    
    @Override
    public void run() {
	for (int i = 0; i < columns.size(); i++) {
	    Column blue = columns.get(i);
	    blue.setColor(Color.BLUE);
	    for (int j = i + 1; j < columns.size(); j++) {
		Column black = columns.get(j);
		black.setColor(Color.BLACK);
		if (blue.getPercentageHeight() > black.getPercentageHeight()) {
		    swap(i, j);
		}
		sleep();
		black.setColor(Color.RED);
	    }
	    blue.setColor(Color.RED);
	}
	finished();
    }
}
