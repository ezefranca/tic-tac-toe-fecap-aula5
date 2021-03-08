package br.fecapp.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var deQuemEhAVez: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pegarBotaoClicado(viewClicada: View) {

        // Faz o cast (conversão de View para Button)
        val botaoClicado: Button = viewClicada as Button

        // Pega o ID do botão clicado
        val idDoBotaoClicado: Int = botaoClicado.id


        // Lógica dos nossos turnos
        var simboloDaVez: String = "X"

        if (deQuemEhAVez) {
            simboloDaVez = "O"
        } else {
            simboloDaVez = "X"
        }
        // inverte o valor de quem eh a vez
        deQuemEhAVez = !deQuemEhAVez

        /*
            if(deQuemEhAVez == true) {
                deQuemEhAVez = false
            } else {
                deQuemEhAVez = true
            }

         */

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

}