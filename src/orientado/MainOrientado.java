/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientado;

import java.util.Scanner;

/**
 *
 * @author Alunos
 */
public class MainOrientado {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Player playerOne = pedirPorJogador();
        Player playerTwo = pedirPorJogador();
        JogoDaVelha jogo = new JogoDaVelha(3, playerOne, playerTwo);
        
        while (true) {
            jogo.printNaTela();
            Player turnOf = jogo.proximoJogador();
            int jogada = turnOf.nextPlay();
            jogo.marcarJogada(jogada);
            Player winner = jogo.verificarSeTerminou();
            if (winner != null) {
                jogo.printNaTela();
                jogo.declararVencedor(winner);
                break;
            }
            if (jogo.empatou()) {
                jogo.printNaTela();
                System.out.println("Jogo empatado");
                break;
            }
        }
        
    }
    
    public static Player pedirPorJogador() {
        System.out.println("Escreva o nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.println("EScolha um simbolo para usar APENAS UMA LETRA");
        String symbol = scanner.nextLine();
        
        return new Player(nome, symbol.substring(0, 1));
    }
}
