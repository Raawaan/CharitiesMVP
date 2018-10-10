package com.example.rawan.charitiesmvp

import android.os.AsyncTask
import android.util.Log
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.Model.RoomDatabase.CharitiesEntity

/**
 * Created by rawan on 09/10/18.
 */
class CharitiesDataAsyncTask<T>(private val inBackground: () -> T,
                             private val onSuccessBackground: (s:T) -> Unit) : AsyncTask<Any, Any, T>() {
    override fun doInBackground(vararg p0: Any?): T{
        return inBackground()
    }
    override fun onPostExecute(result: T) {
        super.onPostExecute(result)
            onSuccessBackground(result)
        }
    }