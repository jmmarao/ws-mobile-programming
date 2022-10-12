package br.edu.ifsp.intents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.intents.Constant.URL
import br.edu.ifsp.intents.databinding.ActivityUrlBinding

class UrlActivity : AppCompatActivity() {

    private lateinit var aub: ActivityUrlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aub = ActivityUrlBinding.inflate(layoutInflater)

        setContentView(aub.root)
        supportActionBar?.subtitle = "UrlActivity"

        val previousUrl = intent.getStringExtra(Constant.URL) ?: ""

        if (previousUrl.isNotEmpty()) {
            aub.urlEt.setText(previousUrl)
        }

        // Other way to get previousUrl
//        previousUrl.takeIf { it.isNotEmpty() }.also {
//            aub.urlEt.setText(it)
//        }

        aub.enterUrlBt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val intentReturn = Intent()
                intentReturn.putExtra(URL, aub.urlEt.text.toString())
                setResult(RESULT_OK, intentReturn)

                // Close the current window and back to the previous one
                finish()
            }
        })
    }
}