package br.com.andre.read.model;

/**
 * Classe que representa o modelo de dados para calculo de frequencia
 */
public class Frequency {

    private String phrase;

    private int quantity = 0;

    public Frequency(String phrase, int quantity) {
        this.phrase = phrase;
        this.quantity = quantity;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
