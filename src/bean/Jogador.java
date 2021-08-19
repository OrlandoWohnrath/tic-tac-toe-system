package bean;
import java.util.Scanner;

import facade.Tabuleiro;

public class Jogador{

	 public Scanner sc = new Scanner(System.in);
	 	
	 private int[] tentativa = new int[2];
	    private int jogador;
	    public String nome;

	    
	    public Jogador(int jogador, String nome){
	        super();
	        this.jogador = jogador;
	        this.nome = nome;
	        System.out.println("Jogador " + nome + " criado!");
	    }
	    
	    public void jogar(Tabuleiro tabuleiro){
	        Tentativa(tabuleiro);
	        tabuleiro.setPosicao(tentativa, jogador);
	    }
	    
	    public void Tentativa(Tabuleiro tabuleiro){
	        do{
	            do{
	                System.out.print("Linha: ");
	                tentativa[0] = sc.nextInt();
	                
	                if( tentativa[0] > 3 ||tentativa[0] < 1)
	                    System.out.println("Linha inválida. É 1, 2 ou 3");
	                
	            }while( tentativa[0] > 3 ||tentativa[0] < 1);
	            
	            do{
	                System.out.print("Coluna: ");
	                tentativa[1] = sc.nextInt();
	                
	                if(tentativa[1] > 3 ||tentativa[1] < 1)
	                    System.out.println("Coluna inválida. É 1, 2 ou 3");
	                
	            }while(tentativa[1] > 3 ||tentativa[1] < 1);
	            
	            tentativa[0]--; 
	            tentativa[1]--;
	            
	            if(!checaTentativa(tentativa, tabuleiro))
	                System.out.println("Esse local já foi marcado. Tente outro.");
	        }while( !checaTentativa(tentativa, tabuleiro) );
	    }
	    
	    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){
	        if(tabuleiro.getPosicao(tentativa) == 0)
	            return true;
	        else
	            return false;
	            
	    }

}
