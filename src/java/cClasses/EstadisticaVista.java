/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cClasses;

public class EstadisticaVista {
    
    private String _nombre;
    private int _total;
    private String _nomGrup;
    private String _nomEscuela;

    public EstadisticaVista(){
        this._nombre = "";
        this._total = 0;
        this._nomGrup = "";       
        this._nomEscuela ="";
    }
    
    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getTotal() {
        return _total;
    }

    public void setTotal(int _total) {
        this._total = _total;
    }

    public String getNomGrup() {
        return _nomGrup;
    }

    public void setNomGrup(String _nomGrup) {
        this._nomGrup = _nomGrup;
    }

    public String getNomEscuela() {
        return _nomEscuela;
    }

    public void setNomEscuela(String _nomEscuela) {
        this._nomEscuela = _nomEscuela;
    }

    
    
}
