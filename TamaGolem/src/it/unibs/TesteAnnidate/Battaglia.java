package it.unibs.TesteAnnidate;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Battaglia {

	// Attributi Battaglia
	private Giocatore g1;
	private Giocatore g2;
	private ArrayList<Pietra> saccaComune; // Lista che contiene le pietre tra le quali scegliere
	private int dimensioneSacca; // S
	private EquilibrioDelMondo equilibrio;

	// Costruttore
	public Battaglia(Giocatore g1, Giocatore g2, EquilibrioDelMondo equilibrio) {
		this.g1 = g1;
		this.g2 = g2;
		this.equilibrio = equilibrio;
		this.dimensioneSacca = (int)Math.ceil(((2 * (double)g1.getNumeroGolem() * (double)g1.getGolem().getPietrePerGolem())/(double)equilibrio.getNumeroElementi())) * equilibrio.getNumeroElementi(); // Uso la formula della dimensione sacca tenendo conto delle approssimazioni
		this.saccaComune = new ArrayList<Pietra>();
		
	}
	
	// Metodo che svolge la battaglia
	public void scontroCompleto() {
		// Per prima cosa inizializzo la sacca comune
		saccaComune = riempiSacca(dimensioneSacca);
		// Istanzio i due golem
		g1.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
		g2.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
		// Faccio caricare all'utente i golem con le pietre della sacca comune
		caricaGolem(g1);
		caricaGolem(g2);
		// Controllo che i due golem non abbiano le stesse pietre nello stesso ordine
		while(g1.getGolem().getListaPietre().equals(g2.getGolem().getListaPietre()))
			seStessePietre(g2); // In caso richiedo le pietre
		while (g1.getNumeroGolem() > 0 && g2.getNumeroGolem() > 0) {		
			pausaScontro(); // Metodo per fare una pausa prima dell'inizio dello scontro
			scontroSingolo();
		}
		// Controllo chi ha vinto e chi ha perso
		if (g1.getNumeroGolem() > 0 && g2.getNumeroGolem() == 0) {
			System.out.println(String.format(Costanti.VITTORIA, g1.getNome()));
			g1.setVittorie(g1.getVittorie() + 1); // Aumento le vittorie per una futura implementazione (classifica)
		} else if (g2.getNumeroGolem() > 0 && g1.getNumeroGolem() == 0) {
			System.out.println(String.format(Costanti.VITTORIA, g2.getNome()));
			g2.setVittorie(g2.getVittorie() + 1);
		}
	}

	// Metodo per dividere i vari momenti di gioco
	private void pausaScontro() {
		InputDati.leggiIntero(Costanti.TASTO_INIZIO_SCONTRO, 0, 0);
	}

	// Metodo che fa scontrare due golem finche' uno dei due muore
	public void scontroSingolo() {
		// Inizializzo gli indici delle pietre dei due golem per il metodo lanciPietre
		int indicePietreTama1 = 0;
		int indicePietreTama2 = 0;
		do {
			pausaLancio(); // Metodo per fare un lancio alla volta
			// Continuo a lanciare le pietre finche' non muore uno dei due golem
			lanciaPietre(indicePietreTama1, indicePietreTama2);
			System.out.println(Costanti.GOLEM); // Stampo a video il disegno dei due golem
			if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() > 0) {
				// Stampo i danni causati dal lancio
				if (danni(indicePietreTama1, indicePietreTama2) > 0)
					System.out.println(String.format(Costanti.DANNI, g2.getNome(), danni(indicePietreTama1, indicePietreTama2)));
				else if (danni(indicePietreTama1, indicePietreTama2) < 0)
					System.out.println(String.format(Costanti.DANNI, g1.getNome(), -danni(indicePietreTama1, indicePietreTama2)));
				else if(danni(indicePietreTama1, indicePietreTama2) == 0)
					System.out.println(Costanti.ELEMENTI_UGUALI);
				// Stampo la vita rimanente dei due golem
				System.out.println(String.format(Costanti.VITA_GOLEM, g1.getNome(), g1.getGolem().getVita()));
				System.out.println(String.format(Costanti.VITA_GOLEM, g2.getNome(), g2.getGolem().getVita()));
				// Se nessuno dei due golem e' morto aumento gli indici e passo alla pietra successiva
				indicePietreTama1++;
				indicePietreTama2++;

				//se gli indici superano l'ultimo indice disponibile dell'array di pietre del golem allora si fanno ripartire da
				//0 così da continuare a ciclare
				if(indicePietreTama1 == g1.getGolem().getListaPietre().size()){
					indicePietreTama1 = 0;
					indicePietreTama2 = 0;
				}

			}
			//deve stopparti quando gli indici sono = numPietrePerGolem - 1
		} while (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() > 0);
		// Se uno dei due golem muore 
		if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() <= 0) {
			indicePietreTama1++;
			indicePietreTama2 = 0;
			morteGolem(g2);
		}

		else if (g1.getGolem().getVita() <= 0 && g2.getGolem().getVita() > 0) {
			indicePietreTama2++;
			indicePietreTama1 = 0;
			morteGolem(g1);
		}
	}

	// Metodo che diminuisce il numero di golem e in caso il numero di golem sia > 0 evoca un altro golem
	private void morteGolem(Giocatore giocatore) {
		giocatore.setNumeroGolem(giocatore.getNumeroGolem() - 1); // Diminuisco di 1 il numero di golem del giocatore dato come parametro
		System.out.println(String.format(Costanti.MORTE_GOLEM, giocatore.getNome())); // Annuncio la mmìorte del golem
		if (giocatore.getNumeroGolem() > 0){
			// In caso non siano finiti i golem ne istanzio uno nuovo e lo carico
			giocatore.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
			caricaGolem(giocatore);
			Costanti.pulisciConsole();
			while(g1.getGolem().getListaPietre().equals(giocatore.getGolem().getListaPietre()))
				seStessePietre(giocatore);
		}
	}

	// Metodo per dividere i vari momenti di gioco
	private void pausaLancio() {
		InputDati.leggiIntero(Costanti.TASTO_LANCIO_PIETRE, 0, 0);
	}

	// Metodo che dati due indici di pietre diminuisce la vita dei golem in base all'equilibrio
	public void lanciaPietre(int indicePietreTama1, int indicePietreTama2) {

		if (danni(indicePietreTama1, indicePietreTama2) > 0) {
			g2.getGolem().setVita(g2.getGolem().getVita() - danni(indicePietreTama1, indicePietreTama2));
		} else if (danni(indicePietreTama1, indicePietreTama2) < 0) {
			g1.getGolem().setVita(g1.getGolem().getVita() + danni(indicePietreTama1, indicePietreTama2));
		}
	}

	// Metodo che ritorna dati due elementi i danni cprrispondenti nella tabella dell'equilibrio
	public int danni(int elemento1, int elemento2) {
		int[][] matEquilibrio = equilibrio.getMatriceEquilibrio();
		int e1 = g1.getGolem().getListaPietre().get(elemento1).getElementoRiferimento().ordinal(); // Ritorna la posizione dell'elemento
		int e2 = g2.getGolem().getListaPietre().get(elemento2).getElementoRiferimento().ordinal();
		return matEquilibrio[e1][e2];
	}

	// Metodo per riempire la sacca comune, richiamato all'inizio dello scontro (ritorna una lista)
	public ArrayList<Pietra> riempiSacca(int dimensioneSacca) {
		ArrayList<Pietra> sacca = new ArrayList<Pietra>(); // Inizializzo la lista
		int elementoCorrente = 0; // Parto dal primo elemento per aggiungere in ordine le pietre
		int numeroPietrePerElemento = (int)((double)dimensioneSacca / (double)equilibrio.getNumeroElementi()); // Dimensione della sacca/numero di elementi
		int contatorePietre = 0; // Contatore per controllare quando si raggiunge il numeroPietrePerElemento
		Elementi[] arrayElementi = Elementi.values(); // Genero l'array dato l'enum di elementi
		for (int pietreInSacca = 0; pietreInSacca < dimensioneSacca; pietreInSacca++) {
			// Aggiungo pietre fino a raggiungere il numeroPietrePerElemento e passo all'elemento successivo, fino a raggiungere la dimensione max della sacca
			sacca.add(new Pietra(arrayElementi[elementoCorrente])); // Aggiungo una pietra istanziata con l'elemento corrente
			contatorePietre++; // Aumento il contatore
			if (contatorePietre == numeroPietrePerElemento) {
				contatorePietre = 0;
				elementoCorrente++;
			}
		}
		return sacca;
	}

	//metodo che viene richiamato ogni volta che si deve riempire un golem e che stampa le pietre rimanenti nella sacca
	// Questo metodo non lo utilizziamo perchè sarebbe un aiuto per l'avversario
	public void vediPietreInSacca(){
		int [] pietreInSacca = new int [equilibrio.getNumeroElementi()];
		Elementi [] elementi = Elementi.values();

		for (Pietra pietra : saccaComune) {
			pietreInSacca[pietra.getElementoRiferimento().ordinal()]++;
		}
		System.out.println(Costanti.PIETRE_DISPONIBILI);
		for(int i = 0; i < equilibrio.getNumeroElementi(); i++){
			System.out.printf(Costanti.PIETRE_IN_SACCA, elementi[i], pietreInSacca[i]);
		}
		System.out.print("\n");
	}

	// Metodo che serve a far caricare dall'utente un golem con delle pietre
	public void caricaGolem(Giocatore giocatore) {
		int numPietreDaAggiungere = giocatore.getGolem().getPietrePerGolem();
		Pietra daAggiungere = null;
		System.out.println(String.format(Costanti.CARICA_IL_TUO_GOLEM, giocatore.getNome(), giocatore.getGolem().getPietrePerGolem()));

		do {
			do {
				//Questo metodo lo abbiamo commentato perche' ci siamo accorti che avrebbe aiutato l'avversario
				//vediPietreInSacca();
				daAggiungere = new Pietra(Menu.chiediPietra(equilibrio.getNumeroElementi(), giocatore.getNome()));
				if (!(saccaComune.contains(daAggiungere)))
					System.out.println(Costanti.PIETRA_NON_DISPONIBILE);

			} while (!saccaComune.contains(daAggiungere));

			giocatore.getGolem().getListaPietre().add(daAggiungere);
			saccaComune.remove(daAggiungere);
			System.out.println(String.format(Costanti.PIETRA_AGGIUNTA_BENE, giocatore.getGolem().getPietrePerGolem() - giocatore.getGolem().getListaPietre().size()));
		} while (giocatore.getGolem().getListaPietre().size() < numPietreDaAggiungere);
		Costanti.pulisciConsole();
	}
	//nel caso in cui il secondo giocatore abbia scelto le stesse pietre del primo allora si svuota il suo golem e le pietre
		//che aveva mangiato vengono rimesse nella sacca comune e gli viene chiesto nuovamente di riempire la sacca
	public void seStessePietre(Giocatore giocatore){
			System.out.println(Costanti.STESSE_PIETRE);
			System.out.println(Costanti.GOLEM_VOMITA);

			//le pietre che ha vomitato vengono riaggiunte alla sacca
			saccaComune.addAll(giocatore.getGolem().getListaPietre());
			giocatore.getGolem().getListaPietre().clear();
			System.out.println(Costanti.ORA_PUOI_AGGIUNGERLE);
			caricaGolem(giocatore);
			Costanti.pulisciConsole();
		}

	// Getters e setters
	public Giocatore getG1() {
		return g1;
	}

	public void setG1(Giocatore g1) {
		this.g1 = g1;
	}

	public Giocatore getG2() {
		return g2;
	}

	public void setG2(Giocatore g2) {
		this.g2 = g2;
	}

	public ArrayList<Pietra> getSaccaComune() {
		return saccaComune;
	}

	public void setSaccaComune(ArrayList<Pietra> saccaComune) {
		this.saccaComune = saccaComune;
	}

	public int getDimensioneSacca() {
		return dimensioneSacca;
	}

	public void setDimensioneSacca(int dimensioneSacca) {
		this.dimensioneSacca = dimensioneSacca;
	}

	public EquilibrioDelMondo getEquilibrio() {
		return equilibrio;
	}

	public void setEquilibrio(EquilibrioDelMondo equilibrio) {
		this.equilibrio = equilibrio;
	}

}
