package com.example.likezhihu.detail.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.ui.home.recommend.RecommendFragment
import com.lxj.xpopup.XPopup
import kotlinx.android.synthetic.main.fragment_home.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView
import java.lang.Exception

/**
 * 首页
 */
class HomeFragment : Fragment() {

    private val titleData = arrayListOf<String>()
    private var adapter: HomeIndicatorAdapter? = null
    private var mFragments = arrayListOf<Fragment>()
    private var commonNavigator: CommonNavigator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("tenda", "HomeFragment onCreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        mIsVisible = true
        super.onViewCreated(view, savedInstanceState)
        Log.e("tenda", "HomeFragment onViewCreated")
        initView()
    }

    fun initView() {
//        mPresenter.attachView(this)
        Log.e("tenda","HomeFragment initView")

//        immersionBar {
//            transparentStatusBar()
//            statusBarDarkFont(true, 0.0f)
//        }
        titleData.add("关注")
        titleData.add("推荐")
        titleData.add("热门")
        titleData.add("新闻")

        followFragment = RecommendFragment()
        mFragments.add(followFragment)
//
        recommendFragment = RecommendFragment()
        mFragments.add(recommendFragment)

        hotFragment = RecommendFragment()
        mFragments.add(hotFragment)

        newsFragment = RecommendFragment()
        mFragments.add(newsFragment)

        adapter = HomeIndicatorAdapter(childFragmentManager, mFragments, titleData)
        viewPage.adapter = adapter
        viewPage.offscreenPageLimit = 4
        commonNavigator = CommonNavigator(activity)
        //item不均分
        commonNavigator?.isAdjustMode = false
        commonNavigator?.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int {
                return titleData.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val colorTransitionPagerTitleView = CommonPagerTitleView(context)
                colorTransitionPagerTitleView.setContentView(R.layout.item_fragment_content_top)
                val title = colorTransitionPagerTitleView.findViewById<TextView>(R.id.tv_name)
                title.text = titleData[index]
                title.textSize = 16f
                colorTransitionPagerTitleView.onPagerTitleChangeListener =
                    object : CommonPagerTitleView.OnPagerTitleChangeListener {
                        override fun onSelected(p0: Int, p1: Int) {
//                        title.setTextColor(ContextCompat.getColor(context, R.color.white))
                            title.setTextColor(resources.getColor(R.color.color_main))
                            title.paint.isFakeBoldText = true
                            title.textSize = 17f
                        }

                        override fun onLeave(p0: Int, p1: Int, p2: Float, p3: Boolean) {
//                        title.setScaleX(1.2f + (1.0f - 1.2f) * p2)
//                        title.setScaleY(1.2f + (1.0f - 1.2f) * p2)
                        }

                        override fun onEnter(p0: Int, p1: Int, p2: Float, p3: Boolean) {
//                        title.setScaleX(1.0f + (1.2f - 1.0f) * p2)
//                        title.setScaleY(1.0f + (1.2f - 1.0f) * p2)
                        }

                        override fun onDeselected(p0: Int, p1: Int) {
//                        title.setTextColor(ContextCompat.getColor(context, R.color.color_f6))
                            title.setTextColor(resources.getColor(R.color.color_ed_hint))
                            title.paint.isFakeBoldText = false
                            title.textSize = 16f
                        }

                    }
                colorTransitionPagerTitleView.setOnClickListener {
//                    if (index == 0 && !LoginUtils.isLogin()) {
//                        context.startActivity<LoginActivity>()
//                        return@setOnClickListener
//                    }
                    viewPage.currentItem = index
                }
                return colorTransitionPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator? {
//                val indicator = LinePagerIndicator(context)
//                indicator.xOffset = 30f
//                indicator.yOffset = 40f
//                indicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
////                indicator.lineWidth=50f
//                indicator.setColors(ContextCompat.getColor(context, R.color.color_main))
//                return indicator
                return null
            }
        }
        magicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(magicIndicator, viewPage)
        viewPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
//                Log.e("tenda","onPageScrollStateChanged:"+state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
//                Log.e("tenda","onPageSelected:"+position)
                if (position == 1) {
                    ll_recommend_tag.visibility = View.VISIBLE
                    ll_recommend_tag_news.visibility = View.GONE
                } else if (position == 3) {
                    ll_recommend_tag.visibility = View.GONE
                    ll_recommend_tag_news.visibility = View.VISIBLE
                } else {
                    ll_recommend_tag.visibility = View.GONE
                    ll_recommend_tag_news.visibility = View.GONE
//                    if (position == 0 && !LoginUtils.isLogin()) {
//                        context!!.startActivity<LoginActivity>()
//                        viewPage.currentItem = 1
//                    }
                }
            }
        })

        viewPage.currentItem = 1

        tv_all.setOnClickListener {
            //全部
            tv_all.setBackgroundResource(R.drawable.bg_color_main_left_s)
            tv_all.setTextColor(context!!.resources.getColor(R.color.white))
            tv_select.setBackgroundResource(R.drawable.bg_color_main_right)
            tv_select.setTextColor(context!!.resources.getColor(R.color.color_text_808))
//            (mFragments[1] as RecommendFragment).onSelect(1)
        }
        tv_select.setOnClickListener {
//            if (!LoginUtils.isLogin()) {
//                context!!.startActivity<LoginActivity>()
//                return@setOnClickListener
//            }
//            //精选
//            tv_all.setBackgroundResource(R.drawable.bg_color_main_left)
//            tv_all.setTextColor(context!!.resources.getColor(R.color.color_text_808))
//            tv_select.setBackgroundResource(R.drawable.bg_color_main_right_s)
//            tv_select.setTextColor(context!!.resources.getColor(R.color.white))
//            (mFragments[1] as RecommendFragment).onSelect(2)
//            //提交友盟统计
//            var map = HashMap<String, Any>()
//            map.put("user_id", LoginUtils.getUserInfo()?.id!!)
//            OtherUtils.upToYouMeng(context!!, "home_prime_click", map)
        }

        tv_news.setOnClickListener {
            //新闻
            tv_news.setBackgroundResource(R.drawable.bg_color_main_left_s)
            tv_news.setTextColor(context!!.resources.getColor(R.color.white))
            tv_pre.setBackgroundResource(R.drawable.bg_color_main_right)
            tv_pre.setTextColor(context!!.resources.getColor(R.color.color_text_808))
//            (mFragments[3] as NewsFragment).onNewsSelect()
        }
        tv_pre.setOnClickListener {
//            if (!LoginUtils.isLogin()) {
//                context!!.startActivity<LoginActivity>()
//                return@setOnClickListener
//            }
//            //情报
//            tv_news.setBackgroundResource(R.drawable.bg_color_main_left)
//            tv_news.setTextColor(context!!.resources.getColor(R.color.color_text_808))
//            tv_pre.setBackgroundResource(R.drawable.bg_color_main_right_s)
//            tv_pre.setTextColor(context!!.resources.getColor(R.color.white))
//            (mFragments[3] as NewsFragment).onInfoSelect()

        }

        ll_search.setOnClickListener {
//            if (!LoginUtils.isLogin()) {
//                context!!.startActivity<LoginActivity>()
//                return@setOnClickListener
//            }
//            context!!.startActivity<SearchActivity>()
        }

        //消息
        rel_notify.setOnClickListener {
//            if (!LoginUtils.isLogin()) {
//                context!!.startActivity<LoginActivity>()
//                return@setOnClickListener
//            }
//            context!!.startActivity<MyNotifyActivity>()
////            context!!.startActivity<LikeOneActivity>()
        }


    }

    fun showCurrentItem(current: Int) {
        viewPage.currentItem = current
    }

    fun showCurrentItem_JINGXUAN(current: Int) {
        viewPage.currentItem = current
        //精选
        tv_all.setBackgroundResource(R.drawable.bg_color_main_left)
        tv_all.setTextColor(context!!.resources.getColor(R.color.color_text_808))
        tv_select.setBackgroundResource(R.drawable.bg_color_main_right_s)
        tv_select.setTextColor(context!!.resources.getColor(R.color.white))
//        (mFragments[1] as RecommendFragment).onSelect(2)
//        //提交友盟统计
//        var map = HashMap<String, Any>()
//        map.put("user_id", LoginUtils.getUserInfo()?.id!!)
//        OtherUtils.upToYouMeng(context!!, "home_prime_click", map)
    }

    fun refreshItem() {
//        if (isViewPrepare && hasLoadData) {
//            if (viewPage.currentItem == 0) {
//                followFragment.refreshItem()
//            } else if (viewPage.currentItem == 1) {
//                recommendFragment.refreshItem()
//            } else {
//                hotFragment.refreshItem()
//            }
//        }
    }

//    override fun lazyLoad() {
//
//    }

//    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
//        super.setUserVisibleHint(isVisibleToUser)
//        if (isVisibleToUser) {
//            if (LoginUtils.isLogin()) {
//                mPresenter.getMessageCount()
//            }
//        }
//        Log.e("tenda", "Home setUserVisibleHint:" + isVisibleToUser)
//    }

    override fun onResume() {
        super.onResume()
//        if (LoginUtils.isLogin() && !ishidden) {
//            mPresenter.getMessageCount()
//            mPresenter.getActivityMessage()
//        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        ishidden = hidden
//        mIsVisible = hidden
//        if (!hidden && hasLoadData) {
//            if (LoginUtils.isLogin()) {
//                mPresenter.getMessageCount()
//            }
//        }
//        Log.e("tenda", "Home onHiddenChanged:" + hidden)
    }

    fun inmmerBar() {
//        immersionBar {
//            transparentStatusBar()
//            statusBarDarkFont(false, 0.0f)
//        }
//        isImmersionBar = true
    }

    fun noInmmerBar() {
//        immersionBar {
//            //只适合纯色状态栏
//            statusBarColor(R.color.white)
//            statusBarDarkFont(true, 0.0f)
//        }
//        isImmersionBar = false
    }

/*    override fun onMessageCountSuccess(bean: MessageCountBean) {
        try {
            if (unread_msg_number == null) {
                return
            }
            if (bean.count > 0) {
                unread_msg_number.visibility = View.VISIBLE
                if (bean.count > 99) {
                    unread_msg_number.text = "99"
                } else {
                    unread_msg_number.text = bean.count.toString()
                }
            } else {
                unread_msg_number.visibility = View.GONE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }*/

/*    override fun getActivityMessageSuccess(bean: ActivityMessageBean) {
        //活动结果弹框
        if (bean.state != 0) {
            var popWindow = XPopup.Builder(context)
                .asCustom(context?.let { TipActivityStateDialog(it, bean.msg) })
            popWindow.show()
        }

    }*/

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
    }

    var ishidden = true
//    lateinit var followFragment: FollowFragment
    lateinit var recommendFragment: RecommendFragment
    lateinit var hotFragment: RecommendFragment
    lateinit var newsFragment: RecommendFragment
    lateinit var followFragment: RecommendFragment
//    lateinit var hotFragment: HotFragment
//    lateinit var newsFragment: NewsFragment
    var isImmersionBar = true
//    val mPresenter by lazy { HomePresenter(context!!) }
//    override fun getLayoutId(): Int = R.layout.fragment_home

}