package android.ten;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    private TextView author,title,authorbrief,text1,text2,text3,text4,text5;
    private ImageView image1,image2,image3,image4;
    private View view;

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
                    info.setTitle(json.getString("title"));
                    initData();
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
        view = inflater.inflate(R.layout.fragment_fragment1_1, container, false);

        initView();


        return view;
    }

    private void initData() {
        author.setText(info.getAuthor());
        authorbrief.setText(info.getAuthorbrief());
        title.setText(info.getTitle());
        text1.setText(info.getText1());
        text2.setText(info.getText2());
        text3.setText(info.getText3());
        text4.setText(info.getText4());
        text5.setText(info.getText5());
        String str1 = info.image1;
        String str2 = info.image2;
        String str3 = info.image3;
        String str4 = info.image4;
        Picasso.with(getContext()).load("http://api.shigeten.net/"+str1).into(image1);
        Picasso.with(getContext()).load("http://api.shigeten.net/"+str2).into(image2);
        Picasso.with(getContext()).load("http://api.shigeten.net/"+str3).into(image3);
        Picasso.with(getContext()).load("http://api.shigeten.net/"+str4).into(image4);

    }

    private void initView() {
        author = (TextView) view.findViewById(R.id.author);
        authorbrief = (TextView) view.findViewById(R.id.authorbrief);
        title = (TextView) view.findViewById(R.id.title);
        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
        text4 = (TextView) view.findViewById(R.id.text4);
        text5 = (TextView) view.findViewById(R.id.text5);
        image1 = (ImageView) view.findViewById(R.id.img1);
        image2 = (ImageView) view.findViewById(R.id.img2);
        image3 = (ImageView) view.findViewById(R.id.img3);
        image4 = (ImageView) view.findViewById(R.id.img4);

        //
    }


}
