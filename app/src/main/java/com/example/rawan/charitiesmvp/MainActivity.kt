package com.example.rawan.charitiesmvp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.Model
import com.example.rawan.charitiesmvp.Model.MyAdaptor
import com.example.rawan.charitiesmvp.Presenter.Presenter
import com.example.rawan.charitiesmvp.Presenter.PresenterInterface
import com.example.rawan.charitiesmvp.View.ViewUI
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),ViewUI,MyReceiver.ConnectivityReceiverListener {
    lateinit var presenter:PresenterInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(MyReceiver(),
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        Stetho.initializeWithDefaults(this)
        presenter= Presenter(Model(),this)
    }
    override fun onResume() {
        super.onResume()
        MyReceiver.connectivityReceiverListener = this
    }
    override fun makeDatabaseCall() {
        presenter.executeDatabase(CharitiesDatabase.getInstance(this))
    }
    override fun makeRetrofitAPICall() {
        presenter.executeAPI()
    }
    override fun setData(list: List<CharitiesData>) {
        val adapter = MyAdaptor(list,clickListener = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("name", it.organization_name)
            intent.putExtra("pic", it.organization_pic)
            intent.putExtra("type", it.organization_type)
            intent.putExtra("desc",it.organization_desc )
            startActivity(intent)
        })
        charititesRV.layoutManager = LinearLayoutManager(this)
        charititesRV.adapter = adapter
    }
    override fun setError(t: Throwable){
        Toast.makeText(this,"$t",Toast.LENGTH_LONG).show()
    }
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            makeDatabaseCall()
            Toast.makeText(this,"NOT CONNECTED",Toast.LENGTH_LONG).show()
        }
        else {
            makeRetrofitAPICall()
            Toast.makeText(this,"CONNECTED",Toast.LENGTH_LONG).show()
        }
    }
}
