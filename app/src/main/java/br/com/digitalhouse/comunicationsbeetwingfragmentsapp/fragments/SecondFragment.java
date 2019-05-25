package br.com.digitalhouse.comunicationsbeetwingfragmentsapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.R;
import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.model.Person;

public class SecondFragment extends Fragment {

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewProfession = view.findViewById(R.id.textViewProfession);
        TextView textViewAge = view.findViewById(R.id.textViewAge);

        if (getArguments() != null) {
            Person person = getArguments().getParcelable("PERSON");

            if (person != null) {
                textViewName.setText(person.getName());
                textViewProfession.setText(person.getProfession());
                textViewAge.setText(person.getAge() + " anos");
            }
        }

        return view;
    }

}
