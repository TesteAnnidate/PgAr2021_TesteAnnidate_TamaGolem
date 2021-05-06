package it.unibs.TesteAnnidate;

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        final int NUM_ELEMENTI = 4;
        final int POTENZA_MAX = 6;   //massimo valore di danno che un elemento può fare
        final int DEFAULT = -1;
        final int NUM_DEBOLI_MASSIMI = 2;    //stabilisco il massimo numero di elementi su cui un elemento può prevalere

        int[][] matrice_adiacenza = new int[NUM_ELEMENTI][NUM_ELEMENTI];

        //inizializzo la matrice con il valore di default DEFAULT

        for (int i = 0; i < NUM_ELEMENTI; i++)
            for (int j = 0; j < NUM_ELEMENTI; j++)
                matrice_adiacenza[i][j] = DEFAULT;

        Random generatore = new Random();

        for (int riga = 0; riga < NUM_ELEMENTI; riga++) {

            int somma_potenze_riga = 0;      //deve essere uguale alla somma delle potenze sulla colonna dello stesso indice
            int somma_potenze_colonna = 0;
            int numero_deboli = 0;

            for (int j = 0; j < NUM_ELEMENTI; j++) {
                //se l'elemento che sto considerando arriva a prevalere sul numero massimo di elementi allora le
                //interazioni con i restanti verrano poste a zero
                //controllo anche che la casella non sia ancora stata impostata, se lo è allora passo avanti ma
                //tengo comunque conto della potenza già presente
                if(matrice_adiacenza[riga][j] == DEFAULT){
                    if (riga != j && numero_deboli < NUM_DEBOLI_MASSIMI) {   //controllo se mi trovo in corrispondenza di elementi diversi
                        //genero un numero a caso fra 0 e POTENZA_MAX
                        matrice_adiacenza[riga][j] = generatore.nextInt(POTENZA_MAX);
                        numero_deboli++;

                    } else matrice_adiacenza[riga][j] = 0;
                }

                //controllo che ci sia almeno un numero inserito nella riga
                //se numero_deboli è = 0 vuol dire che tale elemento non prevale su nessun altro e non avrebbe senso
                if(j == NUM_ELEMENTI-1 && numero_deboli == 0)
                    matrice_adiacenza[riga][j] = generatore.nextInt(POTENZA_MAX -1) + 1;

                if(matrice_adiacenza[riga][j] != DEFAULT)
                    somma_potenze_riga += matrice_adiacenza[riga][j];
            }

            //passo la colonna corrispondente alla riga appena creata
            //do{

            for (int index = 0; index < NUM_ELEMENTI; index++) {
                if (matrice_adiacenza[index][riga] == DEFAULT) {    //se è uguale a -1 vuol dire che non ci sono ancora passata


                    //se ad esempio [ACQUA][TERRA] = 0 allora vuol dire che è la terra ad essere pi forte e quindi
                    //setto gli indici opposti con un numero diverso da 0;

                    if (matrice_adiacenza[riga][index] == 0) {
                        matrice_adiacenza[index][riga] = generatore.nextInt(POTENZA_MAX - 1) + 1;

                    } else matrice_adiacenza[index][riga] = 0;

                }

                if(matrice_adiacenza[index][riga] != DEFAULT)
                    somma_potenze_colonna += matrice_adiacenza[index][riga];

                //se una volta inserito il numero nell'ultima casella della colonna che sto considerando
                //e che le potenze della colonna sono ancora piu piccole (o piu grandi) della riga allora
                //imposto la prima casella della colonna (diversa da 0) al valore che mi manca
                if (index == (NUM_ELEMENTI - 1) && somma_potenze_colonna != somma_potenze_riga) {
                    if (somma_potenze_colonna < somma_potenze_riga) {
                        for (int index2 = 0; index2 < NUM_ELEMENTI; index2++){
                            if (matrice_adiacenza[index2][riga] != 0) {
                                int potenza_mancante = somma_potenze_riga - somma_potenze_colonna;
                                matrice_adiacenza[index2][riga] += potenza_mancante;
                                break;
                            }
                        }
                    } else {   //nel caso in cui ho ottenuto una potenza maggiore
                        //faccio ripassare tutta la colonna e finche la potenza è maggiore o uguale a 2
                        //la diminuisco di uno finche ottengo la somma che mi serve
                        //nel caso finissi di passare la colonna e le cose non andassero ancora bene allora farei
                        //un'altra passata (per il do-while)
                        do {
                            for (int index3 = 0; index3 < NUM_ELEMENTI && somma_potenze_colonna > somma_potenze_riga; index3++) {
                                if (matrice_adiacenza[index3][riga] >= 2) {
                                    matrice_adiacenza[index3][riga]--;
                                    somma_potenze_colonna--;
                                }
                            }
                        } while (somma_potenze_colonna > somma_potenze_riga);
                    }
                }


            }
        }
    }

}
