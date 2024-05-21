package br.edu.fateczl.proj_calcgeometria.controller;

import br.edu.fateczl.proj_calcgeometria.model.Circulo;

public class GeometriaControllerCirculo implements IGeometriaController<Circulo> {

    @Override
    public float calcularArea(Circulo circulo) {
        return (float) (Math.PI * Math.pow(circulo.getRaio(), 2));
    }

    @Override
    public float calcularPerimetro(Circulo circulo) {
        return (float) (2 * Math.PI * circulo.getRaio());
    }
}