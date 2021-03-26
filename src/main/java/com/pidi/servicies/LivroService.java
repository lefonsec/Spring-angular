package com.pidi.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidi.domain.Livro;
import com.pidi.repositories.LivroRepository;
import com.pidi.servicies.exceptions.NotFoudExceptions;



@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repos;
	
	public List<Livro>findAll(){
		return repos.findAll();
	}
	
	public Livro findById(Long id) {
		Optional<Livro> list = repos.findById(id);
		return list.orElseThrow(() -> new NotFoudExceptions(id));
	}
	
	public Livro inser(Livro obj) {
		return repos.save(obj);
	}
	
	public void delete(Long id) {
		repos.deleteById(id);
	}
	
	public Livro update(Long id, Livro obj) {
		Livro entity = repos.getOne(id);
		updateData(entity,obj);
		return repos.save(entity);
	}

	private void updateData(Livro entity, Livro obj) {
		entity.setNome(obj.getNome());
		entity.setTexto(obj.getTexto());
		
	}
	
	
}
