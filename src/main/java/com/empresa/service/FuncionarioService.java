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
	
	private Funcionario guardar(Funcionario request) {
		
		return funcionarioRepository.save(request);
		
	}
	
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	 
	public Funcionario get(Integer id) {
		
		return funcionarioRepository.findById(id).orElse(null);
		
	}
	
	public Funcionario actualizar(Integer id,Funcionario request){
		Optional<Funcionario> f = funcionarioRepository.findById(id);
		return f.map()
		
		
				
		
		
	}
}
