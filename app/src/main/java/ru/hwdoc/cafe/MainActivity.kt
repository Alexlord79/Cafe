package ru.hwdoc.cafe

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        initViews()
        buttonSignIn.setOnClickListener(object : OnClickListener {
            override fun onClick(view: View?) {
                val userName = editTextName.text.toString().trim()
                val password = editTextPassword.text.toString().trim()

                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
//                        getString(R.string.error_fields_empty),
                        R.string.error_fields_empty,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    launchNextScreen(userName)
                }
            }
        })
    }

    private fun launchNextScreen(userName: String) {
        val intent = MakeOrderActivity.newIntent(this@MainActivity, userName)
        startActivity(intent)
    }

    private fun initViews() {
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSignIn = findViewById(R.id.buttonSignIn)
    }
}