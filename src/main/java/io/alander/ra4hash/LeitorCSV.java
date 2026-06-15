package io.alander.ra4hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {
    public static int[] ler(String caminho) throws IOException {
        int count = 0;
        BufferedReader r1 = new BufferedReader(new FileReader(caminho));
        while (r1.readLine() != null) count++;
        r1.close();

        int[] array = new int[count];
        BufferedReader r2 = new BufferedReader(new FileReader(caminho));
        String linha;
        int i = 0;
        while ((linha = r2.readLine()) != null) {
            linha = linha.trim();
            if (linha.isEmpty()) continue;
            try {
                array[i++] = Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                count--;
            }
        }
        r2.close();

        if (i < array.length) {
            int[] ajustado = new int[i];
            for (int k = 0; k < i; k++) ajustado[k] = array[k];
            return ajustado;
        }
        return array;
    }
}
