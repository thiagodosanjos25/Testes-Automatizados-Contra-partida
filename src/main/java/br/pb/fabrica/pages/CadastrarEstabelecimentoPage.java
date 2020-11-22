package br.pb.fabrica.pages;

import br.pb.fabrica.core.BasePage;
import org.openqa.selenium.By;

public class CadastrarEstabelecimentoPage extends BasePage {

    public void setTipoDeEstabelecimento(String texto){
        escrever("id_tipo", texto);
    }


  

    public void clicarBotaoEnviar(){
        clicarBotao("//button[text()='Enviar']");
    }
}
