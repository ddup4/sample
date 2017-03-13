package com.idonans.sample;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by idonans on 2017/3/13.
 */

public class DataLoader {

    private Handler mHandlerUi = new Handler(Looper.getMainLooper());
    private DataCallback mDataCallback;

    public DataLoader(DataCallback dataCallback) {
        mDataCallback = dataCallback;
    }

    public void load() {
        new Thread() {
            @Override
            public void run() {
                List<Bean> beans = null;
                try {
                    String json = ""; // read from server

                    // for test json
                    json = "[{\"data\":\"中国人寿电子商务有限公司\",\"state\":\"leaf\",\"children\":[{\"data\":\"综合部\",\"state\":\"leaf\",\"children\":[{\"data\":\"部经理室\",\"state\":\"leaf\",\"children\":[{\"data\":\"李东海\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042661\",\"layer\":\"4\",\"parentId\":\"71042639\",\"treeName\":\"李东海\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042639\",\"layer\":\"3\",\"parentId\":\"71042633\",\"treeName\":\"部经理室\",\"isLeaf\":\"F\"}},{\"data\":\"战略企划\\/财务部\",\"state\":\"leaf\",\"children\":[{\"data\":\"二级部负责人\",\"state\":\"leaf\",\"children\":[{\"data\":\"邓超\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042666\",\"layer\":\"5\",\"parentId\":\"71042758\",\"treeName\":\"邓超\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042758\",\"layer\":\"4\",\"parentId\":\"71042714\",\"treeName\":\"二级部负责人\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042714\",\"layer\":\"3\",\"parentId\":\"71042633\",\"treeName\":\"战略企划\\/财务部\",\"isLeaf\":\"F\"}},{\"data\":\"办公室\",\"state\":\"leaf\",\"children\":[{\"data\":\"二级部负责人\",\"state\":\"leaf\",\"children\":[{\"data\":\"温涛\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042671\",\"layer\":\"5\",\"parentId\":\"71042760\",\"treeName\":\"温涛\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042760\",\"layer\":\"4\",\"parentId\":\"71042713\",\"treeName\":\"二级部负责人\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042713\",\"layer\":\"3\",\"parentId\":\"71042633\",\"treeName\":\"办公室\",\"isLeaf\":\"F\"}},{\"data\":\"人力资源部\",\"state\":\"leaf\",\"children\":[{\"data\":\"二级部负责人\",\"state\":\"leaf\",\"children\":[{\"data\":\"张玲\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042676\",\"layer\":\"5\",\"parentId\":\"71042762\",\"treeName\":\"张玲\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042762\",\"layer\":\"4\",\"parentId\":\"71042715\",\"treeName\":\"二级部负责人\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042715\",\"layer\":\"3\",\"parentId\":\"71042633\",\"treeName\":\"人力资源部\",\"isLeaf\":\"F\"}},{\"data\":\"内控\\/监察\\/党建\\/工会\",\"state\":\"leaf\",\"children\":[{\"data\":\"二级部负责人\",\"state\":\"leaf\",\"children\":[{\"data\":\"魏振玲\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042678\",\"layer\":\"5\",\"parentId\":\"71042764\",\"treeName\":\"魏振玲\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042764\",\"layer\":\"4\",\"parentId\":\"71042716\",\"treeName\":\"二级部负责人\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042716\",\"layer\":\"3\",\"parentId\":\"71042633\",\"treeName\":\"内控\\/监察\\/党建\\/工会\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042633\",\"layer\":\"2\",\"parentId\":\"24\",\"treeName\":\"综合部\",\"isLeaf\":\"F\"}},{\"data\":\"市场创新部\",\"state\":\"leaf\",\"children\":[{\"data\":\"部经理室\",\"state\":\"leaf\",\"children\":[{\"data\":\"贝贝\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042679\",\"layer\":\"4\",\"parentId\":\"71042649\",\"treeName\":\"贝贝\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042649\",\"layer\":\"3\",\"parentId\":\"71042634\",\"treeName\":\"部经理室\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042634\",\"layer\":\"2\",\"parentId\":\"24\",\"treeName\":\"市场创新部\",\"isLeaf\":\"F\"}},{\"data\":\"网络销售部\",\"state\":\"leaf\",\"children\":[{\"data\":\"部经理室\",\"state\":\"leaf\",\"children\":[{\"data\":\"霸兆宇\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042682\",\"layer\":\"4\",\"parentId\":\"71042652\",\"treeName\":\"霸兆宇\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042652\",\"layer\":\"3\",\"parentId\":\"71042635\",\"treeName\":\"部经理室\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042635\",\"layer\":\"2\",\"parentId\":\"24\",\"treeName\":\"网络销售部\",\"isLeaf\":\"F\"}},{\"data\":\"产险电话销售部\",\"state\":\"leaf\",\"children\":[{\"data\":\"部经理室\",\"state\":\"leaf\",\"children\":[{\"data\":\"范岩\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042686\",\"layer\":\"4\",\"parentId\":\"71042654\",\"treeName\":\"范岩\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042654\",\"layer\":\"3\",\"parentId\":\"71042636\",\"treeName\":\"部经理室\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042636\",\"layer\":\"2\",\"parentId\":\"24\",\"treeName\":\"产险电话销售部\",\"isLeaf\":\"F\"}},{\"data\":\"寿险电话销售部\",\"state\":\"leaf\",\"children\":[{\"data\":\"部经理室\",\"state\":\"leaf\",\"children\":[{\"data\":\"贺侃\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042688\",\"layer\":\"4\",\"parentId\":\"71042656\",\"treeName\":\"贺侃\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042656\",\"layer\":\"3\",\"parentId\":\"71042637\",\"treeName\":\"部经理室\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042637\",\"layer\":\"2\",\"parentId\":\"24\",\"treeName\":\"寿险电话销售部\",\"isLeaf\":\"F\"}},{\"data\":\"运营支持部\",\"state\":\"leaf\",\"children\":[{\"data\":\"部经理室\",\"state\":\"leaf\",\"children\":[{\"data\":\"刘颖久\",\"state\":\"leaf\",\"attr\":{\"id\":\"71042814\",\"layer\":\"4\",\"parentId\":\"71042658\",\"treeName\":\"刘颖久\",\"isLeaf\":\"T\"}}],\"attr\":{\"id\":\"71042658\",\"layer\":\"3\",\"parentId\":\"71042638\",\"treeName\":\"部经理室\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"71042638\",\"layer\":\"2\",\"parentId\":\"24\",\"treeName\":\"运营支持部\",\"isLeaf\":\"F\"}}],\"attr\":{\"id\":\"24\",\"layer\":\"1\",\"treeName\":\"中国人寿电子商务有限公司\",\"isLeaf\":\"F\"}}]";

                    Type type = new TypeToken<List<Bean>>() {
                    }.getType();
                    beans = new Gson().fromJson(json, type);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                final List<Bean> result = beans;
                mHandlerUi.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mDataCallback != null) {
                            mDataCallback.onDataLoad(result);
                        }
                    }
                });
            }
        }.start();
    }

    public void close() {
        mDataCallback = null;
    }

    public static class Bean {
        public String data;
        public String state;
        public List<Bean> children;
        public Attr attr;

        public static class Attr {
            public String id;
            public String layer;
            public String parentId;
            public String treeName;
            public String isLeaf;
        }

        /**
         * 是否是叶子节点
         */
        public boolean isLeafAttr() {
            return this.attr == null || "T".equalsIgnoreCase(this.attr.isLeaf);
        }

    }

    public interface DataCallback {
        void onDataLoad(@Nullable List<Bean> beans);
    }

}
