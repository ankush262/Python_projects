package com.geekymusketeers.taketoocare

/**
 * Implementation of App Widget functionality.
 */
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geekymusketeers.taketoocare.appointment.AppointmentBooking
import com.geekymusketeers.taketoocare.appointment.PatientAppointment


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var patientButton: Button
    private lateinit var doctorButton: Button
    private lateinit var appointmentDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fist_widget)

        // Find the buttons and appointment display by their IDs
        patientButton = findViewById(R.id.patientButton)
        doctorButton = findViewById(R.id.doctorButton)
       // appointmentDisplay = findViewById(R.id.appointmentDisplay)


        // Set click listeners for the buttons
        patientButton.setOnClickListener(this)
        doctorButton.setOnClickListener(this)

        patientButton.setOnClickListener {
            val intent = Intent(this,AppointmentBooking::class.java)
            startActivity(intent)
        }
        doctorButton.setOnClickListener {
            val intent = Intent(this,PatientAppointment::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.patientButton -> showPatientMessage()

            R.id.doctorButton -> showDoctorMessage()


        }
    }

    private fun showPatientMessage() {
        Toast.makeText(this, "You clicked the patient button.", Toast.LENGTH_SHORT).show()
        // Add your patient-related functionality here

        // Example: Display appointment for patient
        val appointment = "Your appointment is on June 23, 2023 at 10:00 AM"
        appointmentDisplay.text = appointment
    }

    private fun showDoctorMessage() {
        Toast.makeText(this, "You clicked the doctor button.", Toast.LENGTH_SHORT).show()
        // Add your doctor-related functionality here

        // Example: Display appointment for doctor
        val appointment = "Your next appointment is on June 25, 2023 at 2:00 PM"
        appointmentDisplay.text = appointment
    }


}


