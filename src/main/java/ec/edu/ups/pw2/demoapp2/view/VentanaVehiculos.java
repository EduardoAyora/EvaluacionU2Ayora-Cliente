package ec.edu.ups.pw2.demoapp2.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.pw2.demoapp2.ON.VehiculoONRemote;

public class VentanaVehiculos {
	
	private VehiculoONRemote vehiculoONRemote;
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demoapp2");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demoapp2");  
              
            final Context context = new InitialContext(jndiProperties);   
              
            this.vehiculoONRemote = (VehiculoONRemote) context.lookup("ejb:/demoapp2/VehiculoON!ec.edu.ups.pw2.demoapp2.ON.VehiculoONRemote");
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public List<String> buscarPorMarca(String marca) {
		List<String> vehiculos = new ArrayList<String>();
		try {
			vehiculos = this.vehiculoONRemote.buscarPorMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}
	
	public List<String> buscarPorModelo(String modelo) {
		List<String> vehiculos = new ArrayList<String>();
		try {
			vehiculos = this.vehiculoONRemote.buscarPorModelo(modelo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}
	
	public List<String> buscarPorAnio(String anio) {
		List<String> vehiculos = new ArrayList<String>();
		try {
			vehiculos = this.vehiculoONRemote.buscarPorAnio(anio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}


}
