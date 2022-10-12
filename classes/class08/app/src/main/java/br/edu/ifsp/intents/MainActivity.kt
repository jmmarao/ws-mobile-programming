package br.edu.ifsp.intents

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.Intent.*
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.intents.Constant.URL
import br.edu.ifsp.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater);
    }

    private lateinit var urlAct: ActivityResultLauncher<Intent>
    private lateinit var permissionCallArl: ActivityResultLauncher<String>
    private lateinit var getImageArl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        supportActionBar?.subtitle = "MainActivity"

        urlAct =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val returnedUrl = result.data?.getStringExtra(URL) ?: ""
                    amb.urlTv.text = returnedUrl
                }
            }

        amb.accessUrlBt.setOnClickListener {
            //val urlActivityIntent = Intent(this, UrlActivity::class.java)
            val urlActivityIntent = Intent("URL_ACTIVITY_MANIFEST")
            urlActivityIntent.putExtra(URL, amb.urlTv.text.toString())
            urlAct.launch(urlActivityIntent)
            //startActivity(urlActivityIntent)
        }

        permissionCallArl = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { allowed ->
            if (allowed!!) {
                callNumber(call = true)
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "You don't have permission to execute",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }

        getImageArl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                // Get image path
                val imageUri = result.data?.data
                imageUri?.let {
                    amb.urlTv.text = it.toString()
                }
                // Openning viewer
                val viewerImageIntent = Intent(ACTION_VIEW, imageUri)
                startActivity(viewerImageIntent)
            }
        }
    }

    // Set menu at ActionBar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Handle options selected on menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.viewMi -> {
                // Open the browser at URL typed. The last line is the one it's returned
                val url = Uri.parse(amb.urlTv.text.toString())
                val intentNavigator = Intent(ACTION_VIEW, url)
                startActivity(intentNavigator)
                true
            }
            R.id.dialMi -> {
                val uri = Uri.parse("tel: ${amb.urlTv.text}")
                val intentCall = Intent(ACTION_DIAL, uri)
                startActivity(intentCall)
                true
            }
//            else -> {
//                false
//            }
            R.id.callMi -> {
                callNumber(call = false)
                true
            }

            R.id.callMi -> {
                // Check android version
                // Higher then Marshmallow
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        callNumber(call = true)
                    } else {
                        permissionCallArl.launch(CALL_PHONE)
                    }
                }
//                else {
//
//                }
                true
            }

            R.id.pickMi -> {
                val getImageIntent = Intent(ACTION_PICK)
                val imageDirectory = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).path
                getImageIntent.setDataAndType(Uri.parse(imageDirectory), "image/*")
                getImageArl.launch(getImageIntent)
                true
            }

            R.id.chooserMi -> {
                val chooserAppIntent = Intent(ACTION_CHOOSER)
                val infoIntent = Intent(ACTION_VIEW, Uri.parse(amb.urlTv.text.toString()))
                chooserAppIntent.putExtra(EXTRA_TITLE, "Choose your browser")
                chooserAppIntent.putExtra(EXTRA_INTENT, infoIntent)
                startActivity(chooserAppIntent)
                true
            }

            else -> {
                false
            }
        }
    }

    private fun callNumber(call: Boolean) {
        val uri = Uri.parse("tel: ${amb.urlTv.text}")
        val intent = Intent(if (call) ACTION_CALL else ACTION_DIAL)
        intent.data = uri
        startActivity(intent)
    }
}