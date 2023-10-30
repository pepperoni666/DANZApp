package com.example.daznapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.daznapp.R
import com.example.daznapp.databinding.ActivityVideoPlayerBinding


class VideoPlayerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityVideoPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.title_video_player)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.getStringExtra(EXTRA_VIDEO_URL)?.let {
            binding.videoView.setVideoPath(it)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(binding.videoView)
            mediaController.setMediaPlayer(binding.videoView)
            binding.videoView.setMediaController(mediaController)
            binding.videoView.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private const val EXTRA_VIDEO_URL = "EXTRA_VIDEO_URL"
        fun getIntent(context: Context, videoUrl: String)=
            Intent(context, VideoPlayerActivity::class.java).apply {
                putExtra(EXTRA_VIDEO_URL, videoUrl)
            }
    }
}