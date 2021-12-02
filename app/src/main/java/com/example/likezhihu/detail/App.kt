package com.example.likezhihu.detail

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.example.likezhihu.detail.util.LoginUtils
import org.json.JSONException
import org.json.JSONObject
import java.lang.ref.WeakReference
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.logging.Level


class App : Application() {

    ////默认北京经纬度
    //纬度
    var latitude: String = "39.92"

    //经度
    var longitude: String = "116.46"

    //邀请码
    var inviteCode = ""

    var mActivityStack: Stack<WeakReference<Activity>>? = null

    var fontScale = 0f

    var isReleaseWgtSuccess = false

    var uMengDeviceToken = ""

    override fun onCreate() {
        super.onCreate()
        Log.e("tenda", "App onCreate")
        instances = this
        LoginUtils.register(this)
//        ImageUtils(this)
//        LogUtils.isShowLog = true
//        initOkGo()
//        initSmartRefresh()

        //图片选择要用
//            PictureAppMaster.getInstance().app = this
//        fontScale = PreferencesUtils.getFloat(this, "fontScaleAll", 1.0f)
//        registerActivityLifecycleCallbacks(this)

//        initJiGuang()
//        if (LoginUtils.isFirstLogin()) {
//            UMConfigure.preInit(this, "", "")
//        }
//        else {
//            initUMeng()
//        }
        //google广告
//        MobileAds.initialize(this)

//        initUNIApp()
//        initFlurry()
    }

    override fun attachBaseContext(base: Context?) {
//        Log.e("tenda", "App attachBaseContext:" + System.currentTimeMillis())
        super.attachBaseContext(base)
    }

    fun initFlurry() {
        // 是否打印本地的Flurry Log
//        FlurryAgent.Builder()
//            .withLogEnabled(true)
//            .build(this, Constans.FLURRY_API_KEY)
    }

    /**
     * 极光推送和魔链
     */
//    fun initJiGuang() {
//        JPushInterface.setDebugMode(true)
//        JPushInterface.init(this)
//        //极光魔链
////        JMLinkAPI.getInstance().setDebugMode(true)
////        JMLinkAPI.getInstance().init(this)
//
//        //设置通知栏样式
//        val builder2 = BasicPushNotificationBuilder(this)
//        builder2.statusBarDrawable = R.mipmap.logo_big
//        builder2.notificationFlags = Notification.FLAG_AUTO_CANCEL // 设置为自动消失
//        builder2.notificationDefaults = (Notification.DEFAULT_SOUND
//                or Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS) // 设置为铃声与震动都要
//        JPushInterface.setDefaultPushNotificationBuilder(builder2)
////        JPushInterface.setPushNotificationBuilder(2, builder2)
//    }

    /**
     * 初始化友盟统计
     */
//    fun initUMeng() {
//        // 初始化SDK
//        /**
//         * 初始化common库
//         * 参数1:上下文，必须的参数，不能为空
//         * 参数2:友盟 app key，非必须参数，如果Manifest文件中已配置app key，该参数可以传空，则使用Manifest中配置的app key，否则该参数必须传入
//         * 参数3:友盟 channel，非必须参数，如果Manifest文件中已配置channel，该参数可以传空，则使用Manifest中配置的channel，否则该参数必须传入，channel命名请详见channel渠道命名规范
//         * 参数4:设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机
//         * 参数5:Push推送业务的secret，需要集成Push功能时必须传入Push的secret，否则传空
//         */
//        //如果AndroidManifest.xml清单配置中没有设置appkey和channel，则可以在这里设置
//        //        UMConfigure.init(this, "58edcfeb310c93091c000be2", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "1fe6a20054bcef865eeb0991ee84525b");
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, Constans.UMENG_MESSAGE_SECRET)
//        // 选用AUTO页面采集模式
//        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO)
//        // 支持在子进程中统计自定义事件
//        UMConfigure.setProcessEvent(true)
//
//        //友盟推送
//        val pushAgent = PushAgent.getInstance(this)
//        pushAgent.displayNotificationNumber = 3
//        pushAgent.register(object : IUmengRegisterCallback {
//            override fun onSuccess(deviceToken: String?) {
//                //注册成功会返回deviceToken
//                uMengDeviceToken = deviceToken!!
////                Log.e("tenda", "PushAgent Success deviceToken:" + deviceToken)
//            }
//
//            override fun onFailure(p0: String?, p1: String?) {
//                Log.e("tenda", "PushAgent Fail")
//            }
//        })
//        //小米
//        MiPushRegistar.register(this, Constans.UMENG_XIAOMI_APPID, Constans.UMENG_XIAOMI_APPKEY)
//        //华为
//        HuaWeiRegister.register(this)
//        //魅族
//        MeizuRegister.register(this, Constans.UMENG_MEIZU_APPID, Constans.UMENG_MEIZU_APPKEY)
//        //OPPO通道，参数1为app key，参数2为app secret
//        OppoRegister.register(this, Constans.UMENG_OPPO_APPKEY, Constans.UMENG_OPPO_APPSECRET)
//        //vivo 通道
//        VivoRegister.register(this)
//
//        /**
//         * 自定义弹框点击事件
//         */
//        val notificationClickHandler = object : UmengNotificationClickHandler() {
//            override fun dealWithCustomAction(context: Context?, msg: UMessage) {
//                super.dealWithCustomAction(context, msg)
////                var extras = msg.custom
//                var extras = msg.extra
//                Log.e("tenda", "extras:" + extras)
//                if (extras.isEmpty()) return
//                try {
//                    val type = extras.get("type")
////                    if (extraJson.length() > 0) {
////                        val type = extraJson.getString("type")
//                    /**
//                     * 消息类型
//                     * 更新通知 recommended  //点击进入本场赛事推荐
//                     * 系统通知 fans         //点击进入消息-通知  关注
//                     * 系统通知 like         //点击进入消息-点赞  点赞
//                     * 系统通知 reply         //点击进入消息-评论  评论
//                     * 系统通知 callReply         //点击进入消息-回复评论  回复评论
//                     * 系统通知 topicBuy         //点击进入消息-通知  文章被购买
//                     *   * 签到提醒 signMessage         //点击进入我的-签到
//                     */
//                    if (!LoginUtils.isLogin()) {
//                        startActivity<LoginActivity>()
//                        return
//                    }
//                    val notify = Intent(context, MyNotifyActivity::class.java)
//                    notify.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    if (type == "recommended") {
//                        //{"topicId":250}
//                        val content = extras.get("content")
////                            val content = extraJson.getString("content")
//                        val contentjson = JSONObject(content)
//                        val topicId = contentjson.getInt("topicId")
//                        val article =
//                            Intent(context, ArticleDetailActivity::class.java)
//                        article.flags = Intent.FLAG_ACTIVITY_NEW_TASK
////                        article.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
//                        article.putExtra("id", topicId)
//                        startActivity(article)
//                    } else if (type == "fans") {
//                        notify.putExtra("index", 2)
//                        startActivity(notify)
//                    } else if (type == "like") {
//                        notify.putExtra("index", 0)
//                        startActivity(notify)
//                    } else if (type == "reply") {
//                        notify.putExtra("index", 1)
//                        startActivity(notify)
//                    } else if (type == "callReply") {
//                        notify.putExtra("index", 1)
//                        startActivity(notify)
//                    } else if (type == "topicBuy") {
//                        notify.putExtra("index", 2)
//                        startActivity(notify)
//                    } else if (type == "signMessage") {
//                        val sign =
//                            Intent(context, TaskActivity::class.java)
//                        sign.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                        sign.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//                        startActivity(sign)
//                    }
////                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//
//            }
//        }
//        pushAgent.notificationClickHandler = notificationClickHandler
//    }


    companion object {
        lateinit var instances: App
    }


/*    fun initOkGo() {
        //1. 构建OkHttpClient.Builder
        val builder = OkHttpClient.Builder()
        //2. 配置log
        val loggingInterceptor = HttpLoggingInterceptor("OkGo")
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.SEVERE)
        builder.addInterceptor(loggingInterceptor)
        //3. 配置超时时间
        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        //全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        //全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        //4. 配置Cookie，以下几种任选其一就行
        //使用sp保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(CookieJarImpl(SPCookieStore(this)))

        OkGo.getInstance().init(this)                       //必须调用初始化
            .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
            .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
            .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE).retryCount =
            3                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0

    }*/

/*    fun initSmartRefresh() {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(android.R.color.transparent, R.color.color_text_gray_refresh)//全局设置主题颜色
//            var hearder = MyHeaderView(context)
            var hearder = ClassicsHeader(context)
//            hearder.setDrawableSize(15f).setTextSizeTime(0f)
            hearder
            //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            //指定为经典Footer，默认是 BallPulseFooter
//            layout.setPrimaryColorsId(android.R.color.transparent, R.color.color_text_gray_refresh)//全局设置主题颜色
            var footer = ClassicsFooter(context)
                .setDrawableSize(15f)
                .setFinishDuration(0)
            footer
        }
    }*/

    /**
     * 初始化uni-app
     */
//    fun initUNIApp() {
//        //初始化 uni小程序SDK ----start----------
////        val item = MenuActionSheetItem("关于", "gy")
////        val item1 = MenuActionSheetItem("获取当前页面url", "hqdqym")
////        val item2 = MenuActionSheetItem("跳转到宿主原生测试页面", "gotoTestPage")
////        val sheetItems: MutableList<MenuActionSheetItem> = ArrayList<MenuActionSheetItem>()
////        sheetItems.add(item)
////        sheetItems.add(item1)
////        sheetItems.add(item2)
//        val config = DCSDKInitConfig.Builder()
//            .setCapsule(false)
////            .setMenuDefFontSize("16px")
////            .setMenuDefFontColor("#ff00ff")
////            .setMenuDefFontWeight("normal")
////            .setMenuActionSheetItems(sheetItems)
////            .setEnableBackground(false) //开启后台运行
//            .build()
//        DCUniMPSDK.getInstance().initialize(this, config, object : DCUniMPSDK.IDCUNIMPPreInitCallback {
//            override fun onInitFinished(b: Boolean) {
//                if (b) {
//                    var path = DCUniMPSDK.getInstance().getAppBasePath(appContext)
//                    val wgtPath = path + "__UNI__11019C4/www/__UNI__11019C4.wgt"
//                    var file = File(wgtPath)
//                    if (!file.exists()) {
//                        downloadWGT()
//                    }
//                }
////                LogUtils.log("onInitFinished----$b")
//            }
//        })
//        //初始化 uni小程序SDK ----end----------
//    }

    /**
     * 下载uni小程序wgt包
     */
    fun downloadWGT() {
//        var path = DCUniMPSDK.getInstance().getAppBasePath(this)
//        DownLoadFileUtils.downloadFile(
//            this, "https://shenjiballs.oss-cn-hangzhou.aliyuncs.com/app/__UNI__11019C4.wgt",
//            path + "__UNI__11019C4/www/", "__UNI__11019C4.wgt",
//            DownLoadFileUtils.DownloadCallBack {
//                releaseUniWgt()
//            }
//        )
    }

    /**
     * 释放uni小程序wgt包
     */
    fun releaseUniWgt() {
//        var path = DCUniMPSDK.getInstance().getAppBasePath(this)
//        val wgtPath = path + "__UNI__11019C4/www/__UNI__11019C4.wgt"
//        LogUtils.log("release path:" + wgtPath)
//        DCUniMPSDK.getInstance().releaseWgtToRunPathFromePath("__UNI__11019C4", wgtPath, object : ICallBack {
//            override fun onCallBack(code: Int, pArgs: Any?): Any? {
//                LogUtils.log("release: code: " + code + " pArgs:" + pArgs)
//                if (code == 1) { //释放wgt完成
//                    try {
//                        LogUtils.log("release success")
////                        DCUniMPSDK.getInstance().startApp(appContext, "__UNI__11019C4")
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//                } else { //释放wgt失败
//                    LogUtils.log("release fail")
////                    Toast.makeText(context, "资源释放失败", Toast.LENGTH_SHORT).show()
//                }
//                return null
//            }
//        })
    }

    /**
     * 添加Activity到栈
     *
     * @param activity
     */
    fun addActivity(activity: Activity) {
        if (mActivityStack == null) {
            mActivityStack = Stack()
        }
        mActivityStack?.add(WeakReference(activity))
    }

    /**
     * 退出应用程序
     */
    fun exitApp() {
        try {
            finishAllActivity()
            // 退出JVM,释放所占内存资源,0表示正常退出
            System.exit(0)
            // 从系统中kill掉应用程序
            android.os.Process.killProcess(android.os.Process.myPid())
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        if (mActivityStack != null) {
            for (activityReference in mActivityStack!!) {
                val activity = activityReference.get()
                if (activity != null) {
                    activity.finish()
                }
            }
            mActivityStack?.clear()
        }
    }

    /**
     * 重新登录
     */
/*    fun reLogin() {
        runOnUiThread {
//            if (JPushInterface.getConnectionState(this)) {
//                deleteAlis()
//            }
            deleteUMAlias()
            LoginUtils.logout()
            MainActivity.mainActivityInstance?.stopTime()
//        finishAllActivity()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("goMain", true)
            startActivity(intent)
        }
    }*/

    /**
     * 删除友盟推送aLIAS
     */
/*    fun deleteUMAlias() {
        var alias = LoginUtils.getUserInfo()?.id.toString()
        Log.e("tenda", "deleteUMAlias alias:" + alias)
        if (TextUtils.isEmpty(alias) && alias != "0") {
            return
        }
        val pushAgent = PushAgent.getInstance(this)
        pushAgent.deleteAlias(alias, "user", object : UTrack.ICallBack {
            override fun onMessage(isSuccess: Boolean, message: String) {
                Log.e("tenda", "deleteAlias isSuccess:" + isSuccess + " message:" + message)
            }
        })
    }*/

    /**
     * 删除极光推送Alis
     */
//    fun deleteAlis() {
//        val tagAliasBean = TagAliasOperatorHelper.TagAliasBean()
//        tagAliasBean.action = TagAliasOperatorHelper.ACTION_DELETE
//        TagAliasOperatorHelper.sequence++
//        tagAliasBean.isAliasAction = true
//        TagAliasOperatorHelper.getInstance()
//            .handleAction(applicationContext, TagAliasOperatorHelper.sequence, tagAliasBean)
//    }

    /*override fun getResources(): Resources {
        var resources=super.getResources()
        Log.e("tenda", "app system size:" + resources.getConfiguration().fontScale)
        if (resources.getConfiguration().fontScale !== fontScale) {
            val configuration: Configuration = resources.getConfiguration()
            configuration.fontScale = fontScale
            resources.updateConfiguration(configuration, resources.getDisplayMetrics())
        }
        return resources
    }*/

//    override fun onActivityPaused(p0: Activity) {
//
//    }
//
//    override fun onActivityStarted(p0: Activity) {
//
//    }
//
//    override fun onActivityDestroyed(p0: Activity) {
//
//    }
//
//    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
//
//    }
//
//    override fun onActivityStopped(p0: Activity) {
//
//    }

//    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
    // 禁止字体大小随系统设置变化
//        val resources: Resources = activity.getResources()
//        if (resources != null && resources.configuration.fontScale != fontScale) {
//            val configuration = resources.configuration
//            configuration.fontScale = fontScale
//            resources.updateConfiguration(configuration, resources.displayMetrics)
//        }
//        addActivity(activity)
//    }

//    override fun onActivityResumed(p0: Activity) {
//
//    }

//    override fun getAppContext(): Context? {
//        return this
//    }
//
//    override fun getPictureSelectorEngine(): PictureSelectorEngine? {
//        return PictureSelectorEngineImp()
//    }

//    override fun attachBaseContext(newBase: Context) {
//        super.attachBaseContext(newBase)
//        MultiDex.install(this)
//    }

}