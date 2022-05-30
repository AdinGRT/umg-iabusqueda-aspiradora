package com.adingrt.vacuumworld.testconsole;

import com.adingrt.vacuumworld.logic.SearchLogic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class TestSearch {
    public static void main(String[] args) {
        List<Character> operators = new ArrayList();
        operators.add('s');
        operators.add('l');
        operators.add('r');
        
        SearchLogic search;
        
        search = new SearchLogic(1, 2);
        
        search.generateTree(4, operators);
        
    }
}
