package com.it.dao.impl;

import com.it.dao.TutorDAO;
import com.it.model.Tutor;

public class TutorDAOImpl extends GenericDAOImpl<Tutor, Long> implements TutorDAO {
    private static TutorDAOImpl instance;

    private TutorDAOImpl() {
        super(Tutor.class);
    }

    synchronized public static TutorDAOImpl getInstance() {
        if (instance == null) {
            instance = new TutorDAOImpl();
        }
        return instance;
    }
}
