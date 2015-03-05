/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.huffman;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Classe que realiza a construção do Arquivo compactado.
 *
 * @author Gilvonaldo Alves da Silva Cavalcanti
 */
public class ConstroiArquivo {

    private final String caminho;
    private HashMap<Character, Integer> frequencia;
    private final BufferedOutputStream output;
    private byte numBitsEscritos;
    private byte currentByte;

    /**
     * Metodo que cria o arquivo compactado no caminho passado no parametro do
     * mesmo.
     *
     * @param caminho Representa o caminho do arquivo que será compactado
     * @param compressPath Caminho onde será salvo o arquivo.
     * @throws java.io.IOException Erro no aquivo.
     */
    public ConstroiArquivo(String caminho, String compressPath) throws IOException {

        this.caminho = caminho;
        this.output = new BufferedOutputStream(new FileOutputStream(compressPath));
        this.currentByte = 0;
        this.numBitsEscritos = 0;
    }

    /**
     * Metodo que escreve Bits.
     *
     * @param bit
     * @throws IOException
     */
    private void escreveBit(int bit) throws IOException {

        if (bit < 0 || bit > 1) {//Verifica se os bits são válidos.
            throw new IllegalArgumentException("Bit Inválido -> " + bit);
        }

        numBitsEscritos++;
        currentByte |= bit << (8 - numBitsEscritos);

        if (numBitsEscritos == 8) {

            output.write(currentByte);
            numBitsEscritos = 0;
            currentByte = 0;
        }
    }

    /**
     * Metodo que fecha o arquivo.
     *
     * @throws IOException
     */
    public void fechar() throws IOException {

        output.write(currentByte);
        output.write(numBitsEscritos);
        output.close();

    }

    /**
     *
     * @return HashMap de inteiros.
     * @throws FileNotFoundException
     * @throws IOException
     */
    private HashMap<Character, Integer> getFrequencia() throws FileNotFoundException, IOException {

        frequencia = new HashMap<>();
        BufferedReader arquivoParaComprecao = new BufferedReader(new FileReader(caminho));

        int tamanho = arquivoParaComprecao.read();

        while (tamanho != -1) {

            Character chave = (char) tamanho;

            if (frequencia.containsKey(chave)) {
                frequencia.put(chave, frequencia.get(chave) + 1);
            } else {
                frequencia.put(chave, 1);
            }
            tamanho = arquivoParaComprecao.read();
        }
        return frequencia;
    }

    /**
     * Metodo que realiza a compreção de Arquivos.
     *
     * @throws IOException
     */
    public void comprimirArquivo() throws IOException {

        Arvore arvore = new Arvore();
        getFrequencia();
        arvore.construirArvore(frequencia);

        HashMap<Character, String> mapa = arvore.getEncodedMap();

        try (BufferedReader arquivoEscolhido = new BufferedReader(new FileReader(caminho))) {

            int resulLeitura = arquivoEscolhido.read();

            while (resulLeitura != -1) {

                Character key = (char) resulLeitura;
                String sequenciaDeBits = mapa.get(key);

                for (int i = 0; i < sequenciaDeBits.length(); i++) {//Percorre uma lista de Bits

                    int bit = Integer.parseInt(sequenciaDeBits.substring(i, i + 1));
                    this.escreveBit(bit);
                }

                resulLeitura = arquivoEscolhido.read();
            }
        }
        this.fechar();
    }

}
