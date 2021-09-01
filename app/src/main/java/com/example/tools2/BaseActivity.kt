package com.example.tools2


import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mytools.ConnectionLiveData
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity(@LayoutRes layout:Int): AppCompatActivity(layout) {

    private val TAG = "tag"
    private lateinit var connectionLiveData: ConnectionLiveData


    override fun onCreate(savedInstanceState: Bundle?) {
        connectionLiveData = ConnectionLiveData(this)
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate from baseActivity")
        setupUi()
        observDataFromHomeViewModel()
    }

    protected fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }



    fun internetCheck(view: View){

        val a = Snackbar.make(view, "No Internet", Snackbar.LENGTH_INDEFINITE)

        connectionLiveData.observe(this, {
            if (it == false) {
                a.setBackgroundTint(ContextCompat.getColor(this, R.color.red)).show()
                refresh()
            }
            if (it == true) {
                Snackbar.make(view, "Connected", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.green))
                        .show()

            }

        })
    }
    abstract fun refresh()


    abstract fun setupUi()
    abstract fun observDataFromHomeViewModel()

}