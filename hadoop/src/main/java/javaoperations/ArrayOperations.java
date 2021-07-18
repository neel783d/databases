package javaoperations;

import java.util.Arrays;

public class ArrayOperations {

  private void initializeArray() {
    int[] a = {1, 2, 3};
    System.out.println("initialize: " + Arrays.toString(a));
  }

  private void insertOperations(int[] a) {
    a[0] = 2;
    a[1] = 3;
    a[2] = 5;
    System.out.println("insert: " + Arrays.toString(a));
  }

  private int[] deleteOperations(int[] a, int index) {
    int[] result = new int[a.length - 1];
    int j = 0;
    if (index >= a.length) {
      return a;
    }

    for (int i = 0; i < a.length; i++) {
      if (i == index) {
        continue;
      }
      result[j] = a[i];
      j += 1;
    }

    return result;
  }

  private int[] appendAtIndex(int[] a, int index, int value) {
    int[] result = new int[a.length + 1];
    boolean flag = false;
    int i = 0;
    for (int val : a) {
      if (i == index) {
        result[i] = value;
        flag = true;
        i++;
      }
      result[i] = val;
      i++;
    }

    if (!flag) {
      result[i] = value;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[5];
    ArrayOperations op = new ArrayOperations();

    op.initializeArray();
    op.insertOperations(a);
    System.out.println("insert: " + Arrays.toString(a));

    a = op.deleteOperations(a, 2);
    System.out.println("delete: " + Arrays.toString(a));

    a = op.appendAtIndex(a, 3, 4);
    System.out.println("appendIndex: " + Arrays.toString(a));
  }
}
