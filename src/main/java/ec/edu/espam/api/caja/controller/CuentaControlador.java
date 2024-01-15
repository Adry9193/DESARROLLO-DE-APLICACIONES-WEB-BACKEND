package ec.edu.espam.api.caja.controller;
import ec.edu.espam.api.caja.domain.Cuenta;
import ec.edu.espam.api.caja.service.CuentaServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cuenta")
public class CuentaControlador {
    private final CuentaServicio cuentaServicio;

    @GetMapping
    public ResponseEntity<List<Cuenta>> listarTodos() {
        return ResponseEntity.ok(cuentaServicio.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Cuenta> grabar(@RequestBody @Valid Cuenta cuenta) {
        return new ResponseEntity<>(cuentaServicio.grabar(cuenta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> editar(@PathVariable Long id, @RequestBody @Valid Cuenta cuentaActualizada) {
        Cuenta cuentaExiste = cuentaServicio.listarPorId(id);

        if (cuentaExiste == null) {
            return ResponseEntity.notFound().build();
        }

        cuentaExiste.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
        cuentaExiste.setTipoCuenta(cuentaActualizada.getTipoCuenta());
        cuentaExiste.setBalanceInicial(cuentaActualizada.getBalanceInicial());
        cuentaExiste.setSaldoCuenta(cuentaActualizada.getSaldoCuenta());
        cuentaExiste.setEstadoCuenta(cuentaActualizada.getEstadoCuenta());

        Cuenta cuentaEditar = cuentaServicio.modificar(cuentaExiste);
        return ResponseEntity.ok(cuentaEditar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaServicio.listarPorId(id));
    }

}
