package forma;

public class Triangulo implements FormaInterface{

    double base;
    double altura;
    double area;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calculaArea() {
        area = (this.base + this.altura)/2;
        return area;
    }
    
}
