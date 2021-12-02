package com.example.likezhihu.detail.util

import android.content.Context
import android.text.TextUtils
import android.util.Log

object LoginUtils {

    lateinit var context: Context

    fun register(c: Context) {
        context = c
    }

    /**
     * 保存用户信息
     * 使用版
     */
//    fun saveUserInfo(userinfoBean: MineInfoBean?) {
//        if (userinfoBean != null) {
//            val json = Gson().toJson(userinfoBean)
//            PreferencesUtils.putString(context, "userinfo", json)
//        } else {
//            PreferencesUtils.putString(context, "userinfo", "")
//        }
//    }

    /**
     * 获取用户信息
     * 使用版
     */
//    fun getUserInfo(): MineInfoBean? {
//        val json = PreferencesUtils.getString(context, "userinfo", "")
//        return if (TextUtils.isEmpty(json)) null else (Gson().fromJson(
//            json,
//            MineInfoBean::class.java
//        ))
//    }

    /**
     * 判断用户是否登录
     * @return
     */
    fun isLogin(): Boolean {
        val token = getToken()
        //已登录，并且token不为空
        var islogin = getLogin()
        if (islogin && token.isNotEmpty()) {
            return true
        }
//        Log.e("tenda", "token:" + token + " islogin:" + islogin)
        return false
    }

    /**
     * 是否是首次登陆
     */
    fun isFirstLogin(): Boolean {
        return PreferencesUtils.getBoolean(context, "isfirstlogin", true)
    }

    fun setFirstLogin(isfirst: Boolean) {
        PreferencesUtils.putBoolean(context, "isfirstlogin", isfirst)
    }

    /**
     * 是否展示推送提示弹框
     */
    fun isShowNotice(): Boolean {
        return PreferencesUtils.getBoolean(context, "shownotice", true)
    }

    fun setShowNotice(isshow: Boolean) {
        PreferencesUtils.putBoolean(context, "shownotice", isshow)
    }

    /**
     * 是否是首次答题
     */
    fun isFirstAns(): Boolean {
        return PreferencesUtils.getBoolean(context, "isfirstAns", true)
    }

    fun setFirstAns(isfirstAns: Boolean) {
        PreferencesUtils.putBoolean(context, "isfirstAns", isfirstAns)
    }

    /**
     * 是否是显示极光魔链
     */
    fun getJMLink(): Boolean {
        return PreferencesUtils.getBoolean(context, "jmlink", false)
    }

    fun setJMLink(isfirst: Boolean) {
        PreferencesUtils.putBoolean(context, "jmlink", isfirst)
    }

    /**
     * 是否已登录
     */
    fun getLogin(): Boolean {
        return PreferencesUtils.getBoolean(context, "islogin", false)
    }

    fun setLogin(islogin: Boolean) {
        PreferencesUtils.putBoolean(context, "islogin", islogin)
    }

    /**
     * 获取用户token
     * @return String?
     */
    fun getToken(): String {
        return PreferencesUtils.getString(context, "token", "")
    }

    /**
     * 保存token
     * @param token String
     */
    fun saveToken(token: String) {
        PreferencesUtils.putString(context, "token", token)
    }

    /**
     * 退出登录
     */
    fun logout() {
        PreferencesUtils.putString(context, "userinfo", "")
        PreferencesUtils.putString(context, "token", "")
        PreferencesUtils.putBoolean(context, "islogin", false)
    }

    fun isFirstOpenApp(): Boolean {
        return PreferencesUtils.getBoolean(context, "isFirstOpenApp", true)
    }

    fun setFirstOpenApp(isFirstOpenApp: Boolean) {
        PreferencesUtils.putBoolean(context, "isFirstOpenApp", isFirstOpenApp)
    }

    /**
     * 获取是否设置了账号密码
     */
    fun getAccountPsw(): Boolean {
        return PreferencesUtils.getBoolean(context, "accountpsw", false)
    }

    /**
     * 设置账号登录密码
     */
    fun setAccountPsw(accountpsw: Boolean) {
        PreferencesUtils.putBoolean(context, "accountpsw", accountpsw)
    }

    /**
     * 是否安装微信
     */
    fun isWeixinAvilible(context: Context): Boolean {
        val packageManager = context.packageManager // 获取packagemanager
        val pinfo = packageManager.getInstalledPackages(0) // 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (i in pinfo.indices) {
                val pn = pinfo[i].packageName
                if (pn == "com.tencent.mm") {
                    return true
                }
            }
        }
        return false
    }

    /**
     * 保存即时比分数据
     */
//    fun saveTimeScore(bean: TimeScoreBean) {
//        val json = Gson().toJson(bean)
//        PreferencesUtils.putString(context, "timescore", json)
//    }
//
//    fun getTimeScore(): TimeScoreBean? {
//        val json = PreferencesUtils.getString(context, "timescore", "")
//        return if (TextUtils.isEmpty(json)) null else (Gson().fromJson(
//            json,
//            TimeScoreBean::class.java
//        ))
//    }

    /**
     * 保存搜索历史记录
     */
//    fun saveSearchHistory(bean: HistoryBean) {
//        val json = Gson().toJson(bean)
//        PreferencesUtils.putString(context, "history", json)
//    }
//
//    fun getSearchHistory(): HistoryBean? {
//        var his = PreferencesUtils.getString(context, "history", "")
//        if (TextUtils.isEmpty(his)) {
//            return null
//        } else {
//            return Gson().fromJson(his, HistoryBean::class.java)
//        }
//    }

    fun clearSearchHistory() {
        PreferencesUtils.putString(context, "history", "")
    }

    /**
     * 保存话题搜索历史记录
     */
//    fun saveSearchTopicHistory(bean: HistoryBean) {
//        val json = Gson().toJson(bean)
//        PreferencesUtils.putString(context, "topic_history", json)
//    }

//    fun saveSearchTopicHistory(bean: HistoryBean, keyword: String) {
//        var newBean = HistoryBean()
//        var newList = arrayListOf<String>()
//        if (bean.list.contains(keyword)) {
//            bean.list.remove(keyword)
//        }
//        newList.add(keyword)
//        for (i in bean.list.indices) {
//            newList.add(bean.list[i])
//            /*if (i == 0) {
//                newList.add(keyword)
//            } else {
//                if (bean.list[i - 1] != keyword)
//                    newList.add(bean.list[i - 1])
//            }*/
//        }
//        newBean.list = newList
//        val json = Gson().toJson(newBean)
//        PreferencesUtils.putString(context, "topic_history", json)
//    }

//    fun getSearchTopicHistory(): HistoryBean? {
//        var his = PreferencesUtils.getString(context, "topic_history", "")
//        if (TextUtils.isEmpty(his)) {
//            return null
//        } else {
//            return Gson().fromJson(his, HistoryBean::class.java)
//        }
//    }

    /**
     * 保存在线时间
     */
//    fun saveOnLineTime(bean: OnLineTimeBean) {
//        val json = Gson().toJson(bean)
//        PreferencesUtils.putString(context, "onlinetime", json)
//    }

//    fun getOnLineTime(): OnLineTimeBean? {
//        var his = PreferencesUtils.getString(context, "onlinetime", "")
//        if (TextUtils.isEmpty(his)) {
//            return null
//        } else {
//            return Gson().fromJson(his, OnLineTimeBean::class.java)
//        }
//    }

    /**
     * 保存广告信息
     */
//    fun saveAdInfo(bean: AdBean) {
//        val json = Gson().toJson(bean)
//        PreferencesUtils.putString(context, "adinfo", json)
//    }

//    fun getAdInfo(): AdBean? {
//        var his = PreferencesUtils.getString(context, "adinfo", "")
//        if (TextUtils.isEmpty(his)) {
//            return null
//        } else {
//            return Gson().fromJson(his, AdBean::class.java)
//        }
//    }

    /**
     * 获取唯一码
     */
//    fun getDeviceId(): String {
//        var deviceid = PreferencesUtils.getString(context, "deviceid", "")
//        if (TextUtils.isEmpty(deviceid)) {
//            deviceid = GetDeviceId.getDeviceId(context)
////            Log.e("tenda", "readDeviceID:" + deviceid)
//            saveDeviceId(deviceid)
//        }
//        return deviceid
//    }

    /**
     * 保存唯一码
     */
//    fun saveDeviceId(deviceid: String) {
//        PreferencesUtils.putString(context, "deviceid", deviceid)
//    }

//    fun getCustomConfig(): CustomConfigBean? {
//        var qrcode = PreferencesUtils.getString(context, "qrcode", "")
//        if (TextUtils.isEmpty(qrcode)) {
//            return null
//        } else {
//            return Gson().fromJson(qrcode, CustomConfigBean::class.java)
//        }
//    }
//
//    fun saveCustomConfig(qrcode: CustomConfigBean) {
//        val json = Gson().toJson(qrcode)
//        PreferencesUtils.putString(context, "qrcode", json)
//    }
}