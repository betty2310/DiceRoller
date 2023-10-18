package com.betty.diceroller

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.betty.diceroller.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnName = "roll"

        var diceImage1 = binding.diceImage
        var diceImage2 = binding.diceImage2

        var rollButton = binding.rollButton
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice(diceImage1, diceImage2)
        }

        // Do a dice roll when the app starts
        rollDice(diceImage1, diceImage2)

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(dice1: ImageView, dice2: ImageView) {
        dice1.setImageResource(drawableResource())
        dice2.setImageResource(drawableResource())
    }

    private fun drawableResource(): Int {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}