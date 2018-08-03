package com.jamerson.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamerson.socialbooksapi.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
