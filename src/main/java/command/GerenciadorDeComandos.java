package command;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeComandos {

    private List<Comando> historicoComandos = new ArrayList<>();

    public void executarComando(Comando comando) {
        this.historicoComandos.add(comando);
        comando.executar();
    }

    public void desfazerUltimoComando() {
        if (!historicoComandos.isEmpty()) {

            Comando comando = this.historicoComandos.get(this.historicoComandos.size() - 1);
            comando.desfazer();

            this.historicoComandos.remove(this.historicoComandos.size() - 1);
        }
    }
}