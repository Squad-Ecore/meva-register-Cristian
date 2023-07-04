package com.meva.finance.service;

import com.meva.finance.dto.request.FamilyRequest;
import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import com.meva.finance.exception.entityException.ValidException;
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

    private final UsuarioRepository usuarioRepository;
    private final FamilyRepository familyRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, FamilyRepository familyRepository) {
        this.usuarioRepository = usuarioRepository;
        this.familyRepository = familyRepository;
    }

    public Usuario save(UsuarioRequest usuarioRequest) {


        validaFamily(usuarioRequest.getFamilyRequest());


        FamilyRequest familyRequest = usuarioRequest.getFamilyRequest();
        usuarioRequest.setFamilyRequest(familyRequest);

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

//    private Family validaFamily(FamilyRequest familyRequest) {
//        if (familyRequest.getId() == null || familyRequest.getId() == 0) {
//            throw new ValidFamilyException("id da family está null. Adicione um id valido");
//        } else if (familyRequest.getDescricao().isEmpty()) {
//            throw new ValidFamilyException("Descricao de family vazia");
//        }
//
//        return familyRepository.save(familyRequest.convert(new Family()));
//    }

    private Family validaFamily(FamilyRequest familyRequest) {
        if (familyRequest.getDescricao().isEmpty()) {
            throw new ValidFamilyException("descricao family esta vazia");
        }
//

        // tentar fazer uma validação onde quando o id for nulo ou 0 cria automaticamento um novo usuario;

        Family request;
        if (familyRequest.getId() == null || familyRequest.getId() == 0) {
            request = new Family();

        } else {
            request = familyRepository.findById(familyRequest.getId()).orElseThrow(() -> new ValidFamilyException("Teste"));
        }

        return familyRepository.save(familyRequest.convert(request));
    }
}





