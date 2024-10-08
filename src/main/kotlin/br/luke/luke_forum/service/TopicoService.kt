package br.luke.luke_forum.service

import br.luke.luke_forum.dto.AtualizacaoTopicoForm
import br.luke.luke_forum.dto.NovoTopicoForm
import br.luke.luke_forum.dto.TopicoPorCategoriaDto
import br.luke.luke_forum.dto.TopicoView
import br.luke.luke_forum.exception.NotFoundException
import br.luke.luke_forum.mapper.TopicoFormMapper
import br.luke.luke_forum.mapper.TopicoViewMapper
import br.luke.luke_forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service



@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "tópico não encontrado"

) {



    fun listar(
        nomeCurso:String?,
        paginacao: Pageable
    ): Page<TopicoView> {

        val topicos = if (nomeCurso==null) {
            repository.findAll(paginacao)
        } else {repository.findByCursoNome(nomeCurso, paginacao) }

        return topicos.map { t -> topicoViewMapper.map(t)}
    }

    fun buscarPorId(id: Long): TopicoView {
        val t = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(t)
    }


    fun cadastrar (form: NovoTopicoForm):TopicoView {


        val topico = topicoFormMapper.map(form)
        repository.save(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm):TopicoView {

        val topico = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)

    }

    fun relatorio():List<TopicoPorCategoriaDto> {

       return repository.relatorio()
    }


}


