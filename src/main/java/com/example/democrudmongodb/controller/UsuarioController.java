package com.example.democrudmongodb.controller;

import com.example.democrudmongodb.Document.Usuario;
import com.example.democrudmongodb.dao.api.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuariosRepo;
    @PostMapping
    public ResponseEntity<?> saveUsuarios(@RequestBody Usuario usuarios){
        try {
           Usuario userSave =  usuariosRepo.save(usuarios);
           return new ResponseEntity<Usuario>(userSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllUsuarios(){
        try {
            List<Usuario> usuario = usuariosRepo.findAll();
            return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUsuarios(@RequestBody Usuario usuarios){
        try {
            Usuario userSave =  usuariosRepo.save(usuarios);
            return new ResponseEntity<Usuario>(userSave, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUsuarios(@PathVariable("id") Integer id){
        try {
            usuariosRepo.deleteById(id);
            return new ResponseEntity<String>("Fue eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}