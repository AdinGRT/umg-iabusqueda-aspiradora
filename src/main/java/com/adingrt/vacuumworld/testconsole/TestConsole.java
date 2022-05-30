package com.adingrt.vacuumworld.testconsole;

import com.adingrt.vacuumworld.logic.Coordinates;
import com.adingrt.vacuumworld.logic.SearchLogic;
import com.adingrt.vacuumworld.logic.VacuumCleaner;
import com.adingrt.vacuumworld.logic.VacuumWorld;
import com.adingrt.vacuumworld.logic.VacuumWorldState;

/**
 *
 * @author Adin Rubio
 */
public class TestConsole {
    public static void main(String[] args) {

        boolean[][] room = new boolean[1][2];
        
        VacuumWorld world = new VacuumWorld(room, true);
        VacuumCleaner vacuum = new VacuumCleaner(new Coordinates(0,0));
        VacuumWorldState state = new VacuumWorldState();
        
        state.setVacuum(vacuum);
        state.setWorld(world);
        world.setRoom(room);
        vacuum.assignWorld(world);
        
        vacuum.action('d');
        
        System.out.println("Vacuum position = " + vacuum.getCurrentPosition().toString());
        System.out.println("State vacuum position = " + state.getVacuum().getCurrentPosition().toString());
        System.out.println(vacuum.getWorld().isDirty(vacuum.getCurrentPosition()));
        
        System.out.println(vacuum.getWorld().getRoom());
        System.out.println(state.getWorld().getRoom());
        
        
        VacuumWorldState otherState = new VacuumWorldState();
        state.copyState(otherState);
        System.out.println(state);
        System.out.println(otherState);
        System.out.println(state.getVacuum());
        System.out.println(otherState.getVacuum());
        System.out.println(state.getWorld());
        System.out.println(otherState.getWorld());
        System.out.println(state.getWorld().getRoom());
        System.out.println(otherState.getWorld().getRoom());
        
        otherState.getVacuum().action('l');
        System.out.println("Vacuum position = " + vacuum.getCurrentPosition().toString());
        System.out.println("State vacuum position = " + state.getVacuum().getCurrentPosition().toString());
        System.out.println("other State vacuum position = " + otherState.getVacuum().getCurrentPosition().toString());
        
        otherState.getVacuum().action('s');
        
        state.getWorld().printRoom();
        otherState.getWorld().printRoom();
        
    }
}
