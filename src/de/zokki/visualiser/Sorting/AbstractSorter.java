package de.zokki.visualiser.Sorting;

import java.awt.Color;

import de.zokki.visualiser.GUI.Column;
import de.zokki.visualiser.Utils.Settings;

public class AbstractSorter extends Thread {

    protected Column[] columns;

    protected AbstractSorter() {
	columns = Column.getColumns();
    }

    protected void sleep() {
	try {
	    Settings.getInstance().panel.repaint();
	    Thread.sleep(Settings.getInstance().getDelay());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    protected void swap(int i, int j) {
	double tempPercentage = columns[j].getPercentageHeight();
	columns[j].setPercentageHeight(columns[i].getPercentageHeight());
	columns[i].setPercentageHeight(tempPercentage);
    }

    @SuppressWarnings("deprecation")
    public void kill() {
	for (Column column : columns) {
	    column.setColor(Color.RED);
	}
	Settings.getInstance().panel.repaint();
	stop();
    }
}
