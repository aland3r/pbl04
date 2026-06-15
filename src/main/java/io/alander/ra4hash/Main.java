package io.alander.ra4hash;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] arquivos = {
            "data/aleatorio_100.csv",
            "data/aleatorio_1000.csv",
            "data/aleatorio_10000.csv",
            "data/crescente_100.csv",
            "data/crescente_1000.csv",
            "data/crescente_10000.csv",
            "data/decrescente_100.csv",
            "data/decrescente_1000.csv",
            "data/decrescente_10000.csv"
        };

        System.out.printf("%-25s %18s %18s %18s%n",
            "Conjunto de Dados", "Bubble Sort (ms)", "Insertion Sort (ms)", "Quick Sort (ms)");
        System.out.println("-".repeat(82));

        for (String arquivo : arquivos) {
            try {
                int[] original = LeitorCSV.ler(arquivo);

                int[] arrayBubble    = copiar(original);
                int[] arrayInsertion = copiar(original);
                int[] arrayQuick     = copiar(original);

                long tempoBubble    = medir(() -> BubbleSort.sort(arrayBubble));
                long tempoInsertion = medir(() -> InsertionSort.sort(arrayInsertion));
                long tempoQuick     = medir(() -> QuickSort.sort(arrayQuick));

                String nome = arquivo.replace("data/", "").replace(".csv", "");
                System.out.printf("%-25s %18.3f %18.3f %18.3f%n",
                    nome,
                    tempoBubble    / 1_000_000.0,
                    tempoInsertion / 1_000_000.0,
                    tempoQuick     / 1_000_000.0);

            } catch (IOException e) {
                System.out.println("Erro ao ler: " + arquivo);
            }
        }
    }

    private static long medir(Runnable algoritmo) {
        long inicio = System.nanoTime();
        algoritmo.run();
        return System.nanoTime() - inicio;
    }

    private static int[] copiar(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}
