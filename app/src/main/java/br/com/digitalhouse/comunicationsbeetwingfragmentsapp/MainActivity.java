package br.com.digitalhouse.comunicationsbeetwingfragmentsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.fragments.FirstFragment;
import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.fragments.SecondFragment;
import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.interfaces.Comunicator;
import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.model.Person;

public class MainActivity extends AppCompatActivity implements Comunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        replaceFragment(R.id.container2, new FirstFragment());
    }

    public void replaceFragment(int container, Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }

    @Override
    public void receiveMessage(Person person) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("PERSON", person);

        Fragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        replaceFragment(R.id.container1, secondFragment);
    }
}
