package br.com.andre.kpair;

import java.util.HashMap;
import java.util.Map;

/**
 * Metodo para calcular o par sobre K
 * @author Andre Guariento
 */
public class Kpair {

    /**
     * Map pairs Atributo para aramzenar os pares de chaves correspondentes
     */
    private Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

    /**
     * Metodo para retornar os pares de chaves
     * @param numbers Array com os numero para pesquisa
     * @param k inteiro que determinara o valor a ser pesquisado nos pares
     * @return Map retornar o mapeamento dos pares
     */
    public Map getKpair(int[] numbers, int k) {
        int c = 1;
        while (c < numbers.length) {
            for (int i = 0; i < numbers.length; i++) {

                if (c <= i) {
                    continue;
                }

                if ((numbers[i] + numbers[c]) == k) {
                    pairs.put(i, c);
                    break;
                }
            }
            c++;
        }
        return pairs;
    }
}
