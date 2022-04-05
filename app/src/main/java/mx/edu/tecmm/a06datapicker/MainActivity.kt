package mx.edu.tecmm.a06datapicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var fechita:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fechita = findViewById(R.id.edFechita)

        fechita.setOnClickListener {
            showDataPickerDialog();
        }
    }

    fun showDataPickerDialog(){
        val newFragment = DatePickerDateFragment.newInstance(DatePickerDialog
            .OnDateSetListener { _, year, month, day ->
            val selectedDate = day.toString() + " / " + (month + 1) + " / " + year
            fechita.setText(selectedDate)
        })
        newFragment.show(supportFragmentManager, "datePicker")
    }
}