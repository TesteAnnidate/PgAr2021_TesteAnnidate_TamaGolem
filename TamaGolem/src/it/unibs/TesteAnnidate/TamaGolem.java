package it.unibs.TesteAnnidate;

import java.util.ArrayList;

public class TamaGolem {

	private ArrayList<Pietra> listaPietre = new ArrayList<>();
	private int vita;
	private int pietrePerGolem; // P

	// Costruttore
	public TamaGolem(int numElementi) {
		this.vita = numElementi * 2;
		this.pietrePerGolem = (int)(((double)numElementi + 1) / 3) + 1;
	}
	
	// Getters e setters
	public ArrayList<Pietra> getListaPietre() {
		return listaPietre;
	}

	public void setListaPietre(ArrayList<Pietra> listaPietre) {
		this.listaPietre = listaPietre;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getPietrePerGolem() {
		return pietrePerGolem;
	}

	public void setPietrePerGolem(int pietrePerGolem) {
		this.pietrePerGolem = pietrePerGolem;
	}

	
}
