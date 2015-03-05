package br.com.ifpb.Proxy;

import br.com.ifpb.huffman.Controlador;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gilvonaldo
 */
public class ControladorProxy {

    private Controlador controle;

    public ControladorProxy() {
        controle = new Controlador();
    }

    /**
     *
     * @param arquivo
     * @param destino
     */
    public void compactar(File arquivo, File destino) {

        try {
            System.out.println("Arquivo: " + arquivo + " Destino: " + destino);
            if (arquivo == null || destino == null) {
                JOptionPane.showMessageDialog(null, "Erro ao Compactar o arquivo.");
            } else {
                controle.compactar(arquivo, destino);
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Compactar o arquivo.");
        }

    }

    /**
     *
     * @param arquivo
     * @param destino
     */
    public void descompactar(File arquivo, File destino) {

        try {
            System.out.println("Arquivo: " + arquivo + " Destino: " + destino);
            if (arquivo == null || destino == null) {
                JOptionPane.showMessageDialog(null, "Erro ao descompactar o arquivo.");
            } else {
                controle.descompactar(arquivo, destino);
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao descompactar o arquivo.");
        }

    }

}
