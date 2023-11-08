public class FilmesNota {
    
    private String nome;
    private Double nota;
    
    public FilmesNota(){        
    }

    public FilmesNota(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Para o filme: " + nome + ", Você deu nota: " + nota;
    }   
}
