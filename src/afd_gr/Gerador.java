package afd_gr;

import java.util.ArrayList;
import java.util.Collections;

public class Gerador {
    private ArrayList<String> palavras_finais = new ArrayList<String>();
    private ArrayList<String> finais_ordenadas = new ArrayList<String>();
    private ArrayList<String> todas_palavras = new ArrayList<String>();
    public int qtd;

    public Gerador(){
    }

    public void GerarPalavras(){
        System.out.print("\nPALAVRAS FINAIS:");
        for(int i=0;i<palavras_finais.size();i++){
            int n = 1+i;
            System.out.print("\nPalavra Final ["+n+"]: "+ palavras_finais.get(i));
        }
        System.out.println();
    }

    public void Mostra_Todas(){
        int n=1;
        System.out.print("\nDERIVAÇÃO DAS PALAVRAS:");
        for(int i=0;i<todas_palavras.size();i++){            
            System.out.print("\nPalavra ["+n+"]: "+ todas_palavras.get(i));
            if(todas_palavras.get(i).toLowerCase()==todas_palavras.get(i)){n++;System.out.println();}
        }
        System.out.println();
    }

    public void Ordenador(){
        Collections.sort(palavras_finais);
        System.out.println("Palavras Ordenadas: ");
        for(int i=0;i<palavras_finais.size();i++){
            System.out.println(palavras_finais.get(i));
        }
    }

    public void Ordenador2(){
        Integer j=0, aux=0;
        for(int i=0;i<palavras_finais.size();i++){
            for(j=0;j<palavras_finais.size();j++){
                if(palavras_finais.get(i).length()<palavras_finais.get(j).length()){
                    Collections.swap(palavras_finais, i, j);
                }
            }
        }
    }

    public void setPalavra(String palavra){
        if(!palavra.isEmpty()){this.todas_palavras.add(palavra);}
        if((palavra.toLowerCase()==palavra)&&(!palavra.isEmpty())){
            this.palavras_finais.add(palavra);
            this.qtd = qtd - 1;
            System.out.print("-> Gerou!\n");
        }
    } 
    
    public void setQtd(int Qtd){
        this.qtd = Qtd;
    }

    public int getQtd(){
        return this.qtd;
    }
}
