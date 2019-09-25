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
    
    public boolean alguemGanhou() {
        for (int i = 0; i < this.size; i++) {
            int base = i * this.size;
            if (verificarCasas(casas.get(base), casas.get(base + 1), casas.get(base + 2))) {
                return true;
            }
        }

        for (int i = 0; i < this.size; i++) {
            if (verificarCasas(casas.get(i + this.size * 0), casas.get(i + this.size * 1), casas.get(i + this.size * 2))) {
                return true;
            }
        }
        
        if (verificarCasas(casas.get(0), casas.get(4), casas.get(8))) {
            return true;
        }
        
        
        if (verificarCasas(casas.get(2), casas.get(4), casas.get(6))) {
            return true;
        }
        
        return false;
    }
    
    private boolean verificarCasas(Casa um, Casa dois, Casa tres) {
        if (um.isFree() || dois.isFree() || tres.isFree()) {
            return false;
        }
        if (um.getOwner() == dois.getOwner() && dois.getOwner() == tres.getOwner()) {
            return true;
        }
        return false;
    }
    
    public boolean estaCheio() {
        for (Casa casa : casas) {
            if (casa.isFree()) {
                return false;
            }
        }
        return true;
    }
    
}