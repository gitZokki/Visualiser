package de.zokki.visualiser.Utils;

import java.awt.Color;
import java.util.ArrayList;

public class Column {
    
    private double percentageHeight;
    
    private Color color;
    
    private static ArrayList<Column> columns;
    
    public Column(double percentageHeight, Color color) {
	setPercentageHeight(percentageHeight);
	setColor(color);
    }
    
    public double getPercentageHeight() {
        return percentageHeight;
    }
    
    public void setPercentageHeight(double percentage) {
        this.percentageHeight = percentage;
    }

    public Color getColor() {
	return color;
    }

    public void setColor(Color color) {
	this.color = color;
    }

    public static ArrayList<Column> getColumns() {
        return columns;
    }

    public static void setColumns(ArrayList<Column> columns) {
	columns.trimToSize();
        Column.columns = columns;
    }
}
