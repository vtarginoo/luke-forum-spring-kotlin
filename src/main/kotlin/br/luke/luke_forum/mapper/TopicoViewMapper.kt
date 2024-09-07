package br.luke.luke_forum.mapper

import br.luke.luke_forum.dto.TopicoView
import br.luke.luke_forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico,TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(t.id, t.titulo, t.mensagem, t.status, t.dataCriacao)
    }


}