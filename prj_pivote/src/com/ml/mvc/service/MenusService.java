package com.ml.mvc.service;

import java.util.List;

import com.ml.mvc.data.MenusDao;
import com.ml.mvc.data.model.Menus;

public class MenusService {
	private static MenusDao menusDao;
	 
    public MenusService() {
    	menusDao = new MenusDao();
    }
    
    public void persist(Menus entity) {
    	menusDao.openCurrentSessionwithTransaction();
    	menusDao.persist(entity);
    	menusDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Menus entity) {
    	menusDao.openCurrentSessionwithTransaction();
    	menusDao.update(entity);
    	menusDao.closeCurrentSessionwithTransaction();
    }
 
    public Menus findById(Integer id) {
    	menusDao.openCurrentSession();
    	Menus menus = menusDao.findById(id);
        menusDao.closeCurrentSession();
        return menus;
    }
 
    public void delete(Integer id) {
    	menusDao.openCurrentSessionwithTransaction();
    	Menus menus  = menusDao.findById(id);
        menusDao.delete(menus);
        menusDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Menus> findAll() {
    	menusDao.openCurrentSession();
        List<Menus> menus = menusDao.findAll();
        menusDao.closeCurrentSession();
        return menus;
    }
 
    public void deleteAll() {
    	menusDao.openCurrentSessionwithTransaction();
    	menusDao.deleteAll();
    	menusDao.closeCurrentSessionwithTransaction();
    }
 
    public MenusDao menusDao() {
        return menusDao;
    }
}
