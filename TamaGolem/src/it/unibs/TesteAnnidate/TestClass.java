package it.unibs.TesteAnnidate;

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        /*int NUM_ELEMENTI = 10;
        int POTENZA_MAX = NUM_ELEMENTI/2 + NUM_ELEMENTI/4;   //massimo valore di danno che un elemento può fare prevalendo su un altro
        //numero elementi/2 + numero elementi/4

        int PREVALE_MAX = NUM_ELEMENTI/2;    //stabilisco il massimo numero di elementi su cui un elemento può prevalere
                                            //per evitare che un elemento non interascisca con nessuno

        //metodo per controllare tabella e vedere se compaiono altri zeri oltre a  quelli che devono esserci oppure
        // che controlla la somma

        final int DEBOLEZZE_MAX = NUM_ELEMENTI/2;
        final int POSITIVO = 1;

        int[][] matrice_adiacenza = new int[NUM_ELEMENTI][NUM_ELEMENTI];

        Random generatore = new Random();

        for (int riga = 0; riga < NUM_ELEMENTI; riga++) {

            int somma_potenze_riga = 0;
            int somma_debolezze = 0;
            int numeroPrevalenze = 0;
            int numeroDebolezze = 0;

            for (int colonna = 0; colonna < NUM_ELEMENTI; colonna++) {
                //controllo anche che la casella non sia ancora stata impostata, se lo è allora passo avanti ma
                //tengo comunque conto della potenza già presente (vedi riga 48)
                if (matrice_adiacenza[riga][colonna] == 0) {
                    //controllo di trovarmi in corrispondenza di elementi diversi e controllo anche non sia stato superato
                    //il numero massimo di elementi sui quali prevalere
                    if (riga != colonna) {
                        int lancioMoneta = generatore.nextInt(2);  //fra 0 e 1

                        if(lancioMoneta == POSITIVO) {
                            if (numeroPrevalenze < PREVALE_MAX) {
                                matrice_adiacenza[riga][colonna] = generatore.nextInt(POTENZA_MAX - 1) + 1;
                                //se la casella sopra è positiva allora la sua opposta deve essere negativa
                            } else {
                                matrice_adiacenza[riga][colonna] = -(generatore.nextInt(POTENZA_MAX - 1) + 1);
                            }
                        }else {
                            if(numeroDebolezze < DEBOLEZZE_MAX){
                                matrice_adiacenza[riga][colonna] = -(generatore.nextInt(POTENZA_MAX - 1) + 1);
                            }else{
                                matrice_adiacenza[riga][colonna] = generatore.nextInt(POTENZA_MAX - 1) + 1;
                                //se la casella sopra è positiva allora la sua opposta deve essere negativa
                            }
                        }
                        matrice_adiacenza[colonna][riga] = -matrice_adiacenza[riga][colonna];

                    }

                }
                if (matrice_adiacenza[riga][colonna] > 0) {
                    somma_potenze_riga += matrice_adiacenza[riga][colonna];
                    numeroPrevalenze++;
                }
                else if (matrice_adiacenza[riga][colonna] < 0) {
                    somma_debolezze += matrice_adiacenza[riga][colonna];
                    numeroDebolezze++;
                }

                //controllo di essere sulla penultima riga, quella che crea casini e e faccio in modo che la somma delle
                //potenze che ci sono prima di inizializzare l'ultimo elemento non sia 0, altrimenti è tipo un casino.


                int moduloPotenze = Math.abs(somma_potenze_riga);
                int moduloDebolezze = Math.abs(somma_debolezze);


                //controllo che le debolezze siano uguali alle potenze
                if (colonna == (NUM_ELEMENTI - 1) && moduloDebolezze != moduloPotenze) {
                    if (moduloDebolezze < moduloPotenze) {
                        int potenza_mancante = moduloPotenze - moduloDebolezze;
                        //parto dalla riga che sto considerando, le altre non le tocco
                        for (int index2 = riga; index2 < NUM_ELEMENTI; index2++) {
                            if (matrice_adiacenza[riga][index2] < 0) {  //se il primo che incontro è negativo
                                matrice_adiacenza[riga][index2] -= potenza_mancante;
                                matrice_adiacenza[index2][riga] = -matrice_adiacenza[riga][index2];
                                break;
                            } else if (matrice_adiacenza[riga][index2] > 0) {
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
                            }else if (matrice_adiacenza[riga][index3] < 0) {
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
        }*/

    }
}


