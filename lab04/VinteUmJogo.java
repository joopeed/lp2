package lp2.lab04;

import java.util.Scanner;
import p1.aplic.cartas.*;

/**
 * João Pedro Leôncio, Matrícula 112110940 2012 - Ciência da Computação -
 * Federal University of Campina Grande
 */

public class VinteUmJogo {

	private static Scanner scanner = new Scanner(System.in);
	private static Mao maoJogador;
	private static Mao maoMesa;
	private static Baralho baralho;
	private static int valorMaoMesa;
	private static int valorMaoJogador;
	private final static String nL = System.getProperty("line.separator");
	private final static String relatorioParcial = "Mão do Jogador: %s" + nL
			+ "Pontuação do Jogador: %d" + nL + "Número de cartas da mesa: %d"
			+ nL;
	private final static String relatorioFinal = nL + "Fim de Partida." + nL
			+ "Cartas do Jogador: %s" + nL + "Cartas da Mesa: %s" + nL
			+ "Valor da mão do Jogador: %d" + nL + "Valor da Mesa: %d" + nL
			+ "Deseja iniciar outra partida? Responda sim ou nao" + nL + nL;

	public static void main(String[] args) {

		baralho = new Baralho();
		baralho.baralhar();
		while (true) {
			if (partida())
				break;
		}
	}

	private static boolean partida() {

		boolean entre = true;
		maoJogador = new Mao();
		maoMesa = new Mao();
		boolean jogadorQuerCarta = true;
		boolean mesaQuerCarta = true;
		System.out.printf("Nova Partida. Há %d cartas restantes no baralho"
				+ nL, baralho.númeroDeCartas());
		valorMaoMesa = valorDaMao(maoMesa);
		valorMaoJogador = valorDaMao(maoJogador);
		if (verificaFimDeJogo(valorMaoJogador, valorMaoMesa, mesaQuerCarta,
				jogadorQuerCarta))
			entre = false;
		adicionaCarta(maoJogador, jogadorQuerCarta);
		if (verificaFimDeJogo(valorMaoJogador, valorMaoMesa, mesaQuerCarta,
				jogadorQuerCarta))
			entre = false;
		adicionaCarta(maoMesa, mesaQuerCarta);

		while (entre) {
			valorMaoMesa = valorDaMao(maoMesa);
			valorMaoJogador = valorDaMao(maoJogador);

			System.out.printf(relatorioParcial, maoJogador, valorMaoJogador,
					maoMesa.númeroDeCartas());

			if (verificaFimDeJogo(valorMaoJogador, valorMaoMesa, mesaQuerCarta,
					jogadorQuerCarta))
				break;
			if (jogadorQuerCarta) {
				System.out.println("Deseja pegar uma carta? sim ou nao");
				jogadorQuerCarta = !lerCompara("sim");
				adicionaCarta(maoJogador, jogadorQuerCarta);
			}

			if (verificaFimDeJogo(valorMaoJogador, valorMaoMesa, mesaQuerCarta,
					jogadorQuerCarta))
				break;
			if (valorMaoMesa < 17) {
				adicionaCarta(maoMesa, mesaQuerCarta);
			} else
				mesaQuerCarta = false;

		}

		System.out.printf(relatorioFinal, maoJogador, maoMesa, valorMaoJogador,
				valorMaoMesa);
		if (lerCompara("sim"))
			return true;
		return false;

	}

	private static boolean lerCompara(String aComparar) {
		return !scanner.nextLine().equalsIgnoreCase(aComparar);
	}

	private static int valorDaMao(Mao mao) {
		int soma = 0, valorAtual = 0;
		for (int i = 0; i < mao.númeroDeCartas(); i++) {
			valorAtual = mao.cartaEm(i).getValor();
			if (valorAtual > 10)
				soma += 10;
			else
				soma += valorAtual;
		}
		return soma;
	}

	private static void adicionaCarta(Mao mao, boolean maoAindaQuerJogar) {
		if (maoAindaQuerJogar)
			mao.adicionar(baralho.pegaCarta());
	}

	private static boolean verificaFimDeJogo(int valorMaoJogador,
			int valorMaoMesa, boolean mesaQuerCarta, boolean jogadorQuerCarta) {
		if (valorMaoJogador == 21) { //
			System.out.println("Jogador Venceu!");
			return true;
		} else if (valorMaoMesa == 21) {
			System.out.println("Mesa Venceu!");
			return true;
		} else if (valorMaoJogador > 21) {
			System.out.println("Jogador Estourou, Mesa Venceu!");
			return true;
		} else if (valorMaoMesa > 21) { //
			System.out.println("Mesa Estourou, Jogador Venceu!");
			return true;
		} else if (!mesaQuerCarta && !jogadorQuerCarta) {
			if (valorMaoJogador > valorMaoMesa)
				System.out.println("Jogador ganhou!"); //
			else if (valorMaoJogador < valorMaoMesa)
				System.out.println("Mesa ganhou!");
			else
				System.out.println("Empate! Mesa ganhou!");
			return true;
		} else if (baralho.númeroDeCartas() == 0) {
			System.out.print("Baralho Acabou. ");
			if (valorMaoJogador > valorMaoMesa)
				System.out.println("Jogador ganhou!"); //
			else if (valorMaoJogador < valorMaoMesa)
				System.out.println("Mesa ganhou!");
			else
				System.out.println("Empate! Mesa ganhou!");
			baralho = new Baralho();
			baralho.baralhar();
			return true;
		}
		return false;
	}

}
