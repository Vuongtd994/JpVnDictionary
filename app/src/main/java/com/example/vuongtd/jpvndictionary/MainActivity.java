package com.example.vuongtd.jpvndictionary;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tìm đối tượng toolbar trên màn hình theo id
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //thiết lập toolbar để thay thế actionBar
        setSupportActionBar(toolbar);

        //tìm đối tượng drawer trên màn hình theo Id
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //lớp này dùng để liên kết các chức năng giữa drawer và toolbar 1 cách chặt cmn chẽ
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        //đồng bộ trạng thái của drawer với các liên kết đến drawerlayout
        toggle.syncState();

        //bắt sk khi chạm vào button sẽ xuất hiện drawer
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //thực hiện 1 tập hợp các hoạt động của fragment
        FragmentTransaction ft=getFragmentManager().beginTransaction();

        android.app.Fragment fragment;
        //khai báo đối tượng fragment qua class kế thừa nó là searchFragment
        fragment =new SearchFragment();
        //thay thế vị trí fragment trong content_frame
        ft.replace(R.id.content_frame,fragment).commit();

        //set title cho toolbar khi ứng dụng chạy
        setTitle(R.string.action_search);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        android.app.Fragment fragment;
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        FragmentTransaction ft=getFragmentManager().beginTransaction();
        android.app.Fragment fragment;

        if (id == R.id.nav_search) {
            // Handle the camera action
            fragment =new SearchFragment();
            ft.replace(R.id.content_frame,fragment).commit();

        } else if (id == R.id.nav_settings) {
            fragment =new SettingFragment();
            ft.replace(R.id.content_frame,fragment).commit();

        } else if (id == R.id.nav_history) {
            fragment =new HistoryFragment();
            ft.replace(R.id.content_frame,fragment).commit();

        } else if (id == R.id.nav_favorites) {
            fragment =new FavoritesFragment();
            ft.replace(R.id.content_frame,fragment).commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        item.setChecked(true);
        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
