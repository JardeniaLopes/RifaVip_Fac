package com.example.rifaking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PontosAdaptador extends FirestoreRecyclerAdapter<Cliente_Model, PontosAdaptador.PontoView> {

    Context context;
    public PontosAdaptador(@NonNull FirestoreRecyclerOptions<Cliente_Model> options, Context context) {
        super(options);
        this.context = context;
    }
    @Override
    protected void onBindViewHolder(@NonNull PontoView holder, int position, @NonNull Cliente_Model model) {
        holder.nomeCliente.setText(model.nomeCliente);
        holder.numeroPonto.setText(model.numeroDoPonto);
        holder.telefoneCliente.setText(model.telefoneCliente);
        holder.enderecoCliente.setText(model.Endereco);

        holder.configuracao.setOnClickListener((view) ->{
            Intent intent = new Intent(context, FormPointCliente.class);
            intent.putExtra("nomeCliente", model.nomeCliente);
            intent.putExtra("numeroDoPonto", model.numeroDoPonto);
            intent.putExtra("telefoneCliente", model.telefoneCliente);
            intent.putExtra("endereco", model.Endereco);
            String pontoId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("pontoId", pontoId);

            context.startActivity(intent);
        });
    }
    @NonNull
    @Override
    public PontoView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pontos,parent,false);
        return new PontoView(view);
    }


    public class PontoView extends RecyclerView.ViewHolder {
        TextView nomeCliente, numeroPonto, telefoneCliente, enderecoCliente;
        ImageButton configuracao;
        public PontoView(@NonNull View itemView) {

            super(itemView);

            nomeCliente = itemView.findViewById(R.id.nome_cliente);
            numeroPonto = itemView.findViewById(R.id.numeroDo_Ponto);
            telefoneCliente = itemView.findViewById(R.id.telefone_Cliente);
            enderecoCliente = itemView.findViewById(R.id.endereco_Cliente);
            configuracao = itemView.findViewById(R.id.configuracaoPontos);
        }
    }
}
