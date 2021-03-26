package com.pidi.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidi.domain.Categoria;
import com.pidi.repositories.CategoriaRepository;
import com.pidi.servicies.exceptions.NotFoudExceptions;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new NotFoudExceptions(id));
	}
	
	public Categoria insert(Categoria obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Categoria update(Long id, Categoria obj) {
		Categoria entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Categoria entity, Categoria obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		
	}
}
