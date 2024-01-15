package ec.edu.espam.api.caja.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@Entity(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuenta", nullable = false)
    private Long idCuenta;

    @Column(name = "numeroCuenta")
    @NotEmpty(message = "Número Cuenta es requerido")
    private String numeroCuenta;

    @Column(name = "tipoCuenta")
    @NotNull(message = "Tipo Cuenta es requerido")
    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    @Column(name = "balanceInicial")
    @NotNull(message = "Balance Inicial es requerido")
    private BigDecimal balanceInicial;

    @Column(name = "saldoCuenta")
    @NotNull(message = "Saldo Cuenta es requerido")
    private BigDecimal saldoCuenta;

    @Column(name = "estadoCuenta")
    @NotNull(message = "Estado es requerido")
    private Boolean estadoCuenta;
    private enum TipoCuenta {
        AHORRO, CORRIENTE
    }

}
