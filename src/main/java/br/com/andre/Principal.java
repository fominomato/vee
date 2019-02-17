package br.com.andre;

import br.com.andre.kpair.Kpair;
import br.com.andre.palindrome.Palindrome;
import br.com.andre.read.ReadFile;

import java.util.Arrays;
import java.util.Map;

/**
 * Classe Principal que roda os testes
 * @author Andre Guariento
 */
public class Principal {

    /**
     * Metodo principal de execução dos teste
     * @param args Lista de Palavras que podem ser enviadas no momento da execução
     * @return void Sem retorno
     */
    public static void main (String[] args) {

        System.out.println(" ");
        System.out.println("TESTE DO PALINDROMO: ");
        Palindrome testPalindrome = new Palindrome();
        testPalindrome.input = "OVO ovo";
        Boolean checkPalindrome = testPalindrome.isPalindrome(Palindrome.complex.SPACE, Palindrome.sensitivity.ISENSITIVE);
        System.out.println("O valor: \"" + testPalindrome.input + "\" é palindromo: " + checkPalindrome);

        System.out.println(" ");
        System.out.println("TESTE DO PAR DE K: ");
        Kpair kpairs = new Kpair();
        int[] numbers = new int[] {7, 1, 5, 6, 9, 3, 11, -1};
        System.out.println("Valores de entrada: " + Arrays.toString(numbers));
        Map<Integer, Integer> pairs = kpairs.getKpair(numbers, 10);
        System.out.println("Resultado do K-Pair: ");
        pairs.forEach((key, value) -> {
            System.out.println(numbers[key] + "," + numbers[value]);
        });

        System.out.println(" ");
        System.out.println("TESTE DE LEITURA PARA AARQUIVOS GRANDES E CONTAGEM DE OCORRENCIA DE FRASES ");
        ReadFile reader = new ReadFile();
        reader.reader("texto.txt");
        System.out.println("Quantidade de linhas unicas: " + reader.topWord.size());
    }
}
