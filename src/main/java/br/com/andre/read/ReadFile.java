package br.com.andre.read;

import br.com.andre.read.model.Frequency;

import java.io.*;
import java.util.*;

/**
 * Classe para ler arquivos muito grande
 * @author André Guariento
 */
public class ReadFile {

    private String folderPath = "C:\\projetos\\vee\\";

    public List<Frequency> topWord = new ArrayList<Frequency>();

    /**
     * Metodo para leitura de arquivo grande e, armazena frases frequentes
     * Em detrimento da utilização do scan utilizei esta abordagem para apresentar uma forma de
     * ler qualquer tamanho de arquivo com o menor consumo de memoria podendo ser emprega em rotina de batch
     * podemos aplicar um fim de leitura informando o tamanho de linhas e se havera nova leitura com moreLines
     * @param filename String Nome do arquivo
     * @throws IOException
     */
    public void reader(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(folderPath + filename));
            int batchSize = 50000;
            boolean moreLines = true;
            while (moreLines) {
                List<String> batch = readBatch(br, batchSize);
                checkWord(batch);
                if (batch.size() < batchSize) {
                    moreLines = false;
                }
                //a aplicação da variavel moreLines com valor false executa a parada do looping de leitura
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Conta as frequencias de repetição para as frases
     * @param lines List com Strings que representam as frases
     */
    private void checkWord(List lines) {
        Map<Integer, String> line = new HashMap<Integer, String>();
        lines.forEach((value) -> {
            Boolean exist = false;
            for (Frequency frequency : topWord) {
                if (frequency.getPhrase().equals(value)) {
                    frequency.setQuantity(frequency.getQuantity() + 1);
                    exist = true;
                }
            }
            if (!exist) {
                topWord.add(new Frequency((String) value,0));
            }
        });
    }

    /**
     * Ler arquivo com menor uso de memoria particionando a leitura
     * @param reader Buffer de leitura
     * @param batchSize tamanho de linhas particionadas para leitura
     * @return List com linhas capturadas
     * @throws IOException
     */
    private List<String> readBatch(BufferedReader reader, int batchSize) throws IOException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < batchSize; i++) {
            String line = reader.readLine().trim();
            if (line != null) {
                String[] frases = line.split("\\|");
                result.addAll((Arrays.asList(frases)));
            } else {
                return result;
            }
        }
        return result;
    }
}
