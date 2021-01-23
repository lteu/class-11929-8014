/***************************
 * Lorenzo Battisti
 * matr. 0000874002 
 * lorenzo.battisti3@studio.unibo.it
 * 
 * Progetto del corso di Algoritmi e Strutture Dati 2019/2020
 * Esercizio 5
 ***************************/

import java.io.*;
import java.util.*;

public class Esercizio5 {
    public static void main(String[] args) {
        String nomeFile = args[0];
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new File(nomeFile));
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file " + nomeFile);
            System.exit(0);
        }

        //lato nella scacchiera
        int n = inputStream.nextInt();

        //lista_nodi conterrà tutti gli elementi della scacchiera; ciascuno di questi sarà costituito dagli indici dei nodi confinanti (solo se questi saranno diversi da "#").
        ArrayList<LinkedList<Integer>> lista_nodi =  new ArrayList<LinkedList<Integer>>(); 
        int sorgente = 0;
        int destinazione = 0;
        
        //creo n*n oggetti
        for(int j = 0; j < n*n; j++) {
            lista_nodi.add(new LinkedList<Integer>());
        }

        //creo i collegamenti (archi) tra i vari nodi
        int i = 0;
        int indice = 0;
        String[] array = new String[n*n];

        while (inputStream.hasNext()) {
            String[] riga = inputStream.next().split("");
            for(int j = 0; j < n; j++) {
                array[indice] = riga[j];

                //memorizzo indice sorgente
                if(riga[j].equals("s")) {
                    sorgente = indice;
                }
                //memorizzo indice destinazione
                if(riga[j].equals("d")) {
                    destinazione = indice;
                }

                if(!riga[j].equals("#")) {
                    //Scorrendo tutti gli elementi risulterà sufficiente analizzare solamente l'elemento di sinistra e quello superiore. 

                    //casella superiore
                    int indice_casella_superiore = indice - n;
                    if (indice_casella_superiore >= 0 && !array[indice_casella_superiore].equals("#")) {
                        lista_nodi.get(indice).add(indice_casella_superiore);
                        lista_nodi.get(indice_casella_superiore).add(indice);
                    }

                    //casella a sinistra
                    if(indice % n != 0 && !array[indice - 1].equals("#")) {
                        lista_nodi.get(indice).add(indice - 1);
                        lista_nodi.get(indice - 1).add(indice);
                    }
                }
                indice++;
            }
            i++;
        }


        //Per risolvere questo esercizio ho deciso di utlizzare la visita in ampiezza di un albero (BFS).

        int precedente[] = new int[n*n];
        int distanza[] = new int[n*n];

        //Caso in cui non fosse possibile raggiungere la meta desiderata
        if (BFS(lista_nodi, sorgente, destinazione, n*n, precedente, distanza) == false) { 
            System.out.println("non raggiungibile"); 
            return; 
        } 

        //Percorso più breve
        LinkedList<Integer> percorso = new LinkedList<Integer>();
        percorso.add(destinazione); 
        while (precedente[destinazione] != -1) {        //solo precedente[sorgente] è uguale a -1: quindi si prosegue fino a quando non si incontrerà il nodo sorgente
            percorso.add(precedente[destinazione]); 
            destinazione = precedente[destinazione]; 
        }

        //Setto Integer.MAX_VALUE come primo valore della LinkedList di ogni nodo della lista_nodi appartenente al percorso.
        //Questo mi permetterà di velocizzare la ricerca tramite il metodo contains (riga 117)
        for (Integer nodo : percorso) {
            lista_nodi.get(nodo).addFirst(Integer.MAX_VALUE);
        }

        //stampa
        stampaLabirinto(n, lista_nodi);

        inputStream.close();
    }

    public static void stampaLabirinto(int n, ArrayList<LinkedList<Integer>> lista_nodi) {
        int numero_nodi = 0;
        int x = 0;

        while(x < n*n) {
            for(int i = 0; i < n; i++) {
                if(!lista_nodi.get(x).isEmpty()) {
                    if (lista_nodi.get(x).contains(Integer.MAX_VALUE)) {        //se non avessi messo Integer.MAX_VALUE come primo elemento, contains avrebbe dovuto, 
                                                                                //nel caso pessimo, scorrere tutti gli elementi, fornendo così un costo computazionale maggiore.
                        System.out.print("+");
                        numero_nodi++;
                    } else {
                        System.out.print(".");
                    }
                } else {
                    System.out.print("#");
                }
                x++;
            }
            
            System.out.println();
        }

        System.out.println(numero_nodi);
    }

    public static boolean BFS(ArrayList<LinkedList<Integer>> lista_nodi, int sorgente, int destinazione, int dimensione, int precedente[], int distanza[]) {  
        
        //creo una coda
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        //creo un array booleano: TRUE se il nodo è stato visitato, FALSE altrimenti.
        boolean vis[] = new boolean[dimensione]; 
  
        //allocazione iniziale dei valori degli array
        for (int i = 0; i < dimensione; i++) { 
            vis[i] = false; 
            distanza[i] = Integer.MAX_VALUE;
            precedente[i] = -1; 
        } 
  
        //Nodo sorgente
        vis[sorgente] = true; 
        distanza[sorgente] = 0; 
        queue.add(sorgente); 
  
        //Algoritmo BFS
        while (!queue.isEmpty()) { 
            int u = queue.remove();             //rimuove il primo elemento della queue

            for (Integer nodo : lista_nodi.get(u)) {       //analizzo tutti i nodi collegati al nodo u
                if (vis[nodo] == false) {                  //se il nodo interno i non è ancora stato visitato...
                    vis[nodo] = true; 
                    distanza[nodo] = distanza[u] + 1;      //aumento di 1 il costo fino al nodo u
                    precedente[nodo] = u;                  //il predecessore diventa u
                    queue.add(nodo);                       //aggiungo il nodo alla coda
    
                    //Quando si raggiunge il nodo destinazione ci si ferma
                    if (nodo == destinazione) 
                        return true; 
                } 
            }
        } 
        return false; 
    } 
}
