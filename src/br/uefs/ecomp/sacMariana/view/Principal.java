/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package br.uefs.ecomp.sacMariana.view;

import br.uefs.ecomp.sacMariana.controller.SACMarianaController;
import br.uefs.ecomp.sacMariana.model.Doacao;
import br.uefs.ecomp.sacMariana.model.Doador;
import br.uefs.ecomp.sacMariana.model.Produto;
import br.uefs.ecomp.sacMariana.util.Console;
import br.uefs.ecomp.sacMariana.util.Iterador;
import br.uefs.ecomp.sacMariana.util.PegaData;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author VAGNER
 */

//Classe principal, onde todos os metodos do controller são gerenciados atravez de um menu.
public class Principal {
    public static void main(String[]args) throws IOException{
        int op = 20; //Variavel que define o fluxo do menu
        
        
        SACMarianaController controlador =new SACMarianaController(); //Instanciando o controller.
        System.out.println("************\nSACMARIANA\n************");
        
        do{
            
//Exibição do menu principal
            // O menu é controlado pela estrutura de repetição do{} while(); 
            System.out.println("(1) >>>Cadastrar Produto<<<");
            System.out.println("(2) >>>Alterar Produto<<<");
            System.out.println("(3) >>>Remover Produto<<<");
            System.out.println("(4) >>>Listar Produtos<<<");
            System.out.println("(5) >>>Cadastrar doador<<<");
            System.out.println("(6) >>>Alterar Doador<<<");
            System.out.println("(7) >>>Remover Doador<<<");
            System.out.println("(8) >>>Listar Doadores<<<");
            System.out.println("(9) >>>Efetuar nova doação<<<");
            System.out.println("(10) >>>Alterar uma doação<<<");
            System.out.println("(11) >>>Remover Doação<<<");
            System.out.println("(12) >>>Listar doações cadastradas<<<");
            System.out.println("(13) >>>Listar doações de determinado doador<<<");
            System.out.println("(14) >>>Listar percentual de doação de cada doador<<<");
            System.out.println("(0) Sair\n");
            
            op = Console.readInt();
            
            if(op == 1){
                int op3 = 11;
                do{
                    int op1;
                    op1 = 0;
                    for(int i = 0; i<50; i++){
                        System.out.println("");
                    }

                    String tipo = null;
                    String nome;
                    Date dt_criacao = new Date();

                    System.out.println("Escolha o tipo do produto: "
                            + "\n(1) Alimento"
                            + "\n(2) Vestuário"
                            + "\n(3) Limpeza"
                            + "\n(4) Monetária");
                    op1 = Console.readInt();
                    if (op1 == 1) {
                        tipo = "Alimento";
                    } else if (op1 == 2) {
                        tipo = "Vestuário";
                    } else if (op1 == 3) {
                        tipo = "Limpeza";
                    } else if (op1 == 4) {
                        tipo = "Monetária";
                    }
                    System.out.println("Digite o nome do produto");
                    nome = Console.readString();

                    controlador.cadastrarProduto(nome, tipo, dt_criacao);
                    System.out.println("Deseja Cadastrar mais produtos? <1-Sim> <2-Nao>");
                    op3 = Console.readInt();
                }while(op3 !=2);
            }else if(op==2){
                int op3 = 0;
                do{
                    for (int i = 0; i < 50; i++) {
                        System.out.println("");
                    }
                    int id;
                    String tipo = null;
                    String nome;
                    Date dt_criacao = new Date();

                    System.out.println("Informe o ID do produto: ");
                    id = Console.readInt();
                    
                    System.out.println("Digite o novo nome do produto");
                    nome = Console.readString();

                    controlador.editarProduto(id, nome, tipo, dt_criacao);
                    System.out.println("Deseja editar mais algum produto? <1-sim> <2-Nao>");
                    op3 = Console.readInt();
                }while(op3 != 2);

                
            }else if(op == 3){
                int op3 = 0;                
                do{

                
                    int id;
                    
                    for (int i = 0; i < 50; i++) {
                        System.out.println("");
                    }
                    Iterador it = controlador.listarProdutos();
                    while (it.temProximo()) {
                        Produto p1 = (Produto) it.obterProximo();
                        System.out.println("ID: " + p1.getId() + " --- " + p1.getNome() + " --- " + p1.getTipo());
                    }
                    int op4 = 0;
                    do{
                        System.out.println("Informe o ID do produto que deseja remover");
                        id = Console.readInt();
                        controlador.removerProduto(id);
                        System.out.println("<1-Continuar> <2-Voltar>");
                        op4 = Console.readInt();
                    }while(op4!=2);
                }while (op3 != 2);
                
                
            }else if(op == 4){
                for ( int i = 0; i < 50; i++) {
                    System.out.println("");
                }
                Iterador it = controlador.listarProdutos();
                while (it.temProximo()) {
                    Produto p1 = (Produto) it.obterProximo();
                    Date data = p1.getDataCadastro();
                    System.out.println("ID: " + p1.getId() + " --- " + p1.getNome() + " --- " + p1.getTipo());

                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("");
                }

            }else if(op == 5){
                int op3 = 0;
                do{
                    for (int i = 0; i < 50; i++) {
                        System.out.println("");
                    }

                    String numCadastro = null;
                    String nome;
                    Date dataNasc = null;
                    String rua;
                    int numero;
                    String bairro;
                    String cep;
                    String cidade;
                    String uf;
                    String pais;
                    String tipo = null;
                    
                    
                    
                    
                    int op4 = 0;
                    do{
                        
                        System.out.println("<1-Pessoa Física> <2-Pessoa Juridica>");
                        op4=Console.readInt();
                        
                    }while (!(op4==1 || op4 == 2));
                    if(op4 == 1){
                        tipo = "Pessoa Física";
                        System.out.println("Informe o CPF");
                        numCadastro = Console.readString();
                        System.out.println("Informe a data de Nascimento no formato dd/MM/yyyy hh");
                        dataNasc = PegaData.pegaData();

                        

                    }else if(op4 ==2){
                        tipo = "Pessoa Jurídica";
                        System.out.println("Informe o CNPJ");
                        numCadastro = Console.readString();
                        System.out.println("Informe a data de Fundação no formato dd/MM/yyyy hh.");
                        dataNasc = PegaData.pegaData();
                        
                    }
                        System.out.println("Informe o nome.");
                       nome = Console.readString();
                       System.out.println("Rua: ");
                       rua = Console.readString();
                       System.out.println("Número da casa: ");
                       numero = Console.readInt();
                       System.out.println("Bairro: ");
                       bairro = Console.readString();
                       System.out.println("CEP: ");
                       cep = Console.readString();
                       System.out.println("Cidade: ");
                       cidade = Console.readString();
                       System.out.println("UF: ");
                       uf = Console.readString();
                       System.out.println("PAÍS: ");
                       pais = Console.readString();
                    
                       controlador.cadastrarDoador(numCadastro, nome, dataNasc, rua, numero, bairro, cep, cidade, uf, pais, tipo);
                       
                       System.out.println("Deseja cadastrar mais Doadores <1-Sim> <2-Nao>");
                       op3 = Console.readInt();

                }while(op3!=2);

            }else if(op==6){
                                int op3 = 0;
                do{
                    for (int i = 0; i < 50; i++) {
                        System.out.println("");
                    }

                    String numCadastro = null;
                    String nome;
                    Date dataNasc = null;
                    String rua;
                    int numero;
                    String bairro;
                    String cep;
                    String cidade;
                    String uf;
                    String pais;
                    String tipo = null;
                    
                    
                    
                    
                    int op4 = 0;
                    do{
                        
                        System.out.println("<1-Pessoa Física> <2-Pessoa Juridica>");
                        op4=Console.readInt();
                        
                    }while (!(op4==1 || op4 == 2));
                    if(op4 == 1){
                        tipo = "Pessoa Física";
                        System.out.println("Informe o CPF");
                        numCadastro = Console.readString();
                        System.out.println("Informe a data de Nascimento no formato dd/MM/yyyy hh");
                        dataNasc = PegaData.pegaData();

                        

                    }else if(op4 ==2){
                        tipo = "Pessoa Jurídica";
                        System.out.println("Informe o CNPJ");
                        numCadastro = Console.readString();
                        System.out.println("Informe a data de Fundação no formato dd/MM/yyyy hh.");
                        dataNasc = PegaData.pegaData();
                        
                    }
                        System.out.println("Informe o nome.");
                       nome = Console.readString();
                       System.out.println("Rua: ");
                       rua = Console.readString();
                       System.out.println("Número da casa: ");
                       numero = Console.readInt();
                       System.out.println("Bairro: ");
                       bairro = Console.readString();
                       System.out.println("CEP: ");
                       cep = Console.readString();
                       System.out.println("Cidade: ");
                       cidade = Console.readString();
                       System.out.println("UF: ");
                       uf = Console.readString();
                       System.out.println("PAÍS: ");
                       pais = Console.readString();
                     
                       controlador.editarDoador(numCadastro, nome, dataNasc, rua, numero, bairro, cep, cidade, uf, pais, tipo);
                       }while(op3!=2);
            }else if(op == 7){
                int op3 = 0;
                do{
                String numCadastro;
                for (int i = 0; i < 50; i++) {
                    System.out.println("");
                }
                System.out.println("Digite o CPF ou CNPJ do doador que deseja remover: ");
                numCadastro = Console.readString();

                controlador.removerDoador(numCadastro);
                    System.out.println("Deseja remover mais algum Doador? <1-Sim> <2-Nao>");
                    op3 = Console.readInt();
                }while (op3!=2);
            }
            else if(op==8){
                for (int i = 0; i < 50; i++) {
                    System.out.println("");
                }
                Iterador x = controlador.listarDoadores();
                System.out.println(x.obterProximo());
                
            }
            else if(op == 9){
                int op3 = 0;
                do{
                for(int i = 0; i<30; i++){
                    System.out.println("");
                }
                System.out.println("************* Efetuar Doação************");
                Produto p1, p2 = null;
                Doador d1;
                Number qtd;
                Date dt_Doacao = new Date();
                String numCadastro;
                int idProduto;
                
                System.out. println("Informe o Numero de cadastro do doador.");
                numCadastro = Console.readString();
                d1 = controlador.obterDoador(numCadastro);
                System.out.println("Informe o ID do produto.");
                idProduto = Console.readInt();
                Iterador x = controlador.listarProdutos();
                while(x.temProximo()){
                    p1 = (Produto) x.obterProximo();
                    if(p1.getId() == idProduto){
                        p2 =  p1;
                    }
                }
                
                System.out.println("Informe a quantidade.");
                qtd = Console.readInt();
                
                
                
                controlador.efetuarDoacao(d1, p2, qtd, dt_Doacao);
                    System.out.println("Deseja fazer outra doação? <1-sim> <2-Nao>");
                    op3 = Console.readInt();
                }while(op3 != 2);
            
            
            }else if(op==10){
                 int id;
                 Produto p1, p2 = null;
                 Doacao doacao1 = null;
                 Doador doador1;
                 Number qdt = null;
                 Date dt_Doacao = new Date();
                 String numCadastro;
                 int idProduto;
                 int idDoacao;
                 System.out.println("Informe o ID da doação que deseja alterar.");
                 idDoacao = Console.readInt();
                 
                for (int i = 0; i < 50; i++) {
                    System.out.println("");
                }
                System.out. println("Informe o Numero de cadastro do doador.");
                numCadastro = Console.readString();
                doador1 = controlador.obterDoador(numCadastro);
                System.out.println("Informe o ID do produto.");
                idProduto = Console.readInt();
                Iterador x = controlador.listarProdutos();
                while(x.temProximo()){
                    p1 = (Produto) x.obterProximo();
                    if(p1.getId() == idProduto){
                        p2 =  p1;
                    }
                }
                
                System.out.println("Informe a quantidade.");
                int qtd = Console.readInt();
                
                controlador.alterarDoacao(idDoacao, doador1, p2, qdt, dt_Doacao);
                
                
                
                
            }else if(op==11){
                int op2 = 0;
                  do{
                    for (int i = 0; i < 50; i++) {
                        System.out.println("");
                    }
                    int id;
                    System.out.println("Informo o ID da doação que deseja remover.");
                    id = Console.readInt();
                    controlador.removerDoacao(id);
                      System.out.println("Deseja remover mais alguma doação? <1-Sim> <2-Nao>");
                      op2 = Console.readInt();
                  }while(op2!=2);
            }else if(op==12){
                System.out.println("***********Doaçoes**********");
                Iterador x = controlador.listarDoacoesOrdenadas(true, null);
                Iterador y =controlador.listarDoacoesOrdenadas(false, null);
                while(x.temProximo()){
                    Doacao d1 = (Doacao) x.obterProximo();
                    System.out.println(" Id: " + d1.getId() + " Nome do doador: " + d1.getDoador().getNome() + " Data da doação: " + d1.getData() + " Nome do produto " + d1.getProduto().getNome());
                }
                
                while(y.temProximo()){
                    Doacao d2 = (Doacao) y.obterProximo();
                    System.out.println(" Id: " + d2.getId() + " Nome do doador: " + d2.getDoador().getNome() + " Data da doação: " + d2.getData() + " Nome do produto " + d2.getProduto().getNome());
                }
                
            }else if(op == 13){
                String numCadastro;
                System.out.println("Informe o CPF/cnpj");
                
//Código imcompleto
                
                
            }
                

        }while(op!=0);
    }
    
}
