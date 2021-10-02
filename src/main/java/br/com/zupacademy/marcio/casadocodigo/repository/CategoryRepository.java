package br.com.zupacademy.marcio.casadocodigo.repository;

import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Integer> {

}
