package com.example.rawan.charitiesmvp

import android.os.AsyncTask
import android.util.Log
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesEntity

/**
 * Created by rawan on 09/10/18.
 */
class CharitiesDataAsyncTask(private val inBackground: () -> List<CharitiesData>,
                             private val onSuccessBackground: (s:List<CharitiesData>) -> Unit) : AsyncTask<Any, Any, List<CharitiesData>>() {
    override fun doInBackground(vararg p0: Any?): List<CharitiesData>{
        return inBackground()
    }
    override fun onPostExecute(result: List<CharitiesData>) {
        super.onPostExecute(result)
            onSuccessBackground(result)
        }
    }