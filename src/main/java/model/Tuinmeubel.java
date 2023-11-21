package model;

/**
 * @author Rowin Vleeshouwer <r.w.vleeshouwer@st.hanze.nl>
 * Beschrijft de eigenschappen van een tuinmeubel
 */

public class Tuinmeubel implements Lading{

    private final String naam;
    private final String type;
    private final int gewicht;

    public Tuinmeubel(String naam, String type, int gewicht) {
        this.naam = naam;
        this.type = type;
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return String.format("{Naam: %s; type: %s; gewicht: %d}", naam, type, gewicht);
    }

    @Override
    public int getGewicht() {
        return gewicht;
    }
}
