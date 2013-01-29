package lp2.lab03;

// Fellype Cavalcante //

import java.util.Scanner;

public class Fellyps {
	public static void main(String args[]) {

		final int SUBIR = 8;
		final int DESCER = 2;
		final int DIREITA = 6;
		final int ESQUERDA = 4;
		final int SUBIRDIREITA = 9;
		final int SUBIRESQUERDA = 7;
		final int DESCERDIREITA = 3;
		final int DESCERESQUERDA = 1;
		final int TURBO = 5;

		final int TAMANHO = 10;
		final int OCUPADO = 1;
		final int LIVRE = 0;

		final String PROMPT = "Indique a movimentação desejada: \n"
				+ "8 (SUBIR), 2(DESCER), 6 (DIREITA), 4 (ESQUERDA), 7 (SUBIR+ESQUERDA), 9 (SUBIR+DIREITA)"
				+ "\n1 (DESCER+ESQUERDA), 3 (DESCER+DIREITA), 5 (TURBO) (<= 0 para sair) \n"
				+ ">> ";

		Scanner entrada = new Scanner(System.in);
		int sala[][] = new int[TAMANHO][TAMANHO];
		int movimento = SUBIR;

		sala[0][0] = OCUPADO;
		int n;

		while (movimento > 0) {
			imprimeSala(sala);

			System.out.print(PROMPT);
			
			int[] posicaoRobo = new int[2];
			posicaoRobo = localizaRobo(sala);
			
			int lin = posicaoRobo[0];
			int col = posicaoRobo[1];

			n = 1;

			movimento = entrada.nextInt();
			if (movimento == TURBO) {
				n = turbo();
				movimento = entrada.nextInt();
			}

			switch (movimento) {
			case SUBIR:
				if (verificaMovimento(lin-n, col, "subiu", n, "" )){
					moveCima(lin, col, sala, n);
				}                       
				break;
				
			case DESCER:
				if (verificaMovimento(lin+n, col, "desceu", n, "")){
                    moveBaixo(lin, col, sala, n);
                 }
				break;
				
			case DIREITA:
				if (verificaMovimento(lin, col+n, "andou", n, "para a direita")){
                    moveDireita(lin, col, sala, n);
                }
				break;

			case ESQUERDA:
                if (verificaMovimento(lin, col-n, "andou", n , "para a esquerda")){
                    moveEsquerda(lin, col, sala, n);
                }
                break;
				
                case SUBIRESQUERDA:
                    if (verificaMovimento(lin-n, col-n, "andou", n,  "para a diagonal superior esquerda")){
                         moveCima(lin, col, sala, n);
                         moveEsquerda(lin-n, col, sala, n);
                    }
                break;
					
                case SUBIRDIREITA:
                       if (verificaMovimento(lin-n, col+n, "andou", n,  "para a diagonal superior direita")){
							moveCima(lin, col, sala, n);
							moveDireita(lin-n, col, sala, n);
						}                               
				break;
				
				case DESCERESQUERDA:
					if (verificaMovimento(lin+n, col-n, "andou", n,  "para a diagonal inferior esquerda")){
						moveBaixo(lin, col, sala, n);
						moveEsquerda(lin+n, col, sala, n);
					}
				break;
                case DESCERDIREITA:
                    if (verificaMovimento(lin+n, col+n, "andou", n, "para a diagonal inferior direita")){
                        moveBaixo(lin, col, sala, n);
                         moveDireita(lin+n, col, sala, n);
                     }
                break;
			}
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

	private static int[] localizaRobo(int[][] sala) {

		int posicao[] = new int[2];

		for (int i = 0; i < sala.length; i++) {
			for (int j = 0; j < sala.length; j++) {

				if (sala[i][j] == 1) {
					posicao[0] = i;
					posicao[1] = j;
				}
			}
		}
		return posicao;
	}
	
	// Movimentos //
	
	private static boolean verificaMovimento(int lin, int col, String frase, int n, String frase2) {

		if (lin < 0 || col < 0 || lin > 9 || col > 9) {
			System.out.println("Movimentação não é possível.");
			return false;
		}
		
		String valor = ((n == 1?"um nível":"dois níveis"));
		System.out.printf("Robô %s %s %s. Agora ele está na posição: [%d,%d]\n", frase, valor, frase2, lin, col);
		return true;
	}

	private static void moveCima(int lin, int col, int[][] sala, int n){
                sala[lin][col] = 0;
                sala[lin-n][col] = 1;
        }
     private static void moveBaixo(int lin, int col, int[][] sala, int n){
                sala[lin][col] = 0;
                sala[lin+n][col] = 1;
        }
	private static void moveDireita(int lin, int col, int[][] sala, int n){
         sala[lin][col] = 0;
         sala[lin][col+n] = 1;
    }
     private static void moveEsquerda(int lin, int col, int[][] sala, int n){
                sala[lin][col] = 0;
                sala[lin][col-n] = 1;
        }
        
        private static int turbo(){
                System.out.println("Turbo Ativado.");
                return 2;
        }
 
}