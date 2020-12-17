package de.zokki.visualiser.GUI;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import de.zokki.visualiser.Utils.Settings;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    Panel panel;

    public GUI(String name, int width, int height) {
	super(name);
	setMinimumSize(new Dimension(width, height));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);

	panel = new Panel(width, height);
	Settings.getInstance().panel = panel;
	setContentPane(panel);
	pack();
	setVisible(true);

	
	addWindowStateListener(new WindowStateListener() {
	    @Override
	    public void windowStateChanged(WindowEvent e) {
		if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
		    setExtendedState(JFrame.MAXIMIZED_BOTH);
		    dispose();
		    setUndecorated(true);
		    setVisible(true);
		}
	    }
	});

	panel.randomizeColumns();
	initSorter();
    }

    private void initSorter() {
//	new BubbleSort().sort();
//	new InsertionSort().sort();
//	new SelectionSort().sort();
//	new Sort().sort();
    }
}
