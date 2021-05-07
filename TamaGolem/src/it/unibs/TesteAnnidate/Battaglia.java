package it.unibs.TesteAnnidate;

public class Battaglia {

	private static final char[] DANNI_FORMAT = String.format(
			"Il giocatore 1 ha subito %d danni, mentre il giocatore 2 ne ha subiti %d", danni(elemento1, elemento2),
			danni(elemento2, elemento1));
	private Giocatore g1;
	private Giocatore g2;
	private boolean isTerminata;

	public void scontroCompleto() {
		g1.getGolem() = new TamaGolem.evocaGolem();
		g2.getGolem() = new TamaGolem.evocaGolem();
		while (g1.getNumeroGolem() > 0 || g2.getNumeroGolem() > 0) {
			scontroSingolo();
		}

	}

	public void scontroSingolo() {
		int i = 0;
		int k = 0;
		do {
			g1.getGolem().lanciaPietra(i);
			g2.getGolem().lanciaPietra(k);
			if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() > 0) {
				System.out.println(DANNI_FORMAT);
				i++;
				k++;
			} else if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() <= 0) {
				i++;
				k = 0;
				g2.setNumeroGolem(g2.getNumeroGolem() - 1);
				if(g2.getNumeroGolem() > 0)
					   g2.getGolem() = new TamaGolem.evocaGolem();
			}

			else if (g1.getGolem().getVita() <= 0 && g2.getGolem().getVita() > 0) {
				k++;
				i = 0;
				g1.setNumeroGolem(g1.getNumeroGolem() - 1);
				if(g1.getNumeroGolem() > 0)
				   g1.getGolem() = new TamaGolem.evocaGolem();
			}

		} while (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() > 0);
	}

	// Costruttore dati due giocatori
	public Battaglia(Giocatore g1, Giocatore g2) {
		super();
		this.g1 = g1;
		this.g2 = g2;
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

	public boolean isTerminata() {
		return isTerminata;
	}

	public void setTerminata(boolean isTerminata) {
		this.isTerminata = isTerminata;
	}

}
