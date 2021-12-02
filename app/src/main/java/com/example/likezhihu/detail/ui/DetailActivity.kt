package com.example.likezhihu.detail.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.util.ViewPagerScroller
import kotlinx.android.synthetic.main.activity_detail.*
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.collections.arrayListOf
import kotlin.collections.isNotEmpty


/**
 * description: 详情页
 * author:Tenda
 * date:2020/9/2
 */
class DetailActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    fun initView() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

        fragmentList.add(DetailFragment().getInstance(true))
        fragmentList.add(DetailFragment().getInstance(false))
        fragmentList.add(DetailFragment().getInstance(false))
        adapter = DetailAdapter(
            supportFragmentManager,
            fragmentList
        )
        vertical_viewpager.adapter = adapter
        vertical_viewpager.offscreenPageLimit = 3
        setDuration()
    }

    /**
     * 设置viewpager的切换时间
     */
    fun setDuration() {
        try {
            val mScroller = ViewPager::class.java.getDeclaredField("mScroller")
            mScroller.setAccessible(true)
            val scroller = ViewPagerScroller(
                this,
                AccelerateInterpolator()
            )
            scroller.setDuration(300)
            mScroller.set(vertical_viewpager, scroller)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun showNext() {
        if (vertical_viewpager.currentItem < fragmentList.size - 1) {
            vertical_viewpager.currentItem = vertical_viewpager.currentItem + 1
            if (vertical_viewpager.currentItem == fragmentList.size - 1) {
                (fragmentList[fragmentList.size - 1] as DetailFragment).noMoreData()
            }
        }
    }

    fun showBefore() {
        if (vertical_viewpager.currentItem > 0) {
            vertical_viewpager.currentItem = vertical_viewpager.currentItem - 1
            (fragmentList[vertical_viewpager.currentItem] as DetailFragment).hasMoreData()
        }
    }

    var fragmentList = ArrayList<Fragment>()
    var adapter: DetailAdapter? = null
    var detailBean: DetailBean? = null

}