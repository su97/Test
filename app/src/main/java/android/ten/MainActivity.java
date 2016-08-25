package android.ten;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    FragmentManager fragmentManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        transaction.add(R.id.fragment,fragment1,"fragment1");
        transaction.add(R.id.fragment,fragment2,"fragment2");
        transaction.add(R.id.fragment,fragment3,"fragment3");
        transaction.add(R.id.fragment,fragment4,"fragment4");

        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
        transaction.show(fragment1);
        transaction.commit();//启动


    }

    public void btn1(View view){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);

        switch(view.getId()){
            case R.id.button1:
                transaction.show(fragment1);
                transaction.commit();
                break;
            case R.id.button2:
                transaction.show(fragment2);
                transaction.commit();
                break;
            case R.id.button3:
                transaction.show(fragment3);
                transaction.commit();
                break;
            case R.id.button4:
                transaction.show(fragment4);
                transaction.commit();
                break;
            default:
                break;
        }

    }


}
