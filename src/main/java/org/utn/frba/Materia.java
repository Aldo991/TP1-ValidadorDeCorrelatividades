package org.utn.frba;

import java.util.ArrayList;
import java.util.List;

public class Materia {
  private List<Materia> correlativas;
  private String nombre;

  public Materia(String nombre) {
    this.nombre = nombre;
    correlativas = new ArrayList<>();
  }
  public boolean cumpleCorrelativas(List<Materia> materias) {
    return materias.stream().filter(m -> esCorrelativa(m)).count() == correlativas.size();
  }
  public boolean esCorrelativa(Materia materia) {
    return correlativas.stream().anyMatch(m -> m.equals(materia))
        || correlativas.size() == 0;
  }
  public void agregarCorrelativa(Materia materia) {
    correlativas.add(materia);
  }
}
