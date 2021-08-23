package facade;

import java.util.Scanner;

import bean.IA;
import bean.Jogador;
import bean.Usuario;

public class Jogo {

	private Tabuleiro tabuleiro;
	private int rodada = 1, vez = 1;
	private Jogador jogador1;
	private Jogador jogador2;
	public Scanner sc = new Scanner(System.in);

	public Jogo() {
		tabuleiro = new Tabuleiro();
		iniciaJogadores();

		while (Jogar())
			;
	}

	public void iniciaJogadores(){
        System.out.println("Quem vai ser o Jogador 1 ?");
        if(escolherJogador() == 1)
            this.jogador1 = new Usuario(1);
        else
            this.jogador1 = new IA(1);
        
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");
        
        if(escolherJogador() == 1)
            this.jogador2 = new Usuario(2);
        else
            this.jogador2 = new IA(2);
        
    }

	public int escolherJogador() {
		int opcao = 0;

		do {
			System.out.println("1. Usuário");
			System.out.println("2. IA\n");
			System.out.print("Opção: ");
			opcao = sc.nextInt();

			if (opcao != 1 && opcao != 2)
				System.out.println("Opção inválida! Tente novamente");
		} while (opcao != 1 && opcao != 2);

		return opcao;
	}

	public boolean Jogar() {
		if (ganhou() == 0) {
			System.out.println("----------------------");
			System.out.println("\nRodada " + rodada);
			System.out.println("É a vez do jogador " + vez());

			if (vez() == 1)
				jogador1.jogar(tabuleiro);
			else
				jogador2.jogar(tabuleiro);

			if (tabuleiro.velha() && ganhou() == 0) {
				System.out.println("VELHAAA!!!");
				return false;
			}
			vez++;
			rodada++;

			return true;
		} else {
			if (ganhou() == -1)
				System.out.println("Jogador 1 ganhou!");
			else
				System.out.println("Jogador 2 ganhou!");

			return false;
		}

	}

	public int vez() {
		if (vez % 2 == 1)
			return 1;
		else
			return 2;
	}

	public int ganhou() {
		if (tabuleiro.validaLinha() == 1)
			return 1;
		if (tabuleiro.validaColuna() == 1)
			return 1;
		if (tabuleiro.checaDiagonais() == 1)
			return 1;

		if (tabuleiro.validaLinha() == -1)
			return -1;
		if (tabuleiro.validaColuna() == -1)
			return -1;
		if (tabuleiro.checaDiagonais() == -1)
			return -1;

		return 0;
	}
}
