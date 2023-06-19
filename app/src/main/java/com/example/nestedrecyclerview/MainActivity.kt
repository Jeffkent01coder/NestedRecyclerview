package com.example.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun prepareData() {
        // best seller
        val bestSellerList = ArrayList<RecyclerItem>()
        bestSellerList.add(RecyclerItem(R.drawable.bags, "Up to 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.mobile, "Up to 10% off"))
        bestSellerList.add(RecyclerItem(R.drawable.watch, "Up to 40% off"))
        bestSellerList.add(RecyclerItem(R.drawable.bags, "Up to 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.mobile, "Up to 10% off"))
        bestSellerList.add(RecyclerItem(R.drawable.watch, "Up to 40% off"))

        //clothing
        val clothingList = ArrayList<RecyclerItem>()
        clothingList.add(RecyclerItem(R.drawable.levis, "Up to 25% off"))
        clothingList.add(RecyclerItem(R.drawable.women, "Up to 30% off"))
        clothingList.add(RecyclerItem(R.drawable.nike, "Up to 35% off"))
        clothingList.add(RecyclerItem(R.drawable.levis, "Up to 25% off"))
        clothingList.add(RecyclerItem(R.drawable.women, "Up to 30% off"))
        clothingList.add(RecyclerItem(R.drawable.nike, "Up to 35% off"))

        mList.add(DataItem(DataItemType.BESTSELLER, bestSellerList))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.tv)))
        mList.add(DataItem(DataItemType.CLOTHING, clothingList))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.nikon)))
        mList.add(DataItem(DataItemType.BESTSELLER, bestSellerList.asReversed()))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.offer)))
    }
}