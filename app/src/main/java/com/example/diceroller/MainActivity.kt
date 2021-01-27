package com.example.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Find the Button in the layout
        val roll = findViewById<Button>(R.id.button_roll)

        // Set a click listener on the button to roll the dice when the user taps the button
        roll.setOnClickListener {
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            rollDice()
        }

        if (savedInstanceState != null) {
            val saveImage = savedInstanceState.getInt("drawableRes")
            imageView.setImageResource(saveImage)
        }

    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {

        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage = findViewById<ImageView>(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val diceResource = when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID and the content description
        diceImage.apply {
            setImageResource(diceResource)
            tag = diceResource
            contentDescription = diceRoll.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ${imageView.tag}")
        //outState.putInt("drawableRes", )
    }
}
