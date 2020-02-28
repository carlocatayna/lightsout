package com.example.catayna_exer3_lightsout

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var moveCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doneButton.setOnClickListener { addNickname(it) }
        nickname_text.setOnClickListener{ updateNickname(it) }
        setListeners()
    }

    private fun makeColored(view: View, listArray:List<View>) {

        var count = 0
        for(items in listArray) {
            if(items.id == view.id) {

                val background = listArray[count].background as ColorDrawable
                val color = background.color

                if(color != Color.BLACK){
                    listArray[count].setBackgroundColor(Color.BLACK)
                    moveCount++
                    val moveText = findViewById<TextView>(R.id.moveText)
                    moveText.text = moveCount.toString()
                }
                else {
                    listArray[count].setBackgroundColor(Color.YELLOW)
                    moveCount++
                    val moveText = findViewById<TextView>(R.id.moveText)
                    moveText.text = moveCount.toString()

                }

                if(count-5>=0) {
                    val background = listArray[count-5].background as ColorDrawable
                    val color = background.color

                    if(color != Color.BLACK){
                        listArray[count-5].setBackgroundColor(Color.BLACK)
                    }
                    else {
                        listArray[count-5].setBackgroundColor(Color.YELLOW)
                    }
                }

                if(count+5<=24) {
                    val background = listArray[count+5].background as ColorDrawable
                    val color = background.color

                    if(color != Color.BLACK){
                        listArray[count+5].setBackgroundColor(Color.BLACK)
                    }
                    else {
                        listArray[count+5].setBackgroundColor(Color.YELLOW)
                    }
                }

                if(count+1!=5 && count+1!=10 && count+1!=15 && count+1!=20 && count+1!=25){

                    val background = listArray[count+1].background as ColorDrawable
                    val color = background.color

                    if(color != Color.BLACK){
                        listArray[count+1].setBackgroundColor(Color.BLACK)
                    }
                    else {
                        listArray[count+1].setBackgroundColor(Color.YELLOW)
                    }
                }

                if(count!=0 && count-1!=4 && count-1!=9 && count-1!=14 && count-1!=19){

                    val background = listArray[count-1].background as ColorDrawable
                    val color = background.color

                    if(color != Color.BLACK){
                        listArray[count-1].setBackgroundColor(Color.BLACK)
                    }
                    else {
                        listArray[count-1].setBackgroundColor(Color.YELLOW)
                    }
                }

                break
            }
            count++
        }

        var out = 0;
        for (items in listArray){
            val background = items.background as ColorDrawable
            val color = background.color

            if(color==Color.BLACK) {
                out++
            }
        }
        if(out==25){
            Toast.makeText(this,"You win!", Toast.LENGTH_LONG).show()
        }
    }


    private fun setListeners() {

        val t1 = findViewById<TextView>(R.id.t1)
        val t2 = findViewById<TextView>(R.id.t2)
        val t3 = findViewById<TextView>(R.id.t3)
        val t4 = findViewById<TextView>(R.id.t4)
        val t5 = findViewById<TextView>(R.id.t5)
        val t6 = findViewById<TextView>(R.id.t6)
        val t7 = findViewById<TextView>(R.id.t7)
        val t8 = findViewById<TextView>(R.id.t8)
        val t9 = findViewById<TextView>(R.id.t9)
        val t10 = findViewById<TextView>(R.id.t10)
        val t11 = findViewById<TextView>(R.id.t11)
        val t12 = findViewById<TextView>(R.id.t12)
        val t13 = findViewById<TextView>(R.id.t13)
        val t14 = findViewById<TextView>(R.id.t14)
        val t15 = findViewById<TextView>(R.id.t15)
        val t16 = findViewById<TextView>(R.id.t16)
        val t17 = findViewById<TextView>(R.id.t17)
        val t18 = findViewById<TextView>(R.id.t18)
        val t19 = findViewById<TextView>(R.id.t19)
        val t20 = findViewById<TextView>(R.id.t20)
        val t21 = findViewById<TextView>(R.id.t21)
        val t22 = findViewById<TextView>(R.id.t22)
        val t23 = findViewById<TextView>(R.id.t23)
        val t24 = findViewById<TextView>(R.id.t24)
        val t25 = findViewById<TextView>(R.id.t25)


        val clickableViews: List<View> =
            listOf(
                t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,
                t21,t22,t23,t24,t25
            )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it,clickableViews) }

        }


    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        //hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val doneButton = findViewById<Button>(R.id.doneButton)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        //show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

}
