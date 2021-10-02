package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.ListaLivroDetalhadoDto;
import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/livros/{id}")
    public ResponseEntity<ListaLivroDetalhadoDto> listaLivroDetalhado(@PathVariable Integer id) {

        Livro livro = livroRepository.getById(id);

        if ( livro == null ) {
            return ResponseEntity.notFound().build();
        }

        ListaLivroDetalhadoDto  listaLivroDetalhadoDto = new ListaLivroDetalhadoDto(livro);
        return ResponseEntity.ok(listaLivroDetalhadoDto);
    }
}
