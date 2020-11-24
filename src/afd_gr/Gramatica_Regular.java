/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd_gr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Gramatica_Regular {
    public List<String> nao_terminais; //LISTA DE NAO-TERMINAIS
    public List<String> terminais; //LISTA DE TERMINAIS
    public List<Regras> conj_regras; //LISTA DAS LISTAS DE DERIVACOES 

    public Gramatica_Regular() {
        this.nao_terminais = new ArrayList(); //DEFINE NOVA LISTA DE NAO-TERMINAIS
        this.terminais = new ArrayList(); //DEFINE NOVA LISTA DE TERMINAIS
        this.conj_regras = new ArrayList(); //DEFINE NOVA LISTA DAS LISTAS DE DERIVACOES 

    }
}
