package br.luke.luke_forum.mapper

import br.luke.luke_forum.dto.NovoTopicoForm
import br.luke.luke_forum.model.Topico
import br.luke.luke_forum.service.CursoService
import br.luke.luke_forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService,
                       private val usuarioService: UsuarioService,): Mapper<NovoTopicoForm, Topico>  {

    override fun map(t: NovoTopicoForm): Topico {

        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idUsuario) )

    }


}
