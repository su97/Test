package android.ten;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    private ViewPager viewPager;
    Fragment1_1 fragment11;
    List<Fragment> data;
    List<String> list = new ArrayList<>();

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        data = new ArrayList<>();
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        initView();
        initData();

        return view;
    }

    private void initData() {
        String uri = "http://api.shigeten.net/api/Critic/GetCriticList";
        RequestParams entity = new RequestParams(uri) ;
        x.http().get(entity, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {

                try {
                    JSONObject json = new JSONObject(result);
                    JSONArray json1 = json.getJSONArray("result");
                    for(int i = 0;i <  json1.length();i++){
                        JSONObject json2 = json1.getJSONObject(i);
                        String str = json2.getString("id");
                        list.add(str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    private void initView() {

        for(int i = 0; i< 10; i++){
            fragment11 = new Fragment1_1();
            data.add(fragment11);
        }

        MyAdapter adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data != null?data.size() : 0;
        }
    }



}
