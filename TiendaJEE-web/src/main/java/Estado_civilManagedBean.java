/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "estado_civilManagedBean")
@ViewScoped
public class Estado_civilManagedBean implements Serializable {
    
    private Integer codigo;
    private String nombre;

    /**
     * Creates a new instance of Estado_civilManagedBean
     */
    public Estado_civilManagedBean() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
