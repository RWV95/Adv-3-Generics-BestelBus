package controller;

import model.Bestelbus;
import model.Pakket;
import model.PakketLezer;
import model.PakkettenBus;

import java.util.List;

public class BusLauncher {

    public static void main(String[] args) {
        PakkettenBus kuBus = new PakkettenBus("rode bus", 170);
        List<Pakket> lijstVanBestand;
        PakketLezer lezerBestand = new PakketLezer();
        lijstVanBestand = lezerBestand.leesPakketLijst("src/main/resources/pakketlijst.txt");
        System.out.println(lijstVanBestand);
        for (Pakket p : lijstVanBestand) {
            kuBus.laadPakket(p);
        }

        Bestelbus<Pakket> testBus = new Bestelbus<>("Test", 500);
        List<Pakket> lijstPakketten;
        lijstPakketten = lezerBestand.leesPakketLijst("src/main/resources/pakketlijst.txt");
        for (Pakket pakket : lijstPakketten) {
            testBus.laadVoorwerp(pakket);
        }

        System.out.println(testBus.zoekZwaarsteVoorwerp());



    }
}
