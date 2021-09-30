package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.AutorDto;
import br.com.zupacademy.marcio.casadocodigo.form.AutorForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

   @Autowired
   private AutorRepository autorRepository;


   @PostMapping
   @Transactional
   public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriComponentsBuilder) {
       Autor autor = form.converter(autorRepository);
       autorRepository.save(autor);

       URI uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
       return ResponseEntity.created(uri).body(new AutorDto((autor)));
   }
}
