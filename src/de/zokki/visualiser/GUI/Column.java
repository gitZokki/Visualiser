package de.zokki.visualiser.GUI;

import java.awt.Color;

public class Column {
    
    private double percentageHeight;
    
    private Color color;
    
    private static Column[] columns;
    
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

    public static Column[] getColumns() {
        return columns;
    }

    public static void setColumns(Column[] columns) {
        Column.columns = columns;
    }
}
