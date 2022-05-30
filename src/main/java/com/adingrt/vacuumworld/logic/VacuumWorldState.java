package com.adingrt.vacuumworld.logic;

import java.util.Objects;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorldState {

    private VacuumCleaner vacuum;
    private VacuumWorld world;

    public VacuumWorldState() {
    }
    
    public VacuumWorldState(VacuumCleaner vacuum, VacuumWorld world) {
        this.vacuum = vacuum;
        this.world = world;
    }

    public VacuumCleaner getVacuum() {
        return vacuum;
    }

    public VacuumWorld getWorld() {
        return world;
    }

    public void copyState(VacuumWorldState otherState) {
        otherState.setVacuum(new VacuumCleaner(new Coordinates(this.vacuum.getCurrentPosition().getX(), this.vacuum.getCurrentPosition().getY())));
        otherState.setWorld(new VacuumWorld(this.world.getRoom().clone(), true));
        otherState.getVacuum().assignWorld(otherState.getWorld());
    }
    
    public boolean isTheSameState(VacuumWorldState otherState) {
        if (this.getVacuum().getCurrentPosition() == otherState.getVacuum().getCurrentPosition()) {
            if (this.getWorld().getRoom().length == otherState.getWorld().getRoom().length) {
                for (int i = 0; i < this.getWorld().getRoom().length; ++i) {
                    if (this.getWorld().getRoom()[i].length == otherState.getWorld().getRoom()[i].length) {
                        for (int j = 0; j < this.getWorld().getRoom()[i].length; ++j) {
                            if (this.getWorld().getRoom()[i][j] != otherState.getWorld().getRoom()[i][j]) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public void setVacuum(VacuumCleaner vacuum) {
        this.vacuum = vacuum;
    }

    public void setWorld(VacuumWorld world) {
        this.world = world;
    }
}
