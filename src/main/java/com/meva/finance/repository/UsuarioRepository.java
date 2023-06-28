package com.meva.finance.repository;

import com.meva.finance.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
//    List<Usuario> findAll();

}
