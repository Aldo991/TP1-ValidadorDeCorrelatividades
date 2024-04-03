package org.utn.frba;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
  private List<Materia> materias;

  public Alumno() {
    materias = new ArrayList<>();
  }
  public void agregarMateriaAprobada(Materia materia) {
    materias.add(materia);
  }

  public List<Materia> getMaterias() {
    return materias;
  }

  public void setMaterias(List<Materia> materias) {
    this.materias = materias;
  }
}
