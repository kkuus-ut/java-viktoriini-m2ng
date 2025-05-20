package org.example.javafxviktoriinim2ng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Viktoriin {

    private List<Kysimus> kysimused;
    private int punktid;
    private Random random;
    private Mängumood mängumood;

    public Viktoriin(List<Kysimus> kysimused, Mängumood mängumood) {
        this.kysimused = kysimused;
        this.punktid = 0;
        this.random = new Random();
        this.mängumood = mängumood;
    }

    public void alustaViktoriin(int arvKysimusi, Scanner skanner) {
        System.out.println("Viktoriin algab!");

        System.out.println(String.format("Mängumood: %s", mängumood.toString().toUpperCase()));


        // TEEME AJUTISE LISTI (IGAL MANGUL UNIKAALNE), ET SAAKSIME PAREMINI UMBER KAIA SUVALISTE KYSIMUSTEGA
        List<Kysimus> manguKysimused = new ArrayList<>(kysimused);

        for (int i = 0; i < arvKysimusi; i++) {

            // VALIME SUVALISE KYSIMUSE
            Kysimus k = getSuvaKysimus(manguKysimused);

            System.out.println("Mis on riigi " + k.getRiik() + " pealinn?");

            String vastus = skanner.nextLine().trim();

            // KONTROLLIB VASTUSE OIGSUST NING LISAB PUNKTE
            if (vastus.equalsIgnoreCase(k.getPealinn())) {
                System.out.println("Õige!");
                punktid++;
            } else {
                System.out.println("Vale, õige vastus on: " + k.getPealinn());

                if (mängumood == Mängumood.RASKE) { // RASKE MANGUMOODI PUHUL KAOTAB MANGIJA KOHESELT, KUI SISESTAB UHE VALE VASTUSE
                    System.out.println("Oled kaotanud mängu, lõpuskoor: " + punktid + "/" + arvKysimusi + ".");
                    return;
                }

            }
        }

        System.out.println("Said " + punktid + "/" + arvKysimusi + " küsimustest õieti.");
    }

    private Kysimus getSuvaKysimus(List<Kysimus> kysimused) {

        Kysimus kysimus = kysimused.get(random.nextInt(kysimused.size())); // TOIMIB SUVALISE KYSIMUSE VALIMINE RANDOM CLASSI ABIL

        // KUNA VOIB JUHTUDA, ET VALIME MITU KORDA SAMA SUVALISE KYSIMUSE, SIIS ME EEMALDAME SELLE LISTIST
        kysimused.remove(kysimus);

        return kysimus;
    }

}
