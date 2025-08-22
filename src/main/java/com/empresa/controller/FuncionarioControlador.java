package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.empresa.entity.Funcionario;
import com.empresa.service.FuncionarioService;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioControlador {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public Funcionario post(@RequestBody Funcionario request) {
		return funcionarioService.guardar(request);
	}
	
	@GetMapping
	public List<Funcionario> Listar(){
		return funcionarioService.listar();
	}
	
	@GetMapping("/{id}")
	public Funcionario listarPorId(@PathVariable Integer id) {
		return funcionarioService.get(id);
	}
	
	@PutMapping("/{id}")
	public Funcionario actualizar(@PathVariable Integer id,@RequestBody Funcionario paciente) {
		return funcionarioService.actualizar(id, paciente);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		funcionarioService.eliminar(id);
	}
	
}
