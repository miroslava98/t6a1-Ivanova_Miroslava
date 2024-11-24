package com.example.t6a1_ivanova_miroslava.pojos

class Disco(
    private var nombre: String,
    private var artista: String,
    private var anyo: Int,
    private var canciones: List<Cancion>
) {
    fun getNombre(): String {
        return nombre
    }

    fun getArtista(): String {
        return artista
    }

    fun getAnyo(): Int {
        return anyo
    }

    fun getCanciones(): List<Cancion> {
        return canciones
    }
}


class DiscoDatos {
    companion object {
        val DISCOS = arrayListOf(
            Disco(
                "Still Got the Blues", "Gary Moore", 1990, listOf(
                    Cancion(1, "Still Got the Blues", 4.10f),
                    Cancion(2, "Texas Strut", 4.51f),
                    Cancion(3, "Too Tired", 2.50f)
                )
            ),
            Disco(
                "Abbey Road", "The Beatles", 1969, listOf(
                    Cancion(1, "Come Together", 4.20f),
                    Cancion(2, "Something", 3.03f),
                    Cancion(3, "Maxwell's Silver Hammer", 3.27f),
                    Cancion(4, "Oh! Darling", 3.26f),
                    Cancion(5, "Octopus's Garden", 2.51f),
                    Cancion(6, "I Want You (She's So Heavy)", 7.47f),
                    Cancion(7, "Here Comes the Sun", 3.05f),
                    Cancion(8, "Because", 2.45f),
                    Cancion(9, "You Never Give Me Your Money", 4.02f),
                    Cancion(10, "Sun King", 2.26f),
                    Cancion(11, "Mean Mr. Mustard", 1.06f),
                    Cancion(12, "Polythene Pam", 1.13f),
                    Cancion(13, "She Came In Through the Bathroom Window", 1.57f),
                    Cancion(14, "Golden Slumbers", 1.31f),
                    Cancion(15, "Carry That Weight", 1.36f),
                    Cancion(16, "The End", 2.20f),
                    Cancion(17, "Her Majesty", 0.23f)
                )
            ),
            Disco(
                "Thriller", "Michael Jackson", 1982, listOf(
                    Cancion(1, "Wanna Be Startin' Somethin'", 6.03f),
                    Cancion(2, "Baby Be Mine", 4.20f),
                    Cancion(3, "The Girl Is Mine", 3.42f),
                    Cancion(4, "Thriller", 5.57f),
                    Cancion(5, "Beat It", 4.18f),
                    Cancion(6, "Billie Jean", 4.54f),
                    Cancion(7, "Human Nature", 4.05f),
                    Cancion(8, "P.Y.T. (Pretty Young Thing)", 3.59f),
                    Cancion(9, "The Lady in My Life", 4.59f)
                )
            ),
            Disco(
                "Back in Black", "AC/DC", 1980, listOf(
                    Cancion(1, "Hells Bells", 5.12f),
                    Cancion(2, "Shoot to Thrill", 5.17f),
                    Cancion(3, "What Do You Do for Money Honey", 3.33f),
                    Cancion(4, "Given the Dog a Bone", 3.30f),
                    Cancion(5, "Let Me Put My Love into You", 4.16f),
                    Cancion(6, "Back in Black", 4.15f),
                    Cancion(7, "You Shook Me All Night Long", 3.30f),
                    Cancion(8, "Have a Drink on Me", 3.58f),
                    Cancion(9, "Shake a Leg", 4.06f),
                    Cancion(10, "Rock and Roll Ain't Noise Pollution", 4.15f)
                )
            ),
            Disco(
                "Rumours", "Fleetwood Mac", 1977, listOf(
                    Cancion(1, "Second Hand News", 2.43f),
                    Cancion(2, "Dreams", 4.14f),
                    Cancion(3, "Never Going Back Again", 2.02f),
                    Cancion(4, "Don't Stop", 3.11f),
                    Cancion(5, "Go Your Own Way", 3.38f),
                    Cancion(6, "Songbird", 3.20f),
                    Cancion(7, "The Chain", 4.30f),
                    Cancion(8, "You Make Loving Fun", 3.36f),
                    Cancion(9, "I Don't Want to Know", 3.11f),
                    Cancion(10, "Oh Daddy", 3.58f),
                    Cancion(11, "Gold Dust Woman", 4.51f)
                )
            ),
            Disco(
                "Nevermind", "Nirvana", 1991, listOf(
                    Cancion(1, "Smells Like Teen Spirit", 5.01f),
                    Cancion(2, "In Bloom", 4.15f),
                    Cancion(3, "Come as You Are", 3.39f),
                    Cancion(4, "Breed", 3.03f),
                    Cancion(5, "Lithium", 4.17f),
                    Cancion(6, "Polly", 2.57f),
                    Cancion(7, "Territorial Pissings", 2.23f),
                    Cancion(8, "Drain You", 3.43f),
                    Cancion(9, "Lounge Act", 2.36f),
                    Cancion(10, "Stay Away", 3.32f),
                    Cancion(11, "On a Plain", 3.16f),
                    Cancion(12, "Something in the Way", 3.52f)
                )
            )
        )

    }
}
