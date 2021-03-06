package uc.us_security.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Usuario;
import uc.us_security.repository.Usuariorepository;
@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private Usuariorepository usuariorepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuariorepository.findByUsername(username);
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role ->new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEstado(), true, 
				true, true, authorities);
	}

}
