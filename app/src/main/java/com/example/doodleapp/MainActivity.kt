package com.example.doodleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import com.example.doodleapp.view.DrawingView

class MainActivity : AppCompatActivity() {

    private lateinit var drawingView: DrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawingView)

        val btnBrush = findViewById<Button>(R.id.btnBrush)
        val btnEraser = findViewById<Button>(R.id.btnEraser)

        btnBrush.setOnClickListener {
            drawingView.setEraser(false)
        }

        btnEraser.setOnClickListener {
            drawingView.setEraser(true)
        }
    }
}
