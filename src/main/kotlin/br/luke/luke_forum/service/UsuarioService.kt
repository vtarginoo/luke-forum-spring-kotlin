package br.luke.luke_forum.service


import br.luke.luke_forum.model.Usuario
import org.springframework.stereotype.Service



@Service
class UsuarioService(private var usuarios : List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com.br"
        )
        usuarios = listOf(usuario)
    }




    fun buscarPorId(idUsuario: Long): Usuario {
       return usuarios.stream().filter{u -> u.id == idUsuario}.findFirst().get()

    }





}