package de.zokki.visualiser.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.zokki.visualiser.Sorting.AbstractSorter;
import de.zokki.visualiser.Sorting.BubbleSort;
import de.zokki.visualiser.Sorting.InsertionSort;
import de.zokki.visualiser.Sorting.MergeSort;
import de.zokki.visualiser.Sorting.SelectionSort;
import de.zokki.visualiser.Sorting.Sort;
import de.zokki.visualiser.Utils.Column;
import de.zokki.visualiser.Utils.Settings;

public class Panel extends JPanel {

    private static final long serialVersionUID = 1L;

    private GUI gui;
    
    private Dimension preferedSize;

    private int width, height;

    private JButton randomiseHeight = new JButton("Randomise height");
    private JButton sort = new JButton("Sort!");
    private JComboBox<String> sortingAlgorithms = new JComboBox<String>();
    private JTextField delay = new JTextField();
    private JTextField columnCount = new JTextField();

    public Panel(int width, int height, GUI gui) {
	this.gui = gui;
	this.preferedSize = new Dimension(width, height);
	this.width = width;
	this.height = height - 50;

	addListener();

	resizeComponents();
	addComponents();
    }

    public void randomizeColumns() {
	int columnsCount = Settings.getInstance().getColumnsCount();
	ArrayList<Column> columns = new ArrayList<Column>();
	for (int i = 0; i < columnsCount; i++) {
	    columns.add(new Column(Math.random() * 100.1d, Color.RED));
	}
	Column.setColumns(columns);
    }

    @Override
    public Dimension getPreferredSize() {
	return preferedSize;
    }

    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	double columnsWidth = width / (double) Settings.getInstance().getColumnsCount();
	ArrayList<Column> columns = Column.getColumns();
	for (int i = 0; i < columns.size(); i++) {
	    g.setColor(columns.get(i).getColor());
	    g.fill3DRect((int) (i * columnsWidth), 50, (int) columnsWidth,
		    (int) (columns.get(i).getPercentageHeight() * (height / (float) 100)), true);
	}
    }

    public void finished() {
	setComponentsEnabled(true);
	sort.setText("Sort!");
	isSorting = false;
    }

    private void addListener() {
	addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
		width = getWidth();
		height = getHeight() - 50;
		repaint();
		resizeComponents();
	    }
	});
    }

    private void resizeComponents() {
	randomiseHeight.setPreferredSize(new Dimension((width / 5) - 5, 40));
	sortingAlgorithms.setPreferredSize(new Dimension((width / 5) - 5, 40));
	delay.setPreferredSize(new Dimension((width / 5) - 5, 40));
	columnCount.setPreferredSize(new Dimension((width / 5) - 5, 40));
	sort.setPreferredSize(new Dimension((width / 5) - 5, 40));
	revalidate();
    }

    boolean isSorting = false;
    AbstractSorter sorter;

    private void addComponents() {
	Settings settings = Settings.getInstance();

	randomiseHeight.setFocusable(false);
	randomiseHeight.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		randomizeColumns();
		repaint();
	    }
	});
	add(randomiseHeight);

	sortingAlgorithms.setFocusable(false);
	sortingAlgorithms.setToolTipText("Sorting algorithms");
	sortingAlgorithms.setModel(new DefaultComboBoxModel<String>(settings.getSortingAlgorithms()));
	add(sortingAlgorithms);

	delay.setText(settings.getDelay() + "");
	delay.setToolTipText("Delay between every action");
	delay.setBorder(BorderFactory.createTitledBorder("Delay"));
	delay.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		gui.setScreenSize(e.getKeyCode());
	    }
	    @Override
	    public void keyTyped(KeyEvent event) {
		EventQueue.invokeLater(new Runnable() {
		    @Override
		    public void run() {
			String text = delay.getText().replaceAll("[^0-9]*", "");
			text = text.substring(0, text.length() >= 5 ? 5 : text.length());
			delay.setText(text);
			settings.setDelay(text.isEmpty() ? 0 : Integer.parseInt(text));
			if (sorter != null) {
			    sorter.interrupt();
			}
		    }
		});
	    }
	});
	add(delay);

	columnCount.setText(settings.getColumnsCount() + "");
	columnCount.setToolTipText("Number of columns");
	columnCount.setBorder(BorderFactory.createTitledBorder("Columns"));
	columnCount.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		gui.setScreenSize(e.getKeyCode());
	    }
	    @Override
	    public void keyTyped(KeyEvent event) {
		EventQueue.invokeLater(new Runnable() {
		    @Override
		    public void run() {
			String text = columnCount.getText().replaceAll("[^0-9]*", "");
			text = text.substring(0, text.length() >= 5 ? 5 : text.length());
			columnCount.setText(text);
			int columns = text.isEmpty() ? 0 : Integer.parseInt(text);
			settings.setColumnsCount(columns == 0 ? 1 : columns);
			randomizeColumns();
			repaint();
		    }
		});
	    }
	});
	add(columnCount);

	sort.setFocusable(false);
	sort.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (isSorting) {
		    sorter.kill();
		    finished();
		} else {
		    sorter = null;
		    isSorting = true;

		    switch ((String) sortingAlgorithms.getSelectedItem()) {
		    case "Bubble Sort":
			sorter = new BubbleSort();
			break;
		    case "Insertion Sort":
			sorter = new InsertionSort();
			break;
		    case "Selection Sort":
			sorter = new SelectionSort();
			break;
		    case "Sort":
			sorter = new Sort();
			break;
		    case "Merge Sort":
			sorter = new MergeSort();
			break;
		    default:
			return;
		    }

		    if (sorter != null) {
			setComponentsEnabled(false);
			sort.setText("Cancel");
			sorter.start();
		    }
		}
	    }
	});
	add(sort);
    }

    private void setComponentsEnabled(boolean enabled) {
	randomiseHeight.setEnabled(enabled);
	sortingAlgorithms.setEnabled(enabled);
	columnCount.setEnabled(enabled);
    }
}
