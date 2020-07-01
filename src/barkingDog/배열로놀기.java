package barkingDog;

import java.util.Arrays;

public class 배열로놀기 {
    public static void main(String[] args){

        int[] arr = new int[10];
        arr[0] =0;
        arr[1] =1;
        arr[2] =2;
        arr[3] =3;
        arr[4] =4;
        arr[5] =5;
        arr[6] =6;
        arr[7] =7;

        int n = 3;
        int a = 5;
        int len = arr.length;

        insert(arr, n, len);

        for(int i : arr){
            System.out.println(i);
        }

        Integer[] arra = new Integer[len];


    }

    static void insert(int[] arr, int n, int a){
        Arrays.fill(arr, 1);
    }

    static void delete(int[] arr, int n, int len){
        for(int i=n; i<len-1; i++){
            arr[i] = arr[i+1];
        }
    }

}

