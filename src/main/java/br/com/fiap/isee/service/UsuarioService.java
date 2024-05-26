package br.com.fiap.isee.service;

import br.com.fiap.isee.entities.Usuario;
import br.com.fiap.isee.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Collection<Usuario> findAll(){
        var usuarios = repository.findAll();
        return usuarios;
    }

    public Optional<Usuario>findById(UUID id){
        var usuario = repository.findById(id);
        return usuario;
    }

    public Usuario save(@RequestBody Usuario usuario){
       return repository.save(usuario);
    }

    public Usuario update(UUID id, Usuario usuario){
        Usuario buscaUsuario = repository.getOne(id);
        buscaUsuario.setNome(usuario.getNome());
        buscaUsuario.setEmail(usuario.getEmail());
        buscaUsuario.setSenha(usuario.getSenha());
        buscaUsuario = repository.save(usuario);
        return buscaUsuario;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}
