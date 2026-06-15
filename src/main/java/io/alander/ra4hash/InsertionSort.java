package io.alander.ra4hash;

public class InsertionSort {

    public static void sort(int[] array) {
        int n = array.length;

        // começa no índice 1 porque o primeiro elemento sozinho já está "ordenado"
        for (int i = 1; i < n; i++) {

            // guarda o elemento atual que será inserido na posição correta
            int chave = array[i];

            // j aponta para o elemento imediatamente à esquerda da chave
            int j = i - 1;

            // desloca para a direita todos os elementos maiores que a chave,
            // abrindo espaço para inserir a chave na posição correta
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }

            // insere a chave na posição correta encontrada
            array[j + 1] = chave;
        }
    }
}
