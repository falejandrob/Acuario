package com.faborjas.acuario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.faborjas.acuario.entities.Acuario;
import com.faborjas.acuario.entities.Pez;

import java.util.List;
import java.util.Random;


public class PecesFragment extends Fragment {
    private static RecyclerView rvPeces;
    private Acuario acuario;
    private List<Pez> listaPeces;
    private MainActivity mainActivity;
    private TextView tvIdAcuario;
    private Button btnLimpiar;
    private Button btnInsertarPez;
    private Button btnAlimentar;


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
        tvIdAcuario = getView().findViewById(R.id.txt_IdAcuario);
        btnLimpiar = getView().findViewById(R.id.btn_Limpiar);
        btnInsertarPez = getView().findViewById(R.id.btn_insertarPez);
        btnAlimentar = getView().findViewById(R.id.btn_Alimentar);
        listaPeces = acuario.getListaPeces();
        rvPeces = getView().findViewById(R.id.rv_Peces);
        mainActivity = (MainActivity) getActivity();
        rvPeces.setAdapter(new PecesAdapter(getContext(),listaPeces,acuario,mainActivity,tvIdAcuario,btnLimpiar,btnInsertarPez,btnAlimentar));
        rvPeces.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    public static void linpiarAcuario(Acuario acuario) {
        List<Pez> listaPeces = acuario.getListaPeces();
        for (int i = 0; i < listaPeces.size(); i++) {
            if (!listaPeces.get(i).isVivo()) {
                listaPeces.remove(i);
                i = i-1;
            }
        }
        acuario.setListaPeces(listaPeces);
        rvPeces.getAdapter().notifyDataSetChanged();
    }
    public static void generarPecesAleatorios(Acuario acuario){
        String[] fishNamesShop = AcuarioFragment.getFishNames();
        String[] typeFishShop = AcuarioFragment.getTypeFish();
        int[] maxRationsShop = AcuarioFragment.getMaxRations();

        String id;
        int pos;
        String [] strings = acuario.getListaPeces().get(acuario.getListaPeces().size()-1).getId().split("-");
        String j = strings[1];
        id = "Cod-" + (Integer.parseInt(j) + 1);
        pos = new Random().nextInt(4);
        Pez pez = new Pez(id,fishNamesShop[new Random().nextInt(fishNamesShop.length)],maxRationsShop[pos],typeFishShop[pos]);
        acuario.insertarPez(acuario,pez);
        rvPeces.getAdapter().notifyDataSetChanged();

    }
    public static void alimentarPeces(Acuario acuario, int raciones){
        List<Pez> listaPeces = acuario.getListaPeces();
        Random numRandom = new Random();
        for (Pez pez: listaPeces) {
            pez.setAlimentoActual(0);
        }
        for (int i = 0; i < raciones; i++) {
            int nmr = numRandom.nextInt(listaPeces.size());
            Pez.incrementarComida(listaPeces.get(nmr));
        }
        for (Pez pez: listaPeces) {
            if (pez.getAlimentoActual() == 0){
                pez.setVivo(false);
            }
        }
        rvPeces.getAdapter().notifyDataSetChanged();
    }
    public static void insertarPezAleatorio(Acuario acuario,Pez pez){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_peces, container, false);
    }
}