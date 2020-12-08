
package afd_gr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transformador {
    private AFD meuAFD=new AFD();
    private String estados;
    
    private char estado_inicial;
    //char [] estado_final;
    private char estado_final;
    private char [] não_terminais; //VÃO RECEBER OS ESTADOS DA AFD
    private char [] terminais; //VÃO RECEBER ALFABETO DO AFD
    private char [][] regras; //VÃO RECEBER AS TRANSIÇÕES DO AFD
    private String argumento;//ARGUMENTO USADO NA GR
    private String GR_alfa;
    
    
    private List<String> ConfigGR_não_terminais=new ArrayList<>();
    private List<String> ConfigGR_terminais=new ArrayList<>();;
    private List<Regras> ConfigGR_conj_regras=new ArrayList<>();; //ISSO SERA UTILIZADO NA CLASSE Gramatica Regular

    
    public Transformador() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite todos os estados (sem espaço): ");
        String est =scan.nextLine();
        estados = est;
        meuAFD.iniciaAFD();        
        GR_alfa="&";
        setNão_terminais(estados.toCharArray());
        setTerminais(meuAFD.getAlf());
      //  setRegras(meuAFD.getMat());
      configuração_gr();  
      regras(meuAFD.getMat());
        setEstado_inicial(meuAFD.getIni());
        setEstado_final(meuAFD.getFim());        
    }
    
    public void regras(char[][] mat){
        String[][] fim=new String[não_terminais.length*2][meuAFD.getMat().length*2];
        List<String> preRegras=new ArrayList<>();
        int k=0,i,j;
        for(i=0;i<não_terminais.length;i++){ //separa os estados
            k=0;
            for(j=0;j<mat.length;j++){ //verifica o tamnho 
                if(ConfigGR_não_terminais.get(i).equals(String.valueOf(mat[j][0]))){
                    fim[i][k]=String.valueOf(mat[j][1])+String.valueOf(mat[j][2]); // ESTRAI A REGRA PARA O NÃO TERMINAL NA ORDEM ADICIONADA
                     k++;
                }                
            } 
            if(ConfigGR_não_terminais.get(i).equals(String.valueOf(meuAFD.getEstfim()))){ 
                //TESTA SE O NÃO TERMINAL É FINAL E JÁ FORAM ESTRAIDAS SUAS TRANSIÇÕES (CASO TENHA)
                    fim[i][k]="&"; k++;
                }
            fim[i][k]="@";
            
            for(int l=0;l<k;l++){
                ConfigGR_conj_regras.get(i).derivacoes.add(fim[i][l]);
            }            
        }        
    }
    
    public char[] getNão_terminais() {
        return não_terminais;
    }

    public void setNão_terminais(char[] não_terminais) {
        this.não_terminais = não_terminais;
    }

    public List<String> getConfigGR_terminais() {
        return ConfigGR_terminais;
    }

    public char[] getTerminais() {
        return terminais;
    }

    public void setTerminais(char[] terminais) {
        this.terminais = terminais;
    }

    public char[][] getRegras() {
        return regras;
    }

    public void setRegras(char[][] regras) {
        this.regras = regras;
    }

    public char getEstado_inicial() {
        return estado_inicial;
    }

    public void setEstado_inicial(char estado_inicial) {
        this.estado_inicial = estado_inicial;
    }

    public char getEstado_final() {
        return estado_final;
    }

    public void setEstado_final(char estado_final) {
        this.estado_final = estado_final;
    }


    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getGR_alfa() {
        return GR_alfa;
    }

    public List<String> getConfigGR_não_terminais() {
        return ConfigGR_não_terminais;
    }

    public List<Regras> getConfigGR_conj_regras() {
        return ConfigGR_conj_regras;
    }
    
    
    
    

    public void configuração_gr(){
        for(int i = 0; i < não_terminais.length; i++){
            argumento = String.valueOf(não_terminais[i]);
            ConfigGR_não_terminais.add(argumento);
            ConfigGR_conj_regras.add(new Regras());
            GR_alfa = GR_alfa + argumento;
        }
        
        for(int i = 0;i < terminais.length; i++){
            argumento = String.valueOf(terminais[i]);
            ConfigGR_terminais.add(argumento);
            GR_alfa = GR_alfa + argumento;
        }
    }
    
     public boolean afdConfirm(){
            return meuAFD.isRec();
        }
  
}
