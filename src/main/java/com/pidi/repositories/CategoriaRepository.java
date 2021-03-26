package com.pidi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidi.domain.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
