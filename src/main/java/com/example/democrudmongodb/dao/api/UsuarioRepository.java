package com.example.democrudmongodb.dao.api;


import com.example.democrudmongodb.Document.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario,Integer> {

}
