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
    
    private final int size;
    private Tabuleiro tabuleiro;
    private final Player pOne;
    private final Player pTwo;
    private Player turnOf = null;

    public JogoDaVelha(int size, Player pOne, Player PTwo) {
        this.size = size;
        this.pOne = pOne;
        this.pTwo = PTwo;
        
        this.tabuleiro = new Tabuleiro(this.size);
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }
    
    public void printNaTela() {
        ArrayList<ArrayList<Casa>> casas = this.tabuleiro.inBlock();
        for (int i = 0; i < casas.size(); i++) {
            ArrayList<Casa> linha = casas.get(i);
            for (int k = 0; k < linha.size(); k++) {
                System.out.print(linha.get(k).value() + " ");
            }
            System.out.println();
        }
    }
    
    public boolean marcarJogada(int jogada) {
        if (this.tabuleiro.isFree(jogada)) {
            return this.tabuleiro.marcarJogada(jogada, this.turnOf);
        }
        return false;
    }
    
    public Player proximoJogador() {
        if (this.turnOf != this.pOne) {
            this.turnOf = this.pOne;
            return this.turnOf;
        }
        this.turnOf = this.pTwo;
        return this.turnOf;
    }
}
