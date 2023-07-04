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




    // teste não salva family mas ele retorna o erro -TENTAR ARRUMAR
    private void validaFamily(FamilyRequest familyRequest) {
        if (familyRequest.getId() == null || familyRequest.getId() == 0) {
            throw new ValidFamilyException("id da family está null. Adicione um id valido");
//        } else if (familyRequest.getDescricao().isEmpty() && familyRequest.getDescricao() != familyRepository.equals(familyRequest)) {
//            saveFamilyVerific(familyRequest);
        } else {
            throw new ValidFamilyException("Para criar uma nova family precisa passar um id e descricao valida");
        }
//        familyRepository.save(familyRequest.convert(new Family()));
    }

//    private Family validaFamily(UsuarioRequest usuarioRequest) throws ValidFamilyException {
//        Long familyId = usuarioRequest.getFamilyRequest().getId();
//
//        if (familyId == null) {
//            throw new ValidFamilyException("id de family é nulo");
//        } else if (familyRepository.findById(familyId).isPresent() || familyId == 0) {
//            return familyRepository.save(usuarioRequest.getFamilyRequest().convert(new Family()));
//        }
//
//        throw new ValidFamilyException("não tem family");
//    }


    private void saveFamilyVerific(FamilyRequest familyRequest) {
        Optional<Family> optionalFamily = familyRepository.findById(familyRequest.getId());

        optionalFamily.ifPresent(family -> familyRepository.save(familyRequest.convert(new Family())));


    }
}





