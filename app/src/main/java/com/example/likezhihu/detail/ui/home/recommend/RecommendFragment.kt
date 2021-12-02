package com.example.likezhihu.detail.ui.home.recommend

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.likezhihu.detail.R
import com.example.likezhihu.detail.util.LoginUtils
import com.lxj.xpopup.XPopup
import java.text.SimpleDateFormat
import kotlin.random.Random

/**
 * 推荐页面
 */
class RecommendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("tenda", "RecommendFragment onCreateView")
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("tenda", "RecommendFragment onViewCreated")
        initView()
    }

//    fun setViewFocus() {
//        /**
//         * 处理查看大图返回键
//         */
//        view!!.isFocusableInTouchMode = true
//        view!!.requestFocus()
//        view!!.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
//            if (keyEvent.action === KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_BACK) {
//                if (iwHelper != null) {
//                    return@OnKeyListener iwHelper!!.handleBackPressed()
//                }
//            }
//            false
//        })
//    }

    fun initView() {
//        EventBus.getDefault().register(this)
//        mPresenter.attachView(this)
//        mTencent = Tencent.createInstance(Constans.QQ_APP_ID, context)
//        refreshlayout.setEnableAutoLoadMore(false)
//        refreshlayout.setFooterInsetStart(-150f)
//        refreshlayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
//            override fun onLoadMore(refreshLayout: RefreshLayout) {
//                page++
//                mPresenter.getData(page, type)
//            }
//
//            override fun onRefresh(refreshLayout: RefreshLayout) {
//                page = 1
//                getData()
//            }
//        })
//        initSdk()
//        initDynamicAdapter()
//        initMoreDialog()


//        nestedScrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
//            if (scrollY == 0) {
//                isScrolledToTop = true
//            } else {
//                isScrolledToTop = false
//            }
//        }
    }

    //绑定顶部布局
/*    fun bindHeadView() {
        var headview = LayoutInflater.from(context).inflate(R.layout.fragment_recommend_head, null, false)
        ll_game = headview.findViewById<LinearLayout>(R.id.ll_game)
        recyclerView_game = headview.findViewById<RecyclerView>(R.id.recyclerView_game)
        layout_banner = headview.findViewById<RelativeLayout>(R.id.layout_banner)
        xbanner = headview.findViewById<XBanner>(R.id.xbanner)
        initGameAdapter()
        dynamicAdapter?.addHeaderView(headview)
    }*/

    //初始化比赛布局
/*    fun initGameAdapter() {
        recyclerView_game.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        hotGameAdapter = RecommendHotGameAdapter()
        recyclerView_game.adapter = hotGameAdapter
        hotGameAdapter?.addChildClickViewIds(R.id.ll_game_root)
        hotGameAdapter?.setOnItemChildClickListener { adapter, view, position ->
            context!!.startActivity<ScoreDetailActivity>("id" to hotGameList[position].id)
        }
    }*/

/*    fun lazyLoad() {
//        handler.postDelayed({
        Log.e("tenda", "RecommendFragment lazyLoad")
        loading_data.visibility = View.VISIBLE
        getData()
        if (LoginUtils.isLogin()) {
            mPresenter.getReportList("report_type")
        }
//        }, 2000)
    }*/

/*    fun refreshItem() {
        if (isScrolledToTop) {
            refreshlayout.autoRefresh()
        } else {
            recyclerView_all.post {
//                recyclerView_all.scrollToPosition(0)
                recyclerView_all.smoothScrollToPosition(0)
            }
        }
//        nestedScrollView.scrollTo(0, 0)
//        refreshlayout.autoRefresh()
    }*/

    /**
     * 1 全部， 2精选
     */
//    fun onSelect(select: Int) {
//        page = 1
//        if (select == 1) {
//            type = 0
//        } else {
//            type = 1
//        }
//        getData()
//    }

/*    fun getData() {
        //推荐数据
        mPresenter.getData(page, type)
//        if (LoginUtils.isLogin()) {
        //首页banner图
        mPresenter.getActivity()
        //热门赛事
        mPresenter.getHotGameList()
//        }
    }*/

/*    override fun onDataSuccess(list: List<RecommendBean>) {
        loading_data.visibility = View.GONE
        no_network.visibility = View.GONE
        if (page == 1) {
            refreshlayout.finishRefresh()
            //有动态内容
            dynamicList.clear()
        }
        refreshlayout.finishLoadMore()
        if (list.isEmpty()) {
            refreshlayout.finishLoadMoreWithNoMoreData()
        }
        dynamicList.addAll(list)
        for (i in dynamicList.indices) {
            if (dynamicList[i].type == 1) {
                dynamicList[i].showImageList = true
                break
            }
        }
        if (page == 1) {
            //加入google原生广告
//            getGoogleAd()
        }
        dynamicAdapter?.setType(type)
        dynamicAdapter?.setList(dynamicList)
        if (dynamicList.isEmpty()) {
            ll_no_data.visibility = View.VISIBLE
        } else {
            ll_no_data.visibility = View.GONE
        }
    }*/

/*    fun getGoogleAd() {
        var adLoader = AdLoader.Builder(context, "ca-app-pub-8864224354306107/5597882128")
            .forNativeAd(object : NativeAd.OnNativeAdLoadedListener {
                override fun onNativeAdLoaded(p0: NativeAd) {
//                    Log.e("tenda", "onNativeAdLoaded")
                    if (dynamicList.isNotEmpty()) {
                        var googlebean = RecommendBean()
                        googlebean.type = 6
                        googlebean.nativeAd = p0
                        var random = Random.nextInt(dynamicList.size)
                        dynamicList.add(random, googlebean)
                        dynamicAdapter?.setList(dynamicList)
                    }
                }
            })
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
//                    Log.e("tenda", "onAdFailedToLoad:" + p0.message)
                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
//                    Log.e("tenda", "onAdLoaded")
                }

                override fun onAdClicked() {
                    super.onAdClicked()
//                    Log.e("tenda", "onAdClicked")
                }

                override fun onAdClosed() {
                    super.onAdClosed()
//                    Log.e("tenda", "onAdClosed")
                }

                override fun onAdOpened() {
                    super.onAdOpened()
//                    Log.e("tenda", "onAdOpened")
                }

                override fun onAdImpression() {
                    super.onAdImpression()
//                    Log.e("tenda", "onAdImpression")
                }
            })
            .build()
        adLoader.loadAd(AdRequest.Builder().build())
    }*/

  /*  override fun onLikeSuccess(msg: String) {
        showToast(msg)
//        ToastUtil.showToastCustomer(msg,context!!)
        if (dynamicList[rememberPosition].hasLike == 0) {
            dynamicList[rememberPosition].hasLike = 1
            dynamicList[rememberPosition].likeCount += 1
        }
        dynamicAdapter?.notifyDataSetChanged()
    }*/

   /* override fun unLikeSuccess(msg: String) {
        showToast(msg)
//        ToastUtil.showToastCustomer(msg,context!!)
        dynamicList[rememberPosition].hasLike = 0
        dynamicList[rememberPosition].likeCount -= 1
        dynamicAdapter?.notifyDataSetChanged()
    }*/

   /* override fun onCommendSuccess(msg: String) {
//        showToast(msg)
        ToastUtil.showToastCustomer(msg, context!!)
        if (commentBean != null) {
            if (dynamicList[rememberPosition].hotReplyList.size < 2) {
                dynamicList[rememberPosition].hotReplyList.add(commentBean)
            }
            dynamicList[rememberPosition].totalReplyCount += 1
            dynamicAdapter?.notifyDataSetChanged()
        }
    }*/

    /*override fun onCollectSuccess(msg: String) {
//        showToast(msg)
        ToastUtil.showToastCustomer(msg, context!!)
        dynamicList[rememberPosition].hasFavorite = 1
        dynamicAdapter?.notifyDataSetChanged()
    }*/

   /* override fun unCollectSuccess(msg: String) {
//        showToast(msg)
        ToastUtil.showToastCustomer(msg, context!!)
        dynamicList[rememberPosition].hasFavorite = 0
        dynamicAdapter?.notifyDataSetChanged()
    }*/

   /* override fun onFollowSuccess(bean: FollowResultBean) {
        var followid = dynamicList[rememberPosition].userId
        if (bean.status == 1) {
//            showToast(bean.message)
            ToastUtil.showToastCustomer(bean.message, context!!)
            for (i in 0 until dynamicList.size) {
                if (dynamicList[i].userId == followid) {
                    dynamicList[i].hasFollow = 1
                }
            }
            dynamicAdapter?.notifyDataSetChanged()
            mPresenter.getRecommendPeople()
            //提交友盟统计
            var map = HashMap<String, Any>()
            map.put("user_id", LoginUtils.getUserInfo()?.id!!)
            map.put("follow_id", followid)
            OtherUtils.upToYouMeng(context!!, "home_follow_click", map)
        } else {
            XPopup.Builder(context)
                .asCustom(FreedomDialog(context!!, object : FreedomDialog.FreedomDialogDelegate {
                    override fun onConfirm() {
                        //解除屏蔽，并关注
                        mPresenter.freedomUser(followid)
                    }
                })).show()
        }
    }*/

    /*override fun onFreeDomUserSuccess(msg: String) {
//        showToast(msg)
        ToastUtil.showToastCustomer(msg, context!!)
        if (isfollowone) {
            isfollowone = false
            dynamicList[rememberPosition].isOpen = true
            for (i in 0 until dynamicList[rememberPosition].recomendPeopleList.size - 1) {
                if (dynamicList[rememberPosition].recomendPeopleList[i].id == followId) {
                    dynamicList[rememberPosition].recomendPeopleList.removeAt(i)
                    break
                }
            }
            dynamicList[rememberPosition].followPosition = listPosition
            dynamicList[rememberPosition].followOffset = lastOffSet
            dynamicAdapter?.notifyDataSetChanged()
        } else {
            var followid = dynamicList[rememberPosition].userId
            for (i in 0 until dynamicList.size) {
                if (dynamicList[i].userId == followid) {
                    dynamicList[i].hasFollow = 1
                }
            }
            dynamicAdapter?.notifyDataSetChanged()
            mPresenter.getRecommendPeople()
            //提交友盟统计
            var map = HashMap<String, Any>()
            map.put("user_id", LoginUtils.getUserInfo()?.id!!)
            map.put("follow_id", followid)
            OtherUtils.upToYouMeng(context!!, "home_follow_click", map)
        }
    }*/

   /* override fun getActivitySuccess(list: List<ActivityBean>) {
        if (list.isNotEmpty()) {
            layout_banner.visibility = View.VISIBLE
            xbanner.setBannerData(R.layout.item_recommend_banner, list)
            xbanner.loadImage { banner, model, view, position ->
                var image_banner = view.findViewById<ImageView>(R.id.image_banner)
                var tv_ad_title = view.findViewById<TextView>(R.id.tv_ad_title)
                ImageLoader.loadImage(context, image_banner, list[position].img)
                var label = list[position].label
                if (!TextUtils.isEmpty(label)) {
                    tv_ad_title.visibility = View.VISIBLE
                    tv_ad_title.text = label
                } else {
                    tv_ad_title.visibility = View.GONE
                }
            }
            xbanner.setOnItemClickListener { banner, model, view, position ->
                if (!LoginUtils.isLogin()) {
                    context!!.startActivity<LoginActivity>()
                    return@setOnItemClickListener
                }
                val intent = Intent(activity, ActionActivity::class.java)
                intent.putExtra("url", list[position].url)
                intent.putExtra("title", list[position].name)
                startActivity(intent)
            }
//            layout_banner.visibility = View.VISIBLE
//            layout_banner.isFocusable = true
//            val images: MutableList<String?> = ArrayList()
//            for (bannerBean in list) {
//                images.add(bannerBean.img)
//            }
//            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR) //设置圆形指示器与标题
//            banner.setIndicatorGravity(BannerConfig.CENTER) //设置指示器位置
//            banner.setImageLoader(GlideImageLoader())
//            banner.setDelayTime(4000) //设置轮播时间
//            banner.setImages(images) //设置图片源
//            banner.setBannerAnimation(Transformer.ZoomOutSlide)
//            banner.setOnBannerListener { position ->
//                if (!LoginUtils.isLogin()) {
//                    context!!.startActivity<LoginActivity>()
//                    return@setOnBannerListener
//                }
//                val intent =
//                    Intent(activity, ActionActivity::class.java)
//                intent.putExtra("url", list[position].url)
//                intent.putExtra("title", list[position].name)
//                startActivity(intent)
//            }
//            banner.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//                override fun onPageScrollStateChanged(state: Int) {
//
//                }
//
//                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//
//                }
//
//                override fun onPageSelected(position: Int) {
//                    try {
//                        var label = list[position].label
//                        if (!TextUtils.isEmpty(label)) {
//                            tv_ad_title.visibility = View.VISIBLE
//                            tv_ad_title.text = list[position].label
//                        } else {
//                            tv_ad_title.visibility = View.GONE
//                        }
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//
//                }
//            })
//            banner.start()
        } else {
            layout_banner.visibility = View.GONE
        }
    }*/

   /* override fun getHotGameSuccess(list: List<ScoreItemBean>) {
        if (list.isNotEmpty()) {
            ll_game.visibility = View.VISIBLE
        } else {
            ll_game.visibility = View.GONE
        }
        hotGameList.clear()
        hotGameList.addAll(list)
        hotGameAdapter?.setList(hotGameList)
        var headerView = LayoutInflater.from(context).inflate(R.layout.item_recommend_hotgame_head, null)
        var tv_date = headerView.findViewById<TextView>(R.id.tv_date)
        var tv_game_size = headerView.findViewById<TextView>(R.id.tv_game_size)
        var date = TimeUtils.millis2String(System.currentTimeMillis(), SimpleDateFormat("MM月dd日"))
        tv_date.text = date
        tv_game_size.text = list.size.toString() + "场"
        hotGameAdapter?.setHeaderView(headerView, 0, LinearLayoutManager.HORIZONTAL)
        hotGameAdapter?.headerLayout?.gravity = Gravity.CENTER_VERTICAL
    }*/

    /*override fun unFollowSuccess(msg: String) {
//        showToast(msg)
        ToastUtil.showToastCustomer(msg, context!!)
        var followid = dynamicList[rememberPosition].userId
        for (i in 0 until dynamicList.size) {
            if (dynamicList[i].userId == followid) {
                dynamicList[i].hasFollow = 0
            }
        }
        dynamicAdapter?.notifyDataSetChanged()
    }*/

    /*override fun onReportListSuccess(list: List<CustomBean>) {
        reportList.clear()
        reportList.addAll(list)
    }*/

    /*override fun onReportSuccess(msg: String) {
//        showToast(msg)
        ToastUtil.showToastCustomer("举报成功", context!!)
        //提交友盟统计
        var map = HashMap<String, Any>()
        map.put("user_id", LoginUtils.getUserInfo()?.id!!)
        map.put("report_id", report_id)
        OtherUtils.upToYouMeng(context!!, "report_click", map)
    }*/

    /*override fun onRecommendListSuccess(list: List<RecommendPeopleBean>) {
        if (list.isNotEmpty()) {
            dynamicList[rememberPosition].isOpen = true
            dynamicList[rememberPosition].recomendPeopleList.clear()
            dynamicList[rememberPosition].recomendPeopleList.addAll(list)
            dynamicList[rememberPosition].followPosition = listPosition
            dynamicList[rememberPosition].followOffset = lastOffSet
            dynamicAdapter?.notifyDataSetChanged()
            //提交友盟统计
            var map = HashMap<String, Any>()
            map.put("user_id", LoginUtils.getUserInfo()?.id!!)
            OtherUtils.upToYouMeng(context!!, "home_follow_refresh_click", map)
        }
    }

    override fun onFollowOneSuccess(bean: FollowResultBean) {
        if (bean.status == 1) {
//            showToast(bean.message)
            ToastUtil.showToastCustomer(bean.message, context!!)
            var index = -1
            dynamicList[rememberPosition].isOpen = true
            for (i in 0 until dynamicList[rememberPosition].recomendPeopleList.size) {
                if (dynamicList[rememberPosition].recomendPeopleList[i].id == followId) {
                    index = i
                    break
                }
            }
            if (index != -1) {
                dynamicList[rememberPosition].recomendPeopleList.removeAt(index)
            }
            dynamicList[rememberPosition].followPosition = listPosition
            dynamicList[rememberPosition].followOffset = lastOffSet
            dynamicAdapter?.notifyDataSetChanged()
        } else {
            XPopup.Builder(context)
                .asCustom(FreedomDialog(context!!, object : FreedomDialog.FreedomDialogDelegate {
                    override fun onConfirm() {
                        //解除屏蔽，并关注
                        isfollowone = true
                        mPresenter.freedomUser(dynamicList[rememberPosition].id)

                    }
                })).show()
        }
    }

    override fun onFollowAllSuccess(msg: String) {
        ToastUtil.showToastCustomer(msg, context!!)
//        showToast(msg)
        dynamicList[rememberPosition].isOpen = false
        dynamicAdapter?.notifyDataSetChanged()
    }*/

    //动态内容
    /*fun initDynamicAdapter() {
        recyclerView_all.clearFocus()
        recyclerView_all.isFocusable = false
//        var manager = object : LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false) {
//            override fun canScrollVertically(): Boolean {
//                return true
//            }
//        }
        var manager = ScrollSpeedLinearLayoutManger(context!!, LinearLayoutManager.VERTICAL, false)
        manager.setSpeedFast()
        recyclerView_all.layoutManager = manager
        recyclerView_all.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //获取RecyclerView当前顶部显示的第一个条目对应的索引
                val position: Int = manager.findFirstVisibleItemPosition()
                //根据索引来获取对应的itemView
                val firstVisiableChildView = manager.findViewByPosition(position)
                if (firstVisiableChildView != null) {
                    //获取当前显示条目的高度
                    val itemHeight = firstVisiableChildView.height
                    //获取当前Recyclerview 偏移量
                    val flag = position * itemHeight - firstVisiableChildView.top
                    //注意事项：recyclerView不要设置padding
                    if (flag == 0) {
                        isScrolledToTop = true
                    } else {
                        isScrolledToTop = false
                    }
                }
            }
        })
        dynamicAdapter = DynamicAdapter(1, object : DynamicAdapter.DynamicAdapterDelegate {
            override fun onFollowOne(position: Int, id: Int, listPosition: Int, lastOffSet: Int) {
                //关注其中一个用户
                rememberPosition = position
                followType = 1
                followId = id
                mPresenter.followOne(id)
                this@RecommendFragment.listPosition = listPosition
                this@RecommendFragment.lastOffSet = lastOffSet
                //提交友盟统计
                var map = HashMap<String, Any>()
                map.put("user_id", LoginUtils.getUserInfo()?.id!!)
                map.put("follow_id", id)
                OtherUtils.upToYouMeng(context!!, "home_follow_click", map)
            }

            override fun onFollowAll(position: Int, ids: String) {
                //批量关注用户
                rememberPosition = position
                mPresenter.followAll(ids)
            }

            override fun seeBigImage(
                parentposition: Int,
                childposition: Int,
                imageView: ImageView,
                imageViewList: List<ImageView>
            ) {
//                Log.e("tenda", "imageViewList size:" + imageViewList.size)
                //查看大图
                var bigimagelist = arrayListOf<String>()
                var images = dynamicList[parentposition].imageList
                if (images.isNotEmpty()) {
                    for (i in images.indices) {
                        bigimagelist.add(images[i].url)
                    }
//                    seeImage(childposition, bigimagelist)
                    iwHelper = ImageLoader.seeBigImage(activity, imageView, imageViewList, bigimagelist)
                    setViewFocus()
                }
            }
        })
        recyclerView_all.adapter = dynamicAdapter
        bindHeadView()
        dynamicAdapter?.addChildClickViewIds(
            R.id.image_more,
            R.id.image_more_artice,
            R.id.ll_like,
            R.id.ll_commend,
            R.id.ll_comment_more,
            R.id.tv_follow,
            R.id.image_avatar,
            R.id.image_share,
            R.id.ll_change,
            R.id.image_pic,
            R.id.image_big,
            R.id.image_close,
            R.id.image_two_1,
            R.id.image_two_2,
            R.id.tv_topic,
            R.id.tv_content,
            R.id.tv_title,
            R.id.image_list
        )
        dynamicAdapter?.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                //更多
                R.id.image_more -> {
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    var bean = dynamicList[position]
                    var ismine = false
                    if (bean.userId == LoginUtils.getUserInfo()?.id) {
                        ismine = true
                    }
                    XPopup.Builder(context)
                        .asCustom(
                            DynamicMoreDialog(
                                context!!,
                                bean.hasFavorite,
                                bean.hasFollow,
                                ismine,
                                reportList,
                                object : DynamicMoreDialog.DynamicMoreDialogDelegate {
                                    override fun onCollect() {
                                        rememberPosition = position
                                        if (bean.hasFavorite == 0) {
                                            //收藏
                                            mPresenter.collect(bean.id)
                                        } else {
                                            //取消收藏
                                            mPresenter.uncollect(bean.id)
                                        }
                                    }

                                    override fun onFollow() {
                                        rememberPosition = position
                                        if (bean.hasFollow == 0) {
                                            //关注
                                            mPresenter.follow(bean.userId)
                                        } else {
                                            //取消关注
                                            mPresenter.unfollow(bean.userId)
                                        }
                                    }

                                    override fun onReport(id: Int, reason: String) {
                                        //举报主题
                                        report_id = id
                                        mPresenter.onReport(bean.id, 1, id, reason, "")
                                    }

                                })
                        )
                        .show()
                }
                R.id.image_more_artice -> {
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    var bean = dynamicList[position]
                    var ismine = false
                    if (bean.userId == LoginUtils.getUserInfo()?.id) {
                        ismine = true
                    }
                    XPopup.Builder(context)
                        .asCustom(
                            DynamicMoreDialog(
                                context!!,
                                bean.hasFavorite,
                                bean.hasFollow,
                                ismine,
                                reportList,
                                object : DynamicMoreDialog.DynamicMoreDialogDelegate {
                                    override fun onCollect() {
                                        rememberPosition = position
                                        if (bean.hasFavorite == 0) {
                                            //收藏
                                            mPresenter.collect(bean.id)
                                        } else {
                                            //取消收藏
                                            mPresenter.uncollect(bean.id)
                                        }
                                    }

                                    override fun onFollow() {
                                        rememberPosition = position
                                        if (bean.hasFollow == 0) {
                                            //关注
                                            mPresenter.follow(bean.userId)
                                        } else {
                                            //取消关注
                                            mPresenter.unfollow(bean.userId)
                                        }
                                    }

                                    override fun onReport(id: Int, reason: String) {
                                        //举报主题
                                        report_id = id
                                        mPresenter.onReport(bean.id, 1, id, reason, "")
                                    }

                                })
                        )
                        .show()
                }
                R.id.ll_like -> {
                    //点赞
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    rememberPosition = position
//                    if (dynamicList[position].hasLike == 0) {
                    //点赞
                    mPresenter.like(dynamicList[position].id, 1, 0)
//                    } else {
//                        //取消点赞
//                        mPresenter.unlike(dynamicList[position].id, 1, 0)
//                    }
                }
                R.id.ll_commend -> {
                    *//**
                     * 评论
                     * 跳转到详情评论模块
                     *//*
//                    if (!LoginUtils.isLogin()) {
//                        context!!.startActivity<LoginActivity>()
//                        return@setOnItemChildClickListener
//                    }
                    if (DoubleUtils.isFastDoubleClick()) {
                        return@setOnItemChildClickListener
                    }
                    context!!.startActivity<ArticleDetailActivity>(
                        "id" to dynamicList[position].id,
                        "scrolltocomment" to true
                    )
                    addViewCount(position)
                }
                R.id.ll_comment_more -> {

                }
                //关注
                R.id.tv_follow -> {
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    rememberPosition = position
                    mPresenter.follow(dynamicList[position].userId)
                }
                R.id.image_avatar -> {
//                    if (!LoginUtils.isLogin()) {
//                        context!!.startActivity<LoginActivity>()
//                        return@setOnItemChildClickListener
//                    }
                    //头像，跳个人主页
                    context!!.startActivity<UserInfoActivity>("id" to dynamicList[position].userId)
                }
                //转发，分享
                R.id.image_share -> {
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    var bean = dynamicList[position]
                    XPopup.Builder(context)
                        .asCustom(OnlyShareDialog(context!!, object : OnlyShareDialog.OnlyShareDialogDelegate {
                            override fun onWechat() {
                                getShareInfo(bean.id, "wx")
                            }

                            override fun onWechatCircle() {
                                getShareInfo(bean.id, "pyq")
                            }

                            override fun onQQ() {
                                getShareInfo(bean.id, "qq")
                            }

                            override fun onSina() {
                                getShareInfo(bean.id, "sina")
                            }

                            override fun onCopyLink() {
                                getShareInfo(bean.id, "copylink")
                            }

                        })).show()
                }
                //换一换，换一批关注用户列表
                R.id.ll_change -> {
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    mPresenter.getRecommendPeople()
                }
                R.id.image_pic -> {
                    //文章 查看大图
                    context!!.startActivity<ArticleDetailActivity>("id" to dynamicList[position].id)
                    addViewCount(position)
//                    var bigimagelist = arrayListOf<String>()
//                    var images = dynamicList[position].imageList
//                    if (images.isNotEmpty()) {
//                        for (i in images.indices) {
//                            bigimagelist.add(images[i].url)
//                        }
////                        seeImage(0, bigimagelist)
//                        var imagelist = arrayListOf<ImageView>()
//                        imagelist.add(view as ImageView)
//                        iwHelper = ImageLoader.seeBigImage(activity, view, imagelist, bigimagelist)
//                        setViewFocus()
//                    }
                }
                R.id.image_big -> {
                    //查看大图
                    context!!.startActivity<ArticleDetailActivity>("id" to dynamicList[position].id)
                    addViewCount(position)
//                    var bigimagelist = arrayListOf<String>()
//                    var images = dynamicList[position].imageList
//                    if (images.isNotEmpty()) {
//                        for (i in images.indices) {
//                            bigimagelist.add(images[i].url)
//                        }
////                        seeImage(0, bigimagelist)
//                        var imagelist = arrayListOf<ImageView>()
//                        imagelist.add(view as ImageView)
//                        iwHelper = ImageLoader.seeBigImage(activity, view, imagelist, bigimagelist)
//                        setViewFocus()
//                    }
                }
                R.id.image_close -> {
                    //关闭广告
                    dynamicList.removeAt(position)
                    dynamicAdapter?.setList(dynamicList)
                }
                R.id.image_two_1 -> {
                    //查看大图
                    context!!.startActivity<ArticleDetailActivity>("id" to dynamicList[position].id)
                    addViewCount(position)
//                    var bigimagelist = arrayListOf<String>()
//                    var images = dynamicList[position].imageList
//                    if (images.isNotEmpty()) {
//                        for (i in images.indices) {
//                            bigimagelist.add(images[i].url)
//                        }
////                        seeImage(0, bigimagelist)
//                        var imagelist = arrayListOf<ImageView>()
//                        imagelist.add(view as ImageView)
//                        iwHelper = ImageLoader.seeBigImage(activity, view, imagelist, bigimagelist)
//                        setViewFocus()
//                    }
                }
                R.id.image_two_2 -> {
                    //查看大图
                    context!!.startActivity<ArticleDetailActivity>("id" to dynamicList[position].id)
                    addViewCount(position)
//                    var bigimagelist = arrayListOf<String>()
//                    var images = dynamicList[position].imageList
//                    if (images.isNotEmpty()) {
//                        for (i in images.indices) {
//                            bigimagelist.add(images[i].url)
//                        }
////                        seeImage(0, bigimagelist)
//                        var imagelist = arrayListOf<ImageView>()
//                        imagelist.add(view as ImageView)
//                        iwHelper = ImageLoader.seeBigImage(activity, view, imagelist, bigimagelist)
//                        setViewFocus()
//                    }
                }
                R.id.tv_topic -> {
                    context!!.startActivity<ArticleDetailActivity>("id" to dynamicList[position].id)
                    addViewCount(position)
                }
                R.id.tv_content -> {
                    context!!.startActivity<ArticleDetailActivity>("id" to dynamicList[position].id)
                    addViewCount(position)
                }
                R.id.tv_title -> {
                    if (dynamicList[position].type == 22) {
//                        context!!.startActivity<TopicDetailActivity>("id" to dynamicList[position].id)
                        context!!.startActivity<TopicDetailPullActivity>("id" to dynamicList[position].id)
                    }
                }
                R.id.image_list -> {
                    //排行榜
                    if (!LoginUtils.isLogin()) {
                        context!!.startActivity<LoginActivity>()
                        return@setOnItemChildClickListener
                    }
                    context!!.startActivity<RateListActivity>("type" to 3)
                }
            }
        }
        dynamicAdapter?.setOnItemClickListener { adapter, view, position ->
//            if (!LoginUtils.isLogin()) {
//                context!!.startActivity<LoginActivity>()
//                return@setOnItemClickListener
//            }
            var bean = dynamicList[position]
            if (bean.type == 5) {
                //广告
                if (!DoubleUtils.isFastDoubleClick()) {
                    context!!.startActivity<CustomWebViewActivity>("title" to "广告", "url" to bean.advertUrl)
                }
            } else {
                if (!DoubleUtils.isFastDoubleClick()) {
                    context!!.startActivity<ArticleDetailActivity>("id" to bean.id)
//                    addViewCount(position)
                }
            }
        }
        dynamicAdapter?.setOnClickListener(object : DynamicAdapter.OnClickListener {
            override fun onClick(id: Int, position: Int) {
                if (!DoubleUtils.isFastDoubleClick()) {
                    context!!.startActivity<ArticleDetailActivity>("id" to id)
//                    addViewCount(position)
                }

            }

        })

    }*/

    fun addViewCount(position: Int) {
//        Log.e("tenda", "addViewCount:" + position)
//        dynamicList[position].viewCount = dynamicList[position].viewCount + 1
//        dynamicAdapter?.notifyDataSetChanged()
    }

/*    fun getShareInfo(id: Int, type: String) {
        shareid = id
        mPresenter.getShareInfo(id, type)
    }*/

    fun initMoreDialog() {
//        moreDialog =
//            DynamicMoreDialog(context!!, object : DynamicMoreDialog.DynamicMoreDialogDelegate {
//                override fun onConfirm() {
//
//                }
//            })
    }

  /*  override fun onShareInfoSuccess(bean: ShareInfoBean, type: String) {
        if (type == "wx") {
            //微信分享
            if (!TextUtils.isEmpty(bean.image)) {
                Thread {
                    val bitmap = Glide.with(this)
                        .asBitmap()
                        .load(bean.image)
                        .submit(200, 200)
                        .get()
                    WxShareUtils.shareWeb(
                        bean.url,
                        bean.title,
                        bean.content,
                        bitmap,
                        true
                    )
                }.start()
            } else {
                WxShareUtils.shareWeb(
                    bean.url,
                    bean.title,
                    bean.content,
                    null,
                    true
                )
            }
        } else if (type == "pyq") {
            //朋友圈
            if (!TextUtils.isEmpty(bean.image)) {
                Thread {
                    val bitmap = Glide.with(this)
                        .asBitmap()
                        .load(bean.image)
                        .submit(200, 200)
                        .get()
                    WxShareUtils.shareWeb(
                        bean.url,
                        bean.title,
                        bean.content,
                        bitmap,
                        false
                    )
                }.start()
            } else {
                WxShareUtils.shareWeb(
                    bean.url,
                    bean.title,
                    bean.content,
                    null,
                    false
                )
            }
        } else if (type == "qq") {
            shareToQQ(bean)
        } else if (type == "sina") {
            shareToWeiBo(bean)
        } else if (type == "copylink") {
            var content = bean.url
            var mClipboardManager =
                context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            var mClipData = ClipData.newPlainText("Label", content)
            mClipboardManager.setPrimaryClip(mClipData)
            ToastUtil.showShortToast("已复制到剪贴板")
        }
        mPresenter.onShareSuccess(shareid)
    }*/

    /*fun shareToQQ(bean: ShareInfoBean) {
        val params = Bundle()
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT)
        params.putString(QQShare.SHARE_TO_QQ_TITLE, bean.title)
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, bean.content)
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, bean.url)
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, bean.image)
//        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222")
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, "其他附加功能")
        mTencent!!.shareToQQ(activity, params, null)
    }*/

    /*fun initSdk() {
        try {
            val authInfo =
                AuthInfo(context, Constans.APP_KY, Constans.REDIRECT_URL, "RecommendFragment")
            mWBAPI = WBAPIFactory.createWBAPI(context)
            mWBAPI?.registerApp(context, authInfo)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }*/

    /*fun shareToWeiBo(bean: ShareInfoBean) {
        var message = WeiboMultiMessage()
        var webpage = WebpageObject()
        webpage.title = bean.title
        webpage.description = bean.content
        webpage.actionUrl = bean.url
        webpage.defaultText = "网页分享"
        message.mediaObject = webpage
        mWBAPI?.shareMessage(message, false)
    }*/

    /*override fun onFail(msg: String) {
        refreshlayout.finishRefresh()
    }

    override fun onNetWorkFail(exception: Throwable?) {
        refreshlayout.finishRefresh()
        loading_data.visibility = View.GONE
        no_network.visibility = View.VISIBLE
        no_network.setOnClickListener {
            page = 1
            getData()
        }
    }*/

   /* @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: Event) {
        when (event.code) {
            EventCode.FOLLOW_USER -> {
                var id = event.t as Int
                for (i in 0 until dynamicList.size) {
                    if (id == dynamicList[i].id) {
                        dynamicList[i].hasFollow = 1
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            EventCode.UN_FOLLOW_USER -> {
                var id = event.t as Int
                for (i in 0 until dynamicList.size) {
                    if (id == dynamicList[i].id) {
                        dynamicList[i].hasFollow = 0
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            EventCode.UN_COLLECT_SUCCESS -> {
                var ids = event.t as String
                for (i in 0 until dynamicList.size) {
                    if (ids.contains(dynamicList[i].id.toString())) {
                        dynamicList[i].hasFavorite = 0
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            EventCode.COLLECT_SUCCESS -> {
                var ids = event.t as String
                for (i in 0 until dynamicList.size) {
                    if (ids.contains(dynamicList[i].id.toString())) {
                        dynamicList[i].hasFavorite = 1
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            EventCode.PRISE_ARTICLE -> {
                var id = event.t as Int
                for (i in 0 until dynamicList.size) {
                    if (id == dynamicList[i].id) {
                        dynamicList[i].hasLike = 1
                        dynamicList[i].likeCount += 1
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            //评论成功，更新数量
            EventCode.CommendSuccess -> {
                var id = event.t as Int
                for (i in 0 until dynamicList.size) {
                    if (id == dynamicList[i].id) {
                        dynamicList[i].totalReplyCount += 1
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            //阅读成功，更新数量
            EventCode.REDER_NUM -> {
                var id = event.t as Int
                for (i in 0 until dynamicList.size) {
                    if (id == dynamicList[i].id) {
                        dynamicList[i].viewCount += 1
                        dynamicAdapter?.notifyDataSetChanged()
                    }
                }
            }
            //登录成功
            EventCode.LOGIN_SUCCESS -> {
                mPresenter.getActivity()
            }
        }
    }*/

    override fun onPause() {
        super.onPause()
//        adView.pause()
    }

    override fun onResume() {
        super.onResume()
//        if (reportList.isEmpty()) {
            if (LoginUtils.isLogin()) {
//                mPresenter.getReportList("report_type")
            }
//        }
//        if (LoginUtils.isLogin()) {
//        mPresenter.getActivity()
//            ToastUtil.showShortToast("onResume 调用getActivity方法")
//        }
//        adView.resume()
    }

    /**
     * 查看大图
     * @param position
     * @param data
     */
    /*fun seeImage(position: Int, data: ArrayList<String>) {
        ImagePreview.getInstance()
            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
            .setContext(context!!)

            // 设置从第几张开始看（索引从0开始）
            .setIndex(position)
            .setZoomTransitionDuration(100)
            //=================================================================================================
            // 有三种设置数据集合的方式，根据自己的需求进行三选一：
            // 1：第一步生成的imageInfo List
            //.setImageInfoList(imageInfoList)

            // 2：直接传url List
            .setImageList(data)

            // 3：只有一张图片的情况，可以直接传入这张图片的url
            //.setImage(UrlUtils.ERWEIQIQUAN_APIHTTP + rech_pic)
            //=================================================================================================
            //显示下载按钮
            .setShowDownButton(false)
            // 开启预览
            .start()
    }*/

//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter.detachView()
//        adView.destroy()
//    }


    var handler = Handler()

//    lateinit var recyclerView_game: RecyclerView
//    lateinit var ll_game: LinearLayout
//    lateinit var layout_banner: RelativeLayout
//    lateinit var xbanner: XBanner

    var isScrolledToTop = true
//    var iwHelper: ImageWatcherHelper? = null
    var report_id = 0
    var shareid = 0
//    var mWBAPI: IWBAPI? = null
//    var mTencent: Tencent? = null
//    var reportList = arrayListOf<CustomBean>()
//    var commentBean: RecommendBean.ReplyBean? = null
    var rememberPosition = 0
    var listPosition: Int = 0
    var lastOffSet: Int = 0
    var followType = 0
    var followId = 0
    var isfollowone = false
//    var moreDialog: DynamicMoreDialog? = null
//    var dynamicList = arrayListOf<RecommendBean>()
//    var dynamicAdapter: DynamicAdapter? = null
//    var hotGameAdapter: RecommendHotGameAdapter? = null
//    var hotGameList = arrayListOf<ScoreItemBean>()
    var page = 1
    var type = 0   //0:全部,1:精选
//    val mPresenter by lazy { RecommendPresenter(context!!) }
//    override fun getLayoutId(): Int = R.layout.fragment_recommend
}