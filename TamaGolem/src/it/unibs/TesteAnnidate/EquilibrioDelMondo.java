package it.unibs.TesteAnnidate;

import java.util.ArrayList;
import java.util.Random;

public class EquilibrioDelMondo {



    public static final int NUM_ELEMENTI = 4;
    public static final int POTENZA_MAX = 6;   //massimo valore di danno che un elemento può fare
    public static final int DEFAULT = -1;

    int [][] matrice_adiacenza = new int[NUM_ELEMENTI][NUM_ELEMENTI];


    public EquilibrioDelMondo(){
        //inizializzo la matrice con il valore di default DEFAULT

        for(int i = 0; i < NUM_ELEMENTI; i++)
            for(int j = 0; j < NUM_ELEMENTI; j++)
                matrice_adiacenza[i][j] = DEFAULT;

        Random generatore = new Random();

        for(int riga = 0; riga < NUM_ELEMENTI; riga++){

            int somma_potenze_riga = 0;      //deve essere uguale alla somma delle potenze sulla colonna dello stesso indice
            int somma_potenze_colonna = 0;

            for(int j = 0; j < NUM_ELEMENTI; j++){
                if(riga != j){   //controllo se mi trovo in corrispondenza di elementi diversi
                    //genero un numero a caso fra 0 e POTENZA_MAX
                    matrice_adiacenza[riga][j] = generatore.nextInt(POTENZA_MAX);
                    somma_potenze_riga += matrice_adiacenza[riga][j];

                }else matrice_adiacenza[riga][j] = 0;

                //passo la colonna corrispondente alla riga appena creata
                do{

                    for(int index = 0; index < NUM_ELEMENTI; index++){
                        if(matrice_adiacenza[index][riga] == DEFAULT){    //se è uguale a -1 vuol dire che non ci sono ancora passata

                            //se ad esempio [ACQUA][TERRA] = 0 allora vuol dire che è la terra ad essere pi forte e quindi
                            //setto gli indici opposti con un numero diverso da 0;
                            if(matrice_adiacenza[riga][index] == 0){
                                matrice_adiacenza[index][riga] = generatore.nextInt(POTENZA_MAX - 1) + 1;
                                somma_potenze_colonna += matrice_adiacenza[index][riga];

                            }else matrice_adiacenza[index][riga] = 0;
                        }
                    }

                }while (somma_potenze_colonna <= somma_potenze_riga);

            }

        }
    }




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
