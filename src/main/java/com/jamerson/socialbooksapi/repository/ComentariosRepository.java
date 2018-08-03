package com.jamerson.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamerson.socialbooksapi.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
