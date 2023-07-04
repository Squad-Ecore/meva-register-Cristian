package com.meva.finance.api;


import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.dto.response.UsuarioResponse;
import com.meva.finance.entity.Usuario;
import com.meva.finance.exception.entityException.ValidFamilyException;
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


    @PostMapping(value = "/salvar")
    public ResponseEntity<UsuarioResponse> save(@RequestBody UsuarioRequest usuarioRequest) throws ValidFamilyException {
        Usuario user = usuarioService.save(usuarioRequest);
        UsuarioResponse response = new UsuarioResponse(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(value = "/delete/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String cpf) {

        usuarioService.deleteId(cpf);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioResponse> update(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario user = usuarioService.update(usuarioRequest);
        UsuarioResponse response = new UsuarioResponse(user);

        return ResponseEntity.ok().body(response);
    }

}
