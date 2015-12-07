/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Claudia
 */
@WebService(serviceName = "wsPreguntas")
public class wsPreguntas {

    db.cDatos _conn;
    ResultSet _rs = null;
    String _dieString = "no valido";

    public wsPreguntas() {
        try {
            _conn = new db.cDatos();
            _conn.conectar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "altaPregunta")
    public String altaPregunta(@WebParam(name = "nombre") String nombre, @WebParam(name = "cont") String cont,
            @WebParam(name = "a") String a, @WebParam(name = "b") String b, @WebParam(name = "c") String c,
            @WebParam(name = "d") String d, @WebParam(name = "rc") String rc) {
        
        try {
            _rs = _conn.consulta("call sp_altaPregunta('" + nombre + "', '" + cont + "');");
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
}
