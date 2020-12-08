
package afd_gr;

import java.util.ArrayList;

public class Transformador {
    char estado_inicial;
    //char [] estado_final;
    char estado_final;
    char [] não_terminais; //VÃO RECEBER OS ESTADOS DA AFD
    char [] terminais; //VÃO RECEBER ALFABETO DO AFD
    char [][] regras; //VÃO RECEBER AS TRANSIÇÕES DO AFD
    String argumento;//ARGUMENTO USADO NA GR
    String GR_alfa;
    
    ArrayList<String> ConfigGR_não_terminais;
    ArrayList<String> ConfigGR_terminais;
    ArrayList<Regras> ConfigGR_conj_regras;

    public char[] getNão_terminais() {
        return não_terminais;
    }

    public void setNão_terminais(char[] não_terminais) {
        this.não_terminais = não_terminais;
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

    public ArrayList<String> getConfigGR_não_terminais() {
        return ConfigGR_não_terminais;
    }

    public ArrayList<Regras> getConfigGR_conj_regras() {
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
        
        String[][] arg = preRegras(regras);
    }
    
    
    public String [][] preRegras(char[][] mat){
        String[][]fim = new String[não_terminais.length * 2][regras.length * 2];
        int k = 0,i,j;
        for(i = 0;i < não_terminais.length;i++){
            k = 0;
            for(j = 0;j < mat.length; j++){
                if(ConfigGR_não_terminais.get(i).equals(String.valueOf(mat[j][0]))){
                    fim[i][k] = String.valueOf(mat[j][1]) + String.valueOf(mat[j][2]);
                    k++;
                }
            }
            if(ConfigGR_não_terminais.get(i).equals(String.valueOf(estado_final))){
                fim[i][k] = "&";
                k++;
            }
            fim[i][j] = "@";
        }
        return fim;
    }
}
