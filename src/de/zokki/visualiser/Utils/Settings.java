package de.zokki.visualiser.Utils;

import de.zokki.visualiser.GUI.Panel;

public class Settings {

    private static Settings instance;
    
    private int columnsCount = 100;
    private int delay = 25;
    
    public Panel panel;
    
    private Settings() {
    }
    
    public static synchronized Settings getInstance() {
	if(instance == null) {
	    instance = new Settings();
	}
	return instance;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public void setColumnsCount(int columnsCount) {
        this.columnsCount = columnsCount;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    
    public String[] getSortingAlgorithms() {
	return new String[] {
		"Bubble Sort", "Insertion Sort", "Selection Sort", "Sort"
	};
    }
}
