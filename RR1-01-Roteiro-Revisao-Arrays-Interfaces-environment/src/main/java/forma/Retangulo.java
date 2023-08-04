package forma;

public class Retangulo implements FormaInterface {
    
    double base;
    double altura;
    double area;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
       area = this.base + this.altura;
       return area;
    }
    
}
