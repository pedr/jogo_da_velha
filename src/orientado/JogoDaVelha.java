package orientado;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunos
 */
public class JogoDaVelha {
    
    private int size;
    private Tabuleiro tabuleiro;
    private Player pOne;
    private Player PTwo;

    public JogoDaVelha(int size, Player pOne, Player PTwo) {
        this.size = size;
        this.pOne = pOne;
        this.PTwo = PTwo;
        
        this.tabuleiro = new Tabuleiro(this.size);
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }
    
    public void printNaTela() {
        ArrayList<ArrayList<Casa>> casas = this.tabuleiro.inBlock();
        for (ArrayList<Casa> line : casas) {
            for (Casa casa : line) {
                System.out.print(casa.value() + " ");
            }
            System.out.println();
        }
    }
}
