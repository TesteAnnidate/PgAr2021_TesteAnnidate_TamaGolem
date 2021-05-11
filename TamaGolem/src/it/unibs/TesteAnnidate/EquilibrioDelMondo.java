package it.unibs.TesteAnnidate;

import java.util.ArrayList;
import java.util.Random;

public class EquilibrioDelMondo {

    int numeroElementi;
    int[][] matriceEquilibrio;

    public EquilibrioDelMondo(int numeroElementi){
        this.numeroElementi = numeroElementi;
        this.matriceEquilibrio = new int[numeroElementi][numeroElementi];
    }

    public boolean isCorrect(){
        int contatore = 0;
        for(int i = 0; i < this.numeroElementi; i++){
            for(int j = 0; j < this.numeroElementi; j ++){
                if(i != j && this.matriceEquilibrio[i][j] == 0) return false;
            }
        }
        return true;
    }

    public int[][] tabellaProvvisoria() {
        int positivo = 1;
        int massimaPotenzaGenerabile = this.numeroElementi / 2 + this.numeroElementi / 4;
        int prevaleMax = this.numeroElementi / 2;     //massimo numero di elementi sul qual epuo prevalere
        int subisceMax = this.numeroElementi / 2;

        int[][] matrice_adiacenza = new int[this.numeroElementi][this.numeroElementi];

        Random generatore = new Random();

        for (int riga = 0; riga < this.numeroElementi; riga++) {

            int somma_potenze_riga = 0;
            int somma_debolezze = 0;
            int numeroPrevalenze = 0;
            int numeroDebolezze = 0;

            for (int colonna = 0; colonna < this.numeroElementi; colonna++) {
                //controllo anche che la casella non sia ancora stata impostata, se lo è allora passo avanti ma
                //tengo comunque conto della potenza già presente
                if (matrice_adiacenza[riga][colonna] == 0) {
                    //controllo di trovarmi in corrispondenza di elementi diversi e controllo anche non sia stato superato
                    //il numero massimo di elementi sui quali prevalere
                    if (riga != colonna) {
                        int lancioMoneta = generatore.nextInt(2);  //fra 0 e 1

                        if (lancioMoneta == positivo) {
                            if (numeroPrevalenze < prevaleMax) {
                                matrice_adiacenza[riga][colonna] = generatore.nextInt(massimaPotenzaGenerabile - 1) + 1;
                                //se la casella sopra è positiva allora la sua opposta deve essere negativa
                            } else {
                                matrice_adiacenza[riga][colonna] = -(generatore.nextInt(massimaPotenzaGenerabile - 1) + 1);
                            }
                        } else {
                            if (numeroDebolezze < subisceMax) {
                                matrice_adiacenza[riga][colonna] = -(generatore.nextInt(massimaPotenzaGenerabile - 1) + 1);
                            } else {
                                matrice_adiacenza[riga][colonna] = generatore.nextInt(massimaPotenzaGenerabile - 1) + 1;
                                //se la casella sopra è positiva allora la sua opposta deve essere negativa
                            }
                        }
                        matrice_adiacenza[colonna][riga] = -matrice_adiacenza[riga][colonna];

                    }

                }
                if (matrice_adiacenza[riga][colonna] > 0) {
                    somma_potenze_riga += matrice_adiacenza[riga][colonna];
                    numeroPrevalenze++;
                } else if (matrice_adiacenza[riga][colonna] < 0) {
                    somma_debolezze += matrice_adiacenza[riga][colonna];
                    numeroDebolezze++;
                }

                int moduloPotenze = Math.abs(somma_potenze_riga);
                int moduloDebolezze = Math.abs(somma_debolezze);


                //controllo che le debolezze siano uguali alle potenze
                if (colonna == (this.numeroElementi - 1) && moduloDebolezze != moduloPotenze) {
                    if (moduloDebolezze < moduloPotenze) {
                        int potenza_mancante = moduloPotenze - moduloDebolezze;
                        //parto dalla riga che sto considerando, le altre non le tocco
                        for (int index2 = riga; index2 < this.numeroElementi; index2++) {
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

                    } else {   //nel caso in cui ho ottenuto una potenza maggiore
                        //faccio ripassare tutta la colonna e finche la potenza è maggiore o uguale a 2
                        //la diminuisco di uno finche ottengo la somma che mi serve
                        //nel caso finissi di passare la colonna e le cose non andassero ancora bene allora farei
                        //un'altra passata (per il do-while)
                        int potenzaMancante = moduloDebolezze - moduloPotenze;
                        for (int index3 = riga; index3 < this.numeroElementi; index3++) {
                            if (matrice_adiacenza[riga][index3] > 0) {
                                matrice_adiacenza[riga][index3] += potenzaMancante;
                                matrice_adiacenza[index3][riga] = -matrice_adiacenza[riga][index3];
                                break;
                            } else if (matrice_adiacenza[riga][index3] < 0) {
                                matrice_adiacenza[riga][index3] += potenzaMancante;
                                matrice_adiacenza[index3][riga] = -matrice_adiacenza[riga][index3];
                                break;
                            }
                        }
                    }

                }
            }
        }

        return matrice_adiacenza;

    }

    public void vediTabella(){
        //Elementi [] elementi = Elementi.values();
        for (int i = 0; i < numeroElementi; i++) {
            System.out.print("|");
            for (int j = 0; j < numeroElementi; j++) {
                System.out.printf(" %2d ", matriceEquilibrio[i][j]);
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }

    public int getNumeroElementi() {
        return numeroElementi;
    }

    public int[][] getMaticeEquilibrio() {
        return matriceEquilibrio;
    }

    public void setMatriceEquilibrio(int[][] matrice) {
        this.matriceEquilibrio = matrice;
    }
}



