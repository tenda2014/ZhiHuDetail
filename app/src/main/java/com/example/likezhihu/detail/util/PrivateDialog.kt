package com.example.likezhihu.detail.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import com.example.likezhihu.detail.R
import com.lxj.xpopup.core.CenterPopupView
import kotlinx.android.synthetic.main.xp_private.view.*

/**
 * description: 隐私政策弹框
 * author:Tenda
 * date:2020/9/7
 */
class PrivateDialog(context: Context, var delegate: PrivateDialogDelegate) :
    CenterPopupView(context) {
    override fun getImplLayoutId(): Int = R.layout.xp_private

    @SuppressLint("JavascriptInterface")
    override fun initPopupContent() {
        super.initPopupContent()
        val webSettings = webveiw.getSettings()
//        var jsInterface = JsInterface()
        //自适应屏幕
//        webSettings.loadWithOverviewMode = true
//        webSettings.domStorageEnabled = true
//        webSettings.javaScriptEnabled = true // 设置支持javascript脚本
//        webSettings.defaultTextEncodingName = "utf-8";
//        webveiw.addJavascriptInterface(jsInterface, "jsCallJava")
//        webveiw.loadUrl(UrlUtils.h5_protocal_alert)
        ll_submit.setOnClickListener {
            delegate.onConfirm()
            dismiss()
        }
        tv_refuse.setOnClickListener {
            LoginUtils.setFirstLogin(true)
//            App.instances.exitApp()
            dismiss()
        }
    }

//    public inner class JsInterface {
//        @JavascriptInterface
//        public fun htmlcallJava(param: String) {
////            Log.e("tenda", "param:" + param)
//            if (param == "user") {
//                //用户协议
//                context.startActivity<CustomWebViewActivity>(
//                    "url" to UrlUtils.h5_protocal,
//                    "title" to "服务协议"
//                )
//            } else if (param == "privacy") {
//                //隐私政策
//                context.startActivity<CustomWebViewActivity>(
//                    "url" to UrlUtils.h5_private,
//                    "title" to "隐私政策"
//                )
//            }
//        }
//    }

    interface PrivateDialogDelegate {
        fun onConfirm()
    }
}