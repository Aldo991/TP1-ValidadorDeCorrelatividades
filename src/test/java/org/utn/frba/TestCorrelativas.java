package org.utn.frba;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestCorrelativas
{
    private Alumno alumno;
    private List<Materia> materias;
    private Inscripcion inscripcion;
    private Materia fisica;
    private Materia matematica;
    private Materia algebra;
    private Materia fisica2;
    private Materia probabilidad;
    @Before
    public void iniciador() {
        alumno = new Alumno();
        materias = new ArrayList<>();
        inscripcion = new Inscripcion(alumno);

        fisica = new Materia("fisica");
        matematica = new Materia("matematica");
        algebra = new Materia("algebra");
        fisica2 = new Materia("fisica 2");
        probabilidad = new Materia("probabilidad");

        fisica2.agregarCorrelativa(fisica);

        probabilidad.agregarCorrelativa(matematica);
        probabilidad.agregarCorrelativa(algebra);
    }

    @Test
    public void materiasSinCorrelativas()
    {
        inscripcion.agregarMateriaAIncribir(fisica);
        inscripcion.agregarMateriaAIncribir(matematica);

        assertTrue(inscripcion.aprobada());
    }
    @Test
    public void materiasConCorrelativasCumplidas()
    {
        alumno.agregarMateriaAprobada(fisica);
        alumno.agregarMateriaAprobada(matematica);
        alumno.agregarMateriaAprobada(algebra);

        inscripcion.agregarMateriaAIncribir(fisica2);
        inscripcion.agregarMateriaAIncribir(probabilidad);

        assertTrue(inscripcion.aprobada());
    }
    @Test
    public void materiasConCorrelativasNoCumplidas()
    {
        alumno.agregarMateriaAprobada(fisica);
        alumno.agregarMateriaAprobada(matematica);

        inscripcion.agregarMateriaAIncribir(fisica2);
        inscripcion.agregarMateriaAIncribir(probabilidad);

        assertFalse(inscripcion.aprobada());
    }
}
