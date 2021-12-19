package uc.us_security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Rol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3490423452440544278L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrol")
	private int id;
	@Column(unique = true)
	private String nombre;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;
}
