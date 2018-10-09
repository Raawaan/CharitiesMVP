package com.example.rawan.charitiesmvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detalied_activity.*

/**
 * Created by rawan on 09/10/18.
 */
class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalied_activity)
        orgNameDetailed.append(intent.getStringExtra("name").toString())
        orgTypeDetailed.append(intent.getStringExtra("type").toString())
        orgDescDetailed.append(intent.getStringExtra("desc").toString())
        Picasso.get().load(intent.getStringExtra("pic").toString()).fit().centerCrop().into(orgImageDetailed)
    }
}