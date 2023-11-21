package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rowin Vleeshouwer <r.w.vleeshouwer@st.hanze.nl>
 * Beschrijft de eigenschappen van een bestelbus die verschillende voorwerpen kan laden en bezorgen
 */

public class Bestelbus<T extends Lading> {

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
        return null;
    }

}
