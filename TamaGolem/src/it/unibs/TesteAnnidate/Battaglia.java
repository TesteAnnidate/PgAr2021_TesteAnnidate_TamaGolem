package it.unibs.TesteAnnidate;

import java.util.ArrayList;

public class Battaglia {

	public static final String VITTORIA_G2 = String.format("Bravo %s, HAI VINTO!!", g2.getNome());
	public static final String VITTORIA_G1 = String.format("Bravo %s, HAI VINTO!!", g1.getNome());
	private static final char[] DANNI_FORMAT = String.format(
			"Il giocatore 1 ha subito %d danni, mentre il giocatore 2 ne ha subiti %d", danni(elemento1, elemento2),
			danni(elemento2, elemento1));

	private Giocatore g1;
	private Giocatore g2;
	private ArrayList<Pietra> saccaComune;

	public void scontroCompleto() {
		g1.setGolem(evocaGolem);
		g2.setGolem(evocaGolem);

		while (g1.getNumeroGolem() > 0 && g2.getNumeroGolem() > 0) {
			scontroSingolo();
		}
		if (g1.getNumeroGolem() > 0 && g2.getNumeroGolem() == 0) {
			System.out.println(VITTORIA_G1);
			g1.setVittorie(g1.getVittorie() + 1);
		} else if (g2.getNumeroGolem() > 0 && g1.getNumeroGolem() == 0) {
			System.out.println(VITTORIA_G2);
			g2.setVittorie(g2.getVittorie() + 1);
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
				k++; // metti is esausto
			} else if (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() <= 0) {
				i++;
				k = 0;
				g2.setNumeroGolem(g2.getNumeroGolem() - 1);
				if (g2.getNumeroGolem() > 0)
					g2.getGolem() = new TamaGolem.evocaGolem();
			}

			else if (g1.getGolem().getVita() <= 0 && g2.getGolem().getVita() > 0) {
				k++;
				i = 0;
				g1.setNumeroGolem(g1.getNumeroGolem() - 1);
				if (g1.getNumeroGolem() > 0)
					g1.getGolem() = new TamaGolem.evocaGolem();
			}

		} while (g1.getGolem().getVita() > 0 && g2.getGolem().getVita() > 0);
	}

	// Costruttore dati due giocatori
	public Battaglia(Giocatore g1, Giocatore g2, int numElementi) {
		super();
		this.g1 = g1;
		this.g2 = g2;
		this.saccaComune = riempiSacca(numElementi);
	}

	public void caricaGolem(g1) {
		
		Menu
		(Elemento -> Quantità) (Verifica la presenza delle pietre nella sacca e se il tamaGolem 
				ha raggiunti il numero max di pietre)
		g1.getGolem().getClass().add(new Pietra);
		saccaComune.remove(Pietra);

	
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
}
