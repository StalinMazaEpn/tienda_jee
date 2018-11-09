/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public interface ManageBeanInterfaces <T>{
    
    public void nuevo();
    
    public void grabar();
    
    public void seleccionar (T t);
    
    public void eliminar (T t);
    
    public void cancelar();
    
}
