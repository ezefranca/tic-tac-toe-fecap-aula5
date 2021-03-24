package br.fecapp.tictactoe

import android.graphics.Color
import android.graphics.*
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Shader.TileMode
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var deQuemEhAVez: Boolean = true
    var acabouAPartida: Boolean = false

    var jogador1 : ArrayList<Int> = ArrayList<Int>()
    var jogador2 : ArrayList<Int> = ArrayList<Int>()

    var jogador1Venceu: Boolean = false
    var jogador2Venceu: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        estilizarTexto()
    }

    fun estilizarTexto() {
        val textoTituloGame : TextView = findViewById(R.id.textoTitulo)

        val gradiente = LinearGradient(
                0F, // x0, x-coordinate for the start of the gradient line
                0F, // y0,  y-coordinate for the start of the gradient line
                100F, // x1,  x-coordinate for the end of the gradient line
                // y1, y-coordinate for the end of the gradient line
                textoTituloGame.height.toFloat(),
                // color0, sRGB color at the start of the gradient line
                Color.parseColor("#2980b9"),
                // color1, sRGB color at the end of the gradient line
                Color.parseColor("#8e44ad"),
                // shader tiling mode
                Shader.TileMode.MIRROR
        )

        textoTituloGame.paint.shader = gradiente
    }

    fun pegarBotaoClicado(viewClicada: View) {

        val textoGameOver : TextView = findViewById(R.id.textoGameOver)
        val botaoReset : Button = findViewById(R.id.botaoReset)

        // Faz o cast (conversão de View para Button)
        val botaoClicado: Button = viewClicada as Button

        // Pega o ID do botão clicado
        val idDoBotaoClicado: Int = botaoClicado.id

        if (idDoBotaoClicado == R.id.botaoReset) {
            textoGameOver.visibility = View.GONE
            botaoReset.visibility = View.GONE
        }

        // Verifica se o botão já foi clicado pelo jogador 1 ou jogador 2, caso sim, ele encerra a função com return
        // Verifica que a partida acabou, caso sim, faz um return e não adiciona nenhum X ou O novo.
        if ((jogador1.contains(idDoBotaoClicado) || jogador2.contains(idDoBotaoClicado)) || acabouAPartida) {
            // encerra a função
            return
        }

        // Lógica dos nossos turnos
        var simboloDaVez: String = "X"



        if (deQuemEhAVez) {
            simboloDaVez = "O"
            jogador1.add(idDoBotaoClicado)
            jogador1Venceu = checaSeJogadorVenceu(jogador1)

            if(jogador1Venceu) {
                acabouAPartida = true
                println("JOGADOR 1 UM VENCEU")
                textoGameOver.visibility = View.VISIBLE
                botaoReset.visibility = View.VISIBLE
                textoGameOver.text = "Jogador: $simboloDaVez WIN!! "
            }

        } else {
            simboloDaVez = "X"
            jogador2.add(idDoBotaoClicado)

            jogador2Venceu = checaSeJogadorVenceu(jogador2)

            if(jogador2Venceu) {
                acabouAPartida = true
                println("JOGADOR 2 DOIS VENCEU")
                textoGameOver.visibility = View.VISIBLE
                botaoReset.visibility = View.VISIBLE
                textoGameOver.text = "Jogador: $simboloDaVez WIN!! "
            }


        }
        // inverte o valor de quem eh a vez
        deQuemEhAVez = !deQuemEhAVez


        // Fim da Lógica dos turnos

        // Pegamos os IDS utilizando o R e comparamos com o nosso botao clicado ID
        // When substitui os nossos if else quando utilizamos kotlin
        when (idDoBotaoClicado) {
                R.id.botao_0_0 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_0_1 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_0_2 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_1_0 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_1_1 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_1_2 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_2_0 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_2_1 -> {
                    botaoClicado.setText(simboloDaVez)
                }
                R.id.botao_2_2 -> {
                    botaoClicado.setText(simboloDaVez)
                }
            }





    }

    fun checaSeJogadorVenceu(jogador: ArrayList<Int>): Boolean {
        // Lógica das Linhas
        if (jogador.contains(R.id.botao_0_0) && jogador.contains(R.id.botao_0_1) && jogador.contains(R.id.botao_0_2)) {
            return true
        }
        else if (jogador.contains(R.id.botao_1_0) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_1_2)) {
            return true
        }
        else if (jogador.contains(R.id.botao_2_0) && jogador.contains(R.id.botao_2_1) && jogador.contains(R.id.botao_2_2)) {
            return true
        // Lógica das Colunas
        }
        else if (jogador.contains(R.id.botao_0_0) && jogador.contains(R.id.botao_1_0) && jogador.contains(R.id.botao_2_0)) {
            return true
        }
        else if (jogador.contains(R.id.botao_0_1) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_2_1)) {
            return true
        }
        else if (jogador.contains(R.id.botao_0_2) && jogador.contains(R.id.botao_1_2) && jogador.contains(R.id.botao_2_2)) {
            return true
        }
        // Lógica das Diagonais
        else if (jogador.contains(R.id.botao_0_0) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_2_2)) {
            return true
        }
        else if (jogador.contains(R.id.botao_0_2) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_2_2)) {
            return true
        }
        return false
        /*
   0 0 | 0 1 | 0 2
   1 0 | 1 1 | 1 2
   2 0 | 2 1 | 2 2


 */
    }
}