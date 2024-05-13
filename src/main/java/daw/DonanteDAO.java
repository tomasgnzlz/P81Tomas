/*
 * Clase que implementa la interface IPersona
 */
package daw;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class DonanteDAO implements IPaciente {

    private Connection con = null;

    public DonanteDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<DonanteVO> getAll() throws SQLException {
        List<DonanteVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from donantes");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                DonanteVO p = new DonanteVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setId_paciente(res.getInt("id_paciente"));
                p.setNombre(res.getString("nombre"));
                p.setFechaNacimiento(res.getDate("fechaNacimiento").toLocalDate());
                p.setGrupoSanguineo(res.getString("grupoSanguineo"));
                p.setRh(res.getString("rh"));
                p.setNumeroDonaciones(res.getInt("numeroDonaciones"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public DonanteVO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        DonanteVO persona = new DonanteVO();

        String sql = "select * from donantes where id_paciente=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                persona.setId_paciente(res.getInt("id_paciente"));
                persona.setNombre(res.getString("nombre"));
                persona.setFechaNacimiento(res.getDate("fechaNacimiento").toLocalDate());
                persona.setGrupoSanguineo(res.getString("grupoSanguineo"));
                persona.setRh(res.getString("rh"));
                persona.setNumeroDonaciones(res.getInt("numeroDonaciones"));
                return persona;
            }

            return null;
        }
    }

    @Override
    public int insertPersona(DonanteVO persona) throws SQLException {

        int numFilas = 0;
        String sql = "insert into donantes values (?,?,?,?,?,?)";

        if (findByPk(persona.getId_paciente()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, persona.getId_paciente());
                prest.setString(2, persona.getNombre());
                prest.setDate(3, Date.valueOf(persona.getFechaNacimiento()));
                prest.setString(4, persona.getGrupoSanguineo());
                prest.setString(5, persona.getRh());
                prest.setInt(6, persona.getNumeroDonaciones());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    @Override
    public int insertPersona(List<DonanteVO> lista) throws SQLException {
        int numFilas = 0;

        for (DonanteVO tmp : lista) {
            numFilas += insertPersona(tmp);
        }

        return numFilas;
    }

    @Override
    public int deletePersona() throws SQLException {

        String sql = "delete from donantes";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    @Override
    public int deletePersona(DonanteVO persona) throws SQLException {
        int numFilas = 0;

        String sql = "delete from donantes where id_paciente = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, persona.getId_paciente());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updatePersona(int pk, DonanteVO nuevosDatos) throws SQLException {

        int numFilas = 0;
        //String sql = "update donantes set id_paciente = ?, nombre = ?, fechaNacimiento = ?, grupoSanguineo = ?, rh = ?, numeroDonaciones = ? where id_paciente = ?";
          String sql = "update donantes set id_paciente = ?, nombre = ?, fechaNacimiento = ?, grupoSanguineo = ?, rh = ?, numeroDonaciones = ? where id_paciente = ?";

        if (findByPk(pk) == null) {
            // La persona a actualizar no existe
            System.out.println("NO EXISTE ESE DONANTE");
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            System.out.println("SI EXISTE ESE DONANTE");
            try (PreparedStatement prest = con.prepareStatement(sql)) {
                
                // Establecemos los parámetros de la sentencia
                prest.setInt(1, nuevosDatos.getId_paciente());
                prest.setString(2, nuevosDatos.getNombre());
                prest.setDate(3, Date.valueOf(nuevosDatos.getFechaNacimiento()));
                prest.setString(4, nuevosDatos.getGrupoSanguineo());
                prest.setString(5, nuevosDatos.getRh());
                prest.setInt(6, nuevosDatos.getNumeroDonaciones());
                prest.setInt(7, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }
    
    
    
    /*
    @Override
public int updatePersona(int pk, DonanteVO nuevosDatos) throws SQLException {
    int numFilas = 0;
    String sql = "update donantes set id_paciente = ?, nombre = ?, fechaNacimiento = ?, grupoSanguineo = ?, rh = ?, numeroDonaciones = ? where id_paciente = ?";

    if (findByPk(pk) == null) {
        // La persona a actualizar no existe
        System.out.println("NO EXISTE ESE DONANTE");
        return numFilas;
    } else {
        // Instanciamos el objeto PreparedStatement para la actualización de datos.
        System.out.println("SI EXISTE ESE DONANTE");
        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Establecemos los parámetros de la sentencia
            prest.setInt(1, nuevosDatos.getId_paciente());
            prest.setString(2, nuevosDatos.getNombre());
            prest.setDate(3, Date.valueOf(nuevosDatos.getFechaNacimiento()));
            prest.setString(4, nuevosDatos.getGrupoSanguineo());
            prest.setString(5, nuevosDatos.getRh());
            prest.setInt(6, nuevosDatos.getNumeroDonaciones());
            prest.setInt(7, pk); // Añadimos el valor del id_paciente original para la cláusula WHERE

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }
}
*/
}
