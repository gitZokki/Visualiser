package de.zokki.visualiser.GUI;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import de.zokki.visualiser.Utils.OSValidator;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private Panel panel;

    private Rectangle bounds = getBounds();
    
    public GUI(String name, int width, int height) {
	super(name);
	setMinimumSize(new Dimension(width, height));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setFocusable(true);

	panel = new Panel(width, height, this);
	setContentPane(panel);
	pack();
	setVisible(true);

	addWindowStateListener(new WindowStateListener() {
	    @Override
	    public void windowStateChanged(WindowEvent e) {
		if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
		    setFullScreen();
		}
	    }
	});
	
	addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
		setBounds();
	    }

	    @Override
	    public void componentMoved(ComponentEvent e) {
		setBounds();
	    }
	});

	addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		setScreenSize(e.getKeyCode());
	    }
	});

	panel.randomizeColumns();
    }
    
    public void setScreenSize(int e) {
	if (getExtendedState() == JFrame.MAXIMIZED_BOTH && e == KeyEvent.VK_ESCAPE) {
	    setBounds(bounds);
	    dispose();
	    setUndecorated(false);
	    setVisible(true);
	} else if (getExtendedState() != JFrame.MAXIMIZED_BOTH && e == KeyEvent.VK_F11) {
	    setFullScreen();
	}
    }
    
    public void setFullScreen() {
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
    
    private void setBounds() {
	if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
	    bounds = getBounds();
	}
    }
}
