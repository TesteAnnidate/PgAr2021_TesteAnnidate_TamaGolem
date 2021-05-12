package it.unibs.TesteAnnidate;

import java.util.ArrayList;

public class TamaGolem {

	private ArrayList<Pietra> listaPietre = new ArrayList<>();
    private int vita;
    private int numPietre;   //P


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

    //metodo is esausto

    //TamaGolem: generatore;

	public TamaGolem(int numElementi){
    	//this.listaPietre   caricamento pietre
		this.vita = numElementi * 4;
		this.numPietre = ((numElementi +1)/3) + 1;
	}


    
    

}
