// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
package integerlisttest;

import java.util.Scanner;

public class IntegerList {
    int[] list; //values in the list
    
    //-------------------------------------------------------
    //create a list of the given size
    //-------------------------------------------------------
    public IntegerList(int size) {
        list = new int[size];
    }
    
    //-------------------------------------------------------
    //fill array with integers between 1 and 100, inclusive
    //-------------------------------------------------------
    public void randomize() {
        for (int i=0; i<list.length; i++)
        list[i] = (int)(Math.random() * 100) + 1;
    }
    
    //-------------------------------------------------------
    //print array elements with indices
    //-------------------------------------------------------
    public void print() {
        for (int i=0; i<list.length; i++)
        System.out.println(i + ":\t" + list[i]);
    }
    
    //-------------------------------------------------------
    //return the index of the first occurrence of target in the list.
    //return -1 if target does not appear in the list
    //-------------------------------------------------------
    public int search(int target) {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
        if (list[i] == target)
        location = i;
        return location;
    }
    
    //-------------------------------------------------------
    //sort the list into ascending order using the selection sort algorithm
    //-------------------------------------------------------
    public void selectionSort() {
        int minIndex;
        for (int i=0; i < list.length-1; i++) {
            //find smallest element in list starting at location i
            minIndex = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] < list[minIndex])
                    minIndex = j;
            //swap list[i] with smallest element
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    
    //-------------------------------------------------------
    //replaces the first occurrence of oldVal in the list with newVal
    //-------------------------------------------------------
    public void replaceFirst(int oldVal, int newVal) {
        int i;
        i = search(oldVal);
        if(i > -1)
            list[i] = newVal;
    }
    
    //-------------------------------------------------------
    //replaces the all occurrence of oldVal in the list with newVal
    //-------------------------------------------------------
    public void replaceAll(int oldVal, int newVal) {
        for (int i = 0; i < list.length - 1; i++)
            if (list[i] == oldVal)
                list[i] = newVal;
    }
    
    //-------------------------------------------------------
    //sorts the list into decreasing
    //-------------------------------------------------------
    public void sortDecreasing() {
        int maxIndex;
        for (int i=0; i < list.length-1; i++) {
            //find largest element in list starting at location i
            maxIndex = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] > list[maxIndex])
                    maxIndex = j;
            //swap list[i] with largest element
            int temp = list[i];
            list[i] = list[maxIndex];
            list[maxIndex] = temp;
        }
    }
    
    //-------------------------------------------------------
    //find the target assuming the list is sorted in decreasing order
    //-------------------------------------------------------
    public int binarySearchD (int target){
        int start = 0;
        int fin = list.length-1;
            
        while (start <= fin){
            int mid = (start + fin)/2;
            if(target > list[mid])
                fin = mid-1;
            else if(target < list[mid])
                start = mid+1;
            else{
                System.out.println( list[mid]+ " is found");
                return mid;
            }
        }
        System.out.println("element not found");
        return 0;  
    }
}
