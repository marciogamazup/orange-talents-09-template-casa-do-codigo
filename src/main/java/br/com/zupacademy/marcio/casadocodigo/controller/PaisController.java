package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.PaisDto;
import br.com.zupacademy.marcio.casadocodigo.form.PaisForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Pais;
import br.com.zupacademy.marcio.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDto> cadastrar (@RequestBody @Valid PaisForm form) {

        Pais pais = form.converter();

        paisRepository.save(pais);

        return ResponseEntity.ok(new PaisDto(pais));

    }
}
