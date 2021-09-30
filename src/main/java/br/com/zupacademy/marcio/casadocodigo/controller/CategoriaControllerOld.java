//package br.com.zupacademy.marcio.casadocodigo.controller;
//
//import br.com.zupacademy.marcio.casadocodigo.dto.CategoriaDto;
//import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
//import br.com.zupacademy.marcio.casadocodigo.validator.ProibeNomeDuplicadoCategoriaValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import javax.validation.Valid;
//
//@RestController
//public class CategoriaControllerOld {
//
//    @PersistenceContext
//    private EntityManager manager;
//    @Autowired
//    private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;
//
//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
//    }
//
//    @PostMapping(value = "/categorias")
//    @Transactional
//    public String cria(@RequestBody @Valid CategoriaDto request) {
//        Categoria categoria = request.toModel();
//        manager.persist(categoria);
//        return  categoria.toString();
//    }
//}
