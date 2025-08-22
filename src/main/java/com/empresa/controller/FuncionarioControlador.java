package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Funcionario;
import com.empresa.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioControlador {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<Map<String,Object>>POST(@Valid @RequestBody Funcionario request, BindingResult bindingResult) {
		Map<String,Object> r = new HashMap<>();
		
		if(bindingResult.hasErrors()) {
			String error = bindingResult.getFieldError().getDefaultMessage();
			r.put("mensaje", "Error en la creacion del paciente.");
			r.put("error", error);
			r.put("status", HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.badRequest().body(r);
		}
		
		try {
			Funcionario creado = funcionarioService.guardar(request);
			r.put("funcionario", creado);
			r.put("mensaje", "Funcionario creado correctamente");
			r.put("status", HttpStatus.OK.value());
			return ResponseEntity.ok(r);
			
			
	} catch (Exception e) {
		r.put("mensaje", "Error en la creacion del paciente");
		r.put("error", e.getMessage());
		r.put("mensaje", HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(r);
	}
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
