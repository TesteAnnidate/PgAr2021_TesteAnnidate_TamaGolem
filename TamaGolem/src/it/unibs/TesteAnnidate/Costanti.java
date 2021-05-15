package it.unibs.TesteAnnidate;

public class Costanti {
    public static final int NUMERO_SPAZI = 100;
	public static final String TRATTINI = "--------------------------------------------------------------";
    public static final String BENVENUTO = "Benvenuto in TamaGolem, di seguito potrai scegliere cosa fare.";

    public static final String SCELTA_DIFFICOLTA = "difficolta' ";
    public static final String[] SCEGLI_DIFFICOLTA = {"Facile", "Intermedio", "super-impossibile"};

    public static final String CONCLUSIONE = "Vai in pace, addio..";
    public static final String COSA_VUOI_FARE = "Cosa vuoi fare?  ";
    public static final String SCELTA_SBAGLIATA = "errore, immetti nuovamente la scelta";
    public static final String RICHIESTA_NOME = "\nInserisci il tuo nome giocatore %d:";
    public static final String PIETRA_DA_AGGIUNGERE = " seleziona la pietra da aggiungere: ";

    public static final String INIZIA_UNA_NUOVA_PARTITA = "- 1 : inizia una nuova partita";
    public static final String ESCI_DAL_GIOCO = "- 0 : esci dal gioco";
    public static final String REGOLE = "- 2 : Regole ufficiali";

    public static final String SCONTRO_IN_FASE_DI_INIZIO= "Lo scontro sta per avere inizio!!\nInserisci la difficolta' di gioco desiderata";
	public static final String REGISTRAZIONE_GIOCATORI = "Perfetto!!\nScelta salvata nel database.\nOra registratevi!";
	public static final String CHE_LA_BATTAGLIA_ABBIA_INIZIO = "Battaglia inizializzata.\nCHE LO SCONTRO ABBIA INIZIO!!!!!";

	//usate in Battaglia
	public static final String VITTORIA = "Bravo %s, HAI VINTO!!";
	public static final String DANNI = "Il Golem di %s ha subito %d danni";
	public static final String ELEMENTI_UGUALI = "Il lancio delle pietre non ha causato danni!";
	public static final String PIETRE_IN_SACCA = "%s = %d ; ";
	public static final String CARICA_IL_TUO_GOLEM = "%s carica il tuo golem, devi inserire %d pietre";
	public static final String PIETRA_NON_DISPONIBILE = "Pietra non disponibile!!";
	public static final String PIETRA_AGGIUNTA_BENE = "Il tuo golem ha mangiato bene la pietra, devi aggiungere ancora %d pietre";
	public static final String STESSE_PIETRE = "I vostri golem hanno mangiato le stesse pietre!!!";
	public static final String GOLEM_VOMITA = "...il tuo golem le sta vomitando nella sacca comune...";
	public static final String ORA_PUOI_AGGIUNGERLE ="\nOra puoi aggiungere nuove pietre!!";
	public static final String MORTE_GOLEM = "Il Golem di %s e' morto!";
	public static final String PIETRE_DISPONIBILI = "Pietre attualmente disponibili: ";
	public static final String VITA_GOLEM = "%s, il tuo golem ha vita = %d";
	public static final String TASTO_LANCIO_PIETRE = "Per lanciare le pietre permi 0";
	public static final String TASTO_INIZIO_SCONTRO = "Per iniziare lo scontro premi 0";
	public static final String MOSTRA_EQUILIBRIO = "La partita è finita, ora potete vedere l'equilibrio degli elementi del vostro mondo (cambiera' ad ogni scontro)";
	public static final String SCELTA_NUMERO_GOLEM = "Inserisci il numero di golem che avra' ogni giocatore per la battaglia (numero golem consigliato per il tuo livello: %d)";
	public static final String CREAZIONE_EQUILIBRIO = "Il mondo per il tuo scontro è stato creato...\nOra tutti gli elementi sono bilanciati";

    
	public static void pulisciConsole() {
	    for(int i = 0; i < NUMERO_SPAZI; i++ )
	    	System.out.println();
	}
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

	public static String GOLEM = "                                                                                                			\r\n"
			+ "			                                                                                                     \r\n"
			+ "                 &#######                           			                        .#######&                \r\n"
			+ "            @@@%&%%%@%###%@                       			                       @%###%@%%&&%@@@           \r\n"
			+ "          %@@@&&&%%%#&%%%@@                       			                       @@&&%%#&%&&&&@@@          \r\n"
			+ "        @@%%@@&&%%%&######%%@                     			                     @%%##%###&%%%&&@@%&@@       \r\n"
			+ "       @@%&&##&%&&&%%%%%%%%%####                  			                  ####%%%%%%%%&&&&%&##&%%@@      \r\n"
			+ "     @%%######&&%%&%##%%##%%%####                 			                 ####%&%##%%##%&%%&@######%%@    \r\n"
			+ "     @@%(###@&%%%%&%&%%##%%#%%(#&&%               			               %&@##%&#%%##%%&%&%%%%&@###%%@@    \r\n"
			+ "    @%%## @@%%%%&%##########  @&&&#####%##%%##%   	  		   &##&&##&(###(%&@@  #########%%%&%%%@& ##&&@   \r\n"
			+ "    @%&##  @@@@%%&(&#########    %@@@@&###%%@     			     @%%###%@@@@&    ###(#####%(%#&@@@@  ##%%@   \r\n"
			+ "    @%%%%%  @@@%&##%######%%##        @@%&%@ @@&  			 &@@@ @&%%@@        ##%&#######(#%%@@@  %%%%&@   \r\n"
			+ "   @%#####(  @@@%##&&& @@@%%##            @@#@    			    @#@@            ##%&@@@.@@%##&@@&  ######%@  \r\n"
			+ "   @@%%%%%%##@@@@@       &@@@@                    			                   #@@@@@       @@@@&##&%%%%%@@  \r\n"
			+ "    &#@&%# @#%%%##%      @%%###                   			                   ##(&&@      ##(%%&#@ #%&@#%   \r\n"
			+ "    @%  (%# @@%%%%&     #@@@%&#                   			                  .#%%@@@      %%%%%@@ #&   #@   \r\n"
			+ "            @&####        @@@%###                 			                 ###%@@(        ####@@           \r\n"
			+ "            @@@%&%%       &@@@@@%%%@              			              @%%&@@@@@.       %%%%@&&           \r\n"
			+ "			                                                                                                     \r\n"
			+ "                                                                                                              \r\n";
}
