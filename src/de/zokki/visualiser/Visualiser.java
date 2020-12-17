package de.zokki.visualiser;

import de.zokki.visualiser.GUI.GUI;

public class Visualiser {

    public static void main(String[] args) {
	new Visualiser();
    }
    
    public Visualiser() {
	new GUI("Sorting Visualiser", 500, 500);
    }
}
