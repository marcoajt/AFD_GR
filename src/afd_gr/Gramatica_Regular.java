package afd_gr;

import java.util.ArrayList;
import java.util.List;

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
