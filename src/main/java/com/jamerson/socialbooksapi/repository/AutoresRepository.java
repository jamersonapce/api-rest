package com.jamerson.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamerson.socialbooksapi.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
