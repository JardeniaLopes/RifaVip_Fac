package com.example.rifaking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RifaAdaptador extends FirestoreRecyclerAdapter<Rifa_Model, RifaAdaptador.RifaView> {
    Context context;

    public RifaAdaptador(@NonNull FirestoreRecyclerOptions<Rifa_Model> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull RifaView holder, int position, @NonNull Rifa_Model model) {
        holder.nome.setText(model.nomeRifa);
        holder.premio.setText(model.premio);
        holder.data.setText(ConfiguracoesDB.dataToString(model.dataSorteio));


        holder.itemView.setOnClickListener((v)->{
            Intent i = new Intent( context,FormPoints.class);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            i.putExtra("docId", docId);
            context.startActivity(i);
        });

        holder.configuracao.setOnClickListener((v)->{
            Intent intent = new Intent(context, FormCreateRifa.class);
            intent.putExtra("nomeRifa",model.nomeRifa);
            intent.putExtra("premio", model.premio);
            intent.putExtra("dataSorteio", model.dataSorteio);
            intent.putExtra("qtPontos", model.qtPontos);
            intent.putExtra("valor", model.valor);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId", docId);
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public RifaView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rifa,parent,false);
        return new RifaView(view);

    }

    public class RifaView extends RecyclerView.ViewHolder{
        TextView nome, premio, data;
        ImageButton configuracao;
        public RifaView(@NonNull View itemView){

            super(itemView);

            nome = itemView.findViewById(R.id.nome_Rifa);
            premio = itemView.findViewById(R.id.premio_Rifa);
            data = itemView.findViewById(R.id.data_Sorteio);
            configuracao = itemView.findViewById(R.id.configuracao);
        }

    }
}
