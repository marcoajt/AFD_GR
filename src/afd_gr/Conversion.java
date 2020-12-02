/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd_gr;

import java.util.Arrays;

/**
 *
 * @author marco
 */
public class Conversion {
    char [] alfabeto;
    char ini;
    char [] fim;
    char [][] dados;

    public char[] getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(char[] alfabeto) {
        this.alfabeto = alfabeto;
    }

    public char getIni() {
        return ini;
    }

    public void setIni(char ini) {
        this.ini = ini;
    }

    public char [] getFim() {
        return fim;
    }

    public void setFim(char [] fim) {
        this.fim = fim;
    }

    public char[][] getDados() {
        return dados;
    }

    public void setDados(char[][] dados) {
        this.dados = dados;
    }
    
    public void transform(){
        System.out.println("----------DADOS----------");
        System.out.print("Alfabeto obitido:");
        System.out.println(alfabeto);
        System.out.print("Inicio: ");
        System.out.println(ini);
        System.out.print("Fim: ");
        System.out.println(fim);
        System.out.print("Matriz de dados: ");
        for(int i = 0;i < dados.length;i++){
            System.out.println("");
            for(int j = 0;j < dados[0].length;j++){
                System.out.print(dados[i][j]+" ");
            }
        }
        System.out.println("");
        System.out.println("---------------------");
    }
}
