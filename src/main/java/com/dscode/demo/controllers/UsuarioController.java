package com.dscode.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dscode.demo.models.UsuarioModel;
import com.dscode.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);		
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
	}
	
	@GetMapping("/query") //Ejemplo--> http://localhost:8080/usuario/query?prioridad=2
	public ArrayList<UsuarioModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "El usuario con id " + id + " se elimino correctamente";
		}else {
			return "No se pudo eliminar el usuario con id " + id;
		}
	}

}
