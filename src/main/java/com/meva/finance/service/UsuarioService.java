package com.meva.finance.service;

import com.meva.finance.dto.request.FamilyRequest;
import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import com.meva.finance.exception.entityException.ValidFamilyException;
import com.meva.finance.repository.FamilyRepository;
import com.meva.finance.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FamilyRepository familyRepository;


    public Usuario save(UsuarioRequest usuarioRequest) {//throws ValidFamilyException {

//        if (usuarioRequest.getFamilyRequest() != null){
//            FamilyRequest familyRequest = usuarioRequest.getFamilyRequest();
//            usuarioRequest.setFamilyRequest(familyRequest);
//
//            familyRepository.save(familyRequest.convert(new Family()));
//        }

        validaFamily(usuarioRequest.getFamilyRequest());
        FamilyRequest familyRequest = usuarioRequest.getFamilyRequest();
        usuarioRequest.setFamilyRequest(familyRequest);
        familyRepository.save(familyRequest.convert(new Family()));
//        validFamily(usuarioRequest.getFamilyRequest());

        return usuarioRepository.save(usuarioRequest.convert(new Usuario()));
    }

    public void deleteId(String cpf) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cpf);

        usuarioOptional.ifPresent(usuario -> usuarioRepository.delete(usuario));
    }

    public Usuario update(UsuarioRequest usuarioRequest){ //throws ValidFamilyException {
        Usuario usuario = usuarioRequest.convert(new Usuario());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioRequest.getCpf());

        if (usuarioOptional.isPresent()) {
            Usuario userPresent = usuarioOptional.get();

            return save(usuarioRequest);
        }

        return usuario;
    }


    // verifica se familyRequest tem os dados obrigatorios
//    private void validFamily(FamilyRequest familyRequest) throws ValidFamilyException {
//        if (familyRequest.getId() == null) {
//            throw new ValidFamilyException("Campo id null");
//        } else if (familyRequest.getDescricao().isEmpty()) {
//            throw new ValidFamilyException("campo descricao vazio");
//        }
//
//        familyRepository.save(familyRequest.convert(new Family()));
//    }

    private void validaFamily(FamilyRequest familyRequest){
        if (familyRequest.getId() == null || familyRequest.getId() <=0){
            throw new ValidFamilyException("Algo deu errado com id family");
        }
        if (familyRequest.getDescricao().isEmpty() ){
            throw new ValidFamilyException("Descricao de family errada");
        }
    }

}



