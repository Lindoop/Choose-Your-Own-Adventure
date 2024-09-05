import java.util.*;
import java.io.*;

public class Sorting{
	
	public void bubbleSort(ArrayList<Integer> list){
		boolean swapDone = true;
		for (int pass = 0; pass < list.size(); pass++){
			if (!swapDone){
				break;
			}
			swapDone = false;
			for (int i = 0; i < list.size() - 1 - pass; i++) {
				if (list.get(i) > list.get(i + 1)) {
					swapDone = true;
					int temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
			System.out.println(list);
		}
	}

	public void selectSort(ArrayList<Integer> list){
		int smallest = 0;
		
  	for (int i =0; i< list.size()-1; i++){
      smallest=i;
      for (int j = i+1; j <list.size(); j++){
      	if (list.get(j) < list.get(smallest)){
          smallest = j;
      	}
    	}
      int temp = list.get(i);
      list.set(i, list.get(smallest));
      list.set(smallest, temp);
			System.out.println(list);
  	}
	}

	public void insertSort(ArrayList<Integer> list){
		for (int i =1; i< list.size(); i++){
      int j = i;
      while (j>0 && list.get(j-1) > list.get(j)){
      	int temp = list.get(j-1);
				list.set(j-1, list.get(j));
        list.set(j, temp);
				j--;
      }
			System.out.println(list);
    }
	}

	public static void mergeSort(ArrayList<Integer> list) {
    if (list == null || list.size() <= 1) {
    	return;
		}
		
    int size = list.size();
    int mid = size / 2;

		ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
		ArrayList<Integer> right = new ArrayList<>(list.subList(mid, size));

    mergeSort(left);
    mergeSort(right);

    merge(list, left, right);
  }

	private static void merge(List<Integer> list, List<Integer> left, List<Integer> right) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.size() && j < right.size()) {
      if (left.get(i) <= right.get(j)) {
        list.set(k, left.get(i));
        i++;
    	} else {
        list.set(k, right.get(j));
        j++;
      }
      k++;
    }

    while (i < left.size()) {
      list.set(k, left.get(i));
      i++;
      k++;
		}

    while (j < right.size()) {
      list.set(k, right.get(j));
      j++;
      k++;
    }
		System.out.println(list);
  }

	public static void quickSort(ArrayList<Integer> list) {
  	if (list == null || list.size() <= 1) {
      return;
    }

    quickSort(list, 0, list.size() - 1);
  }

	private static void quickSort(ArrayList<Integer> list, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(list, low, high);
      quickSort(list, low, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, high);
  	}
  }

	private static int partition(ArrayList<Integer> list, int low, int high) {
  	int pivot = list.get(high);
    int i = low - 1;
		
    for (int j = low; j < high; j++) {
      if (list.get(j) <= pivot) {
        i++;
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
       }
    }

    int temp = list.get(i+1);
		list.set(i+1, list.get(high));
		list.set(high, temp);
		System.out.println(list);
    return i + 1;
  }
}