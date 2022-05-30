package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.linkedtree.ITree;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public interface ISearchLogic<E> {
    //Generar arbol de estados
    public ITree statesTree();
    //Comparacion de estados para saber si es final
    public Boolean isGoal(VacuumWorldState state);
    //Obtener una lista de estados con rutas
    public List<E> getRoute();
}
