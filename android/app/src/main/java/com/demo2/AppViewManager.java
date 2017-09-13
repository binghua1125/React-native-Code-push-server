package com.demo2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binghua.ren on 2017/9/7.
 */

public class AppViewManager extends SimpleViewManager<SwipeMenuListView> {
    private List<String> dataSource;
    private Context mContext;

    @Override
    public String getName() {
        return "SwipeMenuListView";
    }

    @Override
    protected SwipeMenuListView createViewInstance(ThemedReactContext reactContext) {
        mContext = reactContext;
        SwipeMenuListView swipeMenuListView = new SwipeMenuListView(reactContext);
        swipeMenuListView.setMenuCreator(initMenu(reactContext));
        return swipeMenuListView;
    }

    private SwipeMenuCreator initMenu(final ThemedReactContext reactContext) {
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(reactContext);
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                deleteItem.setWidth(100);
                deleteItem.setIcon(R.drawable.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        };
        return creator;
    }

    @ReactProp(name = "array")
    public void setData(SwipeMenuListView swipeMenuListView, ReadableArray array) {
        dataSource = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            dataSource.add(array.getString(i));
        }
        swipeMenuListView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dataSource.size();
        }

        @Override
        public String getItem(int position) {
            return dataSource.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.tv);
            tv.setText(getItem(position));
            return convertView;
        }
    }
}
