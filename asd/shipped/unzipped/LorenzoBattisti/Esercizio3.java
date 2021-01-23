/* **************************
 * Lorenzo Battisti
 * matr. 0000874002 
 * lorenzo.battisti3@studio.unibo.it
 * 
 * Progetto del corso di Algoritmi e Strutture Dati 2019/2020
 * Esercizio 3
 ***************************/

//Premessa: per risolvere questo esercizio ho deciso di creare una nuova classe Ordine (riga 119). 
//Questa avrà come variabili l'indice e il peso complessimo dell'ordine.

import java.io.*;
import java.util.*;

public class Esercizio3 {

    private static Ordine[] lista_ordini;
    private static int peso_massimo = 0;

    public static void main(String[] args) {
        String nomeFile = args[0];
        Scanner inputStream = null;
        int ordini_totali;

        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file " + nomeFile);
            System.exit(0);
        }

        while (inputStream.hasNextInt()) {
            peso_massimo = inputStream.nextInt();
            ordini_totali = inputStream.nextInt();

            lista_ordini = new Ordine[ordini_totali];
    
            for (int i = 0; i < ordini_totali; i++) {
                //Calcolo il peso totale di ogni ordine
                int peso_ordine = 200 * inputStream.nextInt() + 300 * inputStream.nextInt() + 500 * inputStream.nextInt();
                lista_ordini[i] = new Ordine(i, peso_ordine);
            }
        }

        //Ordino lista_ordini in modo tale che il peso di ogni elemento dell'array sia in ordine crescente.
        heapSort(lista_ordini);

        int peso_totale = 0; 
        int indice = 0;
        String output = "";
        int ordini_totali_stampa = 0;

        //Poichè mi viene richiesto il massimo numero di ordini che possono essere soddisfatti sarà sufficiente scorrere tutti gli ordini 
        //partendo dall'indice 0 fino a quando non verrà raggiunta la capienza massima.
        while (peso_totale <= peso_massimo && indice < lista_ordini.length) {       //Costo computazionale: nel peggiore dei casi vengono analizzati tutti gli elementi dell'array (O(n)).
            
            //l'ordine si può fare
            if (lista_ordini[indice].getQuantità() <= (peso_massimo - peso_totale)) {
                output += "\n" + lista_ordini[indice].getIndice();
                ordini_totali_stampa++;
            }

            peso_totale += lista_ordini[indice].getQuantità();
            indice++;
        }

        System.out.print(ordini_totali_stampa);
        System.out.println(output);

        inputStream.close();
    }

    public static void heapSort(Ordine[] array) {
        int dimensione = array.length;

        //Costruisco il Max-Heap
        for (int i = dimensione / 2 - 1; i >= 0; i--) {
            heapify(array, dimensione, i);
        }

        //Uno alla volta estraggo l'ordine con il peso massimo, situato nella radice (array[0]), con l'ultimo ordine (array[i]).
        for (int i = dimensione - 1; i >= 0; i--) {

            Ordine x = array[0]; 
            array[0] = array[i];
            array[i] = x;

            //Porto il nuovo ordine con peso massimo nella radice (array[0]) e l'ordine con il peso minimo in fondo all'heap.
            heapify(array, i, 0);
        }
    }

    //Questo metodo assicura che il valore dei nodi padri non sia mai inferiore a quello dei propri figli.
    public static void heapify(Ordine[] array, int heapSize, int i) {
        int max = i;
        int indice_figlio_sx = 2 * i + 1;
        int indice_figlio_dx = 2 * i + 2;

        //Se il figlio di sinistra è maggiore del padre (array[max])
        if (indice_figlio_sx < heapSize && array[indice_figlio_sx].getQuantità() > array[max].getQuantità())
            max = indice_figlio_sx;

        //Se il figlio di destra è maggiore del padre (array[max])
        if (indice_figlio_dx < heapSize && array[indice_figlio_dx].getQuantità() > array[max].getQuantità())
            max = indice_figlio_dx;

        //Se almeno una delle due condizioni precedenti è stata verifica, e quindi max non è la radice, si scambiamo gli elementi array[max] e array[i]
        if (max != i) {

            Ordine tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;

            //Si chiama ricorsivamente heapify: così facendo porto l'ordine con il peso minimo in fondo all'Heap e porto nella radice il nuovo ordine con il peso massimo.
            heapify(array, heapSize, max);
        }
    }
}

class Ordine {
    private int indice;
    private int quantità;

    public Ordine(int indice, int quantità) {
        this.indice = indice;
        this.quantità = quantità;
    }

    public int getQuantità() {
        return quantità;
    }
    public int getIndice() {
        return indice;
    }

    public void setQuantità(int q) {
        quantità = q;
    }
}