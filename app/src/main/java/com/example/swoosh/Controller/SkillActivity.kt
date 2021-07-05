package com.example.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.EXTRA_LEAGUE
import com.example.swoosh.EXTRA_SKILL
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var league = " "
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
        println(">>>>>>>>>")
        println(league)
    }
    fun onBallerClick(view:View){
        beginnerSkillBtn.isChecked = false
        skill = "baller"

    }
    fun onBeginnerClick(view:View){
        ballerSkillbtn.isChecked = false
        skill = "beginner"
    }
    fun onSkillFinishClicked(view: View){
        if (skill != "") {
            val finishedActivity = Intent(this, FinishActivity::class.java)
            finishedActivity.putExtra(EXTRA_LEAGUE, league)
            finishedActivity.putExtra(EXTRA_SKILL, skill)

            startActivity(finishedActivity)
        }else{
            Toast.makeText(this,"Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}