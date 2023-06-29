package com.meva.finance.service;

import com.meva.finance.dto.request.FamilyRequest;
import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import com.meva.finance.repository.FamilyRepository;
import com.meva.finance.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FamilyRepository familyRepository;


    public Usuario save(UsuarioRequest usuarioRequest) {

        if (usuarioRequest.getFamilyDto() != null) {
            FamilyRequest familyRequest = usuarioRequest.getFamilyDto();
            usuarioRequest.setFamilyDto(familyRequest);

            familyRepository.save(familyRequest.convert(new Family()));
        }

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


    private void listaFamilyId(Integer id) {
        Optional<Family> familyOptional = familyRepository.findById(id);

        familyOptional.ifPresent(family -> familyRepository.findById(id));
    }



}
