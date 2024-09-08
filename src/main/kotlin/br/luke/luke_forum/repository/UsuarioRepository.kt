package br.luke.luke_forum.repository


import br.luke.luke_forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {





}