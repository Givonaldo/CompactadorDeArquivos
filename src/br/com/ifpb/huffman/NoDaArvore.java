/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.huffman;

/**
 *
 * @author Gilvonaldo Alves da Silva Cavalcanti
 */
public class NoDaArvore implements Comparable<NoDaArvore>{
    
    private int tamanho;
    private NoDaArvore esquerda, direita, pai;
    private Character simbolo;
    
    public NoDaArvore(int tamanho, NoDaArvore esquerda, NoDaArvore direita){
        
        this.esquerda = esquerda;
        this.direita = direita;
        this.tamanho = tamanho;
        this.pai = null;
        
    }
    
    public NoDaArvore(){
        
    }
    
    /**
     * 
     * @param token
     * @param weight 
     */
    public NoDaArvore(Character token, int weight){
        
        this.simbolo = token;
        this.tamanho = weight;
        this.esquerda = null;
        this.direita = null;
        pai = null;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isLeaf(){
        
        assert(esquerda==null && direita == null || esquerda !=null && direita!=null);
        return esquerda==null && direita==null;    
    }
    
    /**
     * 
     * @return 
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * 
     * @param weight 
     */
    public void setTamanho(int weight) {
        this.tamanho = weight;
    }

    /**
     * 
     * @return esquerda
     */
    public NoDaArvore getEsquerda() {
        return esquerda;
    }

    /**
     * 
     * @param esquerda
     */
    public void setEsquerda(NoDaArvore esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * 
     * @return direita
     */
    public NoDaArvore getDireita() {
        return direita;
    }

    /**
     * 
     * @param direita
     */
    public void setDireita(NoDaArvore direita) {
        this.direita = direita;
    }

    /**
     * 
     * @return pai
     */
    public NoDaArvore getPai() {
        return pai;
    }

    /**
     * 
     * @param pai 
     */
    public void setPai(NoDaArvore pai) {
        this.pai = pai;
    }

    /**
     * 
     * @return simbolo
     */
    public Character getSimbolo() {
        return simbolo;
    }

    /**
     * 
     * @param simbolo
     */
    public void setSimbolo(Character simbolo) {
        this.simbolo = simbolo;
    }    
    
    @Override
    public int compareTo(NoDaArvore no){
        return this.tamanho - no.tamanho;
    }

}