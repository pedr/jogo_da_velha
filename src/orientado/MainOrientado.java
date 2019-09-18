/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientado;

/**
 *
 * @author Alunos
 */
public class MainOrientado {
    
    public static void main(String[] args) {
        Player pedro = new Player("Pedro", "X");
        Player manu = new Player("Manu", "O");
        
        JogoDaVelha jogo = new JogoDaVelha(3, pedro, manu);
        jogo.printNaTela();
    }
}
