package com.jamerson.socialbooksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamerson.socialbooksapi.domain.Autor;
import com.jamerson.socialbooksapi.repository.AutoresRepository;
import com.jamerson.socialbooksapi.services.exceptions.AutorExistenteException;
import com.jamerson.socialbooksapi.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {

	private final AutoresRepository autoresRepository;

	@Autowired
	public AutoresService(AutoresRepository autoresRepository) {
		this.autoresRepository = autoresRepository;
	}

	public List<Autor> listar() {
		return autoresRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			if (a != null) {
				throw new AutorExistenteException("O autor já existe!");
			}
		}
		return autoresRepository.save(autor);
	}

	public Optional<Autor> buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		if (!autor.isPresent()) {
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado!");
		}
		return autor;
	}
}
