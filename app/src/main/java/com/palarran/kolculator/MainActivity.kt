package com.palarran.kolculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	//listens for which ever number button is pressed and sets that to variable displayNumber
	fun numberButtonEvent(view : View) {
		//checks if operationEvent is true and sets displayNumber to nothing
		if (operationEvent) displayNumber.setText("")

		operationEvent = false
		val buttonSelect = view as Button
		var buttonClickValue : String = displayNumber.text.toString()

		when (buttonSelect.id) {
			button_0.id -> buttonClickValue += "0"
			button_1.id -> buttonClickValue += "1"
			button_2.id -> buttonClickValue += "2"
			button_3.id -> buttonClickValue += "3"
			button_4.id -> buttonClickValue += "4"
			button_5.id -> buttonClickValue += "5"
			button_6.id -> buttonClickValue += "6"
			button_7.id -> buttonClickValue += "7"
			button_8.id -> buttonClickValue += "8"
			button_9.id -> buttonClickValue += "9"
			button_dot.id -> buttonClickValue += "." //TODO prevent from adding more that one dot
		    //TODO this key only changes number to neg, needs fixing or changed to something else
			buttonPlusMinus.id -> buttonClickValue = "-" + buttonClickValue
		}
		displayNumber.setText(buttonClickValue)
	}

	private var operator = "" //plus symbol is only a placeholder
	private var firstNumberEntered = ""
	private var operationEvent = true

	//listens for which ever operator button is pressed and sets that to variable operationEvent
	fun buttonOperatorEvent(view: View) {

		val buttonSelect = view as Button
		when (buttonSelect.id) {
			buttonDivide.id -> operator = "/"
			buttonMultiply.id -> operator = "*"
			buttonSubtract.id -> operator = "-"
			buttonAdd.id -> operator = "+"
		}
		firstNumberEntered = displayNumber.text.toString() //set displayNumber to firstNumberEntered
		operationEvent = true //clears operationEvent for next operation if needed
	}

	//listens for the equal button to be pressed and does the math from functions above
	fun buttonEqualEvent(view: View) {

		val newNumber = displayNumber.text.toString()//set new number to displayNumber
		var answer : Double? = null
		when (operator) {
			"/" -> answer = firstNumberEntered.toDouble() / newNumber.toDouble()
			"*" -> answer = firstNumberEntered.toDouble() * newNumber.toDouble()
			"-" -> answer = firstNumberEntered.toDouble() - newNumber.toDouble()
			"+" -> answer = firstNumberEntered.toDouble() + newNumber.toDouble()
		}
		displayNumber.setText(answer.toString())
		operationEvent = true
	}
}