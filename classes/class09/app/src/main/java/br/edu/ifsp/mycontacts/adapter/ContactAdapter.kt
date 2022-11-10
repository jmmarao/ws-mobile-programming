package br.edu.ifsp.mycontacts.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.getSystemService
import br.edu.ifsp.mycontacts.R
import br.edu.ifsp.mycontacts.databinding.TileContactBinding
import br.edu.ifsp.mycontacts.model.Contact

class ContactAdapter(
    context: Context,
    layoute: Int,
    private val contactList: MutableList<Contact>
) : ArrayAdapter<Contact>(context, R.layout.tile_contact, contactList) {
    private data class TileContactHolder(val nameTv: TextView, val emailTv: TextView)

    private lateinit var tcb: TileContactBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contact = contactList[position]
        var contactTileView = convertView
        var view: View? = null
        if (contactTileView == null) {
            // Inflate with a new cell
            tcb = TileContactBinding.inflate(
                context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                parent,
                false
            )
//            view =
//                (context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
//                    R.layout.tile_contact,
//                    parent,
//                    false
//                )
            contactTileView = tcb.root
            val tileContactHolder = TileContactHolder(tcb.nameTv, tcb.emailTv)
            contactTileView.tag = tileContactHolder
        }
        with(contactTileView.tag as TileContactHolder) {
            nameTv.text = contact.name
            emailTv.text = contact.email
        }

        return contactTileView
    }
}