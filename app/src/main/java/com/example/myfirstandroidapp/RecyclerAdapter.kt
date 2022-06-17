package com.example.myfirstandroidapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")  // a to co? :D

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Dice", "Tip calculator", "ANC", "TBD", "TBD", "TBD", "TBD", "TBD")
    private var details = arrayOf("Simple random number generator", "Unfinished project", "Account number converter", "Short description", "Short description", "Short description", "Short description", "Short description")
    private var images = arrayOf(R.drawable.dice_5, R.drawable.calc, R.drawable.ic_bank, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener{
                when (adapterPosition){
                    0 -> {
                        //navigateToRandomNumberGenerator()
                        itemView.context.startActivity(Intent(itemView.context, RandomNumberGenerator::class.java)) //to poproszę wytłumaczyć bo nie wiem dlaczego tak zadziałało, przypadkowo na to wpadłem
                    }
                    1 -> itemView.context.startActivity(Intent(itemView.context, TipCalculator::class.java))
                    2 -> itemView.context.startActivity(Intent(itemView.context, NumberConverter::class.java))
                    3 -> Toast.makeText(itemView.context, "To be done...", Toast.LENGTH_LONG).show()
                    4 -> Toast.makeText(itemView.context, "To be done...", Toast.LENGTH_LONG).show()
                    5 -> Toast.makeText(itemView.context, "To be done...", Toast.LENGTH_LONG).show()
                    6 -> Toast.makeText(itemView.context, "To be done...", Toast.LENGTH_LONG).show()
                    7 -> Toast.makeText(itemView.context, "To be done...", Toast.LENGTH_LONG).show()
                    8 -> Toast.makeText(itemView.context, "To be done...", Toast.LENGTH_LONG).show()
                    else -> Toast.makeText(itemView.context, "Unexpected value! $adapterPosition", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}