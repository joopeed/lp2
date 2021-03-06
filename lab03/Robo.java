package lp2.lab03;

import java.util.Scanner;

/**
 * Classe que representa as movimentações de um Robô em uma sala, representada
 * por uma matriz 10x10.
 * 
 * Lab03 - 06/12/2012
 * Aluno: João Pedro Ferreira de Melo Leôncio 
 * Matrícula : 112110940
 */
public class Robo {

	/**
	 * Entry point do programa
	 * 
	 * @param args
	 *            Não são usados nesse programa.
	 */
	final static int OCUPADO = 1;
	final static int LIVRE = 0;
	
	public static void main(String args[]) {

		final int SUBIR = 8;
		final int DESCER = 2;
		final int DIREITA = 6;
		final int ESQUERDA = 4;
		final int SUBIR_DIREITA = 9;
		final int SUBIR_ESQUERDA = 7;
		final int DESCER_ESQUERDA = 1;
		final int DESCER_DIREITA = 3;
		final int TURBO = 5;
		final int TAMANHO = 10;
		

		final String PROMPT = "Indique a movimentação desejada: \n"
				+ "1 (DESCER+ESQUERDA), 2 (DESCER), 3 (DESCER+DIREITA)  \n"
				+ "4 (ESQUERDA), 6 (DIREITA), 5 (TURBO), \n" 
				+ "7 (SUBIR+ESQUERDA), 8 (SUBIR), 9 (SUBIR+DIREITA) (<= 0 para sair) \n"
				+ ">> ";

		Scanner entrada = new Scanner(System.in);
		
		int sala[][] = new int[TAMANHO][TAMANHO];
		int movimento = SUBIR;
		int x = 0;
		int y = 0;
		sala[x][y] = OCUPADO;
		int[] posicao = {x,y};
		
		
		boolean andou;
		int passos=1;
		String niveis = "um nível";

		while (movimento > 0) {
			imprimeSala(sala);

			System.out.print(PROMPT);
			
			movimento = entrada.nextInt();
			andou = false;
			if (passos==1) niveis = "um nível";
			
			switch (movimento) {
			case SUBIR:
				andou = paraCima(x,y, sala,passos);
				if (andou) System.out.print("Robô subiu "+niveis+".");
				break;
			case DESCER:
				andou = paraBaixo(x,y, sala,passos);
				if (andou) System.out.print("Robô desceu "+niveis+".");
				break;
			case DIREITA:
				andou = paraDireita(x,y, sala,passos);
				if (andou) System.out.print("Robô andou "+niveis+" para a direita.");
				break;
			case ESQUERDA:
				andou = paraEsquerda(x,y, sala,passos);
				if (andou) System.out.print("Robô andou "+niveis+" para a esquerda.");
				break;
			case DESCER_ESQUERDA:
				andou = paraBaixo(x,y, sala,passos);
				if (andou) {
					andou = paraEsquerda(x+passos,y, sala,passos);
					if (andou) System.out.print("Robô andou "+niveis+" para a esquerda e para baixo.");
					else paraCima(x+passos,y, sala,passos);
				}
				break;
			case DESCER_DIREITA:
				andou = paraBaixo(x,y, sala,passos);
				if (andou) {
					andou = paraDireita(x+passos,y, sala,passos);
					if (andou) System.out.print("Robô andou "+niveis+" para a direita e para baixo.");
					else paraCima(x+passos,y, sala,passos);
				}
				break;
			case SUBIR_ESQUERDA:
				andou = paraCima(x,y, sala,passos);
				if (andou) {
					andou = paraEsquerda(x-passos,y, sala,passos);
					if (andou) System.out.print("Robô andou "+niveis+" para a esquerda e para cima.");
					else paraBaixo(x-passos,y, sala,passos);
				}
				break;
			case SUBIR_DIREITA:
				andou = paraCima(x,y, sala,passos);
				if (andou) {
					andou = paraDireita(x-passos,y, sala,passos);
					if (andou) System.out.print("Robô andou "+niveis+" para a direita e para cima.");
					else paraBaixo(x-passos,y, sala,passos);
				}
				break;
			case TURBO:
				passos = 3;
				niveis = "dois niveis";
				break;
			}
			
			if (passos>1) passos--;
			posicao = pegaPosicao(sala);
			x = posicao[0];
			y = posicao[1];	
			
			if (andou) System.out.printf("Agora ele está na posição: [%d,%d]\n",x,y);
			else if (passos==1) System.err.println("Movimentação não é possível");
			else System.out.println("Turbo ativado.");
			
		}

	}
	
	private static void imprimeSala(int[][] sala) {
		StringBuilder sb = new StringBuilder('-');
		
		for (int i = 0; i < sala.length; i++) {
			sb.append("--");
		}
		
		sb.append("\n");
		
		for (int linha = 0; linha < sala.length; linha++) {
			sb.append('|');
			for (int coluna = 0; coluna < sala.length; coluna++) {
				sb.append("" + sala[linha][coluna] + "|");
			}
			sb.append("\n-");
			for (int i = 0; i < sala.length; i++) {
				sb.append("--");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	
	private static int[] pegaPosicao(int[][] sala){
		int [] retorno = new int[2];
		for(int i=0;i<sala.length;i++){
			for(int j=0;j<sala[i].length;j++){
				if (sala[i][j] == OCUPADO){
					retorno[0] = i;
					retorno[1] = j;
					break;
				}
			}
		}
		return retorno;
	}	
	
	
	private static boolean paraCima(int x, int y, int[][] sala, int passos){
		if(x-passos >=0) {
			sala[x][y]=LIVRE;
			sala[x-passos][y]=OCUPADO;
			return true;
		} else return false;
	}
	
	private static boolean paraBaixo(int x, int y, int[][] sala, int passos){
		if(x+passos < sala.length) {
			sala[x][y]=LIVRE;
			sala[x+passos][y]=OCUPADO;
			return true;
		} else return false;
	}
	
	private static boolean paraDireita(int x, int y, int[][] sala, int passos){
		if(y+passos < sala[y].length) {
			sala[x][y]=LIVRE;
			sala[x][y+passos]=OCUPADO;
			return true;
		} else return false;				
	}
	
	private static boolean paraEsquerda(int x, int y, int[][] sala, int passos){
		if(y-passos >= 0) {
			sala[x][y]=LIVRE;
			sala[x][y-passos]=OCUPADO;
			return true;
		} else return false;			
	}
}
