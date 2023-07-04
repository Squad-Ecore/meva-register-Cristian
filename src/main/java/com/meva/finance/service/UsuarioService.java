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

import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FamilyRepository familyRepository;


    public Usuario save(UsuarioRequest usuarioRequest) throws ValidFamilyException{

        validFamily(usuarioRequest);

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

    private Family validFamily(UsuarioRequest usuarioRequest){
        Long familyId = usuarioRequest.getFamilyRequest().getId();

        if (Objects.isNull(familyId)){
            throw new ValidFamilyException("id de family esta nulo");

        } else {
            FamilyRequest familyRequest = usuarioRequest.getFamilyRequest();
            usuarioRequest.setFamilyRequest(familyRequest);

            return familyRepository.save(usuarioRequest.getFamilyRequest().convert(new Family()));
        }

    }
}





