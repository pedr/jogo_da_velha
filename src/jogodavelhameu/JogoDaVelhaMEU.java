package jogodavelhameu;

import java.util.Scanner;

public class JogoDaVelhaMEU {

    public static void main(String[] args) {
        int[][] tabuleiro = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        String[][] tabuleiroDePosicoes = {
            {"0", "1", "2"},
            {"3", "4", "5"},
            {"6", "7", "8"}
        };
        Scanner scan = new Scanner(System.in);

        int vezDoJogadorNumero = 1;
        String[] simbolos = {"_", "X", "O"};

        System.out.println("Escolha um símbolo digitando O NUMERO QUE ELE REPRESENTA:");
        System.out.println("\t1: " + simbolos[1]);
        System.out.println("\t2: " + simbolos[2]);

        int opc = scan.nextInt();
        if (opc == 2) {
            String s = simbolos[1];
            simbolos[1] = simbolos[2];
            simbolos[2] = s;
        }

        while (true) {
            System.out.println("Vez do jogador " + simbolos[vezDoJogadorNumero]);

            tabuleiroDePosicoes = criaTabuleiroParaPrintar(tabuleiro, tabuleiroDePosicoes, simbolos);
            imprimeTabuleiro(tabuleiroDePosicoes);

            int x, y;
            while (true) {
                System.out.println("Entre uma posição conforme a tabela da esquerda");
                int pos = scan.nextInt();

                int[] coordenadas = transformaPosicaoEmCoordenada(tabuleiro, pos);
                x = coordenadas[0];
                y = coordenadas[1];

                if (verificaEntrada(tabuleiro, x, y)) {
                    break;
                }
                System.out.println("Valor invalido, por favor repita");
            }

            tabuleiro[x][y] = vezDoJogadorNumero;

            if (validaLinhaEColuna(tabuleiro) || validaDiagonal(tabuleiro)) {
                System.out.println("Prabens o jogador " + simbolos[vezDoJogadorNumero] + " venceu");
                break;
            }

            if (verificaSeDeuVelha(tabuleiro)) {
                System.out.println("DEU VELHA, NÃO HÁ MAIS JOGADAS, VOCẼS PERDERAM");
                break;
            }

            if (vezDoJogadorNumero == 1) {
                vezDoJogadorNumero = 2;
            } else {
                vezDoJogadorNumero = 1;
            }
            System.out.println("\n\n\n");
        }
        tabuleiroDePosicoes = criaTabuleiroParaPrintar(tabuleiro, tabuleiroDePosicoes, simbolos);
        imprimeTabuleiro(tabuleiroDePosicoes);

    }

    public static String[][] criaTabuleiroParaPrintar(int[][] tabuleiro, String[][] tabuleiroDePosicoes, String[] simbolos) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int k = 0; k < tabuleiro.length; k++) {
                if (tabuleiro[i][k] == 0) {
                    tabuleiroDePosicoes[i][k] = simbolos[0];
                }
                if (tabuleiro[i][k] == 1) {
                    tabuleiroDePosicoes[i][k] = simbolos[1];
                }
                if (tabuleiro[i][k] == 2) {
                    tabuleiroDePosicoes[i][k] = simbolos[2];
                }
            }
        }

        return tabuleiroDePosicoes;
    }

    public static void imprimeTabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int k = 0; k < (tabuleiro.length * 2); k++) {
                // printa as posições
                if (k < 3) {
                    System.out.print((i * 3 + k) + " ");
                }

                // printa o jogo
                if (k == 3) {
                    System.out.print("  ");
                }
                if (k >= tabuleiro.length) {
                    System.out.print(tabuleiro[i][k % 3] + " ");
                }
            }
            System.out.println("\n");
        }
    }

    public static int[] transformaPosicaoEmCoordenada(int[][] tabuleiro, int pos) {
        int linha = pos / 3;
        int col = pos % 3;
        int[] coordenadas = {linha, col};
        return coordenadas;
    }

    public static boolean verificaEntrada(int[][] tabuleiro, int x, int y) {
        if (x < 0 || x >= tabuleiro.length) {
            return false;
        }
        if (y < 0 || y >= tabuleiro.length) {
            return false;
        }
        if (tabuleiro[x][y] > 0) {
            return false;
        }
        return true;
    }

    public static boolean valida(int x, int y, int z) {
        if (x == y && y == z && ((x + y + z) > 0)) {
            return true;
        }
        return false;
    }

    public static boolean validaLinhaEColuna(int[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {

            if (valida(tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2])) {
                return true;
            }

            if (valida(tabuleiro[0][i], tabuleiro[1][i], tabuleiro[2][i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean validaDiagonal(int[][] tabuleiro) {
        if (valida(tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2])) {
            return true;
        }

        if (valida(tabuleiro[0][2], tabuleiro[1][1], tabuleiro[2][0])) {
            return true;
        }

        return false;
    }

    public static boolean verificaSeDeuVelha(int[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int k = 0; k < tabuleiro.length; k++) {
                if (tabuleiro[i][k] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
