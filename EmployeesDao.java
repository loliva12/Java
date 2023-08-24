package models;

import java.sql.Timestamp;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeesDao {
    //Instanciar la conexión
    ConnectionMySQL cn = new ConnectionMySQL(); 
    Connection conn; 
    PreparedStatement pst;   //Sirve para las consultas
    ResultSet rs;   //Sirve para obtener datos de la consulta y con esto se puede operar
    
    //Variables para enviar datos entre interfaces 
    public static int id_user = 0;
    public static String full_name_user = ""; 
    public static String username_user = "";
    public static String address_user = ""; 
    public static String telephone_user = ""; 
    public static String email_user = ""; 
    public static String rol_user = ""; 
    
    //Metodo de login
    public Employees loginQuery(String user, String password){
        //La consulta trae todos los campos de la tabla employees donde el username es igual a ? poeque no sabemos cual es
        //el usuario que la persona esta ingresando al igual que la contraseña 
        String query = "SELECT * FROM employees WHERE username = ? AND password = ?";
        //Instanciar la clase Employees
        Employees employee = new Employees(); 
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            //Enviar parametros
            pst.setString(1, user);     
            pst.setString(2, password);
            rs = pst.executeQuery(); //ejecutar la consulta
            
            if(rs.next()){
                employee.setId(rs.getInt("id"));
                id_user = employee.getId();
                employee.setFull_name(rs.getString("full_name"));
                full_name_user = employee.getFull_name();
                employee.setUsername(rs.getString("username"));
                username_user = employee.getUsername();
                employee.setAddress(rs.getString("address"));
                address_user = employee.getAddress(); 
                employee.setTelephone(rs.getString("telephone"));
                telephone_user = employee.getTelephone(); 
                employee.setEmail(rs.getString("email"));
                email_user = employee.getEmail(); 
                employee.setRol(rs.getString("rol"));
                rol_user = employee.getRol(); 
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener al empleado " + e);
        }
        return employee; 
    }
    
    //Registrar empleados
    public boolean registerEmployeeQuert(Employees employee){
        String query = "INSERT INTO employees(id, full_name, username, address, telephone, email, password, rol, created,"
                + "updated) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime()); //obtiene la fecha y hora exacta del registro y de la actualizacion
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            //acceder a los metodos setters de empleados para enviar los datos que se registraran en la base de datos 
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getFull_name());
            pst.setString(3, employee.getUsername()); 
            pst.setString(4, employee.getAddress());
            pst.setString(5, employee.getTelephone()); 
            pst.setString(6, employee.getEmail()); 
            pst.setString(7, employee.getPassword());
            pst.setString(8, employee.getRol());
            pst.setTimestamp(9, datetime);
            pst.setTimestamp(10, datetime);
            pst.execute();
            return true; 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar al empleado " + e);
            return false; 
        }
    }
    
    //Listar empleado
    public List listEmployeeQuery(String value){
        List<Employees> list_employees = new ArrayList(); 
        //Consulta para listar todos los empleados 
        String query ="SELECT * FROM employees ORDER BY rol ASC";
        //Consulta para listar el empleado buscado
        String query_search_employee = "SELECT * FROM employees WHERE id LIKE '%" + value + "%'";
        
        try{
            conn = cn.getConnection();
            if(value.equalsIgnoreCase("")){
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery(); 
            }else{
                pst = conn.prepareStatement(query_search_employee);
                rs = pst.executeQuery(); 
            }
            
            //recorre este ciclo mientas encuentra registros
            //rs nos devuelve todos los resultados que trea esta consulta
            while(rs.next()){
                Employees employee = new Employees(); 
                //con los metodos setters vamos a almacenar cada uno de los resultados
                employee.setId(rs.getInt("id"));
                employee.setFull_name(rs.getString("full_name"));
                employee.setUsername(rs.getString("username"));
                employee.setAddress(rs.getString("address")); 
                employee.setTelephone(rs.getString("telephone"));
                employee.setEmail(rs.getString("email"));
                employee.setRol(rs.getString("rol"));
                list_employees.add(employee);  //pasamos toda la informacion a la lista 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_employees; 
    }
    
    //Modificar empleaado
    public boolean updateEmployeeQuert(Employees employee){
        String query = "UPDATE employees SET full_name = ?, username = ?, address = ?, telephone = ?, email = ?, rol = ?, updated = ?"
                + "WHERE id = ?";
        Timestamp datetime = new Timestamp(new Date().getTime()); //obtiene la fecha y hora exacta del registro y de la actualizacion
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            //acceder a los metodos setters de empleados para enviar los datos que se registraran en la base de datos 
            pst.setString(1, employee.getFull_name());
            pst.setString(2, employee.getUsername()); 
            pst.setString(3, employee.getAddress());
            pst.setString(4, employee.getTelephone()); 
            pst.setString(5, employee.getEmail()); 
            pst.setString(6, employee.getRol());
            pst.setTimestamp(7, datetime);
            pst.setInt(8, employee.getId());
            pst.execute();
            return true; 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del empleado " + e);
            return false; 
        }
    }
    
    //Eliminar empleado
    public boolean deleteEmployeeQuery(int id){
        String query ="DELETE FROM employees WHERE id = " + id; 
        
        try{
            conn = cn.getConnection(); 
            pst = conn.prepareStatement(query); 
            pst.execute(); 
            return true; 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No puede eliminar un empleado que tenga relación con otra tabla");
            return false; 
        }
    }
    
    //Cambiar la contraseña
    public boolean updateEmployeePassword(Employees employee){
        String query = "UPDATE employees SET password = ? WHERE username = '" + username_user + "'";
        
        try{
            conn = cn.getConnection(); 
            pst = conn.prepareStatement(query); 
            pst.setString(1, employee.getPassword());
            pst.executeUpdate(); 
            return true; 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la contraseña" + e);
            return false; 
        }
    }
}
