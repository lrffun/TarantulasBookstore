package com.tb.dao.impl;

import com.tb.dao.IAdministratorDao;
import com.tb.domain.Administrator;

public class AdministratorDaoImpl implements IAdministratorDao {

    IAdministratorDao administratorDao;

    @Override
    public Administrator login(Administrator administrator) {
        return administratorDao.login(administrator);
    }

    public void setAdministratorDao(IAdministratorDao administratorDao) {
        this.administratorDao = administratorDao;
    }
}
