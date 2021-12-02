package com.major.magicfootball.ui.welcome.ad

import android.content.Context


//class AdPresenter(context: Context) : BaseKPresenter<AdContract.View>(context),
//    AdContract.Presenter {
//    override fun getAdData() {
//        val map = HashMap<String, Any>()
//        Net.getData(mContext, UrlUtils.advertisingStart, map, object : Net.Callback() {
//            override fun onSuccess(data: Any?, info: String?) {
//                mRootView?.onAdDataSuccess(
//                    Convert.fromJson(
//                        JSON.toJSONString(data),
//                        object : TypeToken<AdBean>() {}.type
//                    )
//                )
//            }
//
//            override fun onError(apiException: Throwable?) {
//                mRootView?.onFail(apiException?.message.toString())
//            }
//        })
//    }
//}