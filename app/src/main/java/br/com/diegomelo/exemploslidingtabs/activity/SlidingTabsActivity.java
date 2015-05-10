package br.com.diegomelo.exemploslidingtabs.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.diegomelo.exemploslidingtabs.R;
import br.com.diegomelo.exemploslidingtabs.activity.adapter.ViewPagerAdapter;
import br.com.diegomelo.exemploslidingtabs.activity.widget.SlidingTabLayout;


public class SlidingTabsActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence[] titulos = {"Semana", "Sábado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tabs);

        init();
        setSupportActionBar(toolbar);
        viewPager.setAdapter(adapter);
        configureTabs();

    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titulos);
        tabs = (SlidingTabLayout)findViewById(R.id.tabs);
    }

    private void configureTabs() {
        //para fixar as abas. Isso deixa as tabs com largura e espaçamento uniforme.
        tabs.setDistributeEvenly(true);
//        seta cor do indicador da tab selecionada
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accent);
            }
        });
        tabs.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sliding_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings :
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
