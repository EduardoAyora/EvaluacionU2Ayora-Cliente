package ec.edu.ups.pw2.demoapp2.ON;

import java.util.List;

public interface VehiculoONRemote {
	public List<String> buscarPorMarca(String marca);
	public List<String> buscarPorModelo(String modelo);
	public List<String> buscarPorAnio(String anio);
}
