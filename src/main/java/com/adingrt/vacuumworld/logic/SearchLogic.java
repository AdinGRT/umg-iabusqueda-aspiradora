package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.linkedtree.ITree;
import com.adingrt.vacuumworld.linkedtree.LinkedTree;
import com.adingrt.vacuumworld.linkedtree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class SearchLogic<E> implements ISearchLogic {

    private static final char SUCKDIRT = 's';
    private static final char MOVELEFT = 'l';
    private static final char MOVERIGHT = 'r';

    private VacuumWorld world;
    private VacuumCleaner vacuum;

    private VacuumWorldState initialState;
    private VacuumWorldState[] finalStates;

    private LinkedTree tree;

    public SearchLogic() {
        this.world = new VacuumWorld(true);
        this.vacuum = new VacuumCleaner(new Coordinates(0, 0));
        this.vacuum.assignWorld(this.world);
        this.initialState = new VacuumWorldState(this.vacuum, this.vacuum.getWorld());
        this.finalStates[0] = new VacuumWorldState(new VacuumCleaner(new Coordinates(0, 0)), new VacuumWorld(false));
        this.finalStates[1] = new VacuumWorldState(new VacuumCleaner(new Coordinates(0, 1)), new VacuumWorld(false));
    }

    public void fillTree(VacuumWorldState stateElementParent, TreeNode<E> parentNode, char operador) {
        VacuumWorldState stateElementChild;
        //GENERAR NUEVO ESTADO CON OPERADOR DADO
        stateElementChild = stateElementParent.copyState(); //COPIAR ESTADO DEL QUE VIENE
        stateElementChild.getVacuum().action(operador); //ESTADO NUEVO GENERADO
        //COMPARAR ESTADOS PARA AGREGAR NODO A ARBOL O NO
        if (parentNode.getChildrens() != null || !parentNode.getChildrens().isEmpty()) {
            for (TreeNode<E> cN : parentNode.getChildrens()) {
                this.fillTree(stateElementChild, cN, operador);
            }
        } else if (!stateElementChild.isTheSameState(stateElementParent)) {
            TreeNode<E> childNode = (TreeNode<E>) this.tree.add(parentNode, stateElementChild);
            this.fillTree(stateElementChild, childNode, operador);
        }
    }

    @Override
    public ITree statesTree() {
        VacuumWorldState currState = initialState.copyState();
        this.tree = new LinkedTree<>();
        TreeNode<E> currNode = (TreeNode<E>) this.tree.addRoot(currState);

        VacuumWorldState auxState;

        //LIMPIAR
        auxState = currState.copyState();
        auxState.getVacuum().action(SUCKDIRT);
        if (!auxState.isTheSameState(currState)) {
            this.tree.add(currNode, auxState);
            if (this.isGoal(auxState)) {
                return this.tree;
            }
        }
        //IZQUIERDA
        auxState = currState.copyState();
        auxState.getVacuum().action(MOVELEFT);
        if (!auxState.isTheSameState(currState)) {
            this.tree.add(currNode, auxState);
            if (this.isGoal(auxState)) {
                return this.tree;
            }
        }
        //DERECHA
        auxState = currState.copyState();
        auxState.getVacuum().action(MOVERIGHT);
        if (!auxState.isTheSameState(currState)) {
            this.tree.add(currNode, auxState);
            if (this.isGoal(auxState)) {
                return this.tree;
            }
        }
        return this.tree;
    }

    @Override
    public Boolean isGoal(VacuumWorldState state) {
        return state.isTheSameState(this.finalStates[0]) || state.isTheSameState(this.finalStates[1]);
    }

    @Override
    public List<E> getRoute() {
        List<VacuumWorldState> routes = new ArrayList<>();
        VacuumWorldState currState = new VacuumWorldState(this.initialState.getVacuum(), this.initialState.getWorld());
        VacuumWorldState auxState;
        while (!this.isGoal(currState)) {
            //MOVER IZQUIERDA
            auxState = new VacuumWorldState(currState.getVacuum(), currState.getWorld());
            auxState.getVacuum().move('l');
            routes.add(auxState);
            //MOVER DERECHA
            auxState = new VacuumWorldState(currState.getVacuum(), currState.getWorld());
            auxState.getVacuum().move('d');
            routes.add(auxState);
            //LIMPIAR
            auxState = new VacuumWorldState(currState.getVacuum(), currState.getWorld());
            auxState.getVacuum().suckdirt();
            routes.add(auxState);
        }
        return (List<E>) routes;
    }

}
