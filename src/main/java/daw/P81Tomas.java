/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import static daw.LecturaEscritura.lecturaFicheroJSON;
import java.io.IOException;
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
        
        
        
        try {
            
        } catch (Exception e) {
        }
    }
}
