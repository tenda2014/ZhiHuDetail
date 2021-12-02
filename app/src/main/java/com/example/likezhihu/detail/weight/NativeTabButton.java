package com.example.likezhihu.detail.weight;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.likezhihu.detail.R;
import com.example.likezhihu.detail.ui.MainActivity;


public class NativeTabButton extends FrameLayout {
    private int mIndex;

    private ImageView mImage;
    private ImageView mImageCenter;
    private TextView mTitle;

    private Drawable mSelectedImg;
    private Drawable mUnselectedImg;

    private Context mContext;
    private int mSelectedColorRes = R.color.color_text;
    private int mUnselectedColorRes = R.color.color_c8;
    private boolean isCenterIcon = false;
    private LinearLayout container;

    public NativeTabButton(Context context) {
        this(context, null);
    }

    public NativeTabButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeTabButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        this.mContext = context;

        OnClickListener clickListner = v -> ((MainActivity) mContext).setFragmentShow(mIndex);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_native_tab_button, this, true);
        container = (LinearLayout) findViewById(R.id.tab_btn_container);

        mImage = (ImageView) findViewById(R.id.tab_btn_default);
        mImageCenter = (ImageView) findViewById(R.id.tab_btn_center);
        mTitle = (TextView) findViewById(R.id.tab_btn_title);
        container.setOnClickListener(clickListner);
    }

    public void setIndex(int index) {
        this.mIndex = index;
    }

    public void setUnselectedImage(Drawable img) {
        this.mUnselectedImg = img;
    }

    public void setSelectedImage(Drawable img) {
        this.mSelectedImg = img;
    }

    /**
     * 设置字体颜色
     *
     * @param selected
     */
    public void setSelectedColor(Boolean selected) {
        if (selected) {
            mTitle.setTextColor(getResources().getColor(R.color.color_main));
        } else {
            mTitle.setTextColor(getResources().getColor(R.color.color_ed_hint));
        }
    }

    public void setSelectedButton(Boolean selected) {
        setSelectedColor(selected);
        if (isCenterIcon) {
            mImageCenter.setVisibility(View.VISIBLE);
            mImage.setVisibility(View.GONE);
//            container.setBackgroundResource(R.drawable.bg_cirle_bg_w);
            if (selected) {
                mImageCenter.setImageDrawable(mSelectedImg);
            } else {
                mImageCenter.setImageDrawable(mUnselectedImg);
            }
        } else {
//            container.setBackgroundColor(getResources().getColor(R.color.white));
            mImageCenter.setVisibility(View.GONE);
            mImage.setVisibility(View.VISIBLE);
            if (selected) {
                mImage.setImageDrawable(mSelectedImg);
            } else {
                mImage.setImageDrawable(mUnselectedImg);
            }
        }
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setCenterIcon(boolean centerIcon) {
        isCenterIcon = centerIcon;
    }
}
