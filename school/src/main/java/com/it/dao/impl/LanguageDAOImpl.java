package com.it.dao.impl;

import com.it.dao.LanguageDAO;
import com.it.model.Language;

public class LanguageDAOImpl extends GenericDAOImpl<Language, Long> implements LanguageDAO {
    private static LanguageDAOImpl instance;

    private LanguageDAOImpl() {
        super(Language.class);
    }

    synchronized public static LanguageDAOImpl getInstance() {
        if (instance == null) {
            instance = new LanguageDAOImpl();
        }
        return instance;
    }

}
