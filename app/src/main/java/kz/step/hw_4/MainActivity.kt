    package kz.step.hw_4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

    class MainActivity : AppCompatActivity() {

        var editLogin: EditText? = null
        var editPassword: EditText? = null
        var buttonEnter: Button? = null
        var textView: TextView? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()

    }
        private fun initializeViews() {
            buttonEnter = findViewById(R.id.button_enter)
            editLogin = findViewById(R.id.editText_login)
            editPassword = findViewById(R.id.password_toggle)
            textView = findViewById(R.id.textView_data)
        }

        private fun initializeLiseners() {
            buttonEnter?.setOnClickListener {
                textView?.text = "\nВаш Логин: " + editLogin?.text.toString() + "\n\nВаш пароль: " + editPassword?.text.toString()

                val message = "\nВаш Логин: " + editLogin?.text.toString() + "\nВаш пароль: " + editPassword?.text.toString()
                sendMessage(message)
             }
        }

        @SuppressLint("QueryPermissionsNeeded")
    fun sendMessage(message: String) {

        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"

        intent.setPackage("com.whatsapp")

        intent.putExtra(Intent.EXTRA_TEXT, message)

        startActivity(intent)
    }
}