
void print(int[] arr1, int[] arr2){

	for(int i =0; i < arr1.length; i++){
	  for(int j = 0; j < arr2.length; j++){
	     for(int k = 0; k < 100000000; k++)
	     {
	     	print()
	     }

	     x + y
	  }
	}
} 

arr1 -> a 
arr2 -> b

O(ab)





int product(int a, int b){
	int sum = 0;
	for(int i = 0; i < b; i++){
		sum = sum + a;
	}
	return sum;
} 

O(b)

// voglio calcolare a^b

int power(int a, int b){
	if(b < 0){
		return 0;
	}else if(b == 0){
		return 1;
	}else{
		return a*power(a, b - 1)
	}
} 

O(b)
b = n

T(n) = T(n - 1) + c

// dopo la modifica
T(n) = T(n - 2) + c

//


int mod(int a, int b){
	if(b <= 0)
	{
		return -1;
	}
	int div = a / b;
	return a - div *b;
}

O(1)

a = 16
b = 5
a - div *b
16 - 3*5 = 1

// 

int div(int a, int b){
	int count = 0;
	int sum =  b;
	while(sum <= a){
		sum += b;
		count++;
	}
	return count;
}

// O(a/b)
// a/b vole
// a = 50
// b = 10
// sum = 10
// while (sum < 50)
	// sum += 10
	// count += 1


// Input: un vettore di interi A[1..n]

// output: la somma del sottovettore A[i..j]
// che ha somma massimale, ovvero il 
// sottovettore la cui somma degli elementi è piu grande
// o uguale lla somma degli elementi di qualunque altro 
// sotto vettore
//

// e.g. A = [-6, -9, (2, 5, -5, 8, 7, 3), -9, 2]
// somma = 2 + 5 -5 + 8 + 7 +3 = 20

int sum(int[] A, int i, int j){
	int sum = 0;
	for (int k = i; k < j; k++) {
		sum = sum + A[k];
	}
	return sum;
}

int maxsum(int[] A, int n){
	int risultato = 0;
	for (int i = 0; i < n; i++) {
		for (int j=i; j < n; j++) {
			int tmp_sum =sum(A,i,j)
			if (tmp_sum > risultato) {
				risultato = tmp_sum;
			}
		}
	}
	return risultato;
}

O(n^3)

// e.g. A = [-6, -9, 2, 5, -5, 8, 7, 3, -9, 2]
// [-6,-15,-13,-8,-13,-5,2,5,-4,-2]
// [-9,-7,-2,-7,1,8,11,-3,1]
// [2,7,2,10,17,20,11,13]
// B = [5,11,20]


int maxsum(int[] A, int n){
	int risultato = 0;
	for (int i = 0; i < n; i++) {
		int sum = 0;
		for (int j=i; j < n; j++) {
			sum =  sum + A[j]
			if(sum > risultato){
				risultato = sum;
			}
		}
	}
	return risultato;
}

// O(n^2)


// ------------------------------
// parco ha visitatori, 
// A = 1 [2] 0 [7] 2 0 2 0 -> 2 
// A = 1 [2] 0 [7] 2 0 2 [10] -> 3 
// breaking record - celebrare per il numero di visitatori alto.
// 
//
// 1) il numero di visitatori al giorno 'i' 
// è più grande di tutti i giorni precedenti
// 2) o è l'ultimo giorno, o i visitatori 
// al giorno 'i' è più grande di giorno i+1 (giorno successivo)

// domanda: quanti giorni di record breaking ?

int count(int[] A){
	int risultato = 0;
	// vostra proposta
	for (int i; i< A.length; i++) {
		// vostra proposta
	}
	return risultato;
}	



int count(int[] A){
	int result = 0;
	int max = A[0];
	for(int i=0; i < A.length; i++){
		boolean condizione1 = A[i] > max || i==0;
		boolean condizione2 = A[i] > A[i+1] || i = A.length-1;
	    if(condizione1 && condizione2){
	          result++;
		}

		if (A[i] > max) {
			max = A[i];
		}
	}
	return result++;
}

// O(n)











