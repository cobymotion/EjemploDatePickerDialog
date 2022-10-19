package mx.edu.tecmm.a06datapicker

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var fechita:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fechita = findViewById(R.id.edFechita)

        fechita.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(fechita.windowToken, 0)
            showDataPickerDialog();
        }
    }

    fun showDataPickerDialog(){
        val newFragment = DatePickerDateFragment.newInstance(DatePickerDialog
            .OnDateSetListener { _, year, month, day ->
            val selectedDate = day.toString() + " / " + (month + 1) + " / " + year
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(fechita.windowToken, 0)
            fechita.setText(selectedDate)
        })
        newFragment.show(supportFragmentManager, "datePicker")


    }
}