package afd_gr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AFD_GR{

    static Gramatica_Regular G_R = new Gramatica_Regular(); //VARIAVEL QUE CONTEM LISTAS COM AS VARIAVEIS TERMINAIS, NAO-TERMINAIS E CONJUNTOS DE REGRAS PARA CADA NAO TERMINAL
    static Gerador cachorro = new Gerador();
    static AFD meuAFD = new AFD();
    static char estados [];
    
    static int infinity; //VARIAVEL USADA PARA REALIZAR VERIFICACAO DE EXCECOES
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite os estados");
        String est =scan.nextLine();
        estados = est.toCharArray();
        
        meuAFD.iniciaAFD();
        
        Transformador trans = new Transformador();
        
        trans.setNão_terminais(estados);
        trans.setTerminais(meuAFD.getAlf());
        trans.setRegras(meuAFD.getMat());
        trans.setEstado_inicial(meuAFD.getIni());
        trans.setEstado_final(meuAFD.getFim());
        
        char [] nao_terminais = estados;
        char [] terminais=meuAFD.getAlf();
        
        if(meuAFD.isRec()){
            String argumento; //VARIAVEL USADA PARA INTERAGIR COM O USUARIO
            //Scanner scan = new Scanner(System.in); //VARIAVEL USADA PARA INTERAGIR COM O USUARIO
            String alfa = new String(); //VARIAVEL USADA PARA GUARDAR O ALFABETO COMPLETO CONTENDO VARIAVEIS TERMINAIS E NAO-TERMINAIS
            char cont_alfa[]; //VARIAVEL USADA PARA GUARDAR O ALFABETO COMPLETO CONTENDO VARIAVEIS TERMINAIS E NAO-TERMINAIS NO FORMATO DE VETOR
            char[] cont_regra_0; //VARIAVEL USADA PARA REALIZAR VERIFICACAO DE EXCECOES
            List<String> cont_regra_1 = new ArrayList(); //VARIAVEL USADA PARA REALIZAR VERIFICACAO DE EXCECOES
            boolean verificador; //VARIAVEL USADA PARA REALIZAR VERIFICACAO DE EXCECOES
            boolean caso_do_meio;
            int cont_0; //VARIAVEL USADA PARA REALIZAR VERIFICACAO DE EXCECOES
            int cont_1; //VARIAVEL USADA PARA REALIZAR VERIFICACAO DE EXCECOES
            int n, automatico=2; //INICIALIZA PARA EFETURAR A DERIVAÇÃO DE OUTRA PALAVRA




            alfa = alfa + "&"; //DEFININDO QUE O PRIMEIRO ELEMENTO DO ALFABETO É O VAZIO

            System.out.println("\nDigite a quantidade de palavras: ");  
            n =scan.nextInt();  
            cachorro.setQtd(n);
            /*
            do{
                System.out.println("\nDigite [1] para inserir raizes manualmente.\nDigite [2] para inserir raizes automáticas.\nDigite: ");  
                automatico = scan.nextInt(); 
                if((automatico!=1)&&(automatico!=2)){
                    System.out.println("\nDigite valor válido!\n"+automatico);
                }
            }while((automatico!=1)&&(automatico!=2));
*/
            //System.out.println("Alfabeto não-terminais; "); //INTERACAO COM O USUARIO
            /*argumento = String.valueOf(term[0]);
            while (!"@".equals(argumento)) { //ENQUANTO O USUARIO NAO DIGITAR @ CONTINUARA NA INSERCAO DE VARIAVEIS NAO-TERMINAIS
                verificador = false; //VARIAVEL TODA VEZ QUE ENTRA NESSA FUNCAO É DEFINIDA EM FALSE
                for (int x = 0; x < G_R.nao_terminais.size(); x++) { //PERCORRE TODAS NAO TERMINAIS
                    if (G_R.nao_terminais.get(x).contains(argumento)) { //COMPARA SE O USUARIO DIGITOU UMA NAO-TERMINAL REPETIDA
                        System.out.println("\nSimbolo invalido! Ja existente nas variaveis nao-terminais\n"); //INTERACAO COM O USUARIO
                        verificador = true; //DEFINE TRUE SINALIZANDO QUE HOUVE UMA EXCECAO
                    }
                }
                if (argumento.contains("&")) { //VERIFICA SE USUARIO DIGITOU O SIMBOLO USADO PARA DEFINIR VAZIO
                    System.out.println("\nSimbolo invalido! Ja existente simbolizando o vazio\n"); //INTERACAO COM O USUARIO
                    verificador = true; //DEFINE TRUE SINALIZANDO QUE HOUVE UMA EXCECAO
                }
                if (verificador == false) { //CASO SEJA FALSE PROCEGUE
                    G_R.nao_terminais.add(argumento); //ARMAZENA A NAO-TERMINAL DIGITADA PELO USUARIO
                    G_R.conj_regras.add(new Regras()); //ADICIONA UM ESPACO NA LISTA DE REGRAS
                    alfa = alfa + argumento; //ADICIONA A NAO TERMINAL NO ALFABETO
                    System.out.println("\nInserido com sucesso!\n"); //INTERACAO COM O USUARIO
                }
                //argumento = scan.next();
            }*/

            for(int i = 0; i < nao_terminais.length;i++){
                 argumento = String.valueOf(nao_terminais[i]);
                 G_R.nao_terminais.add(argumento);
                 G_R.conj_regras.add(new Regras());
                 alfa = alfa + argumento;
            }

            //System.out.println("Alfabeto terminais: "); //INTERACAO COM O USUARIO
            //argumento = scan.next();

            for(int i = 0; i < terminais.length;i++){
                 argumento = String.valueOf(terminais[i]);
                 G_R.terminais.add(argumento);
                 alfa = alfa + argumento;
            }

            /*while (!"@".equals(argumento)) { //ENQUANTO O USUARIO NAO DIGITAR @ CONTINUARA NA INSERCAO DE VARIAVEIS TERMINAIS
                verificador = false; //VARIAVEL TODA VEZ QUE ENTRA NESSA FUNCAO É DEFINIDA EM FALSE
                for (int x = 0; x < G_R.nao_terminais.size(); x++) { //PERCORRE TODAS NAO TERMINAIS
                    if (G_R.nao_terminais.get(x).contains(argumento)) { //COMPARA SE O USUARIO DIGITOU UMA TERMINAL IGUAL A UMA NAO-TERMINAL
                        System.out.println("\nSimbolo invalido! Ja existente nas variaveis nao-terminais\n"); //INTERACAO COM O USUARIO
                        verificador = true; //DEFINE TRUE SINALIZANDO QUE HOUVE UMA EXCECAO
                    }
                }
                for (int x = 0; x < G_R.terminais.size(); x++) { //PERCORRE TODAS TERMINAIS
                    if (G_R.terminais.get(x).contains(argumento)) {//COMPARA SE O USUARIO DIGITOU UMA TERMINAL REPETIDA
                        System.out.println("\nSimbolo invalido! Ja existente nas variaveis terminais\n"); //INTERACAO COM O USUARIO
                        verificador = true; //DEFINE TRUE SINALIZANDO QUE HOUVE UMA EXCECAO
                    }
                }
                if (argumento.contains("&")) { //VERIFICA SE USUARIO DIGITOU O SIMBOLO USADO PARA DEFINIR VAZIO
                    System.out.println("\nSimbolo invalido! Ja existente simbolizando o vazio\n"); //INTERACAO COM O USUARIO
                    verificador = true; //DEFINE TRUE SINALIZANDO QUE HOUVE UMA EXCECAO
                }
                if (verificador == false) { //CASO SEJA FALSE PROCEGUE
                    G_R.terminais.add(argumento); //ARMAZENA A TERMINAL DIGITADA PELO USUARIO
                    alfa = alfa + argumento; //ADICIONA A NAO TERMINAL NO ALFABETO
                    System.out.println("\nInserido com sucesso!\n"); //INTERACAO COM O USUARIO
                }

                argumento = scan.next();
            }*/

            cont_alfa = alfa.toCharArray(); //PASSA A STRING DO ALFABETO PARA O FORMATO ARRAY

            int i,j,k; 
            i=j =k =0; //DEFINE A VARIAVEL DO CONJUNTO DE NÃO-TERMINAL EM 0
            String[][] arg =preRegras(meuAFD.getMat()); //SEPARA A MATRIZ DE TRANSIÇÕES EM UMA MELHOR MANIPULAVEL NA CRIAÇÃO DAS REGRAS
            
            
            do {
                //System.out.println("Informe as regras para a variavel nao-terminal |" + G_R.nao_terminais.get(i) + "| \n A gramatica regular deve ser linear a esquerda ou a direita\nPara usar o vazio utilize o simbolo '&' \n (adicione cada uma com enter ao fim) \n digite @ para avancar: "); //INTERACAO COM O USUARIO
                k=0;
                argumento = arg[i][k]; 
                while (!"@".equals(argumento)) { //ENQUANTO O USUARIO NAO DIGITAR @ CONTINUARA NA INSERCAO DE REGRAS
                    cont_0 = 0; //VARIAVEL USADA PARA VERIFICACAO DE EXCECAO
                    cont_1 = 0; //VARIAVEL USADA PARA VERIFICACAO DE EXCECAO
                    verificador = false; //VARIAVEL TODA VEZ QUE ENTRA NESSA FUNCAO É DEFINIDA EM FALSE
                    caso_do_meio = true; //VARIAVEL TODA VEZ QUE ENTRA NESSA FUNCAO É DEFINIDA EM TRUE
                    cont_regra_0 = argumento.toCharArray(); //ARGUMENTO E PASSADO PARA FORMA DE ARRAY PARA PODER SER ANALISADO MELHOR
                    cont_regra_1.clear(); //LISTA COM CARACTERES E LIMPA

                    for (int x = 0; x < cont_regra_0.length; x++) { //PERCORRE TODOS OS CARACTERES DIGITADOS PELO USUARIO
                        for (int y = 0; y < cont_alfa.length; y++) { //PERCORRE TODO ALFABETO
                            if (cont_regra_0[x] == cont_alfa[y]) { //VERIFICA SE O CARACTER PERTENCE AO ALFABETO
                                cont_0++; //SOMA CASO PERTENCA
                            }
                        }
                    }

                    for (int x = 0; x < cont_regra_0.length; x++) { //PERCORRE TODOS OS CARACTERES DIGITADOS PELO USUARIO
                        for (int y = 0; y < G_R.nao_terminais.size(); y++) { //PERCORRE TODAS VARIAVEIS NAO-TERMINAIS
                            StringBuilder aux_0 = new StringBuilder(); //CRIA UMA STRINGBUILDER
                            aux_0.append(cont_regra_0[x]); //ADICIONA O CARACTER QUE ESTA SENDO ANALISADO
                            String aux_1 = aux_0.toString(); //PASSA O CARACTER PARA O MODELO STRING
                            if (aux_1.contains(G_R.nao_terminais.get(y))) { //VERIFICA SE O CARACTER É IGUAL A ALGUMA VARIAVEL NAO-TERMINAL
                                if ((x == 0 || x == cont_regra_0.length-1)) { //VERIFICA SE É A ULTIMA OU PRIMEIRA POSICAO DA REGRA PARA GARANTIR QUE SEJA LINEAR A DIREITA OU A ESQUERDA
                                    caso_do_meio = false; 
                                }
                                cont_1++; //SOMA SE É IGUAL A ALGUMA NAO-TERMINAL
                            }
                        }
                    }

                    if(cont_1 == 0) //VERIFICA SE NENHUMA NAO-TERMINAL FOI DIGITADA
                    {
                     caso_do_meio = false; //FALSO CASO NAO HAJA PROBLEMAS E NENHUM RISCO DE QUEBRA DE LINEARIDADE 
                    }

                    if (cont_0 == cont_regra_0.length && cont_1 < 2 && caso_do_meio == false) { //CASO SEJA CONT_0 IGUAL O TAMANHO DA PALAVRA DIGITADA SIGNIFICA QUE TODOS CARACTERES PERTENCEM AO ALFABETO QUE FOI GERADO, CASO CONT_1 DEMONSTRE QUE HA MENOS DE DUAS NAO-TERMINAIS NO TERMO E CASO NAO HAJA NENHUMA QUEBRA DE LINEARIDADE ENTAO O PROCESSO SEGUE
                        k++; //SOMA PARA SEGUIR NA CRIAÇÃO DAS REGRAS
                        G_R.conj_regras.get(i).derivacoes.add(argumento); //A REGRA E ADICIONADA NA LISTA DE REGRAS
                       // System.out.println("\nInserido com sucesso!\n"); //INTERACAO COM O USUARIO
                    } else {
                        System.out.println("\nSimbolo invalido!\n"); //INTERACAO COM O USUARIO
                    }
                    
                    //TESTE PARA VER SE É A ULTIMA REGRA
                    //vazio++;
                    argumento = arg[i][k];
              }
                i++; // SOMA O CONTADOR PARA AVANCAR PARA OUTRA NAO TERMINAL
            } while (i < G_R.conj_regras.size());
            

            //EXIBIÇÃO
            System.out.println("Regras:"); //INTERACAO COM O USUARIO
            for (int x = 0; x < G_R.conj_regras.size(); x++) { //PERCORRE TODOS CONJUNTOS DE REGRAS
                int z = G_R.conj_regras.get(x).derivacoes.size(); //DEFINE Z O TAMANHO DESTA LISTA DE REGRAS
                for (int y = 0; y < z; y++) { //PERCORRE TODAS REGRAS DESTE CONJUNTO E REALIZA A EXIBICAO SENDO CADA LINHA REGRAS DE UMA NAO-TERMINAL
                    System.out.print(G_R.nao_terminais.get(x) + " -> "); //EXIBE QUAL NAO-TERMINAL PERTENCE A REGRA
                    System.out.print(G_R.conj_regras.get(x).derivacoes.get(y) + " "); //INTERACAO COM O USUARIO
                }
                System.out.println("\n");
            }
            System.out.println("Alfabeto:"); //INTERACAO COM O USUARIO
            for (int x = 0; x < cont_alfa.length; x++) { //PERCORRE TODO ALFABETO
                System.out.print(cont_alfa[x] + " - "); //INTERACAO COM O USUARIO
            }
            System.out.println("\n");

            if(automatico == 1){
                System.out.println("Informe o simbolo inicial (raiz) para gerar aleatoriamente uma palavra pertencente a esta gramatica regular \n (adicione com enter ao fim) \n digite @ para finalizar: "); //INTERACAO COM O USUARIO
                argumento = scan.next();
            }
            else if(automatico == 2){argumento = rand_root();}

            while ((!"@".equals(argumento)) && (n>=1)) { //ENQUANTO O USUARIO NAO DIGITAR @ CONTINUARA NA INSERCAO DE RAIZ E ASSIM GERANDO PALAVRAS ALEATORIAS A CADA ENTRADA

                verificador = false; //VARIAVEL TODA VEZ QUE ENTRA NESSA FUNCAO É DEFINIDA EM FALSE
                for (int x = 0; x < G_R.nao_terminais.size(); x++) { //PERCORRE TODAS NAO-TERMINAIS
                    if (G_R.nao_terminais.get(x).contains(argumento) && !argumento.contains("@")) { //VERIFICA SE O USUARIO DIGITOU CORRETAMENTE 
                        infinity=0;
                        derivador(argumento); // SE SIM MANDA PARA O DERIVADOR
                        verificador = true; //DEFINE TRUE SINALIZANDO QUE NAO HOUVE UMA EXCECAO
                    }
                }
                if (verificador == false) { //SE NAO INVALIDA A OPERACAO
                    System.out.println("\nSimbolo invalido!\n"); //INTERACAO COM O USUARIO
                }
                n = cachorro.getQtd();
                if(n!=1){
                    if(automatico == 1){
                        System.out.println("Informe o simbolo inicial (raiz) para gerar aleatoriamente uma palavra pertencente a esta gramatica regular \n (adicione com enter ao fim) \n digite @ para finalizar: "); //INTERACAO COM O USUARIO
                        argumento = scan.next();
                    }
                    else{argumento = rand_root();}
                }
            }
            cachorro.GerarPalavras();
            cachorro.Ordenador2();
            cachorro.Mostra_Todas();
            //cachorro.Ordenador();
            cachorro.GerarPalavras();
       }
       else{
           System.out.println("ERRO: Tente outras entradas");
       }
    }
      
    public static void derivador(String parametro) { //ONDE AS PALAVRAS SAO DERIVADAS
        String resultado = new String(); //VARIAVEL FINAL QUE SERA MOSTRADA PARA O USUARIO
        boolean aux = false; //VARIAVEL TODA VEZ QUE ENTRA NESSA FUNCAO É DEFINIDA EM FALSE
        Random choice = new Random(); //VARIAVEL USADA PARA SORTEAR O CAMINHO QUE SERA SEGUIDO
        char origem[] = parametro.toCharArray(); //ORIGEM RECEBE O PARAMETRO EM FORMATO DE ARRAY
        char finale[]; //VARIAVEL USADA PARA TRATAR SIMBOLO VAZI0
           
        
        for (int x = 0; x < G_R.nao_terminais.size(); x++) { //PERCORRE TODAS NAO-TERMINAIS
            for (int y = 0; y < origem.length; y++) { //PERCORRE TODO TERMO DIGITADO PELO USUARIO

                StringBuilder aux1 = new StringBuilder(); //DEFINIDO O STRINGBUILDER
                aux1.append(origem[y]); //ADICIONADO O CARACTER DA PALAVRA DIGITADA PELO USUARIO
                String aux2 = aux1.toString(); //ENTAO TRANSFORMADO EM STRING

                if (G_R.nao_terminais.get(x).equals(aux2)) { //E COMPARADO SE IGUAL A ALGUMA NAO TERMINAL
                    infinity++;
                    aux = true; //AUX DEFINIDA EM TRUE SIMBOLIZANDO QUE UM TERMO A SER DERIVADO FOI ENCONTRADO E A FUNCAO DEVE SER CHAMADA NOVAMENTE PARA VERIFICACAO
                    for (int z = 0; z < origem.length; z++) { //FAZ O MESMO QUE A SEGUNDA FOR, PERCORRE TODO TERMO DIGITADO PELO USUARIO
                        if (y != z && origem[z] != '&') { //COMPARA SE O CARACTER E DIFERENTE DO QUE FOI ACHADO E É IGUAL A UMA NAO-TERMINAL
                            StringBuilder argamassa = new StringBuilder(); //DEFINE STRINGBUILDER
                            argamassa.append(origem[z]); //ADICIONA O CARACTER
                            resultado = resultado + argamassa.toString(); //CONCATENA COM O RESULTADO ESSE CARACTER QUALQUER
                        }
                        if (y == z) { //SE ORIGEM ESTA NO CARACTER DE MESMA POSICAO DE Z E Y ENTAO ESTE CARACTER E UMA NAO TERMINAL E DEVE SER APLICADA UMA REGRA DE DERIVACAO
                            resultado = resultado + G_R.conj_regras.get(x).derivacoes.get(choice.nextInt(G_R.conj_regras.get(x).derivacoes.size())); // É ESCOLHIDA ALEATORIAMENTE UMA REGRA PERTENCENTE A ESTA NAO-TERMINAL E ENTAO CONCATENADA EM RESULTADO
                        }
                    }
                }

            }
        }

        finale = resultado.toCharArray(); //RESULTADO E TRANFORMADA EM VETOR
        resultado = ""; //RESULTADO É LIMPA
        for (int z = 0; z < finale.length; z++) { //PERCORRE TODOS CARACTERES
            if (finale[z] != '&' && finale.length<200) { //VERIFICA, SE NAO FOR UM SIMBOLO DE VAZIO CONCATENA RESULTADO
                StringBuilder argamassa = new StringBuilder();
                argamassa.append(finale[z]);
                resultado = resultado + argamassa.toString(); //A PALAVRA É REESCRITA SEM O SIMBOLO DE VAZIO
            } else if (finale.length == 200) //CASO A PALAVRA TOTAL TENHA ALCANCADO 200 CARACTERES 
             {
              aux=false; //PARA DE DERIVAR
              cachorro.setPalavra(resultado);
             }
        }
        if(infinity == 100) //VERIFICA SE FORAM FEITAS 100 DERIVACOES
        {
         aux=false; //PARA DE DERIVAR CASO SIM
         cachorro.setPalavra(resultado);
        }

        if (aux == true) { //CASO TRUE A RECURSIVA É ATIVADA
            cachorro.setPalavra(resultado);
            //System.out.println("-> " + resultado); //INTERACAO COM O USUARIO
            derivador(resultado); //DERIVADOR E CHAMADO
        }
    }   
    
    public static String rand_root(){
        Random gato = new Random();
        return G_R.nao_terminais.get(gato.nextInt(G_R.nao_terminais.size()));
    }
        
    public static String[][] preRegras(char[][] mat){
        String[][] fim=new String[estados.length*2][meuAFD.getMat().length*2];
        int k=0,i,j;
        for(i=0;i<estados.length;i++){ //separa os estados
            k=0;
            for(j=0;j<mat.length;j++){ //verifica o tamnho 
                if(G_R.nao_terminais.get(i).equals(String.valueOf(mat[j][0]))){
                    fim[i][k]=String.valueOf(mat[j][1])+String.valueOf(mat[j][2]); // ESTRAI A REGRA PARA O NÃO TERMINAL NA ORDEM ADICIONADA
                     k++;
                }                
            }  if(G_R.nao_terminais.get(i).equals(String.valueOf(meuAFD.getEstfim()))){ 
                //TESTA SE O NÃO TERMINAL É FINAL E JÁ FORAM ESTRAIDAS SUAS TRANSIÇÕES (CASO TENHA)
                    fim[i][k]="&"; k++;
                }
            fim[i][k]="@";
        }
        
        return fim;
    }
        
    }
