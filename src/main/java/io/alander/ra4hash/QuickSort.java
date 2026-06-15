package io.alander.ra4hash;

public class QuickSort {
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(array, inicio, fim);
            quickSort(array, inicio, pivo - 1);
            quickSort(array, pivo + 1, fim);
        }
    }

    private static int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, fim);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
