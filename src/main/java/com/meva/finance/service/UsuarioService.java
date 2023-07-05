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

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final FamilyRepository familyRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, FamilyRepository familyRepository) {
        this.usuarioRepository = usuarioRepository;
        this.familyRepository = familyRepository;
    }

    public Usuario save(UsuarioRequest usuarioRequest) throws ValidFamilyException {

        FamilyRequest familyRequest = usuarioRequest.getFamilyRequest();
//        usuarioRequest.setFamilyRequest(familyRequest);

        familyValid(familyRequest);

        findCpfUser(usuarioRequest);

        return usuarioRepository.save(usuarioRequest.convert(new Usuario()));

    }

    public void deleteId(String cpf) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cpf);

        usuarioOptional.ifPresent(usuario -> usuarioRepository.delete(usuario));
    }

    public Usuario update(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequest.convert(new Usuario());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioRequest.getCpf());

        if (usuarioOptional.isPresent()) {
            Usuario userPresent = usuarioOptional.get();

            return save(usuarioRequest);
        }

        return usuario;
    }


    // Validar se o id da family é = 0, se for inserir uma nova family com a descrição enviada
    // Se o id > 0, validar se a family existe no BD;

//    private void familyValid(FamilyRequest familyRequest) {
//        Long idFamily = familyRequest.getId();
//
//        if (idFamily == null || idFamily == 0) {
//            throw new ValidFamilyException("ID null");
//        } else {
//            Optional<Family> existFamily = familyRepository.findById(idFamily);
//            if (!existFamily.isPresent()) {
//                Family family = familyRequest.convert(new Family());
//                familyRepository.save(family);
//
//            }
//        }
//    }

    private void familyValid(FamilyRequest familyRequest) {
        Long idFamily = familyRequest.getId();

        if (idFamily == null || idFamily == 0) {
            throw new ValidFamilyException("Erro -> Id ");
        } else if (familyRequest.getDescricao().isEmpty()) {
            throw new ValidFamilyException("Erro -> descricao");
        } else {

            Family family = familyRequest.convert(new Family());
            familyRepository.save(family);
        }

    }

    private void findCpfUser(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioRequest.getCpf());
        if (usuarioOptional.isPresent()) {
            throw new ValidFamilyException("Cpf de usuario já está cadastrado");
        }
    }
}





