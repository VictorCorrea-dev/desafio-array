import java.util.ArrayList;
import java.util.List;

void main() {

    List<Pessoa> banco = new ArrayList<>();

    banco.add(new Pessoa(1, "João", 23));
    banco.add(new Pessoa(2, "Sérgio", 40));
    banco.add(new Pessoa(3, "Pedro", 16));
    banco.add(new Pessoa(4, "Julia", 25));
    banco.add(new Pessoa(5, "Paola", 30));
    banco.add(new Pessoa(6, "Carlos", 35));
    banco.add(new Pessoa(7, "Ana", 22));
    banco.add(new Pessoa(8, "Lucas", 28));
    banco.add(new Pessoa(9, "Mariana", 31));
    banco.add(new Pessoa(10, "Gabriel", 20));
    banco.add(new Pessoa(11, "Rafael", 32));

    List<Pessoa> cache = new ArrayList<>();

    while (true) {

        IO.println("Digite o ID da pessoa (ou 0 para sair):");
        int id = Integer.parseInt(IO.readln());

        if (id == 0) {
            break;
        }

        Pessoa pessoaEncontrada = null;

        // Procura no cache
        for (Pessoa pessoa : cache) {

            if (pessoa.id == id) {
                pessoaEncontrada = pessoa;
            }
        }

        if (pessoaEncontrada != null) {

            IO.println("Pessoa encontrada no cache: " + pessoaEncontrada);

        } else {
            for (Pessoa pessoa : banco) {

                if (pessoa.id == id) {
                    pessoaEncontrada = pessoa;
                }
            }

            if (pessoaEncontrada != null) {
                if (cache.size() == 10) {
                    IO.println("Cache cheio! Removendo: " + cache.get(0));
                    cache.remove(0);
                }

                cache.add(pessoaEncontrada);

                IO.println("Pessoa adicionada ao cache: " + pessoaEncontrada);

            } else {

                IO.println("Pessoa não encontrada!");
            }
        }

        IO.println("Cache atual: " + cache);
    }
}