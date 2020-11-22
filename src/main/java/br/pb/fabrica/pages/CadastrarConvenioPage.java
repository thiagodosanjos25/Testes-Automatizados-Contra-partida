package br.pb.fabrica.pages;

import br.pb.fabrica.core.BasePage;
import org.openqa.selenium.By;

public class CadastrarConvenioPage extends BasePage {

    /* Formulario */

    public void setConcedente(String tipo){
        selecionarCombo(By.id("id_concedente"), tipo);
    }

    public void setCNPJ(String texto){
        escrever("id_cnpj", texto);
    }

    public void setRazaoSocial(String texto){
        escrever("id_razao_social", texto);
    }

    public void setUnidadeExecutora(String texto){
        escrever("id_unidade_executora", texto);
    }

    public void setEndereco(String texto){
        escrever("id_endereco", texto);
    }

    public void setTelefone(String texto){
        escrever("id_telefone", texto);
    }

    public void setEmail(String texto){
        escrever("id_email", texto);
    }

    public void setRepresentante(String texto){
        escrever("id_representante", texto);
    }

    public void setTipoDeEstabelecimento(String texto){
        selecionarCombo(By.id("id_tipo_de_estabelecimento"), texto);
    }

    public void setData(String texto){
        escrever("id_data", texto);
    }

    public void setDescricao(String texto){
        escrever("id_descricao", texto);
    }

    public void setCondicoes(String texto){
        escrever("id_condicoes", texto);
    }

    /* Botões */

    public void clicarBotaoEnviar(){
        clicarBotao("//button[text()='Enviar']");
    }

}
