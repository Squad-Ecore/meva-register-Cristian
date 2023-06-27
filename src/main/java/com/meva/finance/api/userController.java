package com.meva.finance.api;


import com.meva.finance.dto.UsuarioDto;
import com.meva.finance.entity.Usuario;
import com.meva.finance.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class userController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/salvar")
//    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody UsuarioDto usuarioDto) {

        usuarioService.salva(usuarioDto);

    }

    @DeleteMapping(value = "/delete/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String cpf) {

        usuarioService.deleteId(cpf);
    }


    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UsuarioDto usuarioDto) {

        usuarioService.alterar(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findAll(){
        List<UsuarioDto> list = usuarioService.listUsuario();

        return ResponseEntity.ok().body(list);

    }

}
