package com.ricardo.testesantander.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.ricardo.testesantander.R
import com.ricardo.testesantander.helper.WebServiceDatail
import com.ricardo.testesantander.model.DAOService.DAOServiceDetail
import com.ricardo.testesantander.model.Launches
import com.ricardo.testesantander.model.UserAccount
import com.ricardo.testesantander.view.adapter.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),WebServiceDatail {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle : UserAccount= intent.getSerializableExtra("userAccountParse") as UserAccount
        textNome.text = bundle.name
        textConta.text = bundle.bankAccount + "/" + bundle.agency
        textValor.text = bundle.balance.toString()

        val daoServiceDatail : DAOServiceDetail = DAOServiceDetail(this)
        daoServiceDatail.callService(bundle.userId)
    }

    override fun success(obj: Any?) {

        val launches : Launches = obj as Launches

        val linearLayoutManager = LinearLayoutManager(this)

        recyclerDetail.layoutManager = linearLayoutManager
        recyclerDetail.adapter = DetailAdapter(this,launches)
    }

    override fun erro(throwable: Throwable?) {
        Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show()

    }
}
