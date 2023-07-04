package com.meva.finance.repository;

import com.meva.finance.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
//    List<Usuario> findAll();

    @Override
    Optional<Usuario> findById(String cpf);
}
