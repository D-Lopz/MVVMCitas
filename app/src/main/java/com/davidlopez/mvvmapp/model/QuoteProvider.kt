package com.davidlopez.mvvmapp.model

class QuoteProvider {
    companion object{
        fun random():QuoteModel{
            val position = (quoteList.indices).random()
            return quoteList[position]
        }

        val quoteList = listOf<QuoteModel>(
            QuoteModel("Si las olas del mar chocan con las del río, por que entocnes ese par de Nalgas no chocan con los huevos mios.", "J. Robert Oppenheimer"),
            QuoteModel("Si por besarte fuera al infierno, lo haría solo para presumir que estuve en el paraíso sin tocar el cierlo ", "Brad pitt"),
            QuoteModel("So live a life yo will remember ", "Avicci"),
            QuoteModel("Toda masa aumenta su volumen según el grado de inclinación", "Isaac Newton"),
            QuoteModel("Las patadas son la gasolina de las mujeres", "Samuel Mendez"),
            QuoteModel("No subo gordas pq raya ", "Anonimo")

        )
    }
}