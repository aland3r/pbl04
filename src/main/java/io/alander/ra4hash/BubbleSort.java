package io.alander.ra4hash;

public class BubbleSort {

    public static void sort(int[] array) {
        int n = array.length;

        // cada passagem do loop externo garante que o maior elemento
        // restante "sobe" até sua posição final no final do array
        for (int i = 0; i < n - 1; i++) {

            // o loop interno compara elementos vizinhos dois a dois
            // o limite (n - i - 1) evita comparar posições já ordenadas
            for (int j = 0; j < n - i - 1; j++) {

                // se o elemento da esquerda for maior que o da direita, troca
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
