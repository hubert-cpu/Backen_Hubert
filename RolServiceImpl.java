package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Rol;
import uc.us_security.repository.RolRepository;
import uc.us_security.service.RolService;
@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;
	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public Rol create(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public Rol update(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public Rol read(int id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);

	}

}
