/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import cClasses.*;

/**
 *
 * @author Claudia
 */
@WebService(serviceName = "wsAdminCuentas")
public class wsAdminCuentas {

    db.cDatos _conn;
    ResultSet _rs = null;
    String _dieString = "no valido";

    public wsAdminCuentas() {
        try {
            _conn = new db.cDatos();
            _conn.conectar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "nombre") String nombre, @WebParam(name = "contra") String contra) {
        try {
            _rs = _conn.consulta("call sp_login('" + nombre + "', '" + contra + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada")) {
                    return _rs.getString("id");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "altaCuentaGenerica")
    public String altaCuentaGenerica(@WebParam(name = "nombre") String nombre,
            @WebParam(name = "contra") String contra, @WebParam(name = "correo") String correo,
            @WebParam(name = "tipo") String tipo) {
        try {
            _rs = _conn.consulta("call sp_altaCuentaGenerica('" + nombre + "', '" + contra + "', '" + correo + "', '" + tipo + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("tipo");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "altaCuentaAlumno")
    public String altaCuentaAlumno(@WebParam(name = "nombre") String nombre,
            @WebParam(name = "contra") String contra, @WebParam(name = "anoIng") String anoIng) {
        try {
            _rs = _conn.consulta("call sp_altaCuentaAlumno('" + nombre + "', '" + contra + "', '" + anoIng + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("msj");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "altaCuentaProfesor")
    public String altaCuentaProfesor(@WebParam(name = "ced") String ced,
            @WebParam(name = "nombre") String nombre) {
        try {
            _rs = _conn.consulta("call sp_altaCuentaProfesor('" + ced + "', '" + nombre + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("msj");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "bajaCuenta")
    public String bajaCuenta(@WebParam(name = "nombre") String nombre,
            @WebParam(name = "contra") String contra, @WebParam(name = "tipo") String tipo) {
        try {
            _rs = _conn.consulta("call sp_bajaCuenta('" + nombre + "', '" + contra + "', '" + tipo + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("msj");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "cambiaCuentaAlumno")
    public String cambiaCuentaAlumno(@WebParam(name = "nombrePrev") String nombrePrev,
            @WebParam(name = "nombreNuevo") String nombreNuevo, @WebParam(name = "contraPrev") String contraPrev,
            @WebParam(name = "contraNuevo") String contraNuevo, @WebParam(name = "correo") String correo,
            @WebParam(name = "nomGrupo") String nomGrupo, @WebParam(name = "anoIng") String anoIng) {
        try {
            _rs = _conn.consulta("call sp_cambiaCuentaAlumno('" + nombrePrev + "', '" + nombreNuevo + "', '" + contraPrev + "'"
                    + ", '" + contraNuevo + "', '" + correo + "', '" + nomGrupo + "', '" + anoIng + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("msj");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "cambiaCuentaProfesor")
    public String cambiaCuentaProfesor(@WebParam(name = "nombrePrev") String nombrePrev,
            @WebParam(name = "nombreNuevo") String nombreNuevo, @WebParam(name = "contraPrev") String contraPrev,
            @WebParam(name = "contraNuevo") String contraNuevo, @WebParam(name = "correo") String correo,
            @WebParam(name = "ced") String ced) {
        try {
            _rs = _conn.consulta("call sp_cambiaCuentaProfesor('" + nombrePrev + "', '" + nombreNuevo + "', '" + contraPrev + "'"
                    + ", '" + contraNuevo + "', '" + correo + "', '" + ced + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("msj");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "cambiaCuentaAdministrador")
    public String cambiaCuentaAdministrador(@WebParam(name = "nombrePrev") String nombrePrev,
            @WebParam(name = "nombreNuevo") String nombreNuevo, @WebParam(name = "contraPrev") String contraPrev,
            @WebParam(name = "contraNuevo") String contraNuevo, @WebParam(name = "correo") String correo) {
        try {
            _rs = _conn.consulta("call sp_cambiaCuentaProfesor('" + nombrePrev + "', '" + nombreNuevo + "', '" + contraPrev + "'"
                    + ", '" + contraNuevo + "', '" + correo + "');");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    return _rs.getString("msj");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _dieString;
    }

    @WebMethod(operationName = "getCuentaAlumno")
    public CuentaAlumno getCuentaAlumno(@WebParam(name = "id") int id) {
        CuentaAlumno ca = new CuentaAlumno();
        try {
            _rs = _conn.consulta("call sp_getCuentaAlumno(" + id + ");");
            while (_rs.next()) {
                if (_rs.getString("msj").equals("operacion realizada") == true) {
                    if (_rs.getString("TipoUsuario").equals("alumno")== true) {
                        ca.setAnoIng(_rs.getString("AnoIngreso"));
                        ca.setContra(_rs.getString("Contrasena"));
                        ca.setCorreo(_rs.getString("Correo"));
                        ca.setNombre(_rs.getString("NombreUsuario"));
                        ca.setNombreGrupo(_rs.getString("nomGrup"));
                        ca.setTipo(_rs.getString("TipoUsuario"));
                        return ca;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ca;
    }

}
