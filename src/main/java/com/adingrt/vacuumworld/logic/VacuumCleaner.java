package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.exceptions.InvalidOperationException;

/**
 * @author Adin Rubio
 */
public class VacuumCleaner {

    private String id;
    private Coordinates currentPosition;
    private VacuumWorld world;

    public VacuumCleaner(Coordinates currentPosition) {
        this.currentPosition = currentPosition;
    }

    public VacuumCleaner(String id, Coordinates currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public void assignWorld(VacuumWorld world) {
        this.world = world;
    }

    public VacuumWorld getWorld() {
        return world;
    }

    public void action(char action) {
        if (action == 's') {
            this.suckdirt();
        } else if (action == 'u' || action == 'd' || action == 'l' || action == 'd') {
            this.move(action);
        } else {
            throw new InvalidOperationException("Operador no valido!");
        }
    }

    public void suckdirt() {
        this.world.dirty(this.currentPosition, false);
    }

    private void move(char direction) {
        int x = this.currentPosition.getX();
        int y = this.currentPosition.getY();
        switch (direction) {
            case 'u':
                if (x > 0) {
                    this.currentPosition.setX(x - 1);
                } else {
                    throw new InvalidOperationException("Posicion no valida!");
                }
                break;
            case 'd':
                if (x < this.world.getRoom().length) {
                    this.currentPosition.setX(x + 1);
                } else {
                    throw new InvalidOperationException("Posicion no valida!");
                }
                break;
            case 'l':
                if (x > 0) {
                    this.currentPosition.setX(x - 1);
                } else {
                    throw new InvalidOperationException("Posicion no valida!");
                }
                break;
            case 'r':
                if (y < this.world.getRoom()[0].length) {
                    this.currentPosition.setY(y + 1);
                } else {
                    throw new InvalidOperationException("Posicion no valida!");
                }
                break;
            default:
                throw new InvalidOperationException("Direccion no valida!");
        }
    }

    public Coordinates getCurrentPosition() {
        return currentPosition;
    }

}
