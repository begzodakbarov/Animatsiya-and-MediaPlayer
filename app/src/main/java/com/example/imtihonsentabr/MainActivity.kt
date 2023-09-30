package com.example.imtihonsentabr

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.imtihonsentabr.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var play = false
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this,R.raw.music)

    val array = ArrayList<String>()
    array.add("Ofarin")
    array.add("Balli")
    array.add("Tashakkur")
    array.add("A'lo")
    array.add("Barakalla")
    array.add("Yaxshi")
    array.add("Qoyil")
    array.add("Zo'r")
    array.add("Gap yo'q")



        val anim = AnimationUtils.loadAnimation(this,R.anim.combination)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                if(!play){
                    mediaPlayer.start()
                    play = true
                }
            }

            override fun onAnimationEnd(animation: Animation?) {
                if (play){
                    mediaPlayer.pause()
                        mediaPlayer.seekTo(0)
                    play = false
                }

            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

        })

        binding.btnNext.setOnClickListener {
            binding.txtText.startAnimation(anim)
            var soz = Random().nextInt(9)
            when(soz){
            0->{binding.txtText.text = array[0]}
            1->{binding.txtText.text = array[1]}
            2->{binding.txtText.text = array[2]}
            3->{binding.txtText.text = array[3]}
            4->{binding.txtText.text = array[4]}
            5->{binding.txtText.text = array[5]}
            6->{binding.txtText.text = array[6]}
            7->{binding.txtText.text = array[7]}
            8->{binding.txtText.text = array[8]}
            }
        }
    }

}