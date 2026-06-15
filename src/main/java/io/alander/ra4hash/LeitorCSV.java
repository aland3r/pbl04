package io.alander.ra4hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {

    public static int[] ler(String caminho) throws IOException {

        // primeira leitura: conta quantas linhas o arquivo tem
        // para saber o tamanho do array antes de alocá-lo
        int count = 0;
        BufferedReader r1 = new BufferedReader(new FileReader(caminho));
        while (r1.readLine() != null) count++;
        r1.close();

        // aloca o array com o tamanho contado
        int[] array = new int[count];

        // segunda leitura: preenche o array com os valores do arquivo
        BufferedReader r2 = new BufferedReader(new FileReader(caminho));
        String linha;
        int i = 0;
        while ((linha = r2.readLine()) != null) {
            linha = linha.trim();
            if (linha.isEmpty()) continue;
            try {
                array[i++] = Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                // linha com texto (ex: cabeçalho "Value") é ignorada silenciosamente
                count--;
            }
        }
        r2.close();

        // se havia cabeçalho, o array ficou maior que o necessário —
        // retorna uma cópia ajustada com apenas os elementos lidos
        if (i < array.length) {
            int[] ajustado = new int[i];
            for (int k = 0; k < i; k++) ajustado[k] = array[k];
            return ajustado;
        }

        return array;
    }
}
