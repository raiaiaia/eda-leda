package forma;

public class Quadrado implements FormaInterface{

    double lado;
    double area;

    public Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        area = lado * lado;
        return area;
    }
    
}
