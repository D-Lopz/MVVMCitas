package com.davidlopez.mvvmapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.davidlopez.mvvmapp.data.model.UserModel
import com.davidlopez.mvvmapp.data.model.request.LoginRequest
import com.davidlopez.mvvmapp.databinding.ActivityLoginBinding
import com.davidlopez.mvvmapp.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel._isLoading.observe(this) {
            binding.progress.isVisible = it
        }

        loginViewModel._message.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        loginViewModel._userModel.observe(this) {
            Toast.makeText(this, "Bienvenido ${it?.name}", Toast.LENGTH_SHORT).show()
            startMain(it)

        }
        binding.btnIniciarSesion.setOnClickListener{
            if (validateData()){
                loginViewModel.login(
                    LoginRequest(
                        binding.tietUsername.text.toString(),
                        binding.tietPassword.text.toString()
                    )
                )
            }
        }
    }

    private fun validateData(): Boolean {
        var isValid = true
        with(binding){
            // validar el null del campo username
            if (tietUsername.text.toString().isBlank()){
                isValid = false
                tietUsername.error = "Campo requerido"
            } else {
                tietUsername.error = null
            }
            // validar el null del campo contraseña
            if (tietPassword.text.toString().isBlank()){
                isValid = false
                tietPassword.error = "Campo requerido"
            } else {
                tietPassword.error = null
            }
        }
        return isValid
    }

    private fun startMain(userModel: UserModel?){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", userModel?.name )
        intent.putExtra("lastName", userModel?.lastName)
        intent.putExtra("jwt", userModel?.jwt)
        startActivity(intent)
        finish()
    }

}