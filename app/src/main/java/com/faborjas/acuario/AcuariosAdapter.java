package com.faborjas.acuario;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faborjas.acuario.entities.Acuario;

import java.util.List;


public class AcuariosAdapter extends RecyclerView.Adapter<AcuariosAdapter.AcuariosViewHolder> {

    private List<Acuario> acuarios;
    private Context context;
    private LayoutInflater layoutInflater;
    private MainActivity main;

    public AcuariosAdapter(Context context, List<Acuario> acuarios, MainActivity mainActivity) {
        this.acuarios = acuarios;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.main = mainActivity;

    }


    @NonNull
    @Override
    public AcuariosAdapter.AcuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.fragment_acuarios_adapter, parent,false);
        return new AcuariosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AcuariosAdapter.AcuariosViewHolder holder, int position) {
        holder.tvNombre.setText(acuarios.get(position).getId());
        holder.tvLitros.setText(String.valueOf(acuarios.get(position).getNumLitros()));
        holder.tvNumPeces.setText(String.valueOf(acuarios.get(position).getListaPeces().size()));
        if (acuarios.get(position).isLimpio()){
            holder.tvIsLimpio.setText("Si");
        }else{
            holder.tvIsLimpio.setText("No");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            loadFragment2(new PecesFragment(acuarios.get(holder.getAdapterPosition())));

            }
        });

    }

    public void loadFragment2(Fragment fragment){
        main
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public int getItemCount() {
        return acuarios.size();
    }


    public class AcuariosViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvLitros;
        private TextView tvNumPeces;
        private TextView tvIsLimpio;
        public AcuariosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.txt_idAcuario);
            tvLitros = itemView.findViewById(R.id.txt_numLitros);
            tvNumPeces = itemView.findViewById(R.id.txt_NumPeces);
            tvIsLimpio = itemView.findViewById(R.id.txt_EstaLimpio);
        }
    }
}