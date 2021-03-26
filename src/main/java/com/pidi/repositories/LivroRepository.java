package com.pidi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidi.domain.Livro;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
