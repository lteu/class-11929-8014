/***************************
 * Lorenzo Battisti
 * matr. 0000874002 
 * lorenzo.battisti3@studio.unibo.it
 * 
 * Progetto del corso di Algoritmi e Strutture Dati 2019/2020
 * Esercizio 2
 ***************************/

import java.io.*;
import java.util.*;

public class Esercizio2 {
    public static void main(String[] args) {
        String nomeFile = args[0];
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file");
            System.exit(0);
        }

        while (inputStream.hasNextInt()) {
            int numero_studenti = inputStream.nextInt();

            for (int i = 0; i < numero_studenti; i++) {
                int numero_voti = inputStream.nextInt();

                //Ho scelto di utilizzare un array poichè questo presenta un costo computazione molto basso (O(1)) per ogni operazione.
                int[] lista_voti = new int[numero_voti];

                for (int q = 0; q < numero_voti; q++) {
                    lista_voti[q] = inputStream.nextInt();
                }

                //si analizzano subito i voti di ogni studente, stampando il numero di volte in cui è stato "giù di morale"
                System.out.println(verificaCondizioni(lista_voti));
            }
        }

        inputStream.close();
    }

    public static int verificaCondizioni(int[] lista_voti) {
        int numero_volte_giù_di_morale = 0;

        int voto_minimo = Integer.MAX_VALUE;

        for (int i = 0; i < lista_voti.length; i++) {
            //PRIMA CONDIZIONE: il voto dell'esame i-esimo è strettamente minore di tutti i voti precedenti oppure è il primo esame per lo studente.
            //Il secondo requisito viene rispettato inizializzando voto_minimo uguale a Integer.MAX_VALUE: così facendo il primo voto sarà sempre minore di Integer.MAX_VALUE.
            if(lista_voti[i] < voto_minimo) {
                voto_minimo = lista_voti[i];

                //SECONDA CONDIZIONE: se il voto dell'esame i-esimo è l'ultimo oppure è strettamente minore di quello successivo
                if (i == lista_voti.length - 1 || lista_voti[i] < lista_voti[i+1]) {
                    numero_volte_giù_di_morale++;
                } 
            } 
        }
        
        return numero_volte_giù_di_morale;
    }
}