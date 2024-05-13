/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomas
 */
public class LecturaEscritura {
    

    public static void main(String[] args) throws IOException {
        List<DonanteVO> lista = new ArrayList<>();
        lista = lecturaFicheroJSON();
        lista.forEach(System.out::println);
    }

    public final static String NOMBRE_FICHERO = "donantes.json";

//    // Método que lee el fichero json y lo guarda en una lista
//    public static List<DonanteVO> lecturaFicheroJSON() throws IOException {
//        List<DonanteVO> lista = new ArrayList<>();
//        ObjectMapper mapeador = new ObjectMapper();
//        mapeador.registerModule(new JavaTimeModule());
//
//        lista = mapeador.readValue(new File(NOMBRE_FICHERO),
//                mapeador.getTypeFactory()
//                        .constructCollectionType(List.class, DonanteVO.class));
//         return lista;
//    }
    // Método que lee el fichero json y lo guarda en una lista
    public static List<DonanteVO> lecturaFicheroJSON() throws IOException {
        List<DonanteVO> lista = new ArrayList<>();
        
        ObjectMapper mapeador = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        mapeador.registerModule(module);
        
        lista = mapeador.readValue(new File(NOMBRE_FICHERO),
                mapeador.getTypeFactory().constructCollectionType(List.class, DonanteVO.class));
        
        return lista;
    }
    
}
