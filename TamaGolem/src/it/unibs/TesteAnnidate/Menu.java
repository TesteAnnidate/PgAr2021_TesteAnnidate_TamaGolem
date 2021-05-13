package it.unibs.TesteAnnidate;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

public class Menu {

    //creazione equilibrio: generazione del numero casuale che va a determinare la tabella da usare

    //mettere le pietre nel golem


    //private static final string INSERISCI_NUM_ELEMENTI = "\ninserisci num elementi da usare:";

    private static final String SCELTA_DIFFICOLTA = "difficoltà";
    private static final String[] SCEGLI_DIFFICOLTA = {"Facile", "Intermedio", "super-impossibile"};


    private static final String[] FINE_PARTITA = {"stampa equilibrio", ""};

    private static final String CONCLUSIONE = "Alla prossima";
    public static final String SCELTA_SBAGLIATA = "errore, immetti nuovamente la scelta";
    public static final String RICHIESTA_NOME = "Inserisci il tuo nome: ";
    public static final String PIETRA_DA_AGGIUNGERE = "Pietra da aggiungere: ";


    private static MyMenu ilMenu;
    //private static int numPietre; //è il valore P della consegna


    //decidere la difficoltà
    public static int SceltaDifficolta() {
        ilMenu = new MyMenu(SCELTA_DIFFICOLTA, SCEGLI_DIFFICOLTA);
        int scelta = ilMenu.scegli();
        int numElementi = 0;
        boolean sceltaCorretta = true;
        do {
            switch (scelta) {
                case 1 -> numElementi = NumeriCasuali.estraiIntero(3, 5);
                case 2 -> numElementi = NumeriCasuali.estraiIntero(6, 8);
                case 3 -> numElementi = NumeriCasuali.estraiIntero(9, 10);
                default -> {
                    System.out.println(SCELTA_SBAGLIATA);
                    sceltaCorretta = false;
                }
            }
        }while(!sceltaCorretta);
        return numElementi;
    }

    public static Giocatore creaGiocatore(int numElementi, int numGolem){
        String nome = InputDati.leggiStringa(RICHIESTA_NOME);
        return new Giocatore(nome,numGolem);
    }

    public static Elementi chiediPietra(int numElementi){
        Elementi [] arrayElementi = Elementi.values();

        //stampa degli elementi che possono essere selezionati
        for(int i = 0; i < numElementi; i++){
            System.out.print(i + 1 + "-");
            System.out.println(arrayElementi[i]);
        }
        boolean seValida= true;
        Elementi pietraScelta = null;

        do {
            int scelta = InputDati.leggiIntero(PIETRA_DA_AGGIUNGERE);
            if(scelta <= numElementi){
                pietraScelta = arrayElementi[scelta];
            } else seValida = false;
        }while(!seValida);

        return pietraScelta;
    }
}

