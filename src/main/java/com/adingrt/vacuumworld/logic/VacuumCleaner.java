package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.exceptions.InvalidPositionException;

/**
 * @author Adin Rubio
 */
public class VacuumCleaner<E> {
    private String id;
    private Coordinates currentPosition;
    
    public VacuumCleaner() {
    }

    public VacuumCleaner(String id, Coordinates currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }
    
    public void suckdirt(E[][] room) {
        room[this.currentPosition.getX()][this.currentPosition.getY()] = null;
    }
    
    public void move(E[][] world, char direction) {
        int x = this.currentPosition.getX();
        int y = this.currentPosition.getY();
        switch (direction) {
            case 'u':
                if(x > 0) this.currentPosition.setX(x-1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            case 'd':
                if (x < world.length-1) this.currentPosition.setX(x+1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            case 'l':
                if (y > 0) this.currentPosition.setY(y-1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            case 'r':
                if (y < world[0].length-1) this.currentPosition.setY(y+1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            default:
                throw new InvalidPositionException("Direccion no valida!");
        }
    }
    
    public int[] limpiar(int[] estado){
        if(estado[0] == 0) {
            estado[1] = 1;
        } else if (estado[0] == 1) {
            estado[2] = 1;
        }
        return estado;
    }
    public int[] movIzq(int[] estado){
        estado[0] = 0;
        return estado;
    }
    public int[] movDer(int[] estado){
        estado[0] = 1;
        return estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aspiradora{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
