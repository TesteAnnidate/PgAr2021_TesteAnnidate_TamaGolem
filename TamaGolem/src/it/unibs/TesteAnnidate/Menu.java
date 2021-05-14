package it.unibs.TesteAnnidate;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

public class Menu {

	public static final String HELLO = " __  __     ______     __         __         ______    \r\n"
			+ "/\\ \\_\\ \\   /\\  ___\\   /\\ \\       /\\ \\       /\\  __ \\   \r\n"
			+ "\\ \\  __ \\  \\ \\  __\\   \\ \\ \\____  \\ \\ \\____  \\ \\ \\/\\ \\  \r\n"
			+ " \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\ \r\n"
			+ "  \\/_/\\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_____/ \r\n"
			+ "                                                       ";

	public static final String TAMAGOLEM = " ______   ______     __    __     ______     ______     ______     __         ______     __    __    \r\n"
			+ "/\\__  _\\ /\\  __ \\   /\\ \"-./  \\   /\\  __ \\   /\\  ___\\   /\\  __ \\   /\\ \\       /\\  ___\\   /\\ \"-./  \\   \r\n"
			+ "\\/_/\\ \\/ \\ \\  __ \\  \\ \\ \\-./\\ \\  \\ \\  __ \\  \\ \\ \\__ \\  \\ \\ \\/\\ \\  \\ \\ \\____  \\ \\  __\\   \\ \\ \\-./\\ \\  \r\n"
			+ "   \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\ \\_\\ \r\n"
			+ "    \\/_/   \\/_/\\/_/   \\/_/  \\/_/   \\/_/\\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_____/   \\/_/  \\/_/ \r\n"
			+ "                                                                                                     ";

	public static final String TAMAGOLEM2 = " .----------------. .----------------. .----------------. .----------------. .----------------. .----------------. .----------------. .----------------. .----------------. \r\n"
			+ "| .--------------. | .--------------. | .--------------. | .--------------. | .--------------. | .--------------. | .--------------. | .--------------. | .--------------. |\r\n"
			+ "| |  _________   | | |      __      | | | ____    ____ | | |      __      | | |    ______    | | |     ____     | | |   _____      | | |  _________   | | | ____    ____ | |\r\n"
			+ "| | |  _   _  |  | | |     /  \\     | | ||_   \\  /   _|| | |     /  \\     | | |  .' ___  |   | | |   .'    `.   | | |  |_   _|     | | | |_   ___  |  | | ||_   \\  /   _|| |\r\n"
			+ "| | |_/ | | \\_|  | | |    / /\\ \\    | | |  |   \\/   |  | | |    / /\\ \\    | | | / .'   \\_|   | | |  /  .--.  \\  | | |    | |       | | |   | |_  \\_|  | | |  |   \\/   |  | |\r\n"
			+ "| |     | |      | | |   / ____ \\   | | |  | |\\  /| |  | | |   / ____ \\   | | | | |    ____  | | |  | |    | |  | | |    | |   _   | | |   |  _|  _   | | |  | |\\  /| |  | |\r\n"
			+ "| |    _| |_     | | | _/ /    \\ \\_ | | | _| |_\\/_| |_ | | | _/ /    \\ \\_ | | | \\ `.___]  _| | | |  \\  `--'  /  | | |   _| |__/ |  | | |  _| |___/ |  | | | _| |_\\/_| |_ | |\r\n"
			+ "| |   |_____|    | | ||____|  |____|| | ||_____||_____|| | ||____|  |____|| | |  `._____.'   | | |   `.____.'   | | |  |________|  | | | |_________|  | | ||_____||_____|| |\r\n"
			+ "| |              | | |              | | |              | | |              | | |              | | |              | | |              | | |              | | |              | |\r\n"
			+ "| '--------------' | '--------------' | '--------------' | '--------------' | '--------------' | '--------------' | '--------------' | '--------------' | '--------------' |\r\n"
			+ " '----------------' '----------------' '----------------' '----------------' '----------------' '----------------' '----------------' '----------------' '----------------' ";
	// creazione equilibrio: generazione del numero casuale che va a determinare la
	// tabella da usare

	// mettere le pietre nel golem

	// private static final string INSERISCI_NUM_ELEMENTI = "\ninserisci num
	// elementi da usare:";

	// private static int numPietre; //è il valore P della consegna

    public static void benvenuto(){
        /*System.out.println(Costanti.TRATTINI);
        System.out.println(Costanti.BENVENUTO);
        System.out.println(Costanti.TRATTINI);*/
    	System.out.println(HELLO);
    	System.out.println(TAMAGOLEM);
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
                case 1:
                	numElementi = NumeriCasuali.estraiIntero(4, 5);  //messo 4 perchè le formule non andavano troppo con 3
                	break;
                case 2:
                	numElementi = NumeriCasuali.estraiIntero(6, 8);
                	break;
                case 3:
                	numElementi = NumeriCasuali.estraiIntero(9, 10);
                	break;
                default:
                    System.out.println(Costanti.SCELTA_SBAGLIATA);
                    sceltaCorretta = false;
                    break;
                    }
        }while(!sceltaCorretta);
        return numElementi;
    }

    public static Elementi chiediPietra(int numElementi, String nomeGiocatore){
        Elementi [] arrayElementi = Elementi.values();
        System.out.print("\n");
        //stampa degli elementi che possono essere selezionati
        for(int i = 0; i < numElementi; i++){
            System.out.print(i + 1 + "-");
            System.out.println(arrayElementi[i]);
        }
        boolean seValida= true;
        Elementi pietraScelta = null;

        do {
            int scelta = InputDati.leggiIntero(nomeGiocatore + Costanti.PIETRA_DA_AGGIUNGERE, 1, numElementi);
            if(scelta <= numElementi){
                pietraScelta = arrayElementi[scelta - 1];
            } else seValida = false;
        }while(!seValida);

        return pietraScelta;
    }

    public static Giocatore creaGiocatore(int numElementi, int numGolem, int giocatore){
        String nome = InputDati.leggiStringa(String.format(Costanti.RICHIESTA_NOME, giocatore));
        return new Giocatore(nome,numGolem, numElementi);
    }

    //metodo che gestisce tutto
    public static void inizioTama(){
        benvenuto();
        int comando = 0;
        do {
            comando = richiestaComando();

            switch (comando) {
                case 1:
                	iniziaScontro();
                	break;
                case 0:
                	System.out.println(Costanti.CONCLUSIONE);
                	break;
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
        //Avverti il giocatore della creazione del mondo
        
        //Impostazione del numero di golem per giocatore
        int pietrePerGolem = ((numeroElementi + 1)/3) + 1;
        int numGolemPerGiocatore = ((numeroElementi - 1)*(numeroElementi - 2))/(2 * pietrePerGolem);
        
        
        
		//creazione gicatori
        int contatoreGiocatore = 1;
        Giocatore giocatore1 = creaGiocatore(numeroElementi, numGolemPerGiocatore, contatoreGiocatore);
        contatoreGiocatore++;
        Giocatore giocatore2 = creaGiocatore(numeroElementi, numGolemPerGiocatore, contatoreGiocatore);

        Battaglia nuovaBattaglia = new Battaglia(giocatore1, giocatore2, equilibrio);

        //inizio battaglia
        nuovaBattaglia.scontroCompleto();

        equilibrio.vediTabella();

    }

}
