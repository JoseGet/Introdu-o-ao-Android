package com.example.ocean_androis_intro_fevereiro_2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Criar um listener para o botão
        // Encontrar o botão pelo id.

        // findViewById -> método que encontra View no Layout usando ID
        // Dentro dos <>, informamaos o tipo do elemento que estamos buscando
        // Dentro dos (), informamos o ID do elemento, usando R.id para buscar
        // Depois, armazenamos numa variável
        val btEnviar = findViewById<Button>(R.id.btEnviar);
        val tvResultado = findViewById<TextView>(R.id.tvResultado);
        val txCaixa = findViewById<TextInputEditText>(R.id.txCaixa);

        var newWord: String;

        // Criar um Listener para o botão enviar
        btEnviar.setOnClickListener {
            // quando o clique (toque) ocorre no botão
            newWord = txCaixa.text.toString()

            if(newWord.isBlank())
            {
                txCaixa.error = "Por favor, digite um nome valido!";
            } else
            {
                tvResultado.text = newWord;
            }

        }

        val btNovaTela = findViewById<Button>(R.id.btNewActivity)

        btNovaTela.setOnClickListener {

            // Abrir a Activity Resultado
            // Registrar a intenção (Intent) de abrir a tela

            // Para abrir a Activity: Intent que sabe onde estamos e para onde vamos
            //  -> De onde estamos: this(MainActivity)
            //  -> Para onde vamos: ResultadoActivity::class.java
            val resultadoIntent = Intent(this, ResultadoActivity::class.java);

            //  Adicionar dados a Intent (putExtra)
            // -> Nome para a informação: NOME_DIGITADO
            // -> Valor da informação: String obtido a partir de etNome.text
            resultadoIntent.putExtra("NOME_DIGITADO", txCaixa.text.toString())

            // Inicia a tela a partir dessa Intent
            startActivity(resultadoIntent);

        }

    }
}