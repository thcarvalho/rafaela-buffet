package list;
public class Ordenação {
       
    public  void quickSort(int[] vet, int indexInicial, int indexFinal) {
 		   if(indexInicial < indexFinal) {
 			int partitionIndex = partition(vet, indexInicial, indexFinal);
 		      quickSort(vet, indexInicial, partitionIndex-1);
 		      quickSort(vet, partitionIndex+1, indexFinal);
 		   }
     }
 		
 	
     public int partition(int[] vet, int indexInicial, int indexFinal) {
 		
 		int pivot = vet[indexFinal];
 		int i = indexInicial-1;
 		
 		 for (int j = indexInicial; j < indexFinal; j++) {
 		        if (vet[j] <= pivot) {
 		            i++;
 		            int swapTemp = vet[i];
 		            vet[i] = vet[j];
 		            vet[j] = swapTemp;
 		        }
 		    }

 		    int swapTemp = vet[i+1];
 		    vet[i+1] = vet[indexFinal];
 		    vet[indexFinal] = swapTemp;
 		    return i+1;
 		}
   }



