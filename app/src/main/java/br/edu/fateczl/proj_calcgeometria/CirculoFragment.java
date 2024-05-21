package br.edu.fateczl.proj_calcgeometria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fateczl.proj_calcgeometria.controller.GeometriaControllerCirculo;
import br.edu.fateczl.proj_calcgeometria.model.Circulo;


public class CirculoFragment extends Fragment {

    private EditText edtRaio;
    private TextView tvResultado;
    private Button btnCalArea;
    private Button btncalPerimetro;
    private GeometriaControllerCirculo  controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);

        edtRaio = view.findViewById(R.id.edtRaio);
        tvResultado = view.findViewById(R.id.tvResultado);
        btnCalArea = view.findViewById(R.id.btnCalArea);
        btncalPerimetro = view.findViewById(R.id.btncalPerimetro);
        controller = new GeometriaControllerCirculo();

        btnCalArea.setOnClickListener(v -> {
            String raioStr = edtRaio.getText().toString();
            if (!raioStr.isEmpty()) {
                float raio = Float.parseFloat(raioStr);
                Circulo circulo = new Circulo();
                circulo.setRaio(raio);
                float area = controller.calcularArea(circulo);
                tvResultado.setText(getString(R.string.area, area));
                edtRaio.setText("");
            } else {
                tvResultado.setText(R.string.resultado);
            }
        });

        btncalPerimetro.setOnClickListener(v -> {
            String raioStr = edtRaio.getText().toString();
            if (!raioStr.isEmpty()) {
                float raio = Float.parseFloat(raioStr);
                Circulo circulo = new Circulo();
                circulo.setRaio(raio);
                float perimetro = controller.calcularPerimetro(circulo);
                tvResultado.setText(getString(R.string.perimetro, perimetro));
                edtRaio.setText("");
            } else {
                tvResultado.setText(R.string.resultado);
            }
        });

        return view;
    }
}