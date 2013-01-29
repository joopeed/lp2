package lp2.lab03;
/**
 * Aluno: Ana Luiza Motta Gomes
 * Matrícula: 112110020
 */
import java.util.Scanner;
 
/**
 * Classe que representa as movimentações de um Robô em uma sala, representada
 * por uma matriz 10x10.
 * 
 * Lab03 - 06/12/2012
 */
public class Analu {
 
    /**
         * Entry point do programa
         * 
         * @param args
         *            Não são usados nesse programa.
         */
        public static void main(String args[]) {
 
                final int SUBIR = 8;
                final int DESCER = 2;
                final int DIREITA = 6;
                final int ESQUERDA = 4;
                final int SUBIR_DIREITA=9;
                final int SUBIR_ESQUERDA=7;
                final int DESCER_DIREITA=3;
                final int DESCER_ESQUERDA=1;
                final int TURBO=5;
 
                final int TAMANHO = 10;
                final int OCUPADO = 1;
                final int LIVRE = 0;
 
                final String PROMPT = "Indique a movimentação desejada: \n"
                                + "8 (SUBIR), 2(DESCER), 4 (ESQUERDA), 6 (DIREITA), 7(SUBIR+ESQUERDA), 9(SUBIR+DIREITA), 1(DESCER+ESQUERDA), 3(DESCER+DIREITA) , 5 (TURBO) (<= 0 para sair) \n"
                                + ">> ";
 
                Scanner entrada = new Scanner(System.in);
                int sala[][] = new int[TAMANHO][TAMANHO];
                int movimento = SUBIR;
                int move=1;
                sala[0][0] = OCUPADO;
 
                while (movimento > 0) {
                        imprimeSala(sala);
 
                        System.out.print(PROMPT);
                        
                        movimento = entrada.nextInt();
 
                        switch (movimento) {
                        case SUBIR:
                                MoveCima(sala,move);
                                move=1;
                                break;
                        case DESCER:
                                MoveBaixo(sala,move);
                                move=1;
                                break;
                        case DIREITA:
                                MoveDireita(sala,move);
                                move=1;
                                break;
                        case ESQUERDA:
                                MoveEsquerda(sala,move);
                                move=1;
                                break;
                        case SUBIR_DIREITA:
                                MoveCimaDir(sala,move);
                                move=1;
                                break;
                        case SUBIR_ESQUERDA:
                                MoveCimaEsq(sala,move);
                                move=1;
                                break;
                        case DESCER_DIREITA:
                                MoveBaixoDir(sala,move);
                                move=1;
                                break;
                        case DESCER_ESQUERDA:
                                MoveBaixoEsq(sala,move);
                                move=1;
                                break;
                        case TURBO:
                                move=2;
                                System.out.println("Turbo Ativado");
                                break;
 
                }
                }
 
        }
        private static void MoveBaixoEsq(int[][] sala,int move){
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if (((i+move) <= sala.length-1) && ((j-move) >= 0)) {
                        sala[i+move][j-move]=1;
                        sala[i][j] = 0;
                        System.out.println("Robô foi pra diagonal inferior esquerda. Agora ele está na posição: [" + (i+move) + "," + (j-move) + "]");
                }else {
                        System.out.println("Movimentação não é possível");
                }
        }
        private static void MoveBaixoDir(int[][] sala,int move) {
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((i+move) <= (sala.length-1) && (j+move)<=(sala.length-1)){
                        sala[i+move][j+move]=1;
                        sala[i][j]=0;
                        System.out.println("Robô foi pra diagonal inferior direita. Agora ele está na posição: [" + (i+move) + "," + (j+move) + "]");       
                }else {
                        System.out.println("Movimentação não é possível");
                }
                
        }
        private static void MoveCimaDir(int[][] sala,int move){
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((i-move) >= 0  && (j+move)<=(sala.length-1)) {
                        sala[i-move][j+move]=1;
                        sala[i][j]=0;
                        System.out.println("Robô foi pra diagonal superior direita. Agora ele está na posição: [" + (i-move) + "," + (j+move) + "]");
                } else {
                        System.out.println("Movimentação não é possível");
                }
                
        }
        private static void MoveCimaEsq(int[][] sala,int move) {
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((i-move)>=0 && (j-move)>=0){
                        sala[i-move][j-move]=1;
                        sala[i][j]=0;
                        System.out.println("Robô foi pra diagonal superior esquerda. Agora ele está na posição: [" + (i-move) + "," + (j-move) + "]");
                }else{
                        System.out.println("Movimentação não é possível");
                }
        }
        private static void MoveCima(int[][] sala, int move) {
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((j-move) >= 0) {
                        sala[i][j-move]=1;
                        sala[i][j]=0;
                        System.out.println("Robô subiu um nível. Agora ele está na ["  + (j-move) + "," + i + "]");
                } else {
                        System.out.println("Movimentação não é possível");
                }
        }
        private static void MoveBaixo(int[][] sala, int move){
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((i+move) <= (sala.length -1)){
                        sala[i+move][j]=1;
                        sala[i][j]=0;
                        System.out.println("Robô desceu um nível. Agora ele está na posição: [" + (i+move) + "," + j + "]");
                } else {
                        System.out.println("Movimentação não é possível");
                }
        }
        private static void MoveEsquerda(int[][] sala, int move){
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((j-move) >= 0) {
                        sala[i][j-move]=1;
                        sala[i][j]=0;
                        System.out.println("Robô andou um nível para a esquerda. Agora ele está na posição: [" + i + "," + (j-move) + "]");
                }else {
                        System.out.println("Movimentação não é possível");
                }
        }
        private static void MoveDireita(int[][] sala,int move){
                int[] pos;
                int i,j;
                pos=AchaPosicao(sala);
                i=pos[0];
                j=pos[1];
                if ((j+move) <= (sala.length)-1){
                        sala[i][j+move]=1;
                        sala[i][j]=0;
                        System.out.println("Robô andou um nível para a direita. Agora ele está na posição: ["+ i + "," + (j+move) + "]");
                        
                } else {
                        System.out.println("Movimentação não é possível");
                }
        }
 
 
        
        private static int[] AchaPosicao(int sala[][]){
                int[] posi = new int[2];
                for (int i=0; i < sala.length; i++){
                        for (int j = 0; j < sala.length; j++ ){
                                if (sala[i][j] == 1){
                                         posi[0] = i;
                                         posi[1] = j;
                                        
                                }
                        }
                }
                return posi;
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
 
}
 