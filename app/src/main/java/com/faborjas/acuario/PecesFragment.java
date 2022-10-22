package com.faborjas.acuario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faborjas.acuario.entities.Acuario;
import com.faborjas.acuario.entities.Pez;

import java.util.List;


public class PecesFragment extends Fragment {
    private RecyclerView rvPeces;
    private Acuario acuario;
    private List<Pez> listaPeces;


    public PecesFragment(Acuario acuario) {
        this.acuario = acuario;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        listaPeces = acuario.getListaPeces();
        rvPeces = getView().findViewById(R.id.rv_Peces);
        rvPeces.setAdapter(new PecesAdapter(getContext(),listaPeces));
        rvPeces.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_peces, container, false);
    }
}