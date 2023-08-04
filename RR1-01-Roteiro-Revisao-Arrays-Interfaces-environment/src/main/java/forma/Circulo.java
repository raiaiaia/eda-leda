package forma;

public class Circulo implements FormaInterface{

    double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double calculaArea(){
        double area = Math.PI * (raio * 2);
        return area;
    }
    
}
