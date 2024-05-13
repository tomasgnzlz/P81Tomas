    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     */
    package daw;

    import static daw.LecturaEscritura.lecturaFicheroJSON;
    import java.io.IOException;
    import java.sql.SQLException;
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

            } catch (SQLException sqle) {

                System.out.println("\nNo se ha podido realizar la operación:");
                System.out.println(sqle.getMessage());
            }
            System.out.println("-------- Lista original --------------------");
            listaDonantes.forEach(System.out::println);

        }
    }
