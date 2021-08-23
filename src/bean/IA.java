package bean;

import java.util.Random;
import java.util.Scanner;

import facade.Tabuleiro;

public class IA extends Jogador {

	Scanner sc = new Scanner(System.in);

	public IA(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println("Jogador criado! (IA)");
	}

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, jogador);
	}

	@Override
	public void Tentativa(Tabuleiro tabuleiro) {
		Random rand = new Random();
		do {
			tentativa[0] = rand.nextInt(3);

			tentativa[1] = rand.nextInt(3);
		} while (!checaTentativa(tentativa, tabuleiro));
	}

}
