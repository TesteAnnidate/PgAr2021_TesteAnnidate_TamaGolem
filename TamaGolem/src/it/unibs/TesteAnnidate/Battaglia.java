package it.unibs.TesteAnnidate;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Battaglia {

	public static final String MORTE_GOLEM = "Il Golem di %s è morto!";
	public static final String ELEMENTI_UGUALI = "Il lancio delle pietre non ha causato danni!";
	public static final String DANNI = "Il Golem di %s ha subito %d danni";
	public static final String VITTORIA = "Bravo %s, HAI VINTO!!";
	public static final String PIETRA_AGGIUNTA_BENE = "Il tuo golem ha mangiato bene la pietra";
	public static final String PIETRA_NON_DISPONIBILE = "Pietra non disponibile!!";

	static String GOLEM = "                                                                                                			\r\n"
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

	private Giocatore g1;
	private Giocatore g2;
	private ArrayList<Pietra> saccaComune;
	private int dimensioneSacca; // S
	private EquilibrioDelMondo equilibrio;

	// Costruttore
	public Battaglia(Giocatore g1, Giocatore g2, EquilibrioDelMondo equilibrio) {
		this.g1 = g1;
		this.g2 = g2;
		this.equilibrio = equilibrio;
		this.dimensioneSacca = (int)Math.round(((2 * (double)g1.getNumeroGolem() * (double)g1.getGolem().getPietrePerGolem())/(double)equilibrio.getNumeroElementi())) * equilibrio.getNumeroElementi();
		this.saccaComune = new ArrayList<Pietra>();
		
	}

	public void scontroCompleto() {
		saccaComune = riempiSacca(dimensioneSacca);
		g1.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
		g2.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
		caricaGolem(g1);
		caricaGolem(g2);
		while(g1.getGolem().getListaPietre().equals(g2.getGolem().getListaPietre()))
			seStessePietre(g2);

		while (g1.getNumeroGolem() > 0 && g2.getNumeroGolem() > 0) {
			scontroSingolo();
		}
		if (g1.getNumeroGolem() > 0 && g2.getNumeroGolem() == 0) {
			System.out.println(String.format(VITTORIA, g1.getNome()));
			g1.setVittorie(g1.getVittorie() + 1);
		} else if (g2.getNumeroGolem() > 0 && g1.getNumeroGolem() == 0) {
			System.out.println(String.format(VITTORIA, g2.getNome()));
			g2.setVittorie(g2.getVittorie() + 1);
		}
	}

	public void scontroSingolo() {
		int indicePietreTama1 = 0;
		int indicePietreTama2 = 0;
		do {
			lanciaPietre(indicePietreTama1, indicePietreTama2);
			System.out.println(GOLEM);
			
			if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() > 0) {
				if (danni(indicePietreTama1, indicePietreTama2) > 0)
					System.out.println(String.format(DANNI, g2.getNome(), danni(indicePietreTama1, indicePietreTama2)));
				else if (danni(indicePietreTama1, indicePietreTama2) < 0)
					System.out.println(String.format(DANNI, g1.getNome(), -danni(indicePietreTama1, indicePietreTama2)));
				else if(danni(indicePietreTama1, indicePietreTama2) == 0)
					System.out.println(ELEMENTI_UGUALI);
				InputDati.leggiIntero("Per lanciare le pietre permi 0", 0, 0);
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

		if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() <= 0) {
			indicePietreTama1++;
			indicePietreTama2 = 0;
			g2.setNumeroGolem(g2.getNumeroGolem() - 1);
			System.out.println(String.format(MORTE_GOLEM, g2.getNome()));
			if (g2.getNumeroGolem() > 0){
				g2.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
				caricaGolem(g2);
				while(g1.getGolem().getListaPietre().equals(g2.getGolem().getListaPietre()))
					seStessePietre(g2);
			}
		}

		else if (g1.getGolem().getVita() <= 0 && g2.getGolem().getVita() > 0) {
			indicePietreTama2++;
			indicePietreTama1 = 0;
			g1.setNumeroGolem(g1.getNumeroGolem() - 1);
			System.out.println(String.format(MORTE_GOLEM, g1.getNome()));
			if (g1.getNumeroGolem() > 0){
				g1.setGolem(new TamaGolem(equilibrio.getNumeroElementi()));
				caricaGolem(g1);
				while(g1.getGolem().getListaPietre().equals(g2.getGolem().getListaPietre()))
					seStessePietre(g1);
			}
		}
	}

	public void lanciaPietre(int indicePietreTama1, int indicePietreTama2) {

		if (danni(indicePietreTama1, indicePietreTama2) > 0) {
			g2.getGolem().setVita(g2.getGolem().getVita() - danni(indicePietreTama1, indicePietreTama2));
		} else if (danni(indicePietreTama1, indicePietreTama2) < 0) {
			g1.getGolem().setVita(g1.getGolem().getVita() + danni(indicePietreTama1, indicePietreTama2));
		}
	}

	public int danni(int elemento1, int elemento2) {
		int[][] matEquilibrio = equilibrio.getMatriceEquilibrio();
		int e1 = g1.getGolem().getListaPietre().get(elemento1).getElementoRiferimento().ordinal();
		int e2 = g2.getGolem().getListaPietre().get(elemento2).getElementoRiferimento().ordinal();
		return matEquilibrio[e1][e2];
	}

	public ArrayList<Pietra> riempiSacca(int dimensioneSacca) {
		ArrayList<Pietra> sacca = new ArrayList<Pietra>();
		int elementoCorrente = 0;
		int numeroPietrePerElemento = (int)((double)dimensioneSacca / (double)equilibrio.getNumeroElementi());
		int contatorePietre = 0;
		Elementi[] arrayElementi = Elementi.values();
		for (int pietreInSacca = 0; pietreInSacca < dimensioneSacca; pietreInSacca++) {

			sacca.add(new Pietra(arrayElementi[elementoCorrente]));
			contatorePietre++;
			if (contatorePietre == numeroPietrePerElemento) {
				contatorePietre = 0;
				elementoCorrente++;
			}
		}
		return sacca;
	}

	public void caricaGolem(Giocatore giocatore) {
		int numPietreDaAggiungere = giocatore.getGolem().getPietrePerGolem();
		Pietra daAggiungere = null;
		System.out.println(String.format("%s carica il tuo golem", giocatore.getNome()));

		do {
			do {
				daAggiungere = new Pietra(Menu.chiediPietra(equilibrio.getNumeroElementi(), giocatore.getNome()));
				if (!(saccaComune.contains(daAggiungere)))
					System.out.println(PIETRA_NON_DISPONIBILE);

			} while (!saccaComune.contains(daAggiungere));

			giocatore.getGolem().getListaPietre().add(daAggiungere);
			saccaComune.remove(daAggiungere);
			System.out.println(PIETRA_AGGIUNTA_BENE);
		} while (giocatore.getGolem().getListaPietre().size() < numPietreDaAggiungere);

	}
	//nel caso in cui il secondo giocatore abbia scelto le stesse pietre del primo allora si svuota il suo golem e le pietre
		//che aveva mangiato vengono rimesse nella sacca comune e gli viene chiesto nuovamente di riempire la sacca
		public void seStessePietre(Giocatore giocatore){
			System.out.println("I vostri golem hanno mangiato le stesse pietre!!!");
			System.out.println("...il tuo golem le sta vomitando nella sacca comune...");

			//le pietre che ha vomitato vengono riaggiunte alla sacca
			saccaComune.addAll(giocatore.getGolem().getListaPietre());
			giocatore.getGolem().getListaPietre().clear();
			System.out.print("\n");
			System.out.println("Ora puoi aggiungere nuove pietre!!");
			caricaGolem(giocatore);
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
