package de.zokki.visualiser.Sorting;

import de.zokki.visualiser.Utils.Column;

public class Sort extends AbstractSorter {
    
    public Sort() {
	super();
    }
    
    @Override
    public void run() {
	for (int i = 0; i < columns.size(); i++) {
	    for (int j = i + 1; j < columns.size(); j++) {
		Column standing = columns.get(i);
		Column moving = columns.get(j);
		standing.setColor(standingColumn);
		moving.setColor(movingColumn);
		if (standing.getPercentageHeight() > moving.getPercentageHeight()) {
		    moving.setColor(swappedColumn);
		    standing.setColor(swappedColumn);
		    swap(i, j);
		}
		sleep();
		resetColor(j, j+1);
	    }
	    columns.get(i).setColor(finisedColumn);
	}
	finished();
    }
}
