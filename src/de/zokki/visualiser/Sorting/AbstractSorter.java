package de.zokki.visualiser.Sorting;

import java.awt.Color;
import java.awt.Container;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JRootPane;

import de.zokki.visualiser.GUI.Panel;
import de.zokki.visualiser.Utils.Column;
import de.zokki.visualiser.Utils.Settings;

public class AbstractSorter extends Thread {

    protected final Color standardColumn = Color.RED;
    protected final Color movingColumn = Color.BLUE;
    protected final Color standingColumn = Color.BLACK;
    protected final Color swappedColumn = Color.CYAN;
    protected final Color finisedColumn = Color.GREEN;

    protected ArrayList<Column> columns;

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
	Column tempPercentage = columns.get(j);
	columns.set(j, columns.get(i));
	columns.set(i, tempPercentage);
	panel.repaint();
    }

    @SuppressWarnings("deprecation")
    public void kill() {
	resetColor();
	stop();
    }

    protected void finished() {
	setColorOfColumns(finisedColumn, 0, columns.size());
	panel.finished();
    }

    protected void resetColor() {
	setColorOfColumns(standardColumn, 0, columns.size());
    }
    
    protected void resetColor(int start, int end) {
	setColorOfColumns(standardColumn, start, Math.min(end, columns.size()));
    }
    
    private void setColorOfColumns(Color color, int start, int end) {
	for (int i = start; i < end; i++) {
	    columns.get(i).setColor(color);
	}
	panel.repaint();
    }
}
