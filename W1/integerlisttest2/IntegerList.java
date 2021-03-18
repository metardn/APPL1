// ****************************************************************
// FILE: IntegerList.java
//
// Purpose: Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
package integerlisttest2;

import java.util.Scanner;

public class IntegerList {
    int[] list; //values in the list
    
    //------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    //------------------------------------------------------------
    public IntegerList(int size) {
        list = new int[size];
    }
    
    //------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    //------------------------------------------------------------
    public void randomize() {
        int max = list.length;
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * max) + 1;
    }
    
    //------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    //------------------------------------------------------------
    public void fillSorted() {
        for (int i=0; i<list.length; i++)
            list[i] = i + 2;
    }
    
    //------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    //------------------------------------------------------------
    public String toString()  {
        String s = "";
        for (int i=0; i<list.length; i++)
            s += i + ":\t" + list[i] + "\n";
        return s;
    }
    
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list. Returns -1
    // if target does not appear in the list
    //------------------------------------------------------------
    public int linearSearch(int target) {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
        if (list[i] == target)
            location = i;
        return location;
    }
    
    //------------------------------------------------------------
    // sortIncreasing -- uses selection sort
    //------------------------------------------------------------
    public void sortIncreasing() {
        for (int i=0; i<list.length-1; i++) {
            int minIndex = minIndex(list, i);
            swap(list, i, minIndex);
        }
    }
    
    //-------------------------------------------------------
    //find the target assuming the list is sorted in increasing order
    //-------------------------------------------------------
    public int binarySearch(int val){
        int start = 0;
        int fin = list.length-1;
            
        while (start <= fin){
            int mid = (start + fin)/2;
            if(val < list[mid])
                fin = mid-1;
            else if(val > list[mid])
                start = mid+1;
            else{
                System.out.println( list[mid]+ " is found");
                return mid;
            }
        }
        System.out.println("element not found");
        return 0;  
    }
    
    //------------------------------------------------------------
    // sortDecreasing -- uses insertion sort
    //------------------------------------------------------------
    public void sortDecreasing(){
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i-1;
            while(list[j] < temp && j > 0 ){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = temp;
        }
    }
    
    //------------------------------------------------------------
    // return index of smallest value
    //------------------------------------------------------------
    public int minIndex(int[] list, int minIndex){
        int temp = minIndex;
        for(int i = minIndex+1; i < list.length; i++)
            if (list[i] < list[temp])
                temp = 1;
        return temp;
    }
    
    //------------------------------------------------------------
    // swap two elements of list
    //------------------------------------------------------------
    public void swap(int[] list, int idx1, int idx2){
        int temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
    }
    
}
