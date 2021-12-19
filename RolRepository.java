package uc.us_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uc.us_security.entity.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
