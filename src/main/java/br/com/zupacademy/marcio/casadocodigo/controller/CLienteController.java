package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.dto.ClienteDto;
import br.com.zupacademy.marcio.casadocodigo.form.ClienteForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.marcio.casadocodigo.repository.ClienteRepository;
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
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/clientes")
public class CLienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid @NotNull ClienteForm form) {

        Cliente cliente = form.converter(paisRepository, estadoRepository);

        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteDto(cliente));
    }
}
