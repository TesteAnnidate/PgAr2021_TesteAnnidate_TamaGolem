package it.unibs.TesteAnnidate;

import java.util.ArrayList;

public class TamaGolem {

	private ArrayList<Pietra> listaPietre = new ArrayList<>();
    private int vita;
    private int pietrePerGolem; // P


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

    //metodo is esausto

    
	//TamaGolem: generatore;
	public TamaGolem(){
		
	}

	public TamaGolem(int numElementi){
    	//this.listaPietre   caricamento pietre
		this.vita = numElementi * 4;
		this.pietrePerGolem = ((numElementi +1)/3) + 1;
	}
	

    
    

}
