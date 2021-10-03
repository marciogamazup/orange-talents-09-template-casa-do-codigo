package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.EstadoDto;
import br.com.zupacademy.marcio.casadocodigo.form.EstadoForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Estado;
import br.com.zupacademy.marcio.casadocodigo.repository.EstadoRepository;
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
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form) {

        Estado estado = form.converter(paisRepository);

        estadoRepository.save(estado);

        return ResponseEntity.ok(new EstadoDto(estado));

    }
}
