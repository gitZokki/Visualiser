package de.zokki.visualiser.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.zokki.visualiser.GUI.Column;

public class MergeSort extends AbstractSorter {

    public MergeSort() {
	super();
    }

    @Override
    public void run() {
	Column.setColumns(sort(Arrays.asList(columns)).toArray(new Column[columns.length]));
	finished();
    }

//	funktion mergesort(liste);
    private List<Column> sort(List<Column> columns) {
	//System.out.println(columns.size());
//	  falls (Größe von liste <= 1) dann antworte liste
	if (columns.size() <= 1) {
	    return columns;
//	  sonst
	} else {
//	     halbiere die liste in linkeListe, rechteListe
	    List<Column> left = new ArrayList<Column>();
	    List<Column> right = new ArrayList<Column>();
	    for (int i = 0; i < columns.size(); i++) {
		if(i < columns.size() / 2) {
		    left.add(columns.get(i));
		} else {
		    right.add(columns.get(i));
		}
	    }
//	     linkeListe = mergesort(linkeListe)
	    left = sort(left);
	    Column.setColumns(columns.toArray(new Column[columns.size()]));
//	     rechteListe = mergesort(rechteListe)
	    right = sort(right);
	    Column.setColumns(columns.toArray(new Column[columns.size()]));
//	     antworte merge(linkeListe, rechteListe)
	    return merge(left, right);
	}
    }

//	funktion merge(linkeListe, rechteListe);
    private List<Column> merge(List<Column> left, List<Column> right) {
//	  neueListe
	List<Column> sorted = new ArrayList<Column>();
//	  solange (linkeListe und rechteListe nicht leer)
	while (!left.isEmpty() && !right.isEmpty()) {
	    sleep();
//	  |    falls (erstes Element der linkeListe <= erstes Element der rechteListe)
	    if (left.get(0).getPercentageHeight() <= right.get(0).getPercentageHeight()) {
//	  |    dann füge erstes Element linkeListe in die neueListe hinten ein und entferne es aus linkeListe
		sorted.add(left.get(0));
		left.remove(0);
	    } else {
//	  |    sonst füge erstes Element rechteListe in die neueListe hinten ein und entferne es aus rechteListe
		sorted.add(right.get(0));
		right.remove(0);
	    }
//	  solange_ende
	}
//	  solange (linkeListe nicht leer)
	while (!left.isEmpty()) {
//	  |    füge erstes Element linkeListe in die neueListe hinten ein und entferne es aus linkeListe
	    sorted.add(left.get(0));
	    left.remove(0);
//	  solange_ende
	}
//	  solange (rechteListe nicht leer)
	while (!right.isEmpty()) {
//	  |    füge erstes Element rechteListe in die neueListe hinten ein und entferne es aus rechteListe
	    sorted.add(right.get(0));
	    right.remove(0);
//	  solange_ende
	}
//	  antworte neueListe
	return sorted;
    }
}
