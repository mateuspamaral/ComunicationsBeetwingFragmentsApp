package br.com.digitalhouse.comunicationsbeetwingfragmentsapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.R;
import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.interfaces.Comunicator;
import br.com.digitalhouse.comunicationsbeetwingfragmentsapp.model.Person;

public class FirstFragment extends Fragment {

    private Comunicator comunicator;

    public FirstFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicator = (Comunicator) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person("Mateus", "Aluno", 32);
                comunicator.receiveMessage(person);
            }
        });

        return view;
    }

}
