/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

/**
 *
 * @author Денис
 */
public class ArrayTasks {
    /**
     * Calculates sum of int array elements.
     * @param array - array to calculate sum
     * @return sum of array elements
     */

    public static int calcSumOfElements(int array[]) {
        checkNull(array);
        
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
    
    public static double calcAverage(int array[]){
        return (double)calcSumOfElements(array) / array.length;
    }
    
    public static int findMax( int array[] ){
        int max = array[0];
        int maxIndex = 0;
        for(int i = 1; i<array.length; i++ ){
            if (array[i] > max){
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public static int getMax(int array[]){
        checkNull(array);
        checkEmpty(array);
        
        int max = Integer.MIN_VALUE;
        for(int element : array){
            if(element > max){
                max = element; 
            }
        }
        return max;
    }
    public static int getMaxExt(int array[]){
        checkNull(array);
        checkEmpty(array);
        
        
        int max = array[0];
        for(int element : array){
            if(element > max){
                max = element; 
            }
        }
        return max;
    }
    public static int[] findAllMaxIndexes(int array[]){
        int max = getMax(array);
        int maxIndexes[] = new int [array.length];
        int maxCount = 0;
        for( int i=0; i< array.length; i++){
            if( array[i] == max){
                maxIndexes[maxCount++] = i;
            }
        }
        return Arrays.copyOf(maxIndexes, maxCount);
    }
    
    public static boolean checkSortedIncreasing( int array[]){
        for (int i=0; i<array.length - 1; i++){
            if( array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }
    
    public static void shiftRight(int array[], int k){
        for(int shifts = 0; shifts < k ; shifts++){
            int temp = array[array.length-1];
            for(int i=array.length-1; i>0 ; i-- ){
                array[i] = array[i-1];
            }
            array[0]= temp;
        }
    }
    public static void shiftRightExtMemory( int array[] , int k){
        int temp[] = new int [array.length];
//        for( int i =0; i<array.length; i++){
//            temp[(i+k)%array.length] = array[i];
//        }
        System.arraycopy( array , 0, temp, k, array.length - k);
        System.arraycopy(array , array.length - k, temp, 0, k);
        System.arraycopy( temp, 0, array, 0, temp.length);
    }
    
    public static void printRepeats( int array[]){
        boolean repeats []= new boolean[array.length];
        
        for(int i = 0; i<array.length ; i++){
            //boolean repeat = false;
            for( int j = i+1 ; j <array.length ; j++){
                if( array[i] == array[j]  ){
                    if( !repeats[i] ){
                        System.out.println("array["+i+"]=array["+j+"]=" + array[i]);
                    }        
                    repeats[i] = true;
                    repeats[j] = true;
                }
                
            }
            
        }
    }
    
    public static void printRepeatsAdv( int array[]){
        outer:
        for(int i = 0; i<array.length ; i++){
            //boolean repeat = false;
            for( int j = 0; j<i; j++ ){
                if( array[i]==array[j]){
                    continue outer;
                }
            }
            for( int j = i+1 ; j <array.length ; j++){
                if( array[i] == array[j]  ){
                    System.out.println("array["+i+"]=array["+j+"]=" + array[i]);
                    break;
                }
                
            }
            
        }
    }
    public static void printRepeatsAdvExt( int array[]){
        outer:
        for(int i = 0; i<array.length ; i++){
            //boolean repeat = false;
            
            for( int j = i+1 ; j <array.length ; j++){
                if( array[i] == array[j]  ){
                    for( int k= 0; k<i; k++ ){
                        if( array[i]==array[k]){
                            continue outer;
                        }
                    }
                    System.out.println("array["+i+"]=array["+j+"]=" + array[i]);
                    break;
                }
                
            }
            
        }
        
        
    }
    
    public static int findFirstValue (int array[] , int value){
            for(int i=0; i<array.length ; i++){
                if(array[i]==value){
                    return i;
                }
            }
            return -1;
    }
    
    public static void printUnique( int array[] ){
        for( int i=0; i<array.length; i++){
            boolean unique = true;
            for(int j=0; j<array.length ; j++){
                if( array[i]==array[j] && i!=j){
                    unique = false;
                }
                
            }
            if(unique){
                System.out.println("unique" + array[i]);
            }
        }
    }
    public static void printUnique( int firstArray[] , int secondArray[]){
        for( int i = 0; i<firstArray.length ; i++){
            if( findFirstValue(secondArray, firstArray[i])==-1){
                  System.out.println("unique" + firstArray[i]);
            }
        }
    }
    
    public static int binarySearch(int array[], int value){
        int lower = 0; //inclusive
        int upper = array.length; //exclusice
        while( lower < upper ){
            int mid = lower + ( upper - lower) / 2;
            if( array[mid] ==value ){
                return mid;
            }else if (array[mid] < value){
                lower = mid + 1;
            }else{ //array[mid] > value
                upper = mid;
            }
        }
        return -1;
        
    }
    
    public static void printUniqueFaster( int firstArray[] , int secondArray[]){
        int [] temp =Arrays.copyOf(secondArray, secondArray.length);
        Arrays.sort(temp);
        secondArray = temp;
        
        for( int i = 0; i<firstArray.length ; i++){
            if( binarySearch(secondArray, firstArray[i])==-1){
                  System.out.println("unique" + firstArray[i]);
            }
        }
    }
    
    public static int[] mergeSortedArrays(int firstArray[] , int secondArray[] ){
        int result[] = new int[firstArray.length + secondArray.length];
        
        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;
        
        while( firstIndex < firstArray.length 
               && secondIndex < secondArray.length ){
            if(firstArray[firstIndex]<secondArray[secondIndex] ){
                result[resultIndex++] = firstArray[firstIndex++];
            }else{
                result[resultIndex++] = secondArray[secondIndex++];
            }
        }
        while( firstIndex < firstArray.length ){
            result[resultIndex++] = firstArray[firstIndex++];
        }
        while( secondIndex < secondArray.length ){
            result[resultIndex++] = secondArray[secondIndex++];
        }
        return result;
    } 
    
    public static void mergeSort(int array[]){
        checkNull(array);
        int temp[] = new int[array.length];
        int from = 0;
        int mid = array.length / 2;
        int to = array.length; //exclusive
        
        mergeSorter( array , from , mid ,temp );
        mergeSorter( array , mid , to , temp );
        merger( array , from , mid , to , temp );
        
    }
    /**
     * 
     * @param array
     * @throws IllegalArgumentException 
     */

    private static void checkEmpty(int[] array) throws IllegalArgumentException {
        if( array.length == 0 ){
            throw new IllegalArgumentException("array is empty");
        }
    }


    private static void checkNull(int[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("array must not be null");
        }
    }

    private static void mergeSorter(int[] array, int from, int to, int[] temp) {
        if( to - from <= 1){
            return;
        }
        int mid = from + ( to-from )/2;
        mergeSorter( array , from , mid ,temp );
        mergeSorter( array , mid , to , temp );
        merger( array , from , mid , to , temp );
    }

    private static void merger(int[] array, int from, int mid, int to, int[] result) {
        int firstIndex = from;
        int secondIndex = mid;
        int resultIndex = 0;
        
        while( firstIndex < mid 
               && secondIndex < to ){
            if(array[firstIndex]<array[secondIndex] ){
                result[resultIndex++] = array[firstIndex++];
            }else{
                result[resultIndex++] = array[secondIndex++];
            }
        }
        while( firstIndex < mid ){
            result[resultIndex++] = array[firstIndex++];
        }
        while( secondIndex < to ){
            result[resultIndex++] = array[secondIndex++];
        }
        System.arraycopy(result, 0, array, from, to-from);

    }
    
    public static void replacePositive(int array[]){
        int low = 0;
        int high = array.length -1;
        
        while( low < high ){
            while (array[low] <= 0 && low < high){
                low ++;
            }
            while( array[high] <=0 && low < high ){
                high --;
            }
            
            if( low <high ){
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;
            }
        }
    }

}
