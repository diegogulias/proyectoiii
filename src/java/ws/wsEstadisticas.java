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
import cClasses.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudia
 */
@WebService(serviceName = "Estadisticas")
public class wsEstadisticas {

    db.cDatos _conn;
    ResultSet _rs = null;
    String _dieString = "no valido";

    public wsEstadisticas() {
        try {
            _conn = new db.cDatos();
            _conn.conectar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public EstadisticaVista[] getEstadistica() {

        int rcount=0;
        try {
            this._rs = _conn.getScrollable("select  * from v_estadisticamaygeneral");
            if (this._rs.next()) {
                this._rs.last();
                rcount = this._rs.getRow();
            }
            EstadisticaVista est[] = new EstadisticaVista[rcount];
            _rs.beforeFirst();
            if(this._rs.next()){
                for(int i=0; i<=rcount; i++){
                    est[i].setTotal(this._rs.getInt("total"));
                    est[i].setNombre(this._rs.getString("NombreUsuario"));
                    this._rs.next();
                }
                return est;
            }

            return null;
        } catch (SQLException ex) {
            Logger.getLogger(wsEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
