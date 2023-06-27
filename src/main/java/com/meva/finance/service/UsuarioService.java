package com.meva.finance.service;

import com.meva.finance.dto.FamilyDto;
import com.meva.finance.dto.UsuarioDto;
import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import com.meva.finance.repository.FamilyRepository;
import com.meva.finance.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FamilyRepository familyRepository;


    public void salva(UsuarioDto usuarioDto) {

        if (usuarioDto.getFamilyDto() != null) {
            FamilyDto familyDto = usuarioDto.getFamilyDto();
            usuarioDto.setFamilyDto(familyDto);

            familyRepository.save(familyDto.convert());
        }
        Usuario usuario = usuarioDto.convert();

        usuarioRepository.save(usuario);
    }

    public void deleteId(String cpf) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cpf);

        usuarioOptional.ifPresent(usuario -> usuarioRepository.delete(usuario));
    }

    public void alterar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioDto.convert();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getCpf());

        if (usuarioOptional.isPresent()) {
            salva(usuarioDto);
        }
    }


    private void listaFamilyId(Integer id) {
        Optional<Family> familyOptional = familyRepository.findById(id);

        familyOptional.ifPresent(family -> familyRepository.findById(id));



    }

//    public List<UsuarioDto> listUsuario(){
//
//
//        usuarioRepository.findAll();
//        return listUsuario();
//    }
//
//    private List<Usuario> listUsuarios(){
//        return usuarioRepository.findAll();
//    }
}
