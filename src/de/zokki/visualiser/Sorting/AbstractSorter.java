package de.zokki.visualiser.Sorting;

import java.awt.Color;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JRootPane;

import de.zokki.visualiser.GUI.Column;
import de.zokki.visualiser.GUI.Panel;
import de.zokki.visualiser.Utils.Settings;

public class AbstractSorter extends Thread {

    protected Column[] columns;

    private Panel panel;
    
    protected AbstractSorter() {
	columns = Column.getColumns();
	panel = (Panel) ((Container) ((JRootPane) Window.getWindows()[0].getComponent(0)).getComponent(1))
		.getComponent(0);
    }

    protected void sleep() {
	try {
	    panel.repaint();
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
	resetColor();
	stop();
    }

    protected void finished() {
	resetColor();
	panel.finished();
    }

    protected void resetColor() {
	for (Column column : columns) {
	    column.setColor(Color.RED);
	}
	panel.repaint();
    }
}
