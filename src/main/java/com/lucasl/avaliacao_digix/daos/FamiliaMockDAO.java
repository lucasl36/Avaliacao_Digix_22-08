package com.lucasl.avaliacao_digix.daos;

import java.util.List;

import com.lucasl.avaliacao_digix.models.Familia;
import java.util.ArrayList;

/**
 *
 * @author Lucas Lopes
 */
public class FamiliaMockDAO {
    
    private static FamiliaMockDAO instance;
    
    private FamiliaMockDAO() {
        
    }
    
    public static FamiliaMockDAO getInstance() {
        if(instance == null) {
            instance = new FamiliaMockDAO();
        }
        return instance;
    }
    
    public List<Familia> getFamilias() {
        return new ArrayList<Familia>(){{
            add(new Familia("Silva", 3, 900.0, 0));
            add(new Familia("Ferreira", 2, 900.0, 0));
            add(new Familia("Novaes", 3, 1500.0, 0));
            add(new Familia("Fonseca", 2, 1500.0, 0));
            add(new Familia("Batista", 4, 6500.0, 0));
            add(new Familia("Modesto", 0, 1400.0, 0));
            add(new Familia("Jerônimo", 0, 450.0, 0));
            add(new Familia("Moreira", 0, 2500.0, 0));
            add(new Familia("Guimarães", 1, 8000.0, 0));
        }};
    }
    
}
