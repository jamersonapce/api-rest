package com.jamerson.socialbooksapi.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jamerson.socialbooksapi.domain.Comentario;
import com.jamerson.socialbooksapi.domain.Livro;
import com.jamerson.socialbooksapi.repository.ComentariosRepository;
import com.jamerson.socialbooksapi.repository.LivrosRepository;
import com.jamerson.socialbooksapi.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	private final LivrosRepository livrosRepository;
	private final ComentariosRepository comentariosRepository;

	@Autowired
	public LivrosService(LivrosRepository livrosRepository, ComentariosRepository comentariosRepository) {
		this.livrosRepository = livrosRepository;
		this.comentariosRepository = comentariosRepository;
	}

	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	public Optional<Livro> buscar(Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		if (!livro.isPresent()) {
			throw new LivroNaoEncontradoException("Livro não encontrado!");
		}
		return livro;
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}

	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro não encontrado!");
		}
	}

	public void atualizar(Livro livro) {
		this.verificarExistencia(livro);
		livrosRepository.save(livro);
	}

	private void verificarExistencia(Livro livro) {
		this.buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Optional<Livro> livro = this.buscar(livroId);
		comentario.setLivro(livro.get());
		comentario.setData(Calendar.getInstance());
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId){
		Optional<Livro> livro = this.buscar(livroId);
		return livro.get().getComentarios();
	}
}



















