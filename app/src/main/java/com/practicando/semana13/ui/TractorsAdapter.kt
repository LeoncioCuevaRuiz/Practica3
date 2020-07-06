package com.practicando.semana13.ui

import android.content.Context
import android.graphics.Picture
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.practicando.semana13.R
import com.practicando.semana13.network.response.Tractor
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.row_tractor.view.*

class TractorsAdapter (context:Context)
    :RecyclerView.Adapter<TractorsAdapter.TractorViewHolder>()  {

    var tractors = emptyList<Tractor>()
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = TractorViewHolder(inflater.inflate(R.layout.row_tractor,parent,false))

    override fun getItemCount() = tractors.size

    override fun onBindViewHolder(holder: TractorViewHolder, position: Int)
        = holder.bind(tractors[position])

    internal fun setTractors(tractors:List<Tractor>){
        this.tractors = tractors
        notifyDataSetChanged()
    }

    class TractorViewHolder(item: View): RecyclerView.ViewHolder(item){

        fun bind(tractor:Tractor) {
            val img: ImageView = itemView.findViewById(R.id.vrimagen)
            itemView.apply {
                descripcion.text = tractor.descripcion
                placa.text = tractor.placa
                chofer.text = tractor.chofer
                Picasso.get().load(tractor.imagen).into(img)
            }
        }
    }
}