//package br.com.zupacademy.marcio.casadocodigo.validator;
//
//import br.com.zupacademy.marcio.casadocodigo.dto.AutorDto;
//import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
//import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import java.util.Optional;
//
//@Component
//public class ProibeEmailDuplicadoAutorValidator implements Validator {
//
//    @Autowired
//    private AutorRepository autorRepository;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return AutorDto.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if (errors.hasErrors()) {
//            return;
//        }
//
//        AutorDto request = (AutorDto) target;
//
//        Optional<Autor> possivelAutor = autorRepository
//                .findByEmail(request.getEmail());
//
//        if (possivelAutor.isPresent()) {
//            errors.rejectValue("email", null,
//                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
//                            + request.getEmail());
//        }
//    }
//}
