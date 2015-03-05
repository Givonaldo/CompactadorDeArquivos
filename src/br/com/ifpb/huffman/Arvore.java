/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.huffman;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Classe Árvore que envolve a codificação de Huffman que é um método 
 * de compressão que usa as probabilidades de ocorrência dos símbolos 
 * no conjunto de dados a ser comprimido para determinar códigos de tamanho 
 * variável para cada símbolo. 
 * 
 * Uma árvore binária completa, chamada de árvore de Huffman é construída 
 * recursivamente a partir da junção dos dois símbolos de menor probabilidade, 
 * que são então somados em símbolos auxiliares e estes símbolos auxiliares 
 * recolocados no conjunto de símbolos. O processo termina quando todos os 
 * símbolos foram unidos em símbolos auxiliares, formando uma árvore binária.
 * 
 * @author Gilvonaldo Alves da Silva Cavalcanti
 * @see NoDaArvore
 * @see FileBuilder
 * @Version 1.0
 */
public class Arvore {
    
    private NoDaArvore root;
    
    /*
     * Fila de prioridade de Node que depender de 
     * ordenação natural e que também não permite 
     * a inserção de objetos não-comparáveis
    */
    private final PriorityQueue<NoDaArvore> filaDePrioridade;
    
    
    private final HashMap<Character, NoDaArvore> mapaHashMap;
    private final HashMap<Character, String> encodedMap;
    
    
    public Arvore(){
        
        
        filaDePrioridade = new PriorityQueue<>();
        mapaHashMap = new HashMap<>();
        encodedMap = new HashMap<>();
        
    }   
    
    /**
     * 
     * @param mapa
     */
    private void setMap(HashMap<Character, Integer> mapa){
         for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
             NoDaArvore node = new NoDaArvore(entry.getKey(), entry.getValue());
             this.mapaHashMap.put(entry.getKey(), node);
         }       
    }
    
    /**
     * Metodo que constroi uma árvore de prioridade para ciação 
     * da árvore de Huffman.
     * 
     * @return 
     * @throws IOException 
     */
    private Arvore contruirFilaDePrioridade() throws IOException{
   
        for (Map.Entry<Character, NoDaArvore> entry : mapaHashMap.entrySet()) {
            filaDePrioridade.add(entry.getValue());
        }
        //System.out.println("Tamanho da lista de prioridade: " + filaDePrioridade.size());
        
        return this;
    }
    
    /**
     * 
     * @param map
     * @throws IOException 
     */
    public void construirArvore(HashMap<Character, Integer> map) throws IOException{
        
        setMap(map);
        contruirFilaDePrioridade();
        
        while(this.filaDePrioridade.size()>1){//Enquanto o tamanho da Tabela for maior que 1
            
            NoDaArvore left = filaDePrioridade.remove();
            NoDaArvore right = filaDePrioridade.remove();
            NoDaArvore newNode = new NoDaArvore(left.getTamanho() + right.getTamanho(), left, right);
            left.setPai(newNode);
            right.setPai(newNode);
            filaDePrioridade.add(newNode);
        }
        
        root = filaDePrioridade.remove();
        
        setEncondedMap();
    }
    
    /**
     * Metodo que atribui um código em binário a letra 
     * que for passada no parâmetro.
     * 
     * @param letra
     *      Letra do texto.
     * @return code
     *      Código que será retornado.
     */
    public String getCodigo(Character letra){
        
        NoDaArvore noDaArvore = mapaHashMap.get(letra);
        NoDaArvore parent = noDaArvore;
        String codigo = "";
        
        while(noDaArvore.getPai() != null){
            
            parent = noDaArvore.getPai();
            if(parent.getEsquerda() == noDaArvore){
                codigo = 0 + codigo;
            } else{
                codigo = 1 + codigo;
            }
            noDaArvore = noDaArvore.getPai();
        }
        return codigo;
    }
    
    /**
     * 
     */
    private void setEncondedMap(){
        
        for(Map.Entry<Character, NoDaArvore> entry : mapaHashMap.entrySet()) {
            encodedMap.put(entry.getKey(), getCodigo(entry.getKey()));
        }
    }
    
    /**
     * 
     * @return encodeMap
     */
    public HashMap<Character, String> getEncodedMap(){
        return encodedMap;
    }
    
    /**
     *
     * @return
     */
    public HashMap<Character, NoDaArvore>  getMap(){
        return mapaHashMap;
    }
    
    /**
     * 
     * @return root
     */
    public NoDaArvore getRoot(){
        return root;
    }
    
    /**
     * Retorna a fila de prioridade criada.
     * 
     * @return codeTable
     */
    public PriorityQueue<NoDaArvore> getFilaDePrioridade(){
        return filaDePrioridade;
    }

    void getCodigo(NoDaArvore noDaArvore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}