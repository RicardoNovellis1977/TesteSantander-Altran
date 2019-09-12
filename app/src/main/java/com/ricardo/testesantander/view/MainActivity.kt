package com.ricardo.testesantander.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ricardo.testesantander.R
import com.ricardo.testesantander.model.DAOService.DAOService
import com.ricardo.testesantander.helper.WebService
import com.ricardo.testesantander.model.UserAccountParse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WebService {

    val user : String = "RicardoTeste"
    val password : String = "brq@012"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTeste.setOnClickListener(View.OnClickListener {
            val daoService : DAOService =
                DAOService(this)
            daoService.callService(user,password)
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
}
