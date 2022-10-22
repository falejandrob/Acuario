package com.faborjas.acuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faborjas.acuario.entities.Acuario;
import com.faborjas.acuario.entities.Pez;
import com.faborjas.acuario.viewmodels.AcuariosViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class AcuarioFragment extends Fragment {
    private static String [] typeFish;
    private static int [] maxRations;
    private List<Acuario> acuarioList;
    private static String [] fishNames;
    private AcuariosViewModel model;
    private RecyclerView rvAcuario;
    private static Activity activity;
    private MainActivity mainActivity;//Primero Creas Un Objeto MainActivity
    private static int positionlist;

    public AcuarioFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        initAcuario();
    }

    private void initAcuario() {
        model = new ViewModelProvider(getActivity()).get(AcuariosViewModel.class);
        mainActivity = (MainActivity) getActivity();// Obtienes la actividad y la guardas en el mainActivity
        setTypeFish(getResources().getStringArray(R.array.peces));
        setMaxRations(getResources().getIntArray(R.array.Raciones_Max));
        setFishNames(getResources().getStringArray(R.array.nombres));
        new Tienda().generateShop();
        acuarioList = model.getAcuarioList();
        Log.d("PRUEBA","Esto funciona");
        for (Acuario acuario: acuarioList) {
            Log.d("ACUARIOLIST",acuarioList.toString());
            for (Pez pez:acuario.getListaPeces()) {
                Log.d("PECESLIST",acuarioList.toString());
            }
        }
        rvAcuario = getView().findViewById(R.id.rv_Acuarios);
        rvAcuario.setAdapter(new AcuariosAdapter(getContext(),acuarioList,mainActivity));
        rvAcuario.setLayoutManager(new LinearLayoutManager(getContext()));

    }
    public static void getAdapterPositionList(int position){
        positionlist = position;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acuario, container, false);
    }

    public static int[] getMaxRations() {
        return maxRations;
    }

    public static void setMaxRations(int[] maxRations) {
        AcuarioFragment.maxRations = maxRations;
    }

    public static String[] getTypeFish() {
        return typeFish;
    }

    public static void setTypeFish(String[] typeFish) {
        AcuarioFragment.typeFish = typeFish;
    }

    public static String[] getFishNames() {
        return fishNames;
    }

    public static void setFishNames(String[] fishNames) {
        AcuarioFragment.fishNames = fishNames;
    }


    public class Tienda{
        String[] fishNamesShop = getFishNames();
        String[] typeFishShop = getTypeFish();
        int[] maxRationsShop = getMaxRations();

        public Tienda() {
        }

        private void generateShop(){
            String id = "";

            int pos;
            AcuariosViewModel model = new ViewModelProvider(getActivity()).get(AcuariosViewModel.class);
            List<Acuario> localAcuarioList = new ArrayList<>();
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(4,7); i++) {
                id = "Cod-" + String.valueOf(i);
                Acuario acuario = new Acuario(id,ThreadLocalRandom.current().nextInt(60,101),true);
                for (int j = 0; j < ThreadLocalRandom.current().nextInt(8,12); j++) {
                    id = "Cod-" + String.valueOf(j);
                    pos = new Random().nextInt(4);
                    Pez pez = new Pez(id,fishNamesShop[new Random().nextInt(fishNamesShop.length)],maxRationsShop[pos],typeFishShop[pos]);
                    acuario.insertarPez(acuario,pez);
                }
                localAcuarioList.add(acuario);
            }
            model.setAcuarioList(localAcuarioList);
        }

    }
}
