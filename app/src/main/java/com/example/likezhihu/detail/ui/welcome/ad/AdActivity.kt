package com.example.likezhihu.detail.ui.welcome.ad

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.ui.MainActivity
import com.example.likezhihu.detail.ui.welcome.ad.AdContract
import kotlinx.android.synthetic.main.activity_ad.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat

/**
 * 广告页
 */
class AdActivity : AppCompatActivity(){

//    override fun layoutId(): Int {
//        return R.layout.activity_ad
//    }
//
//    override fun initView() {
//        App.instances.initOkGo()
//        App.instances.initSmartRefresh()
//        App.instances.initUMeng()
//        mPresenter.attachView(this)
//        setPic()
//        initPermission()
//
//        ll_time.setOnClickListener {
//            handle.removeCallbacks(runnable)
//            change()
//        }
//    }
//
//    override fun useImmersionBar(): Boolean {
//        return true
//    }
//
//    override fun initData() {
//        mPresenter.getAdData()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad)
        Log.e("tenda", "AdActivity onCreate")
//        App.instances.initOkGo()
//        App.instances.initSmartRefresh()
//        App.instances.initUMeng()
//        mPresenter.attachView(this)
//        setPic()
        initPermission()
        ll_time.setOnClickListener {
            handle.removeCallbacks(runnable)
            change()
        }
        startTime()
    }

    fun change() {
        if (!isChagne) {
            isChagne = true
            var intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
//            startActivity<MainActivity>()
            finish()
            Log.e("tenda", "AdActivity change")
        }
    }

    override fun onStop() {
        super.onStop()
        Log.e("tenda", "AdActivity onStop")
    }

    fun startTime() {
        handle.postDelayed(runnable, 1000)
    }

//    override fun onAdDataSuccess(bean: AdBean) {
//        if (bean == null) {
//            return
//        }
//        adBean = bean
////        if (second > 0) {
////            ImageLoader.loadImage(this, image_blur, bean.img)
////        }
//        savePic()
//        saveAdInfo(bean)
//    }

//    fun setPic() {
//        var file = File(imagePath + filename + ".png")
//        if (file.exists()) {
//            image_blur.setImageBitmap(BitmapFactory.decodeFile(file.absolutePath))
//            var bean = LoginUtils.getAdInfo()
//            if (bean != null) {
//                tv_ad_title.text = bean.title
//                var day = TimeUtils.millis2String(bean.time, SimpleDateFormat("MM.dd"))
//                tv_day.text = day
//                if (bean.week == 1) {
//                    image_week.setImageResource(R.mipmap.mon)
//                } else if (bean.week == 2) {
//                    image_week.setImageResource(R.mipmap.tue)
//                } else if (bean.week == 3) {
//                    image_week.setImageResource(R.mipmap.wed)
//                } else if (bean.week == 4) {
//                    image_week.setImageResource(R.mipmap.thur)
//                } else if (bean.week == 5) {
//                    image_week.setImageResource(R.mipmap.fri)
//                } else if (bean.week == 6) {
//                    image_week.setImageResource(R.mipmap.sat)
//                } else {
//                    image_week.setImageResource(R.mipmap.sun)
//                }
//            }
//        } else {
//            image_blur.setImageResource(R.mipmap.image_welcom_new)
//        }
//    }

    fun saveAdInfo(bean: AdBean) {
//        LoginUtils.saveAdInfo(bean)
    }

    fun savePic() {
        var file = File(imagePath)
        if (!file.exists()) {
            file.mkdirs()
        }
        glideSave()
    }

    fun initPermission() {
//        val rxPermissions = RxPermissions(this)
//        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//            .subscribe { aBoolean ->
//                if (aBoolean!!) {
//                    startTime()
//                } else {
//                    ToastUtil.showShortToast("权限被拒绝，无法保存广告图")
//                }
//            }
    }

    fun glideSave() {
//        Glide.with(this)
//            .asBitmap()
//            .load(adBean?.img)
//            .into(object : SimpleTarget<Bitmap>() {
//                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                    var file = File(imagePath + filename + ".png")
//                    if (file.exists()) {
//                        file.delete()
//                    }
//                    PictureStorageUtils.isSaveImage(this@AdActivity, resource, imagePath, filename)
//                }
//            })
    }

    fun saveImage(outB: Bitmap, name: String): Boolean {
        //File.separator就是文件路径
        return try {
            val file = File(imagePath)
            if (!file.exists()) {
                file.mkdirs()
            }
            //            Log.e("tenda","saveAndGetImage:" + file);
            val filePath = File("$file/$name.png")
            //            Log.e("tenda","filePath:" + filePath);
            val out = FileOutputStream(filePath) //保存到本地，格式为JPEG
            if (outB.compress(Bitmap.CompressFormat.PNG, 100, out)) {
                out.flush()
                out.close()
            }
            //            Log.e("tenda","saveAndGetImage:END");
            true
        } catch (e: FileNotFoundException) {
            //            Log.e("tenda","FileNotFoundException e.toString: " + e.toString());
            e.printStackTrace()
            false
        } catch (e: IOException) {
            //            Log.e("tenda","IOException e.toString: " + e.toString());
            e.printStackTrace()
            false
        }
    }

//    override fun onFail(msg: String) {
//
//    }
//
//    override fun onNetWorkFail(exception: Throwable?) {
//
//    }

    override fun onDestroy() {
        super.onDestroy()
//        mPresenter.detachView()
        Log.e("tenda", "AdActivity onDestroy")
    }


    var imagePath = Environment.getExternalStorageDirectory().toString() + "/DCIM/" + ".know/"
    var filename = "splash_ad"

    var adBean: AdBean? = null

//    val mPresenter by lazy { AdPresenter(this) }

    var isChagne = false

    var handle = Handler()
    var second = 3
    var runnable = object : Runnable {
        override fun run() {
            Log.e("tenda", "second:" + second)
            if (second > 0) {
                second--
                if(second==0){
                    handle.removeCallbacks(this)
                    change()
                }
                if (tv_time != null) {
                    tv_time.text = "关闭(" + second + "s)"
                }
                handle.postDelayed(this, 1000)
            }
        }
    }
}
