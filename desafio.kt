enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(vararg novoAluno: Aluno) {
        for (aluno in novoAluno) {
            this.inscritos.add(aluno)
        }
        println("Alunos matriculados com sucesso!")
    }
}

fun main() {
    val joao = Aluno("João")
    val maria = Aluno("Maria")
    
    val pooComKotlin = ConteudoEducacional("POO com Kotlin", 120)
    val apiComKotlinESpringBoot = ConteudoEducacional("Criando uma API com Kotlin e Spring Boot", 180)
    
    val formacaoBackEnd = Formacao("Formação Dev Back end", listOf(pooComKotlin, apiComKotlinESpringBoot), Nivel.BASICO)
    
    formacaoBackEnd.matricular(joao, maria)
    
    println("\nAlunos matriculados no curso ${formacaoBackEnd.nome}:")
    for (aluno in formacaoBackEnd.inscritos) {
        println("Nome: " + aluno.nome)
    }
    
    println("\nConteúdo do curso ${formacaoBackEnd.nome}:")
    for (conteudo in formacaoBackEnd.conteudos) {
        println("Nome: ${conteudo.nome} - Duração: ${conteudo.duracao}min")
    }
    
}