package com.example.likezhihu.detail.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.ui.MainActivity
import com.example.likezhihu.detail.util.LoginUtils
import kotlinx.android.synthetic.main.fragment_welcome.*
import java.util.concurrent.TimeUnit
import java.util.logging.Level


class WelcomFragment : Fragment() {
    var type = 1

    fun getInstance(type: Int): WelcomFragment {
        val fragment = WelcomFragment()
        val bundle = Bundle()
        bundle.putInt("type", type)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

//    override fun getLayoutId(): Int {
//        return R.layout.fragment_welcome
//    }

    fun initView() {
//        initOkGo()
//        initSmartRefresh()
        type = arguments!!.getInt("type", -1)
        if (type == 1) {
//            image.setImageResource(R.mipmap.image_welcom_n1)
//            image_bottom.setImageResource(R.mipmap.image_welcom_n1_text_1)
//            ll_position.visibility=View.VISIBLE
//            tv_n1.setBackgroundResource(R.drawable.bg_circle_color_main)
//            tv_n2.setBackgroundResource(R.drawable.bg_circle_e1e2)
//            tv_n3.setBackgroundResource(R.drawable.bg_circle_e1e2)
        } else if (type == 2) {
//            image.setImageResource(R.mipmap.image_welcom_n2)
//            image_bottom.setImageResource(R.mipmap.image_welcom_n1_text_2)
//            ll_position.visibility=View.VISIBLE
//            tv_n1.setBackgroundResource(R.drawable.bg_circle_e1e2)
//            tv_n2.setBackgroundResource(R.drawable.bg_circle_color_main)
//            tv_n3.setBackgroundResource(R.drawable.bg_circle_e1e2)
        } else if (type == 3) {
            image.setImageResource(R.mipmap.image_welcom_new)
//            image_bottom.setImageResource(R.mipmap.image_welcom_n1_text_3)
            ll_position.visibility = View.GONE
//            tv_login.visibility = View.VISIBLE
//            tv_login.setOnClickListener {
//                LoginUtils.setFirstLogin(false)
//                context!!.startActivity<MainActivity>()
//                (activity as WelcomeActivity).finish()
//            }
        }

        ll_time.setOnClickListener {
            handle.removeCallbacks(runnable)
            change()
        }
    }

    fun change() {
        if (!isChagne) {
            isChagne = true
            LoginUtils.setFirstLogin(false)
            startActivity(Intent(context, MainActivity::class.java))
            (activity as WelcomeActivity).finish()
        }
    }

    fun startTime() {
        handle.postDelayed(runnable, 1000)
    }

//    override fun lazyLoad() {
//
//    }

//    private fun initOkGo() {
//        //1. 构建OkHttpClient.Builder
//        val builder = OkHttpClient.Builder()
//        //2. 配置log
//        val loggingInterceptor = HttpLoggingInterceptor("OkGo")
//        //log打印级别，决定了log显示的详细程度
//        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
//        //log颜色级别，决定了log在控制台显示的颜色
//        loggingInterceptor.setColorLevel(Level.SEVERE)
//        builder.addInterceptor(loggingInterceptor)
//        //3. 配置超时时间
//        //全局的读取超时时间
//        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
//        //全局的写入超时时间
//        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
//        //全局的连接超时时间
//        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
//        //4. 配置Cookie，以下几种任选其一就行
//        //使用sp保持cookie，如果cookie不过期，则一直有效
//        builder.cookieJar(CookieJarImpl(SPCookieStore(App.instances)))
//
//        OkGo.getInstance().init(App.instances)                       //必须调用初始化
//            .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
//            .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
//            .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE).retryCount =
//            3                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
//
//    }

    fun initSmartRefresh() {
        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
//            layout.setPrimaryColorsId(android.R.color.transparent, R.color.color_text_gray_refresh)//全局设置主题颜色
////            var hearder = MyHeaderView(context)
//            var hearder = ClassicsHeader(context)
////            hearder.setDrawableSize(15f).setTextSizeTime(0f)
//            hearder
//            //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//        }
        //设置全局的Footer构建器
//        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
//            //指定为经典Footer，默认是 BallPulseFooter
////            layout.setPrimaryColorsId(android.R.color.transparent, R.color.color_text_gray_refresh)//全局设置主题颜色
//            var footer = ClassicsFooter(context)
//                .setDrawableSize(15f)
//                .setFinishDuration(0)
//            footer
//        }
    }

    var isChagne = false

    var handle = Handler()
    var second = 3
    var runnable = object : Runnable {
        override fun run() {
            if (second > 0) {
                second--
                if (tv_time != null) {
                    tv_time.text = "关闭(" + second + "s)"
                }
                handle.postDelayed(this, 1000)
            } else {
                handle.removeCallbacks(this)
                change()
            }
        }
    }

}
