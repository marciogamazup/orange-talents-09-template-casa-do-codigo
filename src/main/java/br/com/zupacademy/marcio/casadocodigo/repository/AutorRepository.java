package br.com.zupacademy.marcio.casadocodigo.repository;

import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

    Optional<Autor> findByEmail(String email);
}
