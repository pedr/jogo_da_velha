package orientado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunos
 */
public class Player {
    
    private String name;
    private String symbol;
    private int games = 0;
    private int victories = 0;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    
    public int playsGame() {
        return ++this.games;
    }
    
    public int victoriesCount() {
        return this.victories;    
    }
    
    public int defeatsCount() {
        return this.games - this.victories;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
    
}
