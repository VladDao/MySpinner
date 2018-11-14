package com.example.vlad.mysoinner

import android.app.Activity
import android.app.NativeActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener



class MainActivity : Activity() {
    lateinit var selected: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner = findViewById(R.id.mySpinner) as Spinner

            selected = spinner.selectedItem.toString()
            Toast.makeText(applicationContext, selected, Toast.LENGTH_SHORT).show();

        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 val selectedItem = parent!!.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, selectedItem, Toast.LENGTH_SHORT).show();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
