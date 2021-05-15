package it.unibs.TesteAnnidate;

public class Giocatore {
	private int numeroGolem; // G
	private TamaGolem golem; 
	private int vittorie;
	private String nome;

	/*Costruttore che prende in input il nome, il numero di golem che ogni giocatore può avere e il numero di elementi
	* nell'equilibrio per generare un giocatore.
	* l'attributo vittore è stato messo per una possile classifica che però non è stata creata.*/
	public Giocatore(String nome, int numeroGolem, int numeroElementi) {
		this.numeroGolem = numeroGolem;
		this.nome = nome;
		this.vittorie = 0;
		this.golem = new TamaGolem(numeroElementi);
	}

	// GETTERS E SETTERS
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
