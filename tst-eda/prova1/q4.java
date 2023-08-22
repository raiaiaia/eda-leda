package prova1;

public class q4 {

    public static String vogaisRepetidas(String[] vogais){
        String out = "";
        int[] vogaisInteiros = new int[5];

        for(int i=0; i<vogais.length; i++){
            if(vogais[i].equals("a")){vogaisInteiros[0]++;}
            if(vogais[i].equals("e")){vogaisInteiros[1]++;}
            if(vogais[i].equals("i")){vogaisInteiros[2]++;}
            if(vogais[i].equals("o")){vogaisInteiros[3]++;}
            if(vogais[i].equals("u")){vogaisInteiros[4]++;}
        }
        for(int i=0; i<vogaisInteiros.length; i++){
            if(vogaisInteiros[i] > 1){
                out += vogais[i] + " ";
            }
        }
        return out.trim();
    }
    public static void main(String[] args) {
        String[] vogais = {"a", "e", "i", "a", "i"};
        System.out.println(vogaisRepetidas(vogais));
    }
}