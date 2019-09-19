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
public class Tabuleiro {
    
    private ArrayList<Casa> casas = new ArrayList<>();
    private int size;

    public Tabuleiro(int size) {
        this.size = size;
        for (int i = 0; i < this.size; i++) {
            for (int k = 0; k < this.size; k++) {
                this.casas.add(new Casa());
            }            
        }
    }
    
    public ArrayList<ArrayList<Casa>> inBlock() {
        ArrayList<ArrayList<Casa>> casas = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            ArrayList<Casa> casasLine = new ArrayList<>();
            for (int k = 0; k < this.size; k++) {
                casasLine.add(this.casas.get(i*this.size + k));
            }
            casas.add(casasLine);
        }
        return casas;
    }
    
    public boolean isFree(int posicao) {
        return this.casas.get(posicao).isFree();
    }
    
    public boolean marcarJogada(int posicao, Player p) {
        return this.casas.get(posicao).marcar(p);
    }
    
}
