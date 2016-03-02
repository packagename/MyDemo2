package mydemo.wy.com.mydemo2;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar; private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawTogle;
    private ListView lvLeftMenu;
    private String[] lvs = {"List Item 01","List Item 02","List Item 03","List Item 04"};
    private ArrayAdapter arrayAdapter;
    private ImageView ivRunningMan;
    /* private AnimationDrawable animationDrawable;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();//获取控件
        //RunningMan动画效果，和本次Toolbar无关
       /* animationDrawable = (AnimationDrawable) ivRunningMan.getBackground();
        animationDrawable.start();*/
        toolbar.setTitle("Toolbar");//设置Toolbar的标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));//设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开/关闭监听
        mDrawTogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                animationDrawable.stop();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                animationDrawable.start();
            }
        };
        mDrawTogle.syncState();
        drawerLayout.setDrawerListener(mDrawTogle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lvs);
        lvLeftMenu.setAdapter(arrayAdapter);

    }

    private void findView(){
        ivRunningMan = (ImageView)findViewById(R.id.iv_main);
        toolbar = (Toolbar)findViewById(R.id.tl_custom);
        drawerLayout = (DrawerLayout)findViewById(R.id.dl_left);
        lvLeftMenu = (ListView)findViewById(R.id.lv_left_menu);
    }
}
