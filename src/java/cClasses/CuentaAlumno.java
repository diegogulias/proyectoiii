/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cClasses;

/**
 *
 * @author Seven
 */
public class CuentaAlumno extends CuentaGenerica{
    
    private String _anoIng;
    private String _nombreGrupo;

    public CuentaAlumno(){
        this._anoIng = "";
        this._nombreGrupo = "";
    }
    
    public String getAnoIng() {
        return _anoIng;
    }

    public void setAnoIng(String _anoIng) {
        this._anoIng = _anoIng;
    }

    public String getNombreGrupo() {
        return _nombreGrupo;
    }

    public void setNombreGrupo(String _nombreGrupo) {
        this._nombreGrupo = _nombreGrupo;
    }
    
    
    
}
