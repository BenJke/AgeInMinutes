package ve.develop.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        select_date_button.setOnClickListener { view ->
            createDatePickerDialog(view)
        }
    }

    private fun createDatePickerDialog(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { view, chosenYear, chosenMonth, chosenDay ->

            val chosenDate = "$chosenDay/${chosenMonth+1}/$chosenYear"
            tv_date.text = chosenDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val formatedDate = sdf.parse(chosenDate)
            val dateInMinutes = formatedDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000
            val differenceInMinutes = currentDateInMinutes - dateInMinutes
            tv_date_in_minutes.text = differenceInMinutes.toString()

        }, year, month, day).show()
    }

}