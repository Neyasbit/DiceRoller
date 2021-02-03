package com.example.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.diceroller.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private val viewModel: GameViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the Button in the layout
        val roll = findViewById<Button>(R.id.button_roll)
        Log.d(TAG, "onCreate: Main ${viewModel.diceResource}")
        updateNextImageOnScreen()
        // Set a click listener on the button to roll the dice when the user taps the button
        roll.setOnClickListener {
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            viewModel.rollDice()
            updateNextImageOnScreen()
            Log.d(TAG, "onCreate: On Click Main ${viewModel.diceResource}")
        }

    }
    
    private fun updateNextImageOnScreen() {
        Log.d(TAG, "updateNextImageOnScreen: ${viewModel.diceResource}")
        binding.imageView.setImageResource(viewModel.diceResource)
    }

}
