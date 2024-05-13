/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import static daw.LecturaEscritura.lecturaFicheroJSON;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomas
 */
public class P81Tomas {

    public static void main(String[] args) throws IOException {

        List<DonanteVO> listaDonantes = new ArrayList<>();
        listaDonantes = lecturaFicheroJSON();
        listaDonantes.forEach(System.out::println);
        System.out.println("\n\n\n\n\n\n\n");
        DonanteDAO daoPersona = new DonanteDAO();
        try {
            System.out.println("Nº personas insertadas " + daoPersona.insertPersona(listaDonantes));
            System.out.println("\n-----------------------------------------\n");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<DonanteVO> nuevaLista = daoPersona.getAll();
            System.out.println("\n-------- Lista con datos recogidos desde la B.D -------------\n");
            nuevaLista.forEach(System.out::println);
            System.out.println("\n-----------------------------------------\n");
            System.out.println("Persona con primary key 1: ");
            System.out.println(daoPersona.findByPk(1));
            System.out.println("\n-----------------------------------------\n");
            System.out.println("Se va a borrar la persona con pk 3");
            System.out.println("Nº personas borradas "
                    + daoPersona.deletePersona(
                            new DonanteVO(3, "Aiman", LocalDate.of(2016, 05, 16), "O", "-", 73)
                    ));
            System.out.println("\n-----------------------------------------\n");
            nuevaLista = daoPersona.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("\n-----------------------------------------\n");
             System.out.println("Modificación de la persona con pk 2");
            System.out.println("Nº Personas modificadas " + 
                    daoPersona.updatePersona(2, new DonanteVO(22, "TomasAriel", LocalDate.of(2028, 6, 28), "A", "+", 0)
                    ));
//            System.out.println("\n-----------------------------------------\n");
//            nuevaLista = daoPersona.getAll();
//            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
//            nuevaLista.forEach(System.out::println);
            

        } catch (SQLException sqle) {
            System.out.println("\nNo se ha podido realizar la operación:\n" + sqle.getMessage());
        }
//////        System.out.println("-------- Lista original --------------------");
//////        listaDonantes.forEach(System.out::println);

    }
}
