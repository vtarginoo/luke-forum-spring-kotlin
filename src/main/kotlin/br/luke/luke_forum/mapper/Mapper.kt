package br.luke.luke_forum.mapper

interface Mapper<T, U> {

    fun map(t:T):U

}
