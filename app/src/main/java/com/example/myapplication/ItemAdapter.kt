package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item.view.*

class ItemAdapter(
    var personas: MutableList<Persona>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        this.context = parent.context
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return personas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ItemViewHolder -> {
                var item= personas[position]
                holder.bind(item)
                var options = RequestOptions()
                options.diskCacheStrategy(DiskCacheStrategy.ALL)
                options.centerCrop()
                options.placeholder(R.drawable.ic_person)

                context?.let {
                    Glide.with(it)
                        .load(item.perfilUrl)
                        .apply(options)
                        .into(holder.ivFotoDePErfil)
                }
            }
        }
    }

    fun add(persona: Persona) {
        if (!personas.contains(persona)) {
            personas.add(persona)
            notifyDataSetChanged()
        }
    }

    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var ivFotoDePErfil =itemView.ivFotoDePerfil
        var tvNombre = itemView.tvNombre

        fun bind(persona: Persona){
            tvNombre.text = persona.nombre
        }
    }
}