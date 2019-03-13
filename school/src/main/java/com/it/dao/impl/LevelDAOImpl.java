package com.it.dao.impl;

import com.it.dao.LevelDAO;
import com.it.model.Level;

public class LevelDAOImpl extends GenericDAOImpl<Level, Long> implements LevelDAO {
    private static LevelDAOImpl instance;

    private LevelDAOImpl() {
        super(Level.class);
    }

    synchronized public static LevelDAOImpl getInstance() {
        if (instance == null) {
            instance = new LevelDAOImpl();
        }
        return instance;
    }
}
