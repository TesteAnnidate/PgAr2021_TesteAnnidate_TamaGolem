package it.unibs.TesteAnnidate;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

public class Menu {

	//stampa l'intestazione iniziale
	public static void benvenuto() {
		System.out.println(Costanti.HELLO);
		System.out.println(Costanti.TAMAGOLEM);
	}

	public static int richiestaComando() {
		System.out.println(Costanti.ESCI_DAL_GIOCO);
		System.out.println(Costanti.INIZIA_UNA_NUOVA_PARTITA);
		System.out.println(Costanti.REGOLE);
		System.out.print("\n");
		return InputDati.leggiIntero(Costanti.COSA_VUOI_FARE, 0, 2);
	}

	// decidere la difficolta'
	public static int SceltaDifficolta() {
		MyMenu ilMenu = new MyMenu(Costanti.SCELTA_DIFFICOLTA, Costanti.SCEGLI_DIFFICOLTA);
		int scelta = ilMenu.scegli();
		int numElementi = 0;
		boolean sceltaCorretta = true;
		do {
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
				System.out.println(Costanti.SCELTA_SBAGLIATA);
				sceltaCorretta = false;
				break;
			}
		} while (!sceltaCorretta);
		return numElementi;
	}

	//gestisce la fase di richiesta delle pietre da far mangiare al golem (viene richiamato in caricaGolem di battaglia)
	public static Elementi chiediPietra(int numElementi, String nomeGiocatore) {
		Elementi[] arrayElementi = Elementi.values();
		System.out.print("\n");
		// stampa degli elementi che possono essere selezionati
		for (int i = 0; i < numElementi; i++) {
			System.out.print(i + 1 + "-");
			System.out.println(arrayElementi[i]);
		}
		boolean seValida = true;
		Elementi pietraScelta = null;

		do {
			int scelta = InputDati.leggiIntero(nomeGiocatore + Costanti.PIETRA_DA_AGGIUNGERE, 1, numElementi);
			if (scelta <= numElementi) {
				pietraScelta = arrayElementi[scelta - 1];
			} else
				seValida = false;
		} while (!seValida);

		return pietraScelta;
	}

	//chiede in unput i nomi dei giocatori
	public static Giocatore creaGiocatore(int numElementi, int numGolem, int giocatore) {
		String nome = InputDati.leggiStringa(String.format(Costanti.RICHIESTA_NOME, giocatore));
		return new Giocatore(nome, numGolem, numElementi);
	}

	// metodo che gestisce tutto
	public static void inizioTama() {
		benvenuto();
		int comando = 0;
		do {
			comando = richiestaComando();

			switch (comando) {
			case 0:
				System.out.println(Costanti.CONCLUSIONE);
				break;
			case 1:
				iniziaScontro();
				break;
			case 2:
				regole();
				break;
			}

		} while (comando != 0);

	}

	//stampa le regole del gioco
	private static void regole() {
		System.out.println("Regole");
		
	}

	// metodo per creare l'equilibrio, creare giocatori, inizializzare una battaglia
	public static void iniziaScontro() {
		System.out.println(Costanti.SCONTRO_IN_FASE_DI_INIZIO);
		int numeroElementi = SceltaDifficolta();
		EquilibrioDelMondo equilibrio = new EquilibrioDelMondo(numeroElementi);
		
		// considero l'eccezione
		do {
			equilibrio.setMatriceEquilibrio(equilibrio.tabellaProvvisoria());
		} while (!(equilibrio.isCorrect()));
		// Avverti il giocatore della creazione del
		System.out.println("Il mondo per il tuo scontro è stato creato...\nOra tutti gli elementi sono bilanciati");

		// Impostazione del numero di golem per giocatore
		int pietrePerGolem = (int)Math.ceil(((double)(numeroElementi + 1) / 3) + 1);
		int numGolemPerGiocatore = (int)Math.ceil(((((double)numeroElementi - 1) * ((double)numeroElementi - 2)) / (2 * (double)pietrePerGolem)));
		numGolemPerGiocatore = InputDati.leggiIntero(String.format("Inserisci il numero di golem che avra' ogni giocatore per la battaglia (numero golem consigliato per il tuo livello: %d)", numGolemPerGiocatore), 1, numeroElementi*5);
		
		// creazione gicatori
		System.out.println(Costanti.REGISTRAZIONE_GIOCATORI);
		int contatoreGiocatore = 1;
		Giocatore giocatore1 = creaGiocatore(numeroElementi, numGolemPerGiocatore, contatoreGiocatore);
		contatoreGiocatore++;
		Giocatore giocatore2 = creaGiocatore(numeroElementi, numGolemPerGiocatore, contatoreGiocatore);

		Battaglia nuovaBattaglia = new Battaglia(giocatore1, giocatore2, equilibrio);

		// inizio battaglia
		System.out.println(Costanti.CHE_LA_BATTAGLIA_ABBIA_INIZIO);
		nuovaBattaglia.scontroCompleto();
		System.out.println("La partita è finita, ora potete vedere l'equilibrio degli elementi del vostro mondo (cambiera' ad ogni scontro)");
		equilibrio.vediTabella();

	}

}
