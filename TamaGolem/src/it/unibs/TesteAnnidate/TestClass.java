package it.unibs.TesteAnnidate;

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        final int NUM_ELEMENTI = 5;
        final int POTENZA_MAX = 3;   //massimo valore di danno che un elemento può fare prevalendo su un altro
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
                    if (moduloDebolezze < moduloPotenze) {
                        int potenza_mancante = moduloPotenze - moduloDebolezze;
                        //parto dalla riga che sto considerando, le altre non le tocco
                        for (int index2 = riga; index2 < NUM_ELEMENTI; index2++) {
                            if (matrice_adiacenza[riga][index2] < 0) {  //se il primo che incontro è negativo
                                matrice_adiacenza[riga][index2] -= potenza_mancante;
                                matrice_adiacenza[index2][riga] = -matrice_adiacenza[riga][index2];
                                break;
                            } else if (matrice_adiacenza[riga][index2] > 0 && matrice_adiacenza[riga][index2] > (potenza_mancante + 1)) {
                                matrice_adiacenza[riga][index2] -= potenza_mancante;
                                matrice_adiacenza[index2][riga] = -matrice_adiacenza[riga][index2];
                                break;
                            }
                        }

                    } else{   //nel caso in cui ho ottenuto una potenza maggiore
                        //faccio ripassare tutta la colonna e finche la potenza è maggiore o uguale a 2
                        //la diminuisco di uno finche ottengo la somma che mi serve
                        //nel caso finissi di passare la colonna e le cose non andassero ancora bene allora farei
                        //un'altra passata (per il do-while)
                        int potenzaMancante = moduloDebolezze - moduloPotenze;
                        for (int index3 = riga; index3 < NUM_ELEMENTI; index3++) {
                            if (matrice_adiacenza[riga][index3] > 0) {
                                matrice_adiacenza[riga][index3] += potenzaMancante;
                                matrice_adiacenza[index3][riga] = - matrice_adiacenza[riga][index3];
                                break;
                            }else if (matrice_adiacenza[riga][index3] < 0 && matrice_adiacenza[riga][index3] < -(potenzaMancante + 1)) {
                                matrice_adiacenza[riga][index3] += potenzaMancante;
                                matrice_adiacenza[index3][riga] = -matrice_adiacenza[riga][index3];
                                break;
                            }
                        }
                    }

                }
            }
        }

        for (int i = 0; i < NUM_ELEMENTI; i++) {
            for (int j = 0; j < NUM_ELEMENTI; j++) {
                System.out.print(matrice_adiacenza[i][j]+ " ");
            }
            System.out.println("\n");
        }

    }
}


