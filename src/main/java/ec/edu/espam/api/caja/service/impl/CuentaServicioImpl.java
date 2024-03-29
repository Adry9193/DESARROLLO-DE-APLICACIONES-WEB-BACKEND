package ec.edu.espam.api.caja.service.impl;

import ec.edu.espam.api.caja.domain.Cuenta;
import ec.edu.espam.api.caja.repository.CuentaRepositorio;
import ec.edu.espam.api.caja.service.CuentaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CuentaServicioImpl implements CuentaServicio {
    private final CuentaRepositorio cuentaRepositorio;
    @Override
    public List<Cuenta> listarTodos() { return cuentaRepositorio.findAll();
    }
    @Override
    public Cuenta grabar(Cuenta cuenta) {
        return cuentaRepositorio.save(cuenta);
    }

    @Override
    public Cuenta modificar(Cuenta cuenta) {return cuentaRepositorio.save(cuenta);
    }
    @Override
    public Cuenta listarPorId(Long id) {
        return cuentaRepositorio.findById(id).orElse(null);
    }
}
