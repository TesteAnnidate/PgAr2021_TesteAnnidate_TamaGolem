package it.unibs.TesteAnnidate;

import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

public class Menu {

    //creazione equilibrio: generazione del numero casuale che va a determinare la tabella da usare

    //mettere le pietre nel golem


    //private static final string INSERISCI_NUM_ELEMENTI = "\ninserisci num elementi da usare:";

    private static final String SCELTA_DIFFICOLTA = "difficoltà";
    private static final String[] SCEGLI_DIFFICOLTA = {"Facile", "Intermedio", "Difficile"};


    private static final String[] FINE_PARTITA = {"stampa equilibrio", ""};

    private static final String CONCLUSIONE = "Alla prossima";


    private static MyMenu ilMenu;
    private static int scelta;
    private static int numElementi;
    //private static int numPietre; //è il valore P della consegna


    //decidere la difficoltà
    public static void SceltaDifficolta() {
        ilMenu = new MyMenu(SCELTA_DIFFICOLTA, SCEGLI_DIFFICOLTA);
        scelta = ilMenu.scegli();
        switch (scelta) {
            case 1:
                numElementi = NumeriCasuali.estraiIntero(3, 5);
                break;

            case 2:
                numElementi = NumeriCasuali.estraiIntero(6, 8);
                break;

            case 3:
                numElementi = NumeriCasuali.estraiIntero(9, 10);
                break;

            default:
                System.out.println("errore");


        }

    }


    //parte finale del menu che stampa l'equilibrio e prepara l'inizio di una partita nuova
    public static void Partita() {

        ilMenu = new MyMenu("", FINE_PARTITA);
        scelta = ilMenu.scegli();
        switch (scelta) {

            //stampa equilibrio partita precente
            case 1:

        }

    }
}

