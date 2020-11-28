package br.pb.fabrica.pages;

import br.pb.fabrica.core.BasePage;
import org.openqa.selenium.By;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

public class CadastrarEstabelecimentoPage extends BasePage {

    public void setTipoDeEstabelecimento(String texto){
        escrever("id_tipo", texto);
    }


  

    public void clicarBotaoEnviar(){
        clicarBotao("//button[text()='Enviar']");
    }
}
