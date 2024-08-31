fun main() {
    fun lerNumeroInteiro(mensagem: String): Int {
        while (true) {
            print(mensagem)
            val entrada = readLine()
            try {
                val numero = entrada?.toIntOrNull()
                if (numero != null && numero >= 0) {
                    return numero
                } else {
                    println("Entrada inválida. Por favor, insira um número inteiro não negativo.")
                }
            } catch (e: NumberFormatException) {
                println("Entrada inválida. Por favor, insira um número inteiro.")
            }
        }
    }

    print("Digite o nome do livro: ")
    val nomeDoLivro = readLine() ?: ""

    val paginasTotais = lerNumeroInteiro("Digite o número total de páginas do livro ${nomeDoLivro}: ")

    val paginasLidas = lerNumeroInteiro("Digite o número de páginas lidas do livro ${nomeDoLivro}: ")

    val progresso = if (paginasTotais > 0) {
        (paginasLidas.toDouble() / paginasTotais) * 100
    } else {
        0.0
    }
    println("\n")
    println("Nome do livro: ${nomeDoLivro}")
    println("Progressão de leitura: %.2f%%".format(progresso))
}