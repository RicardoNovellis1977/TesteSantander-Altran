package com.ricardo.testesantander.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ricardo.testesantander.R
import com.ricardo.testesantander.helper.WebService
import com.ricardo.testesantander.model.DAOService.DAOService
import com.ricardo.testesantander.model.UserAccountParse
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), WebService {

    private lateinit var user : String
    private lateinit var password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTeste.setOnClickListener(View.OnClickListener {

            user = textUser.text.toString()
            password = textPassword.text.toString()

            if (user.length == 11 || isValid(user)){
                if (senhaForte(password)){
                    val daoService : DAOService =
                        DAOService(this)
                    daoService.callService(user,password)
                }else{
                    Toast.makeText(this,"Senha Fraca",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"Cpf ou Email inválido",Toast.LENGTH_LONG).show()
            }
        })
    }
    override fun success(obj: Any?) {

        val objeto : UserAccountParse = obj as UserAccountParse
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("userAccountParse", objeto.userAccount)
        startActivity(intent)

    }
    override fun erro(throwable: Throwable?) {

        Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show()

    }
    fun senhaForte(senha: String): Boolean {
        if (senha.length < 6) return false
        var achouNumero = false
        var achouMaiuscula = false
        var achouMinuscula = false
        var achouSimbolo = false
        for (c in senha.toCharArray()) {
            if (c >= '0' && c <= '9') {
                achouNumero = true
            } else if (c >= 'A' && c <= 'Z') {
                achouMaiuscula = true
            } else if (c >= 'a' && c <= 'z') {
                achouMinuscula = true
            } else {
                achouSimbolo = true
            }
        }
        return achouNumero && achouMaiuscula && achouMinuscula && achouSimbolo
    }

    internal fun isValid(email: String): Boolean {
        val regex = Regex("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")
        return email.matches(regex)
    }
}
