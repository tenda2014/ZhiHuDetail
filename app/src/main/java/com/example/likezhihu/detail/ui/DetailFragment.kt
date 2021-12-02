package com.example.likezhihu.detail.ui

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.util.BounceScrollView
import kotlinx.android.synthetic.main.fragment_topic_detail.*
import java.io.ByteArrayOutputStream


/**
 * description: 详情页Fragment
 * author:Tenda
 * date:2020/9/2
 */
class DetailFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_topic_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun getInstance(isfrist: Boolean): DetailFragment {
        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putBoolean("isfrist", isfrist)
        fragment.arguments = bundle
        return fragment
    }

    fun initView() {
        image_back_h.setOnClickListener {
            activity!!.finish()
        }
        isfrist = arguments!!.getBoolean("isfrist", false)
        scroll_view.setFrist(isfrist)

        scroll_view.setOnOverScrollListener(object : BounceScrollView.OnOverScrollListener {
            override fun onShowNext() {
                tv_next.text = "该话题的下一个讨论"
                tv_next.setTextColor(resources.getColor(R.color.color_text_808))
                image_arrow_up.visibility = View.GONE
                (activity as DetailActivity).showNext()
            }

            override fun onOverScrolling(fromStart: Boolean, overScrolledDistance: Int) {
                if (overScrolledDistance > 0) {
                    image_arrow_up.visibility = View.VISIBLE
                    if (overScrolledDistance > 100) {
                        tv_next.text = "松开查看"
                        image_arrow_up.rotation = 0f
//                        Log.e("tenda", "overScrolledDistance:" + overScrolledDistance + " 松开查看")
                    } else {
                        tv_next.text = "上拉查看"
                        image_arrow_up.rotation = 180f
//                        Log.e("tenda", "overScrolledDistance:" + overScrolledDistance + " 上拉查看")
                    }
                    tv_next.setTextColor(resources.getColor(R.color.color_main))
                } else {
                    tv_next.text = "该话题的下一个讨论"
                    tv_next.setTextColor(resources.getColor(R.color.color_text_808))
                    image_arrow_up.visibility = View.GONE
                }
            }

            override fun onPulling(overScrolledDistance: Int) {
                if (overScrolledDistance < -150) {
                    tv_before.text = "松开查看"
                    image_arrow_up_top.rotation = 0f
                } else {
                    tv_before.text = "下拉查看"
                    image_arrow_up_top.rotation = 180f
                }

                tv_next.text = "该话题的下一个讨论"
                tv_next.setTextColor(resources.getColor(R.color.color_text_808))
                image_arrow_up.visibility = View.GONE
            }

            override fun onShowBefore() {
                tv_before.text = "下拉查看"
                (activity as DetailActivity).showBefore()
            }
        })
    }

    fun hasMoreData() {
        ll_next_content.visibility = View.VISIBLE
        tv_no_more.visibility = View.GONE
        hasNoMoreData = false
        scroll_view.setHasNoMoreData(false)
        var params = scroll_view.layoutParams as RelativeLayout.LayoutParams
        params.bottomMargin = -2100
        scroll_view.layoutParams = params
    }

    fun noMoreData() {
        ll_next_content.visibility = View.GONE
        tv_no_more.visibility = View.VISIBLE
        hasNoMoreData = true
        scroll_view.setHasNoMoreData(true)
        var params = scroll_view.layoutParams as RelativeLayout.LayoutParams
        params.bottomMargin = 0
        scroll_view.layoutParams = params
    }

    var hasNoMoreData = false
    var isfrist = false
    var positionOffSet: Int = 0
}