package br.com.diegomelo.exemploslidingtabs.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import br.com.diegomelo.exemploslidingtabs.activity.HorariosDomingoFragment;
import br.com.diegomelo.exemploslidingtabs.activity.HorariosSabadoFragment;
import br.com.diegomelo.exemploslidingtabs.activity.HorariosSemanaFragment;


/**
 * Created by Diego on 08/05/2015.
 */
public class ViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private CharSequence[] titulos;
    private int numTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence[] titulos) {
        super(fm);
        this.titulos = titulos;
        this.numTabs = titulos.length;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new HorariosSemanaFragment();
            case 1:
                return new HorariosSabadoFragment();
            case 2:
                return new HorariosDomingoFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    public CharSequence[] getTitulos() {
        return titulos;
    }
}
