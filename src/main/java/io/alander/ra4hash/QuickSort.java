package io.alander.ra4hash;

public class QuickSort {

    // método público — recebe apenas o array e chama a versão recursiva
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // método recursivo — divide e conquista: ordena a parte [inicio..fim]
    private static void quickSort(int[] array, int inicio, int fim) {

        // condição de parada: quando o trecho tem 0 ou 1 elemento, já está ordenado
        if (inicio < fim) {

            // particiona o array e obtém a posição final do pivô
            int pivo = particionar(array, inicio, fim);

            // ordena recursivamente a metade esquerda (elementos menores que o pivô)
            quickSort(array, inicio, pivo - 1);

            // ordena recursivamente a metade direita (elementos maiores que o pivô)
            quickSort(array, pivo + 1, fim);
        }
    }

    // separa o array em dois grupos: menores e maiores que o pivô
    // retorna o índice onde o pivô foi colocado definitivamente
    private static int particionar(int[] array, int inicio, int fim) {

        // usa o último elemento como pivô (requisito do trabalho)
        int pivo = array[fim];

        // i marca o limite da zona dos elementos menores que o pivô
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {

            // se o elemento atual é menor ou igual ao pivô, ele pertence à esquerda
            if (array[j] <= pivo) {
                i++;

                // troca: move o elemento para a zona da esquerda
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // coloca o pivô entre as duas zonas, na posição definitiva
        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        // retorna a posição final do pivô
        return i + 1;
    }
}
