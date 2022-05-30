package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.exceptions.InvalidOperationException;

/**
 * @author Adin Rubio
 */
public class VacuumCleaner {

    private String id;
    private Coordinates currentPosition;

    public VacuumCleaner(Coordinates currentPosition) {
        this.currentPosition = currentPosition;
    }

    public VacuumCleaner(String id, Coordinates currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public void action(char action, VacuumWorld world) {
        if (action == 's') {
            this.suckdirt(world);
        } else if (action == 'u' || action == 'd' || action == 'l' || action == 'r') {
            this.move(action, world);
        } else {
            throw new InvalidOperationException("Operador no valido!");
        }
    }

    public void suckdirt(VacuumWorld world) {
        world.dirty(this.currentPosition, false);
    }

    private void move(char direction, VacuumWorld world) {
        int x = this.currentPosition.getX();
        int y = this.currentPosition.getY();
        switch (direction) {
            case 'd':
                if (y > 0) {
                    this.currentPosition.setY(y - 1);
                } else {
                    System.out.println("Posicion no valida!");
                }
                break;
            case 'u':
                if (y < world.getRoom().length - 1) {
                    this.currentPosition.setY(y + 1);
                } else {
                    System.out.println("Posicion no valida!");
                }
                break;
            case 'l':
                if (x > 0) {
                    this.currentPosition.setX(x - 1);
                } else {
                    System.out.println("Posicion no valida!");
                }
                break;
            case 'r':
                if (x < world.getRoom()[0].length - 1) {
                    this.currentPosition.setX(x + 1);
                } else {
                    System.out.println("Posicion no valida!");
                }
                break;
            default:
                System.out.println("Direccion no valida!");
        }
    }

    public Coordinates getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VacuumCleaner{");
        sb.append("id=").append(id);
        sb.append(", currentPosition=").append(currentPosition);
        sb.append('}');
        return sb.toString();
    }

}
