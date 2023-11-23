package com.pmse.motivao

import kotlin.random.Random

data class Phrase(val descricao: String, val categoria: Int)
class Mock {

    private val infinito = MotivacaoKeys.CATEGORIAS.INFINITO
    private val feliz = MotivacaoKeys.CATEGORIAS.FELIZ
    private val sol = MotivacaoKeys.CATEGORIAS.SOL

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", feliz),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", feliz),
        Phrase("Quando está mais escuro, vemos mais estrelas!", feliz),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", feliz),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", feliz),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", feliz),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sol),
        Phrase("Você perde todas as chances que você não aproveita.", sol),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sol),
        Phrase("Enquanto não estivermos comprometidos, haverá hesitação!", sol),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sol),
        Phrase("Se você acredita, faz toda a diferença.", sol),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sol)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getFrase(value: Int): String {
        val filtered = listPhrases.filter { (it.categoria == value || value == infinito) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].descricao
    }


}