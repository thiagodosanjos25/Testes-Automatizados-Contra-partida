package br.pb.fabrica.core;

import static br.pb.fabrica.core.DriverFactory.getDriver;
import static br.pb.fabrica.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.pb.fabrica.pages.LoginPage;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

public class BaseTest {
	
	private LoginPage login = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa() throws InterruptedException {
		login.AcessarTelaInicial();
		Thread.sleep(4000);
		login.InserirUsuario("Fernanda");
		login.InserirSenha("gcp2020");
		login.ClicarBotao();
	}

	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
