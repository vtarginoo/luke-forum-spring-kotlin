package br.luke.luke_forum.controller

import br.luke.luke_forum.dto.AtualizacaoTopicoForm
import br.luke.luke_forum.dto.NovoTopicoForm
import br.luke.luke_forum.dto.TopicoView
import br.luke.luke_forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {



    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: NovoTopicoForm,
                  uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView>{

        val response = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${response.id}").build().toUri()

        return  ResponseEntity.created(uri).body(response)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        var response = service.atualizar(form)

        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {

        service.deletar(id)

    }




}
