import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("💰" + " Bienvenid@ a el Conversor de Moneda" + "💰");
        System.out.println("💵 " + "Puedes convertir cualquiera de estos 5 tipos de monedas:  ARS, BRL, CLP, COP, USD" + "💵");
        System.out.println("Ingresa la cantidad a convertir: " + "💱");
        double cantidad = lectura.nextDouble();
        System.out.println("Ingresa la moneda de origen (código ISO, ej. USD, ARS): ");
        String de = lectura.next().toUpperCase();
        System.out.println("Ingresa la moneda de destino (código ISO, ej. USD, ARS): ");
        String a = lectura.next().toUpperCase();

        try {
            ConversorMoneda conversor = new ConversorMoneda();
            double resultado = conversor.convertir(cantidad, de, a);
            System.out.println("Resultado: " + resultado + " " + a);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            lectura.close();
        }
    }
}
