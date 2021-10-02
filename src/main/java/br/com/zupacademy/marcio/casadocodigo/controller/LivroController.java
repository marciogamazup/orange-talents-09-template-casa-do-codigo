package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.LivroDto;
import br.com.zupacademy.marcio.casadocodigo.form.LivroForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form){

        Livro livro = form.converter(autorRepository, categoryRepository);

        livroRepository.save(livro);

        return ResponseEntity.ok(new LivroDto(livro));

    }

}
