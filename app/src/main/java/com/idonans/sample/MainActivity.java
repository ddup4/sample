package com.idonans.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataLoader.DataCallback {

    private DataLoader mDataLoader;
    private ViewGroup mBeanRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBeanRoot = (ViewGroup) findViewById(R.id.bean_root);

        startDataLoad();
    }

    @Override
    public void onDataLoad(@Nullable List<DataLoader.Bean> beans) {
        // clear old item views
        mBeanRoot.removeAllViews();
        inflateAndBind(this, getLayoutInflater(), mBeanRoot, beans);
    }

    /**
     * 将数据列表渲染为视图列表，如果数据有子列表，则递归渲染子列表视图.
     */
    public void inflateAndBind(final Context context, LayoutInflater inflater, ViewGroup parent, final @Nullable List<DataLoader.Bean> beans) {
        if (beans == null) {
            // ignore
            return;
        }

        for (final DataLoader.Bean bean : beans) {

            final View itemView = inflater.inflate(R.layout.activity_main_bean_item, parent, false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 单击选中
                    // TODO click bean
                    String tipText;
                    if (bean.attr == null) {
                        tipText = "bean attr is null";
                    } else {
                        tipText = bean.attr.treeName;
                    }
                    Toast.makeText(context, "click " + tipText, Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // 长按展示或隐藏子节点
                    ViewGroup childrenView = (ViewGroup) itemView.findViewById(R.id.bean_item_children);
                    if (childrenView.getVisibility() == View.VISIBLE) {
                        childrenView.setVisibility(View.GONE);
                    } else {
                        childrenView.setVisibility(View.VISIBLE);
                    }
                    return true;
                }
            });

            // 绑定当前节点的展示内容
            ViewGroup beanItem = (ViewGroup) itemView.findViewById(R.id.bean_item);
            TextView beanItemCount = (TextView) beanItem.findViewById(R.id.bean_item_count);
            TextView beanItemText = (TextView) beanItem.findViewById(R.id.bean_item_text);
            beanItemCount.setText(String.valueOf(bean.children == null ? "children is null" : "(" + bean.children.size() + ")"));
            beanItemText.setText(bean.attr == null ? "bean attr is null" : bean.attr.treeName);

            if (!bean.isLeafAttr()) {
                // 如果有子节点，递归绑定子节点
                ViewGroup childrenView = (ViewGroup) itemView.findViewById(R.id.bean_item_children);
                inflateAndBind(context, inflater, childrenView, bean.children);
            }

            parent.addView(itemView);
        }
    }

    private void startDataLoad() {
        // 中断上一次的数据加载
        closeDataLoader();

        mDataLoader = new DataLoader(this);
        mDataLoader.load();
    }

    private void closeDataLoader() {
        if (mDataLoader != null) {
            mDataLoader.close();
            mDataLoader = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDataLoader();
    }

}
