package com.hugoyago.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.EditText
import android.widget.ImageView
import com.hugoyago.portfolio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Calcular.setOnClickListener{ descobrirSigno() }

        val dayInput = findViewById<EditText>(R.id.DiaText)
        dayInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "31")
        )

        val monthInput = findViewById<EditText>(R.id.MesText)
        monthInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "12")
        )

    }

    fun descobrirSigno() {
        val MonthText = binding.MesText.text.toString()
        val mesInt = MonthText.toInt()

        val DayText = binding.DiaText.text.toString()
        val dayInt = DayText.toInt()

        val SignoImage: ImageView = findViewById(R.id.signo)
        val SignoText = binding.signoText

        when(mesInt) {
            1 -> if(dayInt >= 1 && dayInt < 20) {
                SignoImage.setImageResource(R.drawable.capricornio)
                SignoText.text = "Shura de Capricórnio"
            } else {
                SignoImage.setImageResource(R.drawable.aquario)
                SignoText.text = "Camus de Aquário"
            }
            2 -> if(dayInt >= 1 && dayInt < 20) {
                SignoImage.setImageResource(R.drawable.aquario)
                SignoText.text = "Camus de Aquário"
            } else {
                SignoImage.setImageResource(R.drawable.peixes)
                SignoText.text = "Afrodite de Peixes"
            }
            3 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.peixes)
                SignoText.text = "Afrodite de Peixes"
            } else {
                SignoImage.setImageResource(R.drawable.aries)
                SignoText.text = "Mu de Áries"
            }
            4 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.aries)
                SignoText.text = "Mu de Áries"
            } else {
                SignoImage.setImageResource(R.drawable.touro)
                SignoText.text = " Aldebaran de Touro"
            }
            5 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.touro)
                SignoText.text = " Aldebaran de Touro"
            } else {
                SignoImage.setImageResource(R.drawable.gemeos)
                SignoText.text = "Saga de Gêmeos"
            }
            6 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.gemeos)
                SignoText.text = "Saga de Gêmeos"
            } else {
                SignoImage.setImageResource(R.drawable.cancer)
                SignoText.text = "Máscara da Morte de Câncer"
            }
            7 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.cancer)
                SignoText.text = "Máscara da Morte de Câncer"
            } else {
                SignoImage.setImageResource(R.drawable.leao)
                SignoText.text = "Aioria de Leão"
            }
            8 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.leao)
                SignoText.text = "Aioria de Leão"
            } else {
                SignoImage.setImageResource(R.drawable.virgem)
                SignoText.text = "Shaka de Virgem"
            }
            9 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.virgem)
                SignoText.text = "Shaka de Virgem"
            } else {
                SignoImage.setImageResource(R.drawable.libra)
                SignoText.text = "Dohko de Libra"
            }
            10 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.libra)
                SignoText.text = "Dohko de Libra"
            } else {
                SignoImage.setImageResource(R.drawable.escorpi_o)
                SignoText.text = "Milo de Escorpião"
            }
            11 -> if(dayInt >= 1 && dayInt < 22) {
                SignoImage.setImageResource(R.drawable.escorpi_o)
                SignoText.text = "Milo de Escorpião"
            } else {
                SignoImage.setImageResource(R.drawable.sagitario)
                SignoText.text = "Aioros de Sagitário"
            }
            12 -> if(dayInt >= 1 && dayInt < 22) {
                SignoImage.setImageResource(R.drawable.sagitario)
                SignoText.text = "Aioros de Sagitário"
            } else {
                SignoImage.setImageResource(R.drawable.capricornio)
                SignoText.text = "Shura de Capricórnio"
            }
        }

    }

} //Aioria de Leão, Shaka de Virgem, Dohko de Libra, Milo de Escorpião, Aioros de Sagitário

class InputFilterMinMax : InputFilter {
    private var min: Int
    private var max: Int

    constructor(minValue: Int, maxValue: Int) {
        this.min = minValue
        this.max = maxValue
    }

    constructor(minValue: String, maxValue: String) {
        this.min = minValue.toInt()
        this.max = maxValue.toInt()
    }

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = (dest.toString() + source.toString()).toInt()
            if (isInRange(min, max, input)) return null
        } catch (nfe: NumberFormatException) {
        }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}