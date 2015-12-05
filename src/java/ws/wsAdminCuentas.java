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

/**
 *
 * @author Claudia
 */
@WebService(serviceName = "wsAdminCuentas")
public class wsAdminCuentas {

    db.cDatos _conn;
    ResultSet _rs; 
    
    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "nombre") String nombre, @WebParam(name = "contra") String contra) {
        return null;
    }
}
