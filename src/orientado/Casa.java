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
    
    public boolean mark(Player p) {
        if (this.owner == null) {
            return false;
        }
        this.owner = p;
        return true;
    }
    
    public String value() {
        if (this.owner == null) {
            return "_";
        }
        return this.owner.toString();
    }
}
