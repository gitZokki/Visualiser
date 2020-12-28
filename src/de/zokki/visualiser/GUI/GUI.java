package de.zokki.visualiser.GUI;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import de.zokki.visualiser.Utils.OSValidator;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private boolean maxed = false;

    private Panel panel;

    public GUI(String name, int width, int height) {
	super(name);
	setMinimumSize(new Dimension(width, height));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setFocusable(true);

	panel = new Panel(width, height);
	setContentPane(panel);
	pack();
	setVisible(true);

	addWindowStateListener(new WindowStateListener() {
	    @Override
	    public void windowStateChanged(WindowEvent e) {
		if (e.getNewState() == JFrame.MAXIMIZED_BOTH && !maxed) {
		    setFullScreen();
		}
	    }
	});

	addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (maxed && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		    maxed = false;
		    setSize(width, height);
		    dispose();
		    setUndecorated(false);
		    setVisible(true);
		} else if (!maxed && e.getKeyCode() == KeyEvent.VK_F11) {
		    setFullScreen();
		}
	    }
	});

	panel.randomizeColumns();
    }

    private void setFullScreen() {
	maxed = true;
	if (OSValidator.IS_UNIX) {
	    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	    gd.setFullScreenWindow(this);
	} else {
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    dispose();
	    setUndecorated(true);
	    setVisible(true);
	}
    }
}
