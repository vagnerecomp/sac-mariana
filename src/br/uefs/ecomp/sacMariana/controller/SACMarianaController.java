package br.uefs.ecomp.sacMariana.controller;

import br.uefs.ecomp.sacMariana.model.Doacao;
import br.uefs.ecomp.sacMariana.model.Doador;
import br.uefs.ecomp.sacMariana.model.Produto;
import br.uefs.ecomp.sacMariana.util.Iterador;
import br.uefs.ecomp.sacMariana.util.lista;
import java.util.Date;

public class SACMarianaController {
    //Todas as listas usadas no programa estão aqui.
        lista listProduto = new lista();
        lista listDoacao = new lista();
        lista listDoador = new lista();
        lista listDoacao2 = new lista();
        lista listDoacaoMonetaria = new lista();
        lista listDoacaoMonetaria2 = new lista();
        lista listDoacaoN_Monetaria = new lista();
        lista listDoacaoN_Monetaria2 = new lista();
        lista listDoacaoN_Monetaria2doador = new lista();
        lista listDoacaoMonetaria2doador = new lista();
        static int geraId;
        static int geraIdDoador;
        static int geraIdDoacao;
        

	public SACMarianaController(){
	
	}
        
//Método que cadastra novos produtos
	public Produto cadastrarProduto(String nome, String tipo, Date dt_criacao) {
            
            Produto p1 = new Produto();
            p1.setNome(nome);
            p1.setTipo(tipo);
            p1.setDataCadastro(dt_criacao);
            p1.setId(geraId);
            listProduto.inserirInicio(p1);
            geraId++;
            
            
        return p1;
        }
        
//Método usado para alterar as informações dos produtos        
	public Produto editarProduto(Integer idProduto, String nome, String tipo, Date dt_criacao) {
           
            Iterador x = listProduto.iterador();

            while(x.temProximo()){
                Produto p = (Produto) x.obterProximo();
                if( p.getId() == idProduto){
                    p.setNome(nome);
                    p.setTipo(tipo);
                    p.setDataCadastro(dt_criacao);
                    return p;
                }
            }

        return null;
        }
        
//Metodo que retorna todos os produtos cadastrados na lista        
	public Iterador listarProdutos() {
            Iterador x = listProduto.iterador();
		return x;
        }
        
//Metodo para remover um produto atravez do seu ID        
	public boolean removerProduto(Integer idProduto) {
            Iterador p1 = listDoacao.iterador();
            while(p1.temProximo()){
                //Esse trecho de código verifica se o produto foi cadastrado na lista de doaçoes
                Doacao d = (Doacao) p1.obterProximo(); 
                if(d.getProduto().getId() == idProduto){
                    return false;
                }
            }
            Iterador x = listProduto.iterador();
            int i = 0;
            while(x.temProximo()){
                Produto p = (Produto) x.obterProximo();
                if(idProduto == p.getId()){
                    listProduto.remover(i);
                }
                i++;
            }

        return true;
        }

//Esse método insere um nomvo doador na lista        
	public Doador cadastrarDoador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) {
            Iterador x = listDoador.iterador();
            while(x.temProximo()){
                Doador d = (Doador) x.obterProximo();
                if( d.getNumCadastro().equals(numCadastro)){
                    return null;
                }
            }
            //O Id é gerado atravez da chamada do metodo incrementando a variável estática.
            Doador d1 = new Doador();
            d1.setNumCadastro(numCadastro);
            d1.setNome(nome);
            d1.setDataNasc(dt_nascimento); //Depende da digitação correta dos dados, senão gera um erro
            d1.setTipo(tipo);
            d1.setRua(rua);
            d1.setNumero(numero);
            d1.setBairro(bairro);
            d1.setCep(cep);
            d1.setCidade(cidade);
            d1.setUf(uf);
            d1.setPais(pais);
            d1.setId(geraIdDoador);
            listDoador.inserirInicio(d1);
            geraIdDoador++;
        return d1;
        }
        
//Permite alterar os dados do doados buscando pelo número de cadastro        
	public Doador editarDoador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) {
            Iterador x = listDoador.iterador();

            while(x.temProximo()){
                Doador d1 = (Doador) x.obterProximo();
                if(d1.getNumCadastro().equals(numCadastro)){
                    d1.setNumCadastro(numCadastro);
                    d1.setNome(nome);
                    d1.setDataNasc(dt_nascimento);
                    d1.setRua(rua);
                    d1.setNumero(numero);
                    d1.setBairro(bairro);
                    d1.setCep(cep);
                    d1.setCidade(cidade);
                    d1.setUf(uf);
                    d1.setPais(pais);
                    return d1;
                }
            }
        return null;
        }
        
        
        
	//Retorna o doador que possui o numero de cadastro pesquisado.
        //Metodo essencial no momento  de efetuar doações.
	public Doador obterDoador(String numCadastro) {
            Iterador x = listDoador.iterador();
            while(x.temProximo()){
                Doador d1 = (Doador) x.obterProximo();
                //Comparando tipo referência com o metodo equals da object.
                if(d1.getNumCadastro().equals(numCadastro)){

                    return d1;
                }
            }
            return null;
	}
	public boolean removerDoador(String numCadastro) {
            Iterador x = listDoador.iterador();
            while(x.temProximo()){
                Doador d1 = (Doador) x.obterProximo();
                int i = 0;
                if(d1.getNumCadastro().equals(numCadastro)){
                    listDoador.remover(i);
                    
                }
                i++;
            }

        return true;
        }
        
        //Retorna o iterador com os valores da lista de doadores para listar na classe principal.
	public Iterador listarDoadores() {
            Iterador x = listDoador.iterador();
		return x;
        }
        
 //Recebe as informaçoes ddas novas doações e insere na lista.       
	public Doacao efetuarDoacao(Doador doador, Produto produto, Number quantidade, Date dt_doacao){
            Doacao d1 = new Doacao();
                d1.setDoador(doador);
                d1.setProduto(produto);
                d1.setId(geraIdDoacao);
                d1.setQtd(quantidade);
                d1.setData(dt_doacao);
                geraIdDoacao++; //Incrementando o ID;
                listDoacao.inserirInicio(d1);
                
                
                //Os objetos da lista produto possuem o atributo tipo. 
                //Essencial para separar os tipos de produtos doados.
                if (d1.getProduto().getTipo().equals("Monetária")){
                    listDoacaoMonetaria.inserirInicio(d1);
                }else{
                    listDoacaoN_Monetaria.inserirInicio(d1);
                }
		return d1;
	}
	
        
//Altera a doação atravez do ID.        
	public Doacao alterarDoacao(Integer idDoacao, Doador doador, Produto produto, Number quantidade, Date dt_doacao){
            Iterador x = listDoacao.iterador();
            while(x.temProximo()){
                Doacao d1 = (Doacao) x.obterProximo();
                if(d1.getId() == idDoacao){
                    d1.setDoador(doador);
                    d1.setProduto(produto);
                    d1.setQtd(quantidade);
                    d1.setData(dt_doacao);
                    
                    return d1;
                }
                
            }
            
		return null;
	}
	
	public boolean removerDoacao(int idDoacao){
            Iterador x = listDoacao.iterador();
            int i = 0;
            while(x.temProximo()){
                Doacao d = (Doacao) x.obterProximo();
                if(idDoacao == d.getId()){
                    listDoacao.remover(i);
                }
                i++;
            }
		return true;
	}
        
        //Ordena as listas monetarias e não monetaria em ordem decrescente do valor
	public Iterador listarDoacoesOrdenadas(boolean monetario, Doador doador){
            if(doador == null){
                    //Iterador itera = listDoador.iterador();
                    if(monetario){
                        int tam = listDoacaoMonetaria.obterTamanho(), pos=0;
                        Doacao d = new Doacao();
                        while(tam > 0)
                        {
                            for(int x=0;x<tam;x++)
                            {
                                    Doacao d2 = (Doacao)listDoacaoMonetaria.recuperar(x);
                                    if(d==null){
                                            d=d2;
                                            pos=x;
                                    }	
                                    else{
                                            if(d2.getQtd().doubleValue() >= d.getQtd().doubleValue()){
                                            d=d2;
                                            pos=x;
                                            }
                                         }
                            }
                        listDoacaoMonetaria2.inserirFinal(d);
                        listDoacaoMonetaria.remover(pos);
                        tam--;
                        }
                        Iterador x = listDoacaoMonetaria2.iterador();
                        return x; //Retorna a lista de doações monetarias ordenada.
                    }else{
                        int tam = listDoacaoN_Monetaria.obterTamanho(), pos=0;
                        Doacao d = new Doacao();
                        d.setQtd(0);
                        while(tam > 0)
                        {
                            for(int x=0;x<tam;x++)
                            {
                                    Doacao d2 = (Doacao)listDoacaoN_Monetaria.recuperar(x);
                                    if(d==null){
                                            d=d2;
                                            pos=x;
                                    }	
                                    else{
                                            if(d2.getQtd().intValue() >= d.getQtd().intValue()){
                                            d=d2;
                                            pos=x;
                                            }
                                         }
                            }
                        listDoacaoN_Monetaria2.inserirFinal(d);
                        listDoacaoN_Monetaria.remover(pos);
                        tam--;
                        }
                        Iterador x = listDoacaoN_Monetaria2.iterador();
                        return x; //Retorna a lista de doações não monetária ordenada

                    }
            }else{
                    //Iterador itera = listDoador.iterador();
                    if(monetario){
                        int tam = listDoacaoMonetaria.obterTamanho(), pos=0;
                        Doacao d = new Doacao();
                        while(tam > 0)
                        {
                            for(int x=0;x<tam;x++)
                            {
                                    Doacao d2 = (Doacao)listDoacaoMonetaria.recuperar(x);
                                    if(d==null){
                                            d=d2;
                                            pos=x;
                                    }	
                                    else{
                                            if(d2.getQtd().doubleValue() >= d.getQtd().doubleValue()){
                                            d=d2;
                                            pos=x;
                                            }
                                         }
                            }
                        if(d.getDoador().equals(doador)){    
                        listDoacaoMonetaria2doador.inserirFinal(d);
                        listDoacaoMonetaria.remover(pos);
                        tam--;
                        }
                        }
                        Iterador x = listDoacaoMonetaria2doador.iterador();
                        return x; //retorna a lista monetaria ordenada por doador
                    }else{
                        int tam = listDoacaoN_Monetaria.obterTamanho(), pos=0;
                        Doacao d = new Doacao();
                        d.setQtd(0);
                        while(tam > 0)
                        {
                            for(int x=0;x<tam;x++)
                            {
                                    Doacao d2 = (Doacao)listDoacaoN_Monetaria.recuperar(x);
                                    if(d==null){
                                            d=d2;
                                            pos=x;
                                    }	
                                    else{
                                            if(d2.getQtd().intValue() >= d.getQtd().intValue()){
                                            d=d2;
                                            pos=x;
                                            }
                                         }
                            }
                        if(d.getDoador().equals(doador)){
                        listDoacaoN_Monetaria2doador.inserirFinal(d);
                        listDoacaoN_Monetaria.remover(pos);
                        tam--;
                        }
                        }
                        Iterador x = listDoacaoN_Monetaria2doador.iterador();
                        return x; //retorna a lista não monetaria ordenada por doador
                
            }
            
	}}
	
	//public void calcularPercentualDoadores(){
	  //      Iterador x = listDoacao.iterador();
                
	//}
        
}