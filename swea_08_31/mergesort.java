package swea_08_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mergesort {
	static int[] sortedArr; 
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] array = new int[1000000];
		
		for (int i = 0; i < 1000000; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		sortedArr = new int[array.length];
		
		mergeSort(array, 0 , array.length-1);
		System.out.println(array[500000]);
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	public static void merge(int[] arr, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left;
		
		
		while (l <= mid && r<= right) {
			if (arr[l] <= arr[r]) {
				sortedArr[idx++] = arr[l++];
			}else {
				sortedArr[idx++] = arr[r++];				
			}
		}
		if (l <= mid) {
			for (int i = l; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}else {
			for (int i = r; i <= right; i++) {
				sortedArr[idx++] = arr[i];				
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
		
		
	}
	
	
	

}
