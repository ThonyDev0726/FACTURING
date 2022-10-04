/*
 * EMPck nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * EMPck nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import DataBase.Conexion;
import Interfaces.crud_empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.EMPLEADO;

/**
 *
 * @author perez
 */
public class EMPLEADO_DAO implements crud_empleado {

    EMPLEADO c = new EMPLEADO();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR_EN_LINEA = "CALL A_SELECT_EMPLEADO_LINEA()";
    String LISTAR = "CALL A_SELECT_EMPLEADO()";
    String LISTAR_ID = "CALL A_S_ID_EMPLEADO(?)";
    String CREAR = "CALL INSERT_EMPLEADO(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_EMPLEADO(?,?,?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_EMPLEADO(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_EMPLEADO_ESTADO(?,?)";

    @Override
    public List listar() {
        ArrayList<EMPLEADO> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                EMPLEADO emp = new EMPLEADO();
                emp.setID_EMPLEADO(rs.getInt(1));
                emp.setSUC_NOMBRE(rs.getString(2));
                emp.setEMP_NOMBRES(rs.getString(3));
                emp.setEMP_APELLIDOS(rs.getString(4));
                emp.setEMP_CEDULA(rs.getString(5));
                emp.setEMP_EMAIL(rs.getString(6));
                emp.setEMP_TELEFONO(rs.getString(7));
                emp.setEMP_DIRECCION(rs.getString(8));
                emp.setEMP_CUMPLEANOS(rs.getString(9));
                emp.setEMP_CREADOR(rs.getString(10));
                emp.setEMP_ESTADO(rs.getString(11));
                emp.setEMP_IMG(rs.getString(12));
                lista.add(emp);
            }
            System.out.println(LISTAR);
            System.out.println(lista.toString());
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS EMPLEADOS" + ex);
        }
        return lista;
    }

    @Override
    public EMPLEADO list(int idEmpleado) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idEmpleado);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_EMPLEADO(rs.getInt(1));
                c.setSUC_NOMBRE(rs.getString(2));
                c.setEMP_NOMBRES(rs.getString(3));
                c.setEMP_APELLIDOS(rs.getString(4));
                c.setEMP_CEDULA(rs.getString(5));
                c.setEMP_EMAIL(rs.getString(6));
                c.setEMP_TELEFONO(rs.getString(7));
                c.setEMP_DIRECCION(rs.getString(8));
                c.setEMP_CUMPLEANOS(rs.getString(9));
                c.setEMP_CREADOR(rs.getString(10));
                c.setEMP_ESTADO(rs.getString(11));
                c.setEMP_IMG(rs.getString(12));
            }
            System.out.println(c.toString());
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS EMPLEADOS" + ex);
        }
        return c;
    }

    @Override
    public String add(EMPLEADO mp) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(CREAR);;
            cs.setInt(1, mp.getFK_SUCURSAL());
            cs.setString(2, mp.getEMP_NOMBRES());
            cs.setString(3, mp.getEMP_APELLIDOS());
            cs.setString(4, mp.getEMP_CEDULA());
            cs.setString(5, mp.getEMP_EMAIL());
            cs.setString(6, mp.getEMP_TELEFONO());
            cs.setString(7, mp.getEMP_DIRECCION());
            cs.setString(8, mp.getEMP_CUMPLEANOS());
            cs.setString(9, mp.getEMP_CREACIOM());
            cs.setString(10, mp.getEMP_CREADOR());
            cs.setString(11, mp.getEMP_IP());
            cs.setString(12, mp.getEMP_ESTADO());
            cs.setString(13, mp.getEMP_IMG());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL EMPLEADO");
            System.out.println(ex);
            return "El Empleado no fue creado con exito!";
        }
        return "El Empleado fue creado con exito!";
    }

    @Override
    public String update(EMPLEADO mp) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, mp.getID_EMPLEADO());
            cs.setInt(2, mp.getFK_SUCURSAL());
            cs.setString(3, mp.getEMP_NOMBRES());
            cs.setString(4, mp.getEMP_APELLIDOS());
            cs.setString(5, mp.getEMP_CEDULA());
            cs.setString(6, mp.getEMP_EMAIL());
            cs.setString(7, mp.getEMP_TELEFONO());
            cs.setString(8, mp.getEMP_DIRECCION());
            cs.setString(9, mp.getEMP_CUMPLEANOS());
            cs.setString(10, mp.getEMP_ESTADO());
            cs.setString(11, mp.getEMP_IMG());
            cs.execute();
            System.out.println(ACTUALIZAR);
            System.out.println(mp.toString());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL EMPLEADO");
            System.out.println(ex);
            return "El Empleado no fue actualizado!";
        }
        return "El empleado fue actualizado con exito!";
    }

    @Override
    public List listar_en_linea() {
        ArrayList<EMPLEADO> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_EN_LINEA);
            rs = cs.executeQuery();
            while (rs.next()) {
                EMPLEADO emp = new EMPLEADO();
                emp.setID_EMPLEADO(rs.getInt(1));
                emp.setFK_SUCURSAL(rs.getInt(2));
                emp.setEMP_NOMBRES(rs.getString(3));
                emp.setEMP_APELLIDOS(rs.getString(4));
                emp.setEMP_CEDULA(rs.getString(5));
                emp.setEMP_EMAIL(rs.getString(6));
                emp.setEMP_TELEFONO(rs.getString(7));
                emp.setEMP_DIRECCION(rs.getString(8));
                emp.setEMP_CUMPLEANOS(rs.getString(9));
                emp.setEMP_CREACIOM(rs.getString(10));
                emp.setEMP_CREADOR(rs.getString(11));
                emp.setEMP_IP(rs.getString(12));
                emp.setEMP_ESTADO(rs.getString(13));
                emp.setEMP_IMG(rs.getString(14));
                lista.add(emp);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS CLIENTES" + ex);
        }
        return lista;
    }

    @Override
    public String actualizar_estado(int id, String estado) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR_ESTADO);
            cs.setInt(1, id);
            cs.setString(2, estado);
            System.out.println(ACTUALIZAR_ESTADO);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DAR DE BAJA AL EMPLEADO");
            System.out.println(ex);
            return "Error al dar baja al empleado!";
        }
        return "El empleado fue dado de baja con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println(ELIMINAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el empleado!");
            System.out.println(ex);
            return "Error al eliminar el empleado!";
        }
        return "El empleado fue eliminado con exito!";
    }
}
