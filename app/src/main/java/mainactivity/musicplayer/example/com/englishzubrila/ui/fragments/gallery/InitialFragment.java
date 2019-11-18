package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.ListViewPager;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.adapter.ViewPegerAdaptor;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.bottomnavigation.BottomNavigationBehavior;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.сonflicting.Conflicting;

public class InitialFragment  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_fragmint);

        setNavigationViewListener();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Gallery");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.coordinatorLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.open, R.string.closed);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager = findViewById(R.id.frame_container);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        setupViewPager();
        setupNavigationView();
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    private void setupNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.backward:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.further:
                                viewPager.setCurrentItem(1);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setupViewPager(){
        ViewPegerAdaptor adaptor = new ViewPegerAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new HomeFragment());
        adaptor.addFragment(new ListViewPager());
        viewPager.setAdapter(adaptor);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.backward);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.further);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.information:
                Intent intent = new Intent(InitialFragment.this, Conflicting.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}
