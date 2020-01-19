package com.example.bdt

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.textViewName
import kotlinx.android.synthetic.main.recyclerview_item.*
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() {
private var dob:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        button4.setOnClickListener {
            val cal: Calendar = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener{
                view:DatePicker?,year:Int,month:Int,dayOfMonth:Int ->
                cal.set(year,month,dayOfMonth)
                dob = SimpleDateFormat("yyyy.MM.dd").format(cal).toLong()
                button3.text= SimpleDateFormat("yyyy.MM.dd").format(cal)
            }
            DatePickerDialog(this,dateSetListener,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        button4.setOnClickListener{
            val intent =Intent()
            val name = editText.text.toString()
            intent.putExtra(EXTRA_NAME,name)
            intent.putExtra(EXTRA_DOB,dob)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }



    }
    companion object{
         const val EXTRA_NAME =".com.examnple.bdt.NAME"
         const val EXTRA_DOB =".com.examnple.bdt.DOB"
    }

}
