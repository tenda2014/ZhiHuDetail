package com.example.likezhihu.detail.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.util.LoginUtils
import com.example.likezhihu.detail.util.PrivateDialog
import com.lxj.xpopup.XPopup
import com.example.likezhihu.detail.ui.welcome.ad.AdActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

/**
 * 欢迎页
 */
class WelcomeActivity : AppCompatActivity() {

    var adapter: MyAdapter? = null
    var imageList = ArrayList<Fragment>()
    lateinit var welcomFragment: WelcomFragment

    inner class MyAdapter(fm: FragmentManager, var fragments: ArrayList<Fragment>) :
        FragmentStatePagerAdapter(fm) {

        override fun getItem(i: Int): Fragment {
            return fragments[i]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.e("tenda", "WelcomeActivity:" + System.currentTimeMillis())
        //状态栏透明
//        immersionBar {
//        }
        if (LoginUtils.isFirstLogin()) {
            setContentView(R.layout.activity_welcome)
            initData()
        } else {
            startActivity(Intent(this, AdActivity::class.java))
//            startActivity<AdActivity>()
            finish()
        }
    }

//    override fun layoutId(): Int {
//        return R.layout.activity_welcome
//    }

//    override fun useImmersionBar(): Boolean {
//        return true
//    }

//    override fun initView() {
////        Log.e("tenda", "WelcomeActivity initView:" + System.currentTimeMillis())
//    }

    fun initData() {
//        if (LoginUtils.isFirstLogin()) {
//            imageList.add(WelcomFragment().getInstance(1))
//            imageList.add(WelcomFragment().getInstance(2))
        welcomFragment = WelcomFragment().getInstance(3)
//        blurImage()
        imageList.add(welcomFragment)
        adapter = MyAdapter(supportFragmentManager, imageList)
        recyclerView.adapter = adapter
        recyclerView.offscreenPageLimit = 1
        XPopup.Builder(this)
            .hasShadowBg(false)
            .dismissOnTouchOutside(false)
            .dismissOnBackPressed(false)
            .asCustom(PrivateDialog(this, object : PrivateDialog.PrivateDialogDelegate {
                override fun onConfirm() {
//                    initPermission()
                    image_blur.visibility = View.GONE
                    ll_text.visibility = View.GONE
//                    App.instances.initUMeng()
                    welcomFragment.startTime()
                }
            }))
            .show()
//        } else {
//            startActivity<MainActivity>()
//            finish()
//        }
    }

    override fun onStop() {
        super.onStop()
        Log.e("tenda", "WelcomeActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("tenda", "WelcomeActivity onDestroy")
    }

//    fun blurImage() {
//        image_blur.visibility = View.VISIBLE
//        var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.image_welcom_new)
//        var resultbit = ImageUtils.stackBlur(bitmap, 30)
//        image_blur.setImageBitmap(resultbit)
//
//        ll_text.visibility = View.VISIBLE
//        tv_txt1.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
//        var stringBuilder = SpannableString("换新升级 智能推荐")
//
//        stringBuilder.setSpan(
//            MaskFilterSpan(BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)),
//            0,
//            stringBuilder.length,
//            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
//        )
//        tv_txt1.text = stringBuilder
//
//        tv_txt2.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
//        var stringBuilder2 = SpannableString("球迷社区 聚焦热点")
//
//        stringBuilder2.setSpan(
//            MaskFilterSpan(BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)),
//            0,
//            stringBuilder2.length,
//            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
//        )
//        tv_txt2.text = stringBuilder2
//    }

//    fun initPermission() {
//        /*  Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION,*/
//        val rxPermissions = RxPermissions(this)
//        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//            .subscribe { aBoolean ->
//                if (aBoolean!!) {
//                    image_blur.visibility = View.GONE
//                    ll_text.visibility = View.GONE
//                    App.instances.initUMeng()
//                    welcomFragment.startTime()
//                } else {
//                    ToastUtil.showShortToast("权限被拒绝，无法使用app")
//                    finish()
//                }
//            }
//    }
}
