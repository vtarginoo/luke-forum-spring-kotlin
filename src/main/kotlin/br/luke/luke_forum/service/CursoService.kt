package br.luke.luke_forum.service

import br.luke.luke_forum.model.Curso
import br.luke.luke_forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository ) {


    fun buscarPorId(idCurso: Long): Curso {

        return repository.getReferenceById(idCurso)


    }

}
