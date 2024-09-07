package br.luke.luke_forum.service

import br.luke.luke_forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private var cursos : List<Curso>) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        )
        cursos = listOf(curso)
    }


    fun buscarPorId(idCurso: Long): Curso {

        return cursos.stream().filter{c -> c.id == idCurso}.findFirst().get()


    }

}
