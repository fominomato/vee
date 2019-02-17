package br.com.andre.palindrome;

/**
 * Classe Palindrome - Palindromo
 * @author André Guariento
 */
public class Palindrome {

    /**
     * String de entrada para testar palindromo
     */
    public String input;

    /**
     * Atributo que define o tipo de complexidade
     * Checkar com base nos espaços
     * Checkar removendo espaços
     */
    public enum complex {
        NORMAL,
        SPACE
    };

    /**
     * Atributo que definirá se deverá ser validado por case-sensitive(Maiusculo e Minusculo)
     */
    public enum sensitivity {
        SENSITIVE,
        ISENSITIVE
    }

    /**
     * Funcionalidade isPalindrome
     * Testa se palavra de entrada é um palindromo pelo tipo de complexidade aplicada
     * @param type complex enumerador que identifica o tipo de acao para determinar o palindromo
     * @return boolean
     */
    public boolean isPalindrome(complex type, sensitivity caseSense) {
        String auxInput = (type == complex.SPACE)?input.replaceAll("\\s+", ""):input;
        String invInput = new StringBuffer(auxInput).reverse().toString();

        if (caseSense == sensitivity.SENSITIVE) {
            return invInput.equals(auxInput);
        }
        return invInput.equalsIgnoreCase(auxInput);
    }
}
