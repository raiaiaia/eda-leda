package forma;

public class CalculaArea {
    public static void main(String[] args) {
        
        Triangulo t = new Triangulo(2, 2);
        System.out.println("Área do triângulo: " + t.calculaArea());

        Circulo c = new Circulo(4);
        System.out.println("Área do círculo: " + c.calculaArea());

        Retangulo r = new Retangulo(3, 6);
        System.out.println("Área do retângulo: " + r.calculaArea());

        Quadrado q = new Quadrado(4);
        System.out.println("Área do quadrado: " + q.calculaArea());
    }
}
