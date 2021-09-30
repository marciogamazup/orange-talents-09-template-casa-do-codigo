//package br.com.zupacademy.marcio.casadocodigo.validator;
//
//import br.com.zupacademy.marcio.casadocodigo.dto.CategoriaDto;
//import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
//import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import java.util.Optional;
//
//@Component
//public class ProibeNomeDuplicadoCategoriaValidator implements Validator {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return CategoriaDto.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if (errors.hasErrors()) {
//            return;
//        }
//
//        CategoriaDto request = (CategoriaDto) target;
//
//        Optional<Categoria> possivelCategoria = categoryRepository
//                .findByNome(request.getNome());
//
//        if (possivelCategoria.isPresent()) {
//            errors.rejectValue("nome", null,
//                    "Já existe uma outra categoria com a mesma descrição "
//                        +request.getNome());
//        }
//    }
//}
