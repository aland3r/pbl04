package io.alander.ra4hash;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // lista de todos os arquivos CSV a serem processados
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

        // cabeçalho da tabela de resultados
        System.out.printf("%-25s %18s %18s %18s%n",
            "Conjunto de Dados", "Bubble Sort (ms)", "Insertion Sort (ms)", "Quick Sort (ms)");
        System.out.println("-".repeat(82));

        // processa cada arquivo individualmente
        for (String arquivo : arquivos) {
            try {
                // lê os dados do CSV e armazena no array original
                int[] original = LeitorCSV.ler(arquivo);

                // cria três cópias independentes do array original
                // para que cada algoritmo receba exatamente os mesmos dados não ordenados
                int[] arrayBubble    = copiar(original);
                int[] arrayInsertion = copiar(original);
                int[] arrayQuick     = copiar(original);

                // executa cada algoritmo na sua cópia e mede o tempo individualmente
                long tempoBubble    = medir(() -> BubbleSort.sort(arrayBubble));
                long tempoInsertion = medir(() -> InsertionSort.sort(arrayInsertion));
                long tempoQuick     = medir(() -> QuickSort.sort(arrayQuick));

                // remove o prefixo "data/" e o sufixo ".csv" para exibir só o nome
                String nome = arquivo.replace("data/", "").replace(".csv", "");

                // converte de nanossegundos para milissegundos (÷ 1.000.000) e imprime
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

    // captura o tempo antes e depois da execução do algoritmo usando System.nanoTime()
    // retorna a diferença em nanossegundos — apenas o tempo da ordenação é medido
    private static long medir(Runnable algoritmo) {
        long inicio = System.nanoTime();
        algoritmo.run();
        return System.nanoTime() - inicio;
    }

    // copia o array manualmente, sem usar métodos prontos do Java
    // necessário para garantir que cada algoritmo ordene os mesmos dados originais
    private static int[] copiar(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}
