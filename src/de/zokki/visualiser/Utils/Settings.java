package de.zokki.visualiser.Utils;

public class Settings {

    private static Settings instance;
    
    private int columnsCount = 50;
    private int delay = 25;
    
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
