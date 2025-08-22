package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.repository.FuncionarioRepository;
import com.empresa.entity.Funcionario;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	public Funcionario guardar(Funcionario request) {
		Funcionario nuevo = new Funcionario();
		nuevo.setCedula(request.getCedula());
		nuevo.setNombre(request.getNombre());
		nuevo.setEmail(request.getEmail());
		nuevo.setTelefono(request.getTelefono());
		
		return funcionarioRepository.save(nuevo);
		
	}
	
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	 
	public Funcionario get(Integer id) {
		
		return funcionarioRepository.findById(id).orElse(null);
		
	}
	
	public Funcionario actualizar(Integer id,Funcionario request){
		Optional<Funcionario> f = funcionarioRepository.findById(id);
		if(f.isPresent()) {
			Funcionario nuevo = f.get();
			nuevo.setCedula(request.getCedula());
			nuevo.setNombre(request.getNombre());
			nuevo.setEmail(request.getEmail());
			nuevo.setTelefono(request.getTelefono());
			
			return funcionarioRepository.save(nuevo);
		}else {
			return null;
		}
	}
	
	public void eliminar(Integer id) {
		funcionarioRepository.deleteById(id);
	}
}
