package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastname: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirmPassword: TextInputLayout
    lateinit var etFisrtName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etConfirmPassword: TextInputEditText
    lateinit var btSignUp: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
        castViews()
        tvLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        btSignUp.setOnClickListener {
            validateSignUp()
        }
    }
    fun castViews(){
        tvLogin = findViewById(R.id.tvLogin)
        tilFirstName=findViewById(R.id.tilFirstName)
        tilLastname =findViewById(R.id.tilLastName)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        tilConfirmPassword=findViewById(R.id.tilConfirmPassword)
        etFisrtName=findViewById(R.id.etFirstName)
        etLastName=findViewById(R.id.etLastName)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)
        btSignUp=findViewById(R.id.btSignUp)

    }
//    to validate info entered
    fun validateSignUp(){
    val firstName=etFisrtName.text.toString()
    val lastName=etLastName.text.toString()
    val email=etEmail.text.toString()
    val password=etPassword.text.toString()
    val confirmPassword=etConfirmPassword.text.toString()
    var error = false

    if(firstName.isBlank()){
        tilFirstName.error="First Name is required "
        error=true
    }
    if(lastName.isBlank()){
        tilLastname.error="Last Name is required "
        error=true
    }
    if(email.isBlank()){
        tilEmail.error="Email is required "
        error=true
    }
    if(password.isBlank()){
        tilPassword.error="password is required "
        error=true
    }
    if(confirmPassword.isBlank()){
        tilConfirmPassword.error="confirm password is required "
        error=true
    }
    if (password!=confirmPassword){
        tilConfirmPassword.error="Password does not match"
        error=true
    }
    if(!error){
        Toast.makeText(this,"Signed up successfully",Toast.LENGTH_SHORT)
            .show()
    }
    }

}