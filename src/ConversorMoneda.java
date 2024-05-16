import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConversorMoneda {
    private static final Set<String> SUPPORTED_CURRENCIES = new HashSet<>(Set.of("ARS", "BRL", "CLP", "COP", "USD"));
    private ConsultarMoneda consultarMoneda;

    public ConversorMoneda() {
        this.consultarMoneda = new ConsultarMoneda();
    }

    public double convertir(double cantidad, String de, String a) {
        if (!SUPPORTED_CURRENCIES.contains(de) || !SUPPORTED_CURRENCIES.contains(a)) {
            throw new IllegalArgumentException("Moneda no soportada. Monedas soportadas: ARS, BRL, CLP, COP, USD.");
        }
        Moneda moneda = consultarMoneda.consultaMoneda(de);
        Map<String, Double> tasas = moneda.getConversionRates();
        if (tasas.containsKey(a)) {
            return cantidad * tasas.get(a);
        } else {
            throw new IllegalArgumentException("Moneda de destino no encontrada.");
        }
    }
}
