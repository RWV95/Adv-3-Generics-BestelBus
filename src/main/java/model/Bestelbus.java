package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rowin Vleeshouwer <r.w.vleeshouwer@st.hanze.nl>
 * Beschrijft de eigenschappen van een bestelbus die verschillende voorwerpen kan laden en bezorgen
 */

public class Bestelbus<T extends Weegbaar> {

    public static final int GRENSWAARDE_NEGATIEVE_LADING = 0;

    private final String naam;
    private int totaalGewicht;
    private final int maximumGewicht;
    private final List<T> lading;

    public Bestelbus (String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadVoorwerp(T voorwerp) {
        if (!(totaalGewicht + voorwerp.getGewicht() > maximumGewicht) &&
                !(voorwerp.getGewicht() < GRENSWAARDE_NEGATIEVE_LADING)) {
            lading.add(voorwerp);
            totaalGewicht += voorwerp.getGewicht();
        }
    }

    public List<T> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public T zoekZwaarsteVoorwerp() {
        if (lading.isEmpty()) {
            return null;
        } else {
            return zoekZwaarsteVoorwerp(0);
        }
    }

    private T zoekZwaarsteVoorwerp (int index) {
        if (index == lading.size()) {
            return lading.get(index - 1);
        }
        T zwaarsteVoorwerp = zoekZwaarsteVoorwerp(index + 1);
        if (lading.get(index).getGewicht() > zwaarsteVoorwerp.getGewicht()) {
            return lading.get(index);
        } else {
            return zwaarsteVoorwerp;
        }
    }

    // Iteratieve methode

//    public T zoekZwaarsteVoorwerp() {
//        if (lading.isEmpty()) {
//            return null;                      // Return null for an empty list
//        }
//
//        T zwaarsteVoorwerp = lading.get(0);   // Assume the first object is the heaviest initially
//
//        for (int i = 1; i < lading.size(); i++) {
//            T currentObject = lading.get(i);
//
//            // Compare the weight of the current object with the weight of the heaviest object so far
//            if (currentObject.getGewicht() > zwaarsteVoorwerp.getGewicht()) {
//                zwaarsteVoorwerp = currentObject; // Update if the current object is heavier
//            }
//        }
//
//        return zwaarsteVoorwerp;
//    }

}
