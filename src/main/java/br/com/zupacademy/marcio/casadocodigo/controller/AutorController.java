package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {

        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping(value = "/autores")
    @Transactional
    public String cria(@RequestBody @Valid AutorForm request) {

        Autor autor = request.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
