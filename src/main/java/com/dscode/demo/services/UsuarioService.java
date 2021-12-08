package com.dscode.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dscode.demo.models.UsuarioModel;
import com.dscode.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	// Mostrar todos los usuarios
	public ArrayList<UsuarioModel> obtenerUsuarios() {
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}

	// Guardar usuarios
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}

	// Mostrar usuario por id
	public Optional<UsuarioModel> obtenerPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	// Mostrar usuario por prioridad
	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
		return usuarioRepository.findByPrioridad(prioridad);
	}

	// Mostrar usuario por nombre de usuario
	public ArrayList<UsuarioModel> obtenerPorNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	// Mostrar usuario por nombre de usuario
	public ArrayList<UsuarioModel> obtenerPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	//Eliminar usuario
	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
}
