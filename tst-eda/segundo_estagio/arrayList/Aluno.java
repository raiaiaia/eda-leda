package arrayList;

public class Aluno {

    private String nome, matricula;
    
    public Aluno(String nome, String matricula) {
        this.matricula = matricula;
        this.nome = nome;
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Aluno)) return false;
        Aluno aluno = (Aluno) obj;
        return this.matricula == aluno.matricula;
    }
    
}