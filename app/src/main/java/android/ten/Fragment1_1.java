package android.ten;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1_1 extends Fragment {


    private NewsInfo info;

    public Fragment1_1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        final String id = bundle.getString("id");
        String uri = "http://api.shigeten.net/api/Critic/GetCriticContent?id=" + id;
        RequestParams entity = new RequestParams(uri);
        x.http().get(entity, new Callback.CacheCallback<String>(){

            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject json = new JSONObject(result);
                    info.setAuthor(json.getString("author"));
                    info.setAuthorbrief(json.getString("authorbrief"));
                    info.setImage1(json.getString("image1"));
                    info.setImage2(json.getString("image2"));
                    info.setImage3(json.getString("image3"));
                    info.setImage4(json.getString("image4"));
                    info.setText1(json.getString("text1"));
                    info.setText2(json.getString("text2"));
                    info.setText3(json.getString("text3"));
                    info.setText4(json.getString("text4"));
                    info.setText5(json.getString("text5"));
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1_1, container, false);
    }


}
