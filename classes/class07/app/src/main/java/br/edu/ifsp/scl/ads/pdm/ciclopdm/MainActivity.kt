package br.edu.ifsp.scl.ads.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import br.edu.ifsp.scl.ads.pdm.ciclopdm.databinding.ActivityMainBinding

// To inhereit a class it's necessary to declare open before the class
class MainActivity : AppCompatActivity() {
    //i.  private val activityMainBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    // ii.
    // private lateinit var activityMainBinding: ActivityMainBinding

    // iii.
    private val activityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private companion object {
        const val TAG = "TAG_CYCLE_PDM"
        const val ET_DYNAMIC_VALUE = "ET_DYNAMIC_VALUE"
    }

    private lateinit var dinamicEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ii.
        // activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        dinamicEt = EditText(this)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(0, 10, 0, 0)
        dinamicEt.layoutParams = layoutParams
        dinamicEt.hint = "EditText dynamic"

        activityMainBinding.root.addView(dinamicEt)
        val savedValue: String = savedInstanceState?.getString(ET_DYNAMIC_VALUE) ?: ""
        dinamicEt.setText(savedValue)

        Log.v(TAG, "onCreate: FULL cycle initialized")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart: VISIBLE cycle initialized")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume: FOREGROUND cycle initialized")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart: Preparing onStart execution")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause: Closing FOREGROUNG cycle")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop: Closing VISIBLE cycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy: Closing FULL cycle")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ET_DYNAMIC_VALUE, dinamicEt.text.toString())
        Log.v(TAG, "onSaveInstanceState: Saving ET dynamic")

    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        val savedValue: String = savedInstanceState.getString(ET_DYNAMIC_VALUE, "")
//        dinamicEt.setText(savedValue)
//        Log.v(TAG, "onRestoreInstanceState: Restoring ET dynamic")
//    }
}