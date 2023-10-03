package com.betty.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val diceImage2: ImageView = findViewById(R.id.dice_image2)
        diceImage.setImageResource(drawableResource())
        diceImage2.setImageResource(drawableResource())
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