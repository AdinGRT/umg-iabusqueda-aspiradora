package com.adingrt.vacuumworld.logic;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorldState {

    private VacuumCleaner vacuum;
    private VacuumWorld world;
    private char operator;

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
    
    public char getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VacuumWorldState{");
        sb.append("vacuum=").append(vacuum);
        sb.append(", world=").append(world);
        sb.append(", operator=").append(operator);
        sb.append('}');
        return sb.toString();
    }
    
    public void changeState(char operator) {
        this.vacuum.action(operator, this.world);
        this.operator = operator;
    };
    
    public void copyState(VacuumWorldState state) {
        int yRoom = state.getWorld().getRoom().length;
        int xRoom = state.getWorld().getRoom()[0].length;
        this.setVacuum(new VacuumCleaner(new Coordinates(state.getVacuum().getCurrentPosition().getX(), state.getVacuum().getCurrentPosition().getY())));
        this.setWorld(new VacuumWorld(new boolean[yRoom][xRoom], true));
    }
    
    public boolean isTheSameGeneratedState(VacuumWorldState otherState) {
        if (this.getVacuum().getCurrentPosition().getX() == otherState.getVacuum().getCurrentPosition().getX()
                && this.getVacuum().getCurrentPosition().getY() == otherState.getVacuum().getCurrentPosition().getY()){
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

    private void setVacuum(VacuumCleaner vacuum) {
        this.vacuum = vacuum;
    }

    private void setWorld(VacuumWorld world) {
        this.world = world;
    }

}
