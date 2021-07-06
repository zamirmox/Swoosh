package com.example.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
   lateinit var player: Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!
        println(">>>>>>>>>")
        println(player.league)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"

    }
    fun onBeginnerClick(view:View) {
        ballerSkillbtn.isChecked = false
        player.skill = "beginner"
    }
    fun onSkillFinishClicked(view:View) {
        if (player.skill != "") {
            val finishedActivity = Intent(this, FinishActivity::class.java)
            finishedActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishedActivity)
        }else{
            Toast.makeText(this,"Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}