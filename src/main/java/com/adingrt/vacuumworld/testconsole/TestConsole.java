package com.adingrt.vacuumworld.testconsole;

import com.adingrt.vacuumworld.logic.Coordinates;
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
        VacuumCleaner vacuum = new VacuumCleaner(new Coordinates(0, 0));
        VacuumWorldState state = new VacuumWorldState();

        state.setVacuum(vacuum);
        state.setWorld(world);

        state.getVacuum().action('d', state.getWorld());

        System.out.println("Vacuum position = " + vacuum.getCurrentPosition().toString());
        System.out.println("State vacuum position = " + state.getVacuum().getCurrentPosition().toString());
        System.out.println(state.getWorld().isDirty(state.getVacuum().getCurrentPosition()));

        System.out.println(state.getWorld().getRoom());

        VacuumWorldState otherState = new VacuumWorldState();
        otherState.copyState(state);

        System.out.println(state);
        System.out.println(otherState);
        System.out.println(state.getVacuum());
        System.out.println(otherState.getVacuum());
        System.out.println(state.getWorld());
        System.out.println(otherState.getWorld());
        System.out.println(state.getWorld().getRoom());
        System.out.println(otherState.getWorld().getRoom());

        otherState.getVacuum().action('l', otherState.getWorld());
        System.out.println("Vacuum position = " + vacuum.getCurrentPosition().toString());
        System.out.println("State vacuum position = " + state.getVacuum().getCurrentPosition().toString());
        System.out.println("other State vacuum position = " + otherState.getVacuum().getCurrentPosition().toString());

        otherState.getVacuum().action('s', otherState.getWorld());

        VacuumWorldState newState = new VacuumWorldState();
        newState.copyState(state);
        System.out.println("new State vacuum position = " + newState.getVacuum().getCurrentPosition().toString());
        newState.getVacuum().action('d', newState.getWorld());
        System.out.println("new State vacuum position = " + newState.getVacuum().getCurrentPosition().toString());
        
        newState.getVacuum().action('u', newState.getWorld());
        System.out.println("new State vacuum position = " + newState.getVacuum().getCurrentPosition().toString());
        
        state.getWorld().printRoom();
        otherState.getWorld().printRoom();

        System.out.println("Is the same? = " + state.isTheSameGeneratedState(otherState));
        System.out.println("Is the same? = " + state.isTheSameGeneratedState(newState));
    }
}
