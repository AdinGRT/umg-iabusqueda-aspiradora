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
    
    public void printRoom() {
        for (int i = 0; i < this.room.length; ++i) {
            for(int j = 0; j < this.room[i].length; ++j) {
                System.out.println(this.room[i][j]);
            }
        }
    }
    
}
