package it.unibs.TesteAnnidate;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

public class Menu {

    public static void benvenuto(){
        System.out.println(Costanti.TRATTINI);
        System.out.println(Costanti.BENVENUTO);
        System.out.println(Costanti.TRATTINI);
    }

    public static int richiestaComando(){
        System.out.println(Costanti.INIZIA_UNA_NUOVA_PARTITA);
        System.out.println(Costanti.ESCI_DAL_GIOCO);
        System.out.print("\n");
        return InputDati.leggiIntero(Costanti.COSA_VUOI_FARE, 0, 1);
    }

    //decidere la difficoltà
    public static int SceltaDifficolta() {
        MyMenu ilMenu = new MyMenu(Costanti.SCELTA_DIFFICOLTA, Costanti.SCEGLI_DIFFICOLTA);
        int scelta = ilMenu.scegli();
        int numElementi = 0;
        boolean sceltaCorretta = true;
        do {
            switch (scelta) {
                case 1 -> numElementi = NumeriCasuali.estraiIntero(3, 5);
                case 2 -> numElementi = NumeriCasuali.estraiIntero(6, 8);
                case 3 -> numElementi = NumeriCasuali.estraiIntero(9, 10);
                default -> {
                    System.out.println(Costanti.SCELTA_SBAGLIATA);
                    sceltaCorretta = false;
                }
            }
        }while(!sceltaCorretta);
        return numElementi;
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
            int scelta = InputDati.leggiIntero(Costanti.PIETRA_DA_AGGIUNGERE);
            if(scelta <= numElementi){
                pietraScelta = arrayElementi[scelta];
            } else seValida = false;
        }while(!seValida);

        return pietraScelta;
    }

    public static Giocatore creaGiocatore(int numElementi, int numGolem){
        String nome = InputDati.leggiStringa(Costanti.RICHIESTA_NOME);
        return new Giocatore(nome,numGolem);
    }

    //metodo che gestisce tutto
    public static void inizioTama(){
        benvenuto();
        int comando;
        do {
            comando = richiestaComando();

            switch (comando) {
                case 1 -> iniziaScontro();
                case 0 -> System.out.println(Costanti.CONCLUSIONE);
            }

        }while(comando!=0);

    }

    //metodo per creare l'equilibrio da mettere sopra
    public static void iniziaScontro(){
        int numeroElementi = SceltaDifficolta();
        EquilibrioDelMondo equilibrio = new EquilibrioDelMondo(numeroElementi);
        //considero l'eccezione
        do {
            equilibrio.setMatriceEquilibrio(equilibrio.tabellaProvvisoria());
        }while(!(equilibrio.isCorrect()));

        //Impostazione del numero di golem per giocatore
        int pietrePerGolem = ((numeroElementi + 1)/3) + 1;
        int numGolemPerGiocatore = (numeroElementi - 1)*(numeroElementi - 2)/(2 * pietrePerGolem);

        //creazione gicatori
        Giocatore giocatore1 = creaGiocatore(numeroElementi, numGolemPerGiocatore);
        Giocatore giocatore2 = creaGiocatore(numeroElementi, numGolemPerGiocatore);

        Battaglia nuovaBattaglia = new Battaglia(giocatore1, giocatore2, numeroElementi, equilibrio);

        //inizio battaglia
        nuovaBattaglia.scontroCompleto();

        equilibrio.vediTabella();

    }

}
