package com.example.doodleapp

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.SeekBar
import com.example.doodleapp.view.DrawingView
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener


class MainActivity : AppCompatActivity() {

    private lateinit var drawingView: DrawingView
    private var lastSelectedColor: Int = 0xFF000000.toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        drawingView = findViewById(R.id.drawingView)
        val seekBar = findViewById<SeekBar>(R.id.seekBarSize)
        val btnBrush = findViewById<Button>(R.id.btnBrush)
        val btnEraser = findViewById<Button>(R.id.btnEraser)
        val colorPickerView = findViewById<ColorPickerView>(R.id.colorPickerView)
        val colorPreview = findViewById<View>(R.id.colorPreview)

        // Tamaño inicial del pincel
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val size = if (progress < 1) 1f else progress.toFloat()
                drawingView.setBrushSize(size)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Selección de color
        colorPickerView.setColorListener(ColorEnvelopeListener { envelope: ColorEnvelope, _: Boolean ->
            val selectedColor = envelope.color
            lastSelectedColor = selectedColor
            drawingView.setBrushColor(selectedColor)
            colorPreview.setBackgroundColor(selectedColor)
        })

        // Borrador
        btnEraser.setOnClickListener {
            drawingView.setEraser(true)
        }

        // Volver al pincel
        btnBrush.setOnClickListener {
            drawingView.setEraser(false)
            drawingView.setBrushColor(lastSelectedColor) // Restaura el último color
        }
    }
}
