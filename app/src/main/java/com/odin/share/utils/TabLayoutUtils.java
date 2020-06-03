package com.odin.share.utils;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;

public class TabLayoutUtils {

    /**
     * 修改TabLayout的下划线的宽度
     *
     * @param tabLayout TabLayout
     */
    public static void changeIndicatorWidthEqualsTextView(TabLayout tabLayout) {
        if (tabLayout == null) {
            return;
        }
        try {
            LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
            for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                View tabView = mTabStrip.getChildAt(i);
                int viewWidth = 0;
                viewWidth = tabView.getWidth();
                if (viewWidth == 0) {
                    tabView.measure(0, 0);
                    viewWidth = tabView.getMeasuredWidth();
                }
                Field mTextViewField = tabView.getClass().getDeclaredField("textView");
                mTextViewField.setAccessible(true);
                TextView mTextView = (TextView) mTextViewField.get(tabView);
                tabView.setPadding(0, 0, 0, 0);
                int width;
                width = mTextView.getWidth();
                if (width == 0) {
                    mTextView.measure(0, 0);
                    width = mTextView.getMeasuredWidth();
                }
                int margin = (viewWidth - width) / 2;
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                params.width = width;
                params.leftMargin = margin;
                params.rightMargin = margin;
                tabView.setLayoutParams(params);
                tabView.invalidate();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
