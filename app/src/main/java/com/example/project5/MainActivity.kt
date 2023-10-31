package com.example.project5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val sleepDataList: MutableList<SleepData> = mutableListOf(
        SleepData("2002-10-24", "8 hours", "Good")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_tracking)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = SleepDataAdapter(sleepDataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val button: Button = findViewById(R.id.button)
        val editTextDay: EditText = findViewById(R.id.editTextText)
        val editTextDuration: EditText = findViewById(R.id.editTextText2)
        val editTextQuality: EditText = findViewById(R.id.editTextText3)

        button.setOnClickListener {
            val day = editTextDay.text.toString()
            val duration = editTextDuration.text.toString()
            val quality = editTextQuality.text.toString()

            // Validate input (you might want to add more validation logic)
            if (day.isNotEmpty() && duration.isNotEmpty() && quality.isNotEmpty()) {
                // Create a new SleepData object and add it to the list
                val newSleepData = SleepData(day, duration, quality)
                sleepDataList.add(newSleepData)

                // Notify the adapter that the data set has changed
                adapter.notifyDataSetChanged()

                // Clear EditText fields after adding the new item
                editTextDay.text.clear()
                editTextDuration.text.clear()
                editTextQuality.text.clear()

                Log.d("MainActivity", "New Sleep Data Added: $newSleepData")
            } else {
                // Handle invalid input (optional)
                Log.d("MainActivity", "Invalid input")
            }
        }
    }
}

