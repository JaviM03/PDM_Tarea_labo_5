package com.aldana.talle2app

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldana.talle2app.adapter.CoinAdapter
import com.aldana.talle2app.models.Coin
import com.aldana.talle2app.utils.CoinSerializer
import com.aldana.talle2app.utils.NetworkUtilities
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var viewAdapter: CoinAdapter
    lateinit var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = CoinAdapter(listOf<Coin>()) {
            Snackbar.make(rv_moneda,
                    "CLick en " + it.name,
                    Snackbar.LENGTH_SHORT)
                    .show()
        }

        rv_moneda.apply {
            adapter = viewAdapter
            layoutManager = viewManager
        }

        CoinsFetch().execute()
    }


    private inner class CoinsFetch : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg query: String): String {

            val ID = query[0]
            val monedaAPI = NetworkUtilities.NetworkUtils().buildUrl("coin")

            return try {
                NetworkUtilities.NetworkUtils().getResponseFromHttpUrl(monedaAPI)
            } catch (e: IOException) {
                ""
            }

        }
    }
}

