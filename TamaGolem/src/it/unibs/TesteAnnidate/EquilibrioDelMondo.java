package it.unibs.TesteAnnidate;

import it.unibs.fp.mylib.InputDati;

import java.util.Random;

public class EquilibrioDelMondo {



    public static final int NUM_ELEMENTI = 4;
    public static final int POTENZA_MAX = 6;   //massimo valore di danno che un elemento può fare
    public static final int DEFAULT = -1;

    int [][] matrice_adiacenza = new int[NUM_ELEMENTI][NUM_ELEMENTI];







    //so che ad esempio la somma degli elementi sulla riga [TERRA][ACQUA] deve essere uguale alla somma degli elementi
    //sulla riga [ACQUA][TERRA], ossia la somma dei pesi sugli elementi piu forti deve essere uguale alla somma dei pesi
    //su quelli piu deboli

    /*public EquilibrioDelMondo(){

        //riempio la tabella con -1, così so già dove sono passata e dove no


        //inizio a riempire la tabella, scelgo con un rand il primo elemento e con un rand il secondo.

        //prima potrei inserire valori -1 nella tabella così da assicurarmi di essere passata per tutta la tabella
        int caselle_passate = 0;

        do{
            Random generatore = new Random();
            //ottengo un numero casuale compreso fra 0 e 4
            int riga= generatore.nextInt(Elementi.SCHIFO.ordinal() + 1);
            int colonna = generatore.nextInt(Elementi.SCHIFO.ordinal() + 1);

            if(riga == colonna) {
                this.matrice_adiacenza[riga][colonna] = 0;
                caselle_passate ++;    //lo aumento solo di uno perchè la cella che ho cambiato è una sola
            }

            if(riga != colonna && this.matrice_adiacenza[riga][colonna] == DEFAULT){  //default puo essere tipo -1
                int potenza_assegnata = generatore.nextInt(POTENZA_MAX + 1);

                this.matrice_adiacenza[riga][colonna] = potenza_assegnata;

                //se ho assegnato a zero il valore [TERRA][ACQUA] vuol dire che in questo caso l'elemento debole è
                //la terra e quindi vado a impostare il valore di potenza dell'acqua sulla terra (per esempio)
                if(potenza_assegnata == 0){
                    this.matrice_adiacenza[colonna][riga] = generatore.nextInt(POTENZA_MAX + 1);
                }else this.matrice_adiacenza[colonna][riga] = 0;

                caselle_passate +=2;

            }

        }while(caselle_passate < NUM_ELEMENTI*NUM_ELEMENTI);
    }*/


    //lista di matrici




}
