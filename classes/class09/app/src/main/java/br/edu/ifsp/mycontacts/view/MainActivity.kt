package br.edu.ifsp.mycontacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import br.edu.ifsp.mycontacts.R
import br.edu.ifsp.mycontacts.databinding.ActivityMainBinding
import br.edu.ifsp.mycontacts.model.Contact

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // Data source
    private val contactList: MutableList<Contact> = mutableListOf()

    // Adapter method 1 - and lines 35 to 39 onCreate
//    private lateinit var contactAdapter: ArrayAdapter<String>

    private val contactAdapter: ArrayAdapter<String> by lazy {
        ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            contactList.map { it.toString() }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        fillContactList()
        amb.contactsLv.adapter = contactAdapter

//        contactAdapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            contactList.map { it.name }
//        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addContactMi -> {
                //Open contact screen
                true
            }
            else -> {
                false
            }
        }
    }

    private fun fillContactList() {
        for (i in 1..50) {
            contactList.add(
                Contact(
                    id = i,
                    name = "Name $i",
                    address = "Address $i",
                    phone = "Phone $i",
                    email = "Email $i",
                )
            )
        }
    }
}