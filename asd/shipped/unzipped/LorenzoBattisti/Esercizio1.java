/***************************
 * Lorenzo Battisti
 * matr. 0000874002 
 * lorenzo.battisti3@studio.unibo.it
 * 
 * Progetto del corso di Algoritmi e Strutture Dati 2019/2020
 * Esercizio 1
 ***************************/

import java.io.*;
import java.util.*;

public class Esercizio1 {
    public static void main(String[] args) {
        String nomeFile = args[0];
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file " + nomeFile);
            System.out.println("Si ricorda che è necessario fornire come parametro prima il nome del file (String), poi il valore della variabile m (int)");
            System.exit(0);
        }

        //Poichè la mia intenzione è quella di ordinare la lista, utilizzo un oggetto della classe TreeMap.
        //Ho fatto questa decisione poichè il costo computazionale per le operazioni di get, put e remove è solo di O(logn)
        TreeMap<Integer,String> lista = new TreeMap<Integer,String>();

        while (inputStream.hasNextLine()) {
            String riga = inputStream.nextLine();
            if (riga.contains(" ")) {
                String[] elementi = riga.split(" ");
                lista.put(Integer.parseInt(elementi[0]), elementi[1]);              //costo computazionale: O(nlogn)
            } else {
                throw new IllegalArgumentException("La stringa " + riga + " non contine spazi");
            }
        }

        //NUMERO DI ELEMENTI DELLA LISTA
        int n = lista.size();
        
        //NUMERO DI VALORI DA STAMPARE
        int m = 0;
        try {
            m = (Integer.parseInt(args[1]));
        } catch (Exception e) {
            System.out.println("Non è stato inserito un valore corretto di m");
            System.out.println("Si ricorda che è necessario fornire come parametro prima il nome del file (String), poi il valore della variabile m (int)");
            System.exit(0);
        }

        if (n < m || m <= 0) {
            System.out.println("Il valore di m non è valido.");
            System.out.println("È necessario che m sia strettamente maggiore di 0 e minore di n (n = " + n + ").");
            System.exit(0);
        }

        
        //Serve un indice della lista (x)
        int x = lista.firstKey();                           //costo computazionale: O(logn)
        for (int i = 0; i < m; i++) {                       //costo O(m)
            x = lista.ceilingKey(x);                        //restituisce la prima chiave maggiore o uguale di x
                                                            //costo computazionale: O(logn)
            System.out.println(x + " " + lista.get(x));
            x++;
        }                                                   //costo totale: O(m logn)


        inputStream.close();
    }
}

//COSTO COMPUTAZIONALE TOTALE:
//O(nlogn) + O(mlogn) = O(nlogn)