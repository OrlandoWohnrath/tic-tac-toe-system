package facade;
import java.util.Scanner;

import bean.Jogador;

public class Jogo {
	
	 private Tabuleiro tabuleiro;
	    private int rodada=1, vez=1;
	    private Jogador jogador1;
	    private Jogador jogador2;
	    public Scanner sc = new Scanner(System.in);

	    
	    public Jogo(){
	        tabuleiro = new Tabuleiro();
	        iniciaJogadores();
	        
	        while( Jogar() );
	    }
	    
	    public void iniciaJogadores(){
	    	String nomeJ;
	        System.out.println("Quem vai ser o Jogador 1 ?\nNome:");
	        nomeJ = sc.nextLine();
	        this.jogador1 = new Jogador(1, nomeJ);
	        
	        System.out.println("----------------------");
	        System.out.println("Quem vai ser o Jogador 2 ?\nNome:");
	        nomeJ = sc.nextLine();
	        this.jogador2 = new Jogador(2, nomeJ);
	        
	        
	    }
	    
	    public boolean Jogar(){
	        if(ganhou() == 0 ){
	            System.out.println("----------------------");
	            System.out.println("\nRodada "+rodada);
	            System.out.println("É a vez do jogador " + vez() );
	            
	            if(vez()==jogador1.nome)
	                jogador1.jogar(tabuleiro);
	            else
	                jogador2.jogar(tabuleiro);
	            
	            
	            if(tabuleiro.velha()){
	                System.out.println("VELHAAA!!!");
	                return false;
	            }
	            vez++;
	            rodada++;

	            return true;
	        } else{
	            if(ganhou() == -1 )
	                System.out.println(jogador1.nome + " ganhou!");
	            else
	                System.out.println(jogador2.nome + " ganhou!");
	            
	            return false;
	        }
	            
	    }
	    
	    public String vez(){
	        if(vez%2 == 1)
	            return jogador1.nome;
	        else
	            return jogador2.nome;
	    }
	    
	    public int ganhou(){
	        if(tabuleiro.validaLinha() == 1)
	            return 1;
	        if(tabuleiro.validaColuna() == 1)
	            return 1;
	        if(tabuleiro.checaDiagonais() == 1)
	            return 1;
	        
	        if(tabuleiro.validaLinha() == -1)
	            return -1;
	        if(tabuleiro.validaColuna() == -1)
	            return -1;
	        if(tabuleiro.checaDiagonais() == -1)
	            return -1;
	        
	        return 0;
	    }
}
