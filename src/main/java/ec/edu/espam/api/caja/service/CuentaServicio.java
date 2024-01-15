package ec.edu.espam.api.caja.service;
import ec.edu.espam.api.caja.domain.Cuenta;

import java.util.List;

public interface CuentaServicio {
    List<Cuenta> listarTodos();
    Cuenta grabar(Cuenta cuenta);
    Cuenta modificar(Cuenta cuenta);
    Cuenta listarPorId(Long id);
}
