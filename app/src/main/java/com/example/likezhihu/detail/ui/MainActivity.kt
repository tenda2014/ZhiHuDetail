package com.example.likezhihu.detail.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.ui.home.HomeFragment
import com.example.likezhihu.detail.weight.NativeTabButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("tenda", "MainActivity onCreate")
//        bt_see.setOnClickListener {
//            startActivity(Intent(this, DetailActivity::class.java))
//        }
        initTab()
        initFragment()
        setFragmentShow(0)
    }

    private fun initTab() {
        mTabButtons = arrayOf(tab0, tab1, tab2, tab3)
        for (i in mTabButtons!!.indices) {
            mTabButtons!![i].setTitle(getString(title[i]))
            mTabButtons!![i].setIndex(i)
            mTabButtons!![i].setSelectedImage(ContextCompat.getDrawable(this, checkImage[i]))
            mTabButtons!![i].setUnselectedImage(ContextCompat.getDrawable(this, unCheckImage[i]))
        }
    }

    private fun initFragment() {
        homeFragment = HomeFragment()
        scoreFragment = HomeFragment()
        listFragment = HomeFragment()
        mineFragment = HomeFragment()
//        scoreFragment = ScoreRootFragment()
//        listFragment = ListFragment()
//        listFragment = CreateArticleFragment()
//        listFragment = LibraryFragment()
//        listFragment.showTitle()
//        mineFragment = MineFragment()

        mFragments = arrayOf(homeFragment, scoreFragment, listFragment, mineFragment)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, homeFragment)
            .add(R.id.fragment_container, scoreFragment).hide(scoreFragment)
            .add(R.id.fragment_container, listFragment).hide(listFragment)
            .add(R.id.fragment_container, mineFragment).hide(mineFragment)
            .show(homeFragment)
            .commit()
    }

    /**
     * 底部按钮点击事件
     */
    fun setFragmentShow(index: Int) {
        if (currentTabIndex != index) {
            val trx = supportFragmentManager.beginTransaction()
            trx.hide(mFragments!![currentTabIndex])
            if (!mFragments!![index].isAdded) {
                trx.add(R.id.fragment_container, mFragments!![index])
            }
//            trx.show(mFragments!![index]).commit()
            trx.show(mFragments!![index]).commitAllowingStateLoss()
        } else {
            if (index == 0) {
                //首页刷新
                homeFragment.refreshItem()
            }
        }
        currentTabIndex = index

        for (item in mTabButtons!!) {
            item.setSelectedButton(false)
        }
        mTabButtons!![index].setSelectedButton(true)
    }

    override fun onResume() {
        super.onResume()
        Log.e("tenda", "MainActivity onResume")
    }

    lateinit var homeFragment: HomeFragment
    lateinit var scoreFragment: HomeFragment
    lateinit var listFragment: HomeFragment
    lateinit var mineFragment: HomeFragment

    var currentTabIndex: Int = 0
    private var mTabButtons: Array<NativeTabButton>? = null
    private var mFragments: Array<Fragment>? = null
    private var title =
        intArrayOf(R.string.main_tab0, R.string.main_tab1, R.string.main_tab2, R.string.main_tab3)
    private var checkImage = intArrayOf(
        R.mipmap.tab_home_s,
        R.mipmap.tab_score_s,
        R.mipmap.tab_create_s,
        R.mipmap.tab_mine_s
    )
    private var unCheckImage = intArrayOf(
        R.mipmap.tab_home_n,
        R.mipmap.tab_score_n,
        R.mipmap.tab_create_n,
        R.mipmap.tab_mine_n
    )
}