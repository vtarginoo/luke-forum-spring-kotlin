package br.luke.luke_forum.service


import br.luke.luke_forum.model.Usuario
import br.luke.luke_forum.repository.UsuarioRepository
import org.springframework.stereotype.Service



@Service
class UsuarioService(private val repository: UsuarioRepository) {


    fun buscarPorId(idUsuario: Long): Usuario {
       return repository.getReferenceById(idUsuario)

    }





}