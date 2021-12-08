package com.dscode.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dscode.demo.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
	public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
	public abstract ArrayList<UsuarioModel> findByEmail(String email);
}
