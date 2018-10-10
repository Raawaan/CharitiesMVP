package com.example.rawan.charitiesmvp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.CharitiesDataModel
import com.example.rawan.charitiesmvp.View.CharitiesDataAdaptor
import com.example.rawan.charitiesmvp.Presenter.CharitiesDataPresenterImpl
import com.example.rawan.charitiesmvp.Presenter.CharitiesDataPresenter
import com.example.rawan.charitiesmvp.View.CharitiesViewUI
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),CharitiesViewUI,InternetConnectionReceiver.ConnectivityReceiverListener {
    private lateinit var charitiesDataPresenter:CharitiesDataPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(InternetConnectionReceiver(),
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        Stetho.initializeWithDefaults(this)
        charitiesDataPresenter= CharitiesDataPresenterImpl(CharitiesDataModel(),this)
//        makeRetrofitAPICall()

    }
    override fun onResume() {
        super.onResume()
        InternetConnectionReceiver.connectivityReceiverListener = this
    }
    override fun makeDatabaseCall() {
        charitiesDataPresenter.executeDatabase(CharitiesDatabase.getInstance(this))
    }
    override fun makeRetrofitAPICall() {
        charitiesDataPresenter.executeAPI()
    }
    override fun setData(list: List<CharitiesData>) {
//        val database= CharitiesDatabase.getInstance(this)
//        for(item in list){
//            var s = CharitiesEntity(item.organization_name,item.organization_type,item.organization_desc,item.organization_pic)
//            database.CharitiesDao().insertUser(s)
//        }
        val adapter = CharitiesDataAdaptor(list, clickListener = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("name", it.organization_name)
            intent.putExtra("pic", it.organization_pic)
            intent.putExtra("type", it.organization_type)
            intent.putExtra("desc", it.organization_desc)
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
