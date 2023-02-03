import entities.Pessoa;
import repositories.PessoaRepository;

import java.io.IOException;

public class Main {

    private static PessoaRepository pessoaRepository;

    public Main() {
        pessoaRepository = new PessoaRepository();
    }
    public static void main(String[] args) throws IOException {
        new Main();
        pessoaRepository.save(
                new Pessoa(1, "Pedro", "Da Silva", 20)
        );

    }

}