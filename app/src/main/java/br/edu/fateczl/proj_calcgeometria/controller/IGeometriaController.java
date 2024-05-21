package br.edu.fateczl.proj_calcgeometria.controller;

import br.edu.fateczl.proj_calcgeometria.model.Circulo;

public interface IGeometriaController<T> {
    float calcularArea(T figura);
    float calcularPerimetro(T figura);

}