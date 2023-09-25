enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

open class Usuario(val nome: String, val sobrenome: String, val idade: Int)

data class Aluno(val usuario: Usuario , val matricula: String)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    fun matricular(aluno: Aluno) {
      //("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        println("----------------------------- MATRICULADOS --------------------------------")
        println("Aluno: ${aluno.usuario.nome} Matricula: ${aluno.matricula} => Matriculado na formacao =>  ${this.nome}")
    }
}

fun main() {
    //("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    val conteudosEducacionaisBasic = listOf<ConteudoEducacional>(ConteudoEducacional("HTML", 120), ConteudoEducacional("Git", 10), ConteudoEducacional("Scrum", 20), ConteudoEducacional("Relacionamento Interpessoal", 40))
    val conteudosEducacionaisIntermediate = listOf<ConteudoEducacional>(ConteudoEducacional("Java", 120), ConteudoEducacional("C++", 100), ConteudoEducacional("Kotlin"), ConteudoEducacional("C#"))
    val conteudosEducacionaisDificil = listOf<ConteudoEducacional>(ConteudoEducacional("Design Systems", 300), ConteudoEducacional("Gerenciamento de Projetos", 100), ConteudoEducacional("Cloud", 150), ConteudoEducacional("Design Patterns"))

    val alunos = arrayListOf<Aluno>()

    //Inscritos
    val aluno1 = Aluno(Usuario("Mane", "Garrincha", 34), matricula = "123445")
    val aluno2 = Aluno(Usuario("Edson", "Arantes",45), matricula = "234456")
    val aluno3 = Aluno(Usuario("Joao", "Paulo", 42), matricula = "34567")
    val aluno4 = Aluno(Usuario("Brunno", "Marcio",43), matricula = "465789")
    val aluno5 = Aluno(Usuario("Tercio", "Limeira", 24), matricula = "56987")
    val aluno6 = Aluno(Usuario("Marcio", "Silva",22), matricula = "98745")


    val formacaoBasica = Formacao(Nivel.BASICO.toString(), conteudosEducacionaisBasic)
    val formacaoIntermediaria = Formacao(Nivel.INTERMEDIARIO.toString(), conteudosEducacionaisIntermediate)
    val formacaoDificil = Formacao(Nivel.DIFICIL.toString(), conteudosEducacionaisDificil)

    println("----------------------------- ALUNOS --------------------------------")
    alunos.add(aluno1)
    alunos.add(aluno2);
    alunos.add(aluno3)
    alunos.add(aluno4);
    alunos.add(aluno5)
    alunos.add(aluno6);


    alunos.forEach {

        println("Aluno: ${it.usuario.nome} ${it.usuario.sobrenome} - Idade: ${it.usuario.idade} - Matricula: ${it.matricula} ")
    }


    for(aluno in alunos){

        when (aluno.usuario.idade % 6) {
            0,5 -> {
                formacaoBasica.inscritos.add(aluno)
                formacaoBasica.matricular(aluno)
            }
            1,4 -> {
                formacaoIntermediaria.inscritos.add(aluno)
                formacaoIntermediaria.matricular(aluno)
            }
            2,3 -> {
                formacaoDificil.inscritos.add(aluno)
                formacaoDificil.matricular(aluno)
            }
            else -> { // Note the block
                print("Sem formacao")
            }
        }

    }
   
}
