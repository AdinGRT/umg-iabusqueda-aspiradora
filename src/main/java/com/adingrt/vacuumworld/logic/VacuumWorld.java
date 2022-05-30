package com.adingrt.vacuumworld.logic;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorld {
    private boolean[][] room;

    public VacuumWorld(boolean[][] room) {
        this.room = room;
    }

    public VacuumWorld(boolean dirty) {
        if (dirty) this.dirtyEverything();
        else this.clearAll();
    }
    
    public VacuumWorld(boolean[][] room, boolean dirty) {
        this.room = room;
        if (dirty) this.dirtyEverything();
        else this.clearAll();
    }

    public boolean[][] getRoom() {
        return room;
    }

    public void setRoom(boolean[][] room) {
        this.room = room;
    }

    public boolean isDirty(Coordinates coord) {
        return this.room[coord.getY()][coord.getX()];
    }

    public void dirty(Coordinates coord, boolean isDirty) {
        this.room[coord.getY()][coord.getX()] = isDirty;
    }
    
    private void dirtyEverything() {
        for (int i = 0; i < this.room.length; ++i) {
            for(int j = 0; j < this.room[i].length; ++j) {
                this.room[i][j] = true;
            }
        }
    }
    
    private void clearAll() {
        for (int i = 0; i < this.room.length; ++i) {
            for(int j = 0; j < this.room[i].length; ++j) {
                this.room[i][j] = false;
            }
        }
    }
    
    public String printRoom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.room.length; ++i) {
            for(int j = 0; j < this.room[i].length; ++j) {
                if(this.room[i][j]) {
                    sb.append("Habitacion en: " + i + " " + j + "esta sucia! \n");
                }
                else {
                    sb.append("Habitacion en: " + i + " " + j + "esta limpia! \n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VacuumWorld{");
        sb.append(this.printRoom());
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
