package it.unibs.TesteAnnidate;

import java.util.ArrayList;

public class Giocatore {

	// private ArrayList<TamaGolem> listaGolem = new ArrayList<>();
	private int numeroGolem; //G
	private TamaGolem golem;
	private int vittorie;
	private String nome;

	
	

	// Costruttore che prende come parametro il nome del giocatore e azzera le vittorie
	public Giocatore(String nome, int numeroGolem) {
		super();
		this.numeroGolem = numeroGolem;
		this.nome = nome;
		this.vittorie = 0;
		this.golem = new TamaGolem()
	}
	// Getters e setters

	public int getNumeroGolem() {
		return numeroGolem;
	}

	public void setNumeroGolem(int numeroGolem) {
		this.numeroGolem = numeroGolem;
	}

	public TamaGolem getGolem() {
		return golem;
	}

	public void setGolem(TamaGolem golem) {
		this.golem = golem;
	}

	public int getVittorie() {
		return vittorie;
	}

	public void setVittorie(int vittorie) {
		this.vittorie = vittorie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
