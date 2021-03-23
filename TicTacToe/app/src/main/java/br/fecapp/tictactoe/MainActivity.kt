package br.fecapp.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
    }

    fun pegarBotaoClicado(viewClicada: View) {

        // Faz o cast (conversão de View para Button)
        val botaoClicado: Button = viewClicada as Button

        // Pega o ID do botão clicado
        val idDoBotaoClicado: Int = botaoClicado.id

        // Logica do Reset
        if (idDoBotaoClicado == R.id.botao_reset) {
            val textoVitoriaID = R.id.textoVitoria
            val textoVitoriaTextView = findViewById<TextView>(textoVitoriaID)
            textoVitoriaTextView.visibility = View.GONE

            val botaoResetID = R.id.botao_reset
            val botaoReset = findViewById<Button>(botaoResetID)
            botaoReset.visibility = View.INVISIBLE
        }

        // Verifica se o botão já foi clicado pelo jogador 1 ou jogador 2, caso sim, ele encerra a função com return
        // Verifica que a partida acabou, caso sim, faz um return e não adiciona nenhum X ou O novo.
        if ((jogador1.contains(idDoBotaoClicado) || jogador2.contains(idDoBotaoClicado)) || acabouAPartida) {
            // encerra a função
            return
        }




        // Lógica dos nossos turnos
        var simboloDaVez: String = "X"
        var jogadorVitoriaFrase: String = "Jogador Venceu: "

        if (deQuemEhAVez) {
            simboloDaVez = "O"
            jogador1.add(idDoBotaoClicado)
            jogador1Venceu = checaSeJogadorVenceu(jogador1)

            if(jogador1Venceu) {
                acabouAPartida = true
                println("JOGADOR 1 UM VENCEU")
                jogadorVitoriaFrase = jogadorVitoriaFrase + " " + simboloDaVez
            }

        } else {
            simboloDaVez = "X"
            jogador2.add(idDoBotaoClicado)

            jogador2Venceu = checaSeJogadorVenceu(jogador2)

            if(jogador2Venceu) {
                acabouAPartida = true
                println("JOGADOR 2 DOIS VENCEU")
                jogadorVitoriaFrase = jogadorVitoriaFrase + " " + simboloDaVez
            }


        }
        // inverte o valor de quem eh a vez
        deQuemEhAVez = !deQuemEhAVez

        if (acabouAPartida) {
            val botaoResetID = R.id.botao_reset
            val botaoReset = findViewById<Button>(botaoResetID)
            botaoReset.visibility = View.VISIBLE


            val textoVitoriaID = R.id.textoVitoria
            val textoVitoriaTextView = findViewById<TextView>(textoVitoriaID)
            textoVitoriaTextView.visibility = View.VISIBLE
            textoVitoriaTextView.text = jogadorVitoriaFrase

        }

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
        } else if (jogador.contains(R.id.botao_2_0) && jogador.contains(R.id.botao_2_1) && jogador.contains(R.id.botao_2_2)) {
            return true
        // Lógica das Colunas
        } else if (jogador.contains(R.id.botao_0_0) && jogador.contains(R.id.botao_1_0) && jogador.contains(R.id.botao_2_0)) {
            return true
        } else if (jogador.contains(R.id.botao_0_1) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_2_1)) {
            return true
        } else if (jogador.contains(R.id.botao_0_2) && jogador.contains(R.id.botao_1_2) && jogador.contains(R.id.botao_2_2)) {
            return true
        // Lógica das Diagonais
        } else if (jogador.contains(R.id.botao_0_0) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_2_2)) {
            return true
        } else if (jogador.contains(R.id.botao_0_0) && jogador.contains(R.id.botao_1_1) && jogador.contains(R.id.botao_2_0)) {
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