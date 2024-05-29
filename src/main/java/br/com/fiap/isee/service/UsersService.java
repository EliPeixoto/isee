package br.com.fiap.isee.service;

import br.com.fiap.isee.controller.exception.ControllerNotFoundException;
import br.com.fiap.isee.entities.Users;
import br.com.fiap.isee.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Service
public class UsersService {
    @Autowired
    private UsersRepository repository;

    public Collection<Users> findAll(){
        var usuarios = repository.findAll();
        return usuarios;
    }

    public Users findById(String id){
        var usuario = repository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Usuario não encontrado!"));
        return usuario;
    }

    public Users save(@RequestBody Users users){
       return repository.save(users);
    }

    public Users update(String id, Users users){
       try {
           Users buscaUsers = repository.getOne(id);
           buscaUsers.setNome(users.getNome());
           buscaUsers.setEmail(users.getEmail());
           buscaUsers.setSenha(users.getSenha());
           buscaUsers = repository.save(users);
           return buscaUsers;
       }catch (EntityNotFoundException e){
           throw new ControllerNotFoundException("Usuario não encontrado!");
       }


    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
