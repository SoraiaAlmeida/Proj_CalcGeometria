package br.edu.fateczl.proj_calcgeometria.controller;
import br.edu.fateczl.proj_calcgeometria.model.Retangulo;

public  class GeometriaControllerRetangulo implements IGeometriaController<Retangulo> {

        @Override
        public float calcularArea(Retangulo retangulo) {
            return retangulo.getBase() * retangulo.getAltura();
        }

        @Override
        public float calcularPerimetro(Retangulo retangulo) {
            return 2 * (retangulo.getBase() + retangulo.getAltura());
        }

    }
