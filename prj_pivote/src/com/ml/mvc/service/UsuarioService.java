package com.ml.mvc.service;

import java.util.List;

import com.ml.mvc.data.UsuarioDao;
import com.ml.mvc.data.model.Usuario;

public class UsuarioService {
	private static UsuarioDao usuarioDao;
	 
    public UsuarioService() {
    	usuarioDao = new UsuarioDao();
    }
    
    public void persist(Usuario entity) {
    	usuarioDao.openCurrentSessionwithTransaction();
    	usuarioDao.persist(entity);
    	usuarioDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Usuario entity) {
    	usuarioDao.openCurrentSessionwithTransaction();
    	usuarioDao.update(entity);
    	usuarioDao.closeCurrentSessionwithTransaction();
    }
 
    public Usuario findById(Integer id) {
    	usuarioDao.openCurrentSession();
    	Usuario usuario = usuarioDao.findById(id);
        usuarioDao.closeCurrentSession();
        return usuario;
    }
    
    public Usuario findByName(String name) {
    	usuarioDao.openCurrentSession();
    	Usuario usuario = usuarioDao.findByName(name);
        usuarioDao.closeCurrentSession();
        return usuario;
    }
 
    public void delete(Integer id) {
    	usuarioDao.openCurrentSessionwithTransaction();
    	Usuario usuario  = usuarioDao.findById(id);
        usuarioDao.delete(usuario);
        usuarioDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Usuario> findAll() {
    	usuarioDao.openCurrentSession();
        List<Usuario> usuarios = usuarioDao.findAll();
        usuarioDao.closeCurrentSession();
        return usuarios;
    }
 
    public void deleteAll() {
    	usuarioDao.openCurrentSessionwithTransaction();
    	usuarioDao.deleteAll();
    	usuarioDao.closeCurrentSessionwithTransaction();
    }
 
    public UsuarioDao usuarioDao() {
        return usuarioDao;
    }
}
