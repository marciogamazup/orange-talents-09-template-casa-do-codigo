package br.com.zupacademy.marcio.casadocodigo.repository;

import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
