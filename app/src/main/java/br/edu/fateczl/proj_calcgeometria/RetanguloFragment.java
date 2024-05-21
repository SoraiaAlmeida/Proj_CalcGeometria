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

import br.edu.fateczl.proj_calcgeometria.controller.GeometriaControllerRetangulo;
import br.edu.fateczl.proj_calcgeometria.model.Retangulo;


public class RetanguloFragment extends Fragment {

    private EditText edtBase;
    private EditText edtAltura;
    private TextView tvResultado;
    private Button btnCalArea;
    private Button btncalPerimetro;
    private GeometriaControllerRetangulo controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retangulo, container, false);

        edtBase = view.findViewById(R.id.edtBase);
        edtAltura = view.findViewById(R.id.edtAltura);
        tvResultado = view.findViewById(R.id.tvResultado);
        btnCalArea= view.findViewById(R.id.btnCalArea);
        btncalPerimetro = view.findViewById(R.id.btncalPerimetro);

        controller = new GeometriaControllerRetangulo();

        btnCalArea.setOnClickListener(v -> {
            String baseStr = edtBase.getText().toString();
            String alturaStr = edtAltura.getText().toString();
            if (!baseStr.isEmpty() && !alturaStr.isEmpty()) {
                float base = Float.parseFloat(baseStr);
                float altura = Float.parseFloat(alturaStr);
                Retangulo retangulo = new Retangulo();
                retangulo.setBase(base);
                retangulo.setAltura(altura);
                float area = controller.calcularArea(retangulo);
                tvResultado.setText(getString(R.string.area, area));
                edtBase.setText("");
                edtAltura.setText("");
            } else {
                tvResultado.setText(R.string.resultado);
            }
        });


        btncalPerimetro.setOnClickListener(v -> {
                String baseStr = edtBase.getText().toString();
                String alturaStr = edtAltura.getText().toString();
                if (!baseStr.isEmpty() && !alturaStr.isEmpty()) {
                    float base = Float.parseFloat(baseStr);
                    float altura = Float.parseFloat(alturaStr);
                    Retangulo retangulo = new Retangulo();
                    retangulo.setBase(base);
                    retangulo.setAltura(altura);
                    float perimetro = controller.calcularPerimetro(retangulo);
                    tvResultado.setText(getString(R.string.perimetro, perimetro));
                    edtBase.setText("");
                    edtAltura.setText("");
                } else {
                    tvResultado.setText(R.string.resultado);
                }
            });

            return view;
        }
    }

