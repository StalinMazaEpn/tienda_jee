/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.tienda.entidades.Cargo;
import com.tienda.session.CargoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "cargoManagedBean")/*nombre para llamar a la vista*/
@ViewScoped
public class CargoManagedBean implements Serializable ,ManageBeanInterfaces<Cargo>{

        
    public CargoManagedBean() {
    }
    @EJB
    /*invocar la modulo cargo face local*/
    private CargoFacadeLocal cargoFacadeLocal; 
    
    private List<Cargo> ListaCargo;
    /*esto es para cuando quiero agregar o editar un cargo*/
    private Cargo cargo;
    
    @PostConstruct
    public void init(){
        /*en listar los valores en la lista*/
        ListaCargo=cargoFacadeLocal.findAll();
    }

    @Override
    public void nuevo() {
        /*instaciar un nuevo cargo*/
        cargo= new Cargo();
    }

    @Override
    public void grabar() {
        try {
            if(cargo.getCodigo()== null){
            }
            else{
                cargoFacadeLocal.edit(cargo);
            }
            cargo=null;
            ListaCargo= cargoFacadeLocal.findAll();
        }
        catch(Exception e){
                e.printStackTrace();
        }
    }

    @Override
    public void seleccionar(Cargo t) {
        cargo =t;
    }

    @Override
    public void eliminar(Cargo t) {
        try{
            cargoFacadeLocal.remove(t);
            //listar los cargos
            ListaCargo= cargoFacadeLocal.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void cancelar() {
        cargo=null;
    }
    
    /*default void mostrarMensajeTry(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage msg = new FacesMessage(tipo, mensaje, "");
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, msg);
     }*/

    public List<Cargo> getListaCargo() {
        return ListaCargo;
    }

    public void setListaCargo(List<Cargo> ListaCargo) {
        this.ListaCargo = ListaCargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
