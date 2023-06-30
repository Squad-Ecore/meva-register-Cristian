package com.meva.finance.api;


import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.dto.response.UsuarioResponse;
import com.meva.finance.entity.Usuario;
import com.meva.finance.exception.InvalidFamilyException;
import com.meva.finance.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
public class userController {

    @Autowired
    private UsuarioService usuarioService;


    // Tentar fazer um tratamento de erro com a validação de family
    @PostMapping(value = "/salvar")
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        try {
            Usuario user = usuarioService.save(usuarioRequest);
            UsuarioResponse response = new UsuarioResponse(user);
            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {

            throw new InvalidFamilyException("Teste 1", e.getCause());
        }


    }

    @DeleteMapping(value = "/delete/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String cpf) {

        usuarioService.deleteId(cpf);
    }


    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioResponse> update(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        Usuario user = usuarioService.update(usuarioRequest);
        UsuarioResponse response = new UsuarioResponse(user);

        return ResponseEntity.ok().body(response);
    }


}
