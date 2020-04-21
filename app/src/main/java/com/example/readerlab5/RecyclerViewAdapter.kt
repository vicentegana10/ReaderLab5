package com.example.readerlab5

import android.app.AlertDialog
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_list_row.view.*

class RecyclerViewAdapter(private val items: ArrayList<Item5>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemCard>() {

    override fun onBindViewHolder(holder: ItemCard, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCard {
        val inflatedView = parent.inflate(R.layout.recyclerview_list_row, false)
        return ItemCard(inflatedView)
    }

    override fun getItemCount(): Int = items.count()

    class ItemCard(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var item: Item5? = null

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            print("Se aprieta boton")

            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Agregar Producto")

            //builder.setView(view.imageView)
            val txt : String = "Nombre:  "+ (item?.nombre ?: null) + "\nPrecio:  "+ (item?.precio ?: null)
            builder.setMessage(txt)
            //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
            // IMPLEMENTAR FUNCION QUE SUME 1 AL TEXTVIEW3 Y SUME EL PRECIO A TEXTVIEW4

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(view.context,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(view.context,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }

        fun bindItem(item: Item5) {
            this.item = item
            view.textView.text = item.nombre
            view.textView2.text =  "$"+item.precio

            Picasso.get()
                .load(item.urlName)    //"http://i.imgur.com/DvpvklR.png" de ejemplo
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(view.imageView)

        }
    }

}