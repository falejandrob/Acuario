package com.faborjas.acuario;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faborjas.acuario.entities.Pez;

import java.util.List;


public class PecesAdapter extends RecyclerView.Adapter<PecesAdapter.PecesViewHolder> {


    private List<Pez> listaPeces;
    private Context context;
    private LayoutInflater layoutInflater;

    public PecesAdapter(Context context, List<Pez> listaPeces) {
        this.listaPeces = listaPeces;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PecesAdapter.PecesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.fragment_peces_adapter, parent,false);
        return new PecesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PecesAdapter.PecesViewHolder holder, int position) {
        holder.tvNombre.setText(listaPeces.get(position).getNombre());
        holder.tvEspecie.setText(listaPeces.get(position).getEspecia());
        holder.tvRaciones.setText(String.valueOf(listaPeces.get(position).getAlimentoActual()));
        if (listaPeces.get(position).isVivo()){
            holder.tvIsVivo.setText("Vivo");
        }else{
            holder.tvIsVivo.setText("Muerto");
        }

    }

    @Override
    public int getItemCount() {
        return listaPeces.size();
    }



    public class PecesViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvEspecie;
        private TextView tvRaciones;
        private TextView tvIsVivo;
        public PecesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.txt_NombrePez);
            tvEspecie = itemView.findViewById(R.id.txt_especiePez);
            tvRaciones = itemView.findViewById(R.id.txt_numRaciones);
            tvIsVivo = itemView.findViewById(R.id.txt_IsVivo);
        }
    }
}