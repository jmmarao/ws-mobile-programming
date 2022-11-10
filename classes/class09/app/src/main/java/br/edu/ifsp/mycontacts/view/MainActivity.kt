package br.edu.ifsp.mycontacts.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.ifsp.mycontacts.R
import br.edu.ifsp.mycontacts.adapter.ContactAdapter
import br.edu.ifsp.mycontacts.databinding.ActivityMainBinding
import br.edu.ifsp.mycontacts.model.Constant.EXTRA_CONTACT
import br.edu.ifsp.mycontacts.model.Contact

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // Data source
    private val contactList: MutableList<Contact> = mutableListOf()

    // Adapter method 1 - and lines 35 to 39 onCreate
//    private lateinit var contactAdapter: ArrayAdapter<String>

    private lateinit var contactAdapter = ContactAdapter(this, contactList)

    private lateinit var carl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        fillContactList()
        amb.contactsLv.adapter = contactAdapter

        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT)
                contact?.let { _contact ->
                    contactList.add(_contact)
                    contactAdapter.add(_contact.toString())
                    contactAdapter.notifyDataSetChanged()
                }
            }
        }

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
                carl.launch(Intent(this, ContactActivity::class.java))
                true
            }
            else -> {
                false
            }
        }
    }

    private fun fillContactList() {
        for (i in 1..10) {
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