package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.marcio.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<AutorDto> lista() {
        List<Autor> autores = autorRepository.findAll();
        return AutorDto.converter(autores);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder) {
        Autor autor = form.converter();
        autorRepository.save((autor));

        URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDto(autor));
    }
}
