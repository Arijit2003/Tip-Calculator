package com.example.tipcalculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.widget.addTextChangedListener
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.time.times
import kotlin.math.*
import java.lang.*
import kotlin.NumberFormatException

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    var tip:Double=0.0
    lateinit var cost:EditText
    lateinit var showTip:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radioGroup:RadioGroup=findViewById(R.id.rdGroup)
        cost=findViewById(R.id.editTextNumber)
        val calculate:Button=findViewById(R.id.calc)
        var switch:Switch=findViewById(R.id.round)
        showTip=findViewById(R.id.showTip)
        val amazing:RadioButton=findViewById(R.id.amazing)
        val good:RadioButton=findViewById(R.id.good)
        val ok:RadioButton=findViewById(R.id.ok)
        cost.setOnKeyListener { view, keyCode, event -> handleKeyEvent(view,keyCode) }
        cost.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                    if(amazing.isChecked){
                        tip=try {
                            ((cost.text.toString().toDouble())*20/100).toDouble()
                        }catch (e:NumberFormatException){
                            0.0
                        }
                    }
                    else if(good.isChecked){
                        tip=try {
                            ((cost.text.toString().toDouble())*18/100).toDouble()
                        }catch (e:NumberFormatException){
                            0.0
                        }
                    }
                    else if(ok.isChecked){
                        tip=try {
                            ((cost.text.toString().toDouble())*15/100).toDouble()
                        }catch (e:NumberFormatException){
                            0.0
                        }
                    }

            }

        })




        switch.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){
                if(amazing.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*20/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                else if(good.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*18/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                else if(ok.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*15/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }

                tip=(tip.roundToInt()).toDouble()
            }
            else{
                if(amazing.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*20/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                else if(good.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*18/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                else if(ok.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*15/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
            }

        }
        calculate.setOnClickListener(){
            if(switch.isChecked) {
                tip=(tip.roundToInt()).toDouble()
                showTip.text = "Tip Amount: $"+tip.toString()
            }
            else{
                if(amazing.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*20/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                else if(good.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*18/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                else if(ok.isChecked){
                    tip=try {
                        ((cost.text.toString().toDouble())*15/100).toDouble()
                    }catch (e:NumberFormatException){
                        0.0
                    }
                }
                showTip.text = "Tip Amount: $"+tip.toString()
            }
        }

    }
    fun tipFunc(view:View){
        if(view is RadioButton) {

            if (view.isChecked) {
                when (view.id) {
                    R.id.amazing -> {
                        tip = try {
                            (cost.text.toString().toDouble() * 20 / 100).toDouble()
                        }catch (e:NumberFormatException){
                            0.0
                        }


                    }
                    R.id.good -> {
                        tip = try {
                            (cost.text.toString().toDouble() * 18 / 100).toDouble()
                        }catch (e:NumberFormatException){
                            0.0
                        }
                    }
                    R.id.ok -> {
                        tip = try {
                            (cost.text.toString().toDouble() * 15 / 100).toDouble()
                        }catch (e:NumberFormatException){
                            0.0
                        }
                    }
                }

            }
        }




        }
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }


}