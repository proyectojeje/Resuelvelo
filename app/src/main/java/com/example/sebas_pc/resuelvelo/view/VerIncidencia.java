package com.example.sebas_pc.resuelvelo.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebas_pc.resuelvelo.R;
import com.example.sebas_pc.resuelvelo.model.Departamentos;
import com.example.sebas_pc.resuelvelo.model.Incidencia;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class VerIncidencia extends AppCompatActivity {

    private FirebaseRecyclerAdapter mAdapter, mAdapter2, mAdapter3;
    private DatabaseReference mDatabase,mDatabase2,mDatabase3;
    String idIncidencia;
    String idEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_incidencia);

        String uid = FirebaseAuth.getInstance().getUid();
        idIncidencia = getIntent().getStringExtra("INCIDENCIA_KEY");

        idEmpresa = getIntent().getStringExtra("EMPRESA_KEY");


        mDatabase = FirebaseDatabase.getInstance().getReference().child("incidencia").child("alta").child(uid);

        RecyclerView recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query postsQuery = mDatabase;

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Incidencia>()
                .setQuery(postsQuery, Incidencia.class)
                .setLifecycleOwner(this)
                .build();
        mAdapter = new FirebaseRecyclerAdapter<Incidencia, IncidenciaViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull IncidenciaViewHolder holder, final int position, @NonNull final Incidencia empresa) {
                holder.departamento.setText(empresa.departamento);
                holder.prioridad.setText(empresa.prioridad);
                holder.motivo.setText(empresa.motivo);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(VerIncidencia.this, VerIncidenciaCompleta.class);
                        intent.putExtra("INCIDENCIA_KEY", getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public IncidenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incidencia, parent, false);
                return new IncidenciaViewHolder(view);

            }
        };
        recyclerView.setAdapter(mAdapter);

        //

        jaja();
        jeje();


        //


    }

    public void jaja(){
        String uid = FirebaseAuth.getInstance().getUid();

        mDatabase2 = FirebaseDatabase.getInstance().getReference().child("incidencia").child("media").child(uid);

        RecyclerView recyclerView = findViewById(R.id.list_viewM);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query postsQuery = mDatabase2;

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Incidencia>()
                .setQuery(postsQuery, Incidencia.class)
                .setLifecycleOwner(this)
                .build();
        mAdapter2 = new FirebaseRecyclerAdapter<Incidencia, IncidenciaViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull IncidenciaViewHolder holder, final int position, @NonNull final Incidencia empresa) {
                holder.departamento.setText(empresa.departamento);
                holder.prioridad.setText(empresa.prioridad);
                holder.motivo.setText(empresa.motivo);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(VerIncidencia.this, VerIncidenciaCompleta.class);
                        intent.putExtra("INCIDENCIA_KEY", getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public IncidenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incidencia, parent, false);
                return new IncidenciaViewHolder(view);

            }
        };
        recyclerView.setAdapter(mAdapter2);
    }
    public void jeje() {
        String uid = FirebaseAuth.getInstance().getUid();

        mDatabase3 = FirebaseDatabase.getInstance().getReference().child("incidencia").child("baja").child(uid);

        RecyclerView recyclerView = findViewById(R.id.list_viewB);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query postsQuery = mDatabase3;

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Incidencia>()
                .setQuery(postsQuery, Incidencia.class)
                .setLifecycleOwner(this)
                .build();
        mAdapter3 = new FirebaseRecyclerAdapter<Incidencia, IncidenciaViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull IncidenciaViewHolder holder, final int position, @NonNull final Incidencia empresa) {
                holder.departamento.setText(empresa.departamento);
                holder.prioridad.setText(empresa.prioridad);
                holder.motivo.setText(empresa.motivo);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(VerIncidencia.this, VerIncidenciaCompleta.class);
                        intent.putExtra("INCIDENCIA_KEY", getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public IncidenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incidencia, parent, false);
                return new IncidenciaViewHolder(view);

            }
        };
        recyclerView.setAdapter(mAdapter3);
    }
}