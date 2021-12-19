package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.Rol;



public interface RolService {
	List<Rol> readAll();
	Rol create(Rol rol);
	Rol update(Rol rol);
	Rol read(int id);
	void delete(int id);
}
