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
public class Casa {
    
    private boolean isOccupied = false;
    private Player owner = null;

    public Casa() {
    }
    
    public boolean marcar(Player p) {
        if (this.isOccupied) {
            return false;
        }
        this.isOccupied = true;
        this.owner = p;
        return true;
    }
    
    public String value() {
        if (this.owner == null) {
            return "_";
        }
        return this.owner.toString();
    }
    
    public boolean isFree() {
        return !this.isOccupied;
    }
}
