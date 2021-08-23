package bean;

import java.util.Scanner;

import facade.Tabuleiro;

public class Usuario extends Jogador {

	Scanner sc = new Scanner(System.in);

	public Usuario(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println("Jogador criado! (Usu�rio)");
	}

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, jogador);
	}

	@Override
	public void Tentativa(Tabuleiro tabuleiro) {
		do {
			do {
				System.out.print("Linha: ");
				tentativa[0] = sc.nextInt();

				if (tentativa[0] > 3 || tentativa[0] < 1)
					System.out.println("Linha inv�lida. � 1, 2 ou 3");

			} while (tentativa[0] > 3 || tentativa[0] < 1);

			do {
				System.out.print("Coluna: ");
				tentativa[1] = sc.nextInt();

				if (tentativa[1] > 3 || tentativa[1] < 1)
					System.out.println("Coluna inv�lida. � 1, 2 ou 3");

			} while (tentativa[1] > 3 || tentativa[1] < 1);

			tentativa[0]--;
			tentativa[1]--;

			if (!checaTentativa(tentativa, tabuleiro))
				System.out.println("Esse local j� foi marcado. Tente outro.");
		} while (!checaTentativa(tentativa, tabuleiro));
	}
}
