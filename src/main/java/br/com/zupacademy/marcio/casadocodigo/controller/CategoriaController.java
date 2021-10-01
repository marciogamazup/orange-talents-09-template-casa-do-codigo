package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.marcio.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriComponentsBuilder) {

        Categoria categoria = form.converter(categoryRepository);
        categoryRepository.save(categoria);

        URI uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

//    @PostMapping
//    @Transactional
////    public String cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriComponentsBuilder) {
//    public String cadastrar(@RequestBody @Valid CategoriaForm form) {
//
//        Categoria categoria = form.converter();
//        categoryRepository.save(categoria);
//
//        return categoria.getId().toString();
//    }
}
