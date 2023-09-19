package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {

	public double raiz(int numero, int raiz, double erro){
		return searchRaiz(numero, raiz, erro, 0, numero);
	}

	private double searchRaiz(int numero, int raiz, double erro, double leftIndex, double rightIndex){
		double chute = (leftIndex + rightIndex) / 2;
  		double chuteElevado = pow(chute, raiz);
  		double result = 0;
  		double meuErro = chuteElevado - numero;
  
  		if(meuErro < 0){
  			meuErro = -meuErro;
  		}
  		if(meuErro < erro){
  			result = chute;
  		}else if(chuteElevado > numero){
  			result = searchRaiz(numero, raiz, erro, leftIndex, chute);
  		}else{
  			result = searchRaiz(numero, raiz, erro, chute, rightIndex);
  		}
  
 		return result;
	}

	private double pow(double number, int expo){
  		if(expo == 0) return 1;
  		else return number * pow(number, expo-1);
 	}

}