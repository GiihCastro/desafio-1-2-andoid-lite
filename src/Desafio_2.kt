data class Livro(
    val nome: String,
    val genero: String,
    val autor: String,
    val paginasTotais: Int,
    val paginasLidas: Int
) {
    fun progressao(): Double {
        return if (paginasTotais > 0) {
            (paginasLidas.toDouble() / paginasTotais) * 100
        } else {
            0.0
        }
    }
}

fun main() {
    
    val livros = mutableListOf<Livro>()

    while (true) {
        println("\nMenu:")
        println("1. Cadastrar livro")
        println("2. Consultar por nome")
        println("3. Consultar por gênero")
        println("4. Consultar por autor")
        println("5. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> cadastrarLivro(livros)
            2 -> consultar(livros, "nome")
            3 -> consultar(livros, "gênero")
            4 -> consultar(livros, "autor")
            5 -> break
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun cadastrarLivro(livros: MutableList<Livro>) {
    println("\nCadastro de Livro")

    print("Nome do livro: ")
    val nome = readLine() ?: ""

    print("Gênero: ")
    val genero = readLine() ?: ""

    print("Autor: ")
    val autor = readLine() ?: ""

    val paginasTotais = lerNumeroInteiro("Número total de páginas: ")
    val paginasLidas = lerNumeroInteiro("Número de páginas lidas: ")

    livros.add(Livro(nome, genero, autor, paginasTotais, paginasLidas))
    println("Livro cadastrado com sucesso!")
}

fun consultar(livros: List<Livro>, criterio: String) {
    print("\nDigite o $criterio para consulta: ")
    val pesquisa = readLine() ?: ""

    val resultado = when (criterio) {
        "nome" -> livros.filter { it.nome.contains(pesquisa, ignoreCase = true) }
        "gênero" -> livros.filter { it.genero.contains(pesquisa, ignoreCase = true) }
        "autor" -> livros.filter { it.autor.contains(pesquisa, ignoreCase = true) }
        else -> emptyList()
    }

    if (resultado.isEmpty()) {
        println("Nenhum livro encontrado.")
    } else {
        println("\nResultados encontrados:")
        resultado.forEach { livro ->
            println("Nome do livro: ${livro.nome}")
            println("Número total de páginas: ${livro.paginasTotais}")
            println("Número de páginas lidas: ${livro.paginasLidas}")
            println("Gênero: ${livro.genero}")
            println("Autor: ${livro.autor}")
            println("Progressão de leitura: %.2f%%".format(livro.progressao()))
            println()
        }
    }
}

fun lerNumeroInteiro(mensagem: String): Int {
    while (true) {
        print(mensagem)
        val entrada = readLine()
        val numero = entrada?.toIntOrNull()
        if (numero != null && numero >= 0) {
            return numero
        } else {
            println("Entrada inválida. Por favor, insira um número inteiro não negativo.")
        }
    }
}