/***************************
 * Lorenzo Battisti
 * matr. 0000874002 
 * lorenzo.battisti3@studio.unibo.it
 * 
 * Progetto del corso di Algoritmi e Strutture Dati 2019/2020
 * Esercizio 4
 ***************************/

import java.io.*;
import java.util.*;

public class Esercizio4 {
    public static void main(String[] args) {
        String nomeFile = args[0];
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file " + nomeFile);
            System.exit(0);
        }

        int numero_container = 0;
        int peso_totale = 0;
        
        //Array di n oggetti contenente il peso di ciascun container
        int[] lista_container;

        while (inputStream.hasNextInt()) {
            numero_container = inputStream.nextInt();
            lista_container = new int[numero_container];
            int contatore = 0;
            while(inputStream.hasNextInt()) {
                lista_container[contatore] = inputStream.nextInt();
                peso_totale += lista_container[contatore];
                contatore++;
            } 
            
            System.out.println(zaino3(lista_container, (peso_totale/2)));
        }

        inputStream.close();
    }

    //Per risolvere questo esercizio applico la terza versione del "Problema dello zaino" vista a lezione.
    //Nello specifico andrò a fornire come capienza massima la metà del peso totale: così facendo, tramite questo algoritmo, 
    //otterrò un sottoinsieme di oggetti il cui peso complessivo sarà il massimo possibile e minore o uguale alla metà del peso totale.
    
    //Questa procedura mi permetterà di ottenere la minor differenza di peso possibile tra i container posti sul ponte anteriore e quelli posti sul ponte posteriore.
    //Inoltre mi assicurerà anche che il peso di tutti i container situati nel ponte anteriore sarà minore o uguale al peso di quelli nel ponte posteriore.
    public static int zaino3 (int[] p, int C) {

        int i = 0;
        int j = 0; 
        int[][] M = new int[p.length][C+1];
        boolean[][] U = new boolean[p.length][C+1];   //mi conta gli oggetti scelti

        //riempio la prima riga
        for (j = 0; j <= C; j++) {
            if (j < p[0]) {
                M[0][j] = 0;
                U[0][j] = false;
            } else {
                M[0][j] = p[0];
                U[0][j] = true;
            }
        }

        //riempio tutte le altre righe
        for (i = 1; i < p.length; i++) {
            for (j = 0; j <= C; j++) {
                if ((j >= p[i]) && (M[i-1][j-p[i]] + p[i] > M[i-1][j])) {
                    M[i][j] = M[i-1][j-p[i]] + p[i];
                    U[i][j] = true;
                } else {
                    M[i][j] = M[i-1][j];
                    U[i][j] = false;
                }
            }
        }

        //stampa risultati
        if(M[p.length-1][C] != 0) {
            i = p.length - 1;
            j = C;
            while (i >= 0 && j >= 0) {
                if (U[i][j]) {
                    System.out.println(i + " " + p[i]);
                    j = j - p[i];
                }
                i--;
            }
        }

        return M[p.length-1][C];
    }
}