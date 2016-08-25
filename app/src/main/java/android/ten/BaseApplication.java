package android.ten;

import android.app.Application;

import org.xutils.x;

/**
 * User: hzhk(1097282555@qq.com)
 * Date: 2016/07/26
 * Time: 10:48
 * progject: XUtilsDemo
 * Describe：
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //设置xUitls的debug模式，建议发布的时候，关闭
        x.Ext.setDebug(true);
    }
}