package it.unibs.TesteAnnidate;

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        final int NUM_ELEMENTI = 5;
        final int POTENZA_MAX = 4;   //massimo valore di danno che un elemento può fare prevalendo su un altro
        final int DEFAULT = -80;          //valore con cui viene inizializzata la matrice inizialmente
        final int NUM_DEBOLI_MASSIMI = 2;    //stabilisco il massimo numero di elementi su cui un elemento può prevalere
        //per evitare che un elemento non interascisca con nessuno

        int[][] matrice_adiacenza = new int[NUM_ELEMENTI][NUM_ELEMENTI];


        for (int i = 0; i < NUM_ELEMENTI; i++) {
            for (int j = 0; j < NUM_ELEMENTI; j++) {
                matrice_adiacenza[i][j] = DEFAULT;
            }
        }

        Random generatore = new Random();

        for (int riga = 0; riga < NUM_ELEMENTI; riga++) {

            int somma_potenze_riga = 0;
            int somma_debolezze = 0;
            int numero_deboli = 0;

            for (int j = 0; j < NUM_ELEMENTI; j++) {
                //se l'elemento che sto considerando arriva a prevalere sul numero massimo di elementi allora le
                //interazioni con i restanti verrano poste a zero
                //controllo anche che la casella non sia ancora stata impostata, se lo è allora passo avanti ma
                //tengo comunque conto della potenza già presente (vedi riga 48)
                if (matrice_adiacenza[riga][j] == DEFAULT) {
                    //controllo di trovarmi in corrispondenza di elementi diversi e controllo anche non sia stato superato
                    //il numero massimo di elementi sui quali prevalere
                    if (riga != j) {
                        if (numero_deboli < NUM_DEBOLI_MASSIMI) {
                            matrice_adiacenza[riga][j] = generatore.nextInt(POTENZA_MAX - 1) + 1;
                            //se la casella sopra è positiva allora la sua opposta deve essere negativa
                            matrice_adiacenza[j][riga] = -matrice_adiacenza[riga][j];
                            numero_deboli++;

                        } else {
                            matrice_adiacenza[riga][j] = -(generatore.nextInt(POTENZA_MAX - 1) + 1);
                            matrice_adiacenza[j][riga] = -matrice_adiacenza[riga][j];

                        }
                    } else matrice_adiacenza[riga][j] = 0;

                }
                if (matrice_adiacenza[riga][j] > 0)
                    somma_potenze_riga += matrice_adiacenza[riga][j];
                else if (matrice_adiacenza[riga][j] < 0)
                    somma_debolezze += matrice_adiacenza[riga][j];

                int moduloPotenze = Math.abs(somma_potenze_riga);
                int moduloDebolezze = Math.abs(somma_debolezze);

                //controllo che le debolezze siano uguali alle potenze
                if (j == (NUM_ELEMENTI - 1) && moduloDebolezze != moduloPotenze) {
                    //se sono piu piccole le cose negative decremento i positivi
                    if(moduloDebolezze < moduloPotenze){
                        do {
                            for (int index2 = riga; index2 < NUM_ELEMENTI; index2++) {
                                //non se è gia 1 o -1 non posso farlo andare a 0
                                if (matrice_adiacenza[riga][index2] >= 2) {
                                    matrice_adiacenza[riga][index2]--;
                                    matrice_adiacenza[index2][riga]++;
                                    moduloPotenze--;
                                }else if(matrice_adiacenza[riga][index2] < 0){
                                    matrice_adiacenza[riga][index2] --;
                                    matrice_adiacenza[index2][riga]++;
                                    moduloDebolezze ++;
                                }

                                if (moduloDebolezze == moduloPotenze)
                                    break;
                            }
                        }while (moduloDebolezze != moduloPotenze) ;
                    //se il modulo delle potenze è piu grande
                    }else{
                        do {
                            for (int index2 = riga; index2 < NUM_ELEMENTI; index2++) {
                                //non se è gia 1 o -1 non posso farlo andare a 0
                                if (matrice_adiacenza[riga][index2] >0) {
                                    matrice_adiacenza[riga][index2]++;
                                    matrice_adiacenza[index2][riga]--;
                                    moduloPotenze++;
                                }else if(matrice_adiacenza[riga][index2] <= -2){
                                    matrice_adiacenza[riga][index2] ++;
                                    matrice_adiacenza[index2][riga]--;
                                    moduloDebolezze --;
                                }

                                if (moduloDebolezze == moduloPotenze)
                                    break;
                            }
                        }while (moduloDebolezze != moduloPotenze) ;
                    }
                }
            }
        }
    }
}


