package com.example.m1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.m1.MainActivity
import com.example.m1.SignUp
import com.example.m1.databinding.ActivitySigninBinding
import com.google.firebase.auth.FirebaseAuth

class Signin : AppCompatActivity() {

    //private lateinit var binding: ActivitySigninBindingk
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)*/
        setContentView(R.layout.activity_signin)

        val txt_click_me = findViewById(R.id.textView) as TextView

        txt_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }




       firebaseAuth = FirebaseAuth.getInstance()



        val btn_click_me = findViewById(R.id.button) as Button
        val email_textView = findViewById(R.id.emailEt) as EditText
        val pass_textView = findViewById(R.id.passET) as EditText
      /*  btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            //val email = email_textView.text.toString()
            //val pass = email_textView.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/

        //binding.textView.setOnClickListener {
          //  val intent = Intent(this, SignUp::class.java)
            //startActivity(intent)
        //}

        btn_click_me.setOnClickListener {
           val email = email_textView.text.toString()
           val pass = pass_textView.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    /*override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }*/
}