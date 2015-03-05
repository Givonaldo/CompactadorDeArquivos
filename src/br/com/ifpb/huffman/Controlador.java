/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.huffman;

import br.com.ifpb.models.Zip;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author gilvonaldo
 */
public class Controlador {

    public void compactar(File arquivo, File caminho) throws IOException {

        System.out.println(caminho.getAbsolutePath()+System.getProperty("file.separator").toString()+"Arquivo.txt");
        ConstroiArquivo file = new ConstroiArquivo(arquivo.getAbsolutePath(), caminho.getAbsolutePath()+System.getProperty("file.separator")+"Arquivo.mat");
        
        File[] files;
        files = new File[0];
        files[0] = arquivo;
        
        Zip z = new Zip();
        z.zip(files, caminho);
        
    }

    public void descompactar(File arquivo, File caminho) throws IOException {

        Zip zip = new Zip();
        zip.unzip(arquivo, caminho);
    }
    
    /**
     *
     * @param arquivo
     */
    public void gerarGrafico(String arquivo) {

    }

}
