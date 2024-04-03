package org.utn.frba;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
  private List<Materia> materiasAInscribir;
  private Alumno alumno;

  public Inscripcion(Alumno alumno) {
    this.alumno = alumno;
    materiasAInscribir = new ArrayList<>();
  }
  public boolean aprobada() {
    return materiasAInscribir.stream()
        .allMatch(materia -> materia.cumpleCorrelativas(alumno.getMaterias()));
  }
  public void agregarMateriaAIncribir(Materia materia) {
    materiasAInscribir.add(materia);
  }
}
