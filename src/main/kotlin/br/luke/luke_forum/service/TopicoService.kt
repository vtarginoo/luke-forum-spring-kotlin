package br.luke.luke_forum.service

import br.luke.luke_forum.dto.AtualizacaoTopicoForm
import br.luke.luke_forum.dto.NovoTopicoForm
import br.luke.luke_forum.dto.TopicoView
import br.luke.luke_forum.mapper.TopicoFormMapper
import br.luke.luke_forum.mapper.TopicoViewMapper
import br.luke.luke_forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList


@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper

) {



    fun listar(): List<TopicoView> {
        println("ta funcionando")
        return topicos.stream().map { t -> topicoViewMapper.map(t)  }
            .collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewMapper.map(t)
    }


    fun cadastrar (form: NovoTopicoForm):TopicoView {


        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm):TopicoView {

        val t = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()

        t.titulo = form.titulo
        t.mensagem = form.mensagem

        return topicoViewMapper.map(t)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicos = topicos.minus(topico)
    }


}


