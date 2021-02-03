package com.example.diceroller

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class GameViewModel : ViewModel() {
    private val TAG = GameViewModel::class.java.simpleName
    /*
    * the property corresponding to resource ID
     */
    private var _diceResource by Delegates.notNull<Int>()
    val diceResource get() = _diceResource
    /*
    * initialization on first start
     */
    init {
        rollDice()
        Log.d(TAG, ": Create $_diceResource")
    }
    fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Determine which drawable resource ID to use based on the dice roll
         _diceResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Log.d(TAG, "rollDice: roll = $diceRoll res = $_diceResource")
    }
}