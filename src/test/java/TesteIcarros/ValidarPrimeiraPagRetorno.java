package TesteIcarros;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Model.carro;
import PageObject.Enums.AnoMinimo;
import PageObject.Enums.Marca;
import PageObject.Enums.Modelo;
import utils.MassaExcelSeguroViagem;

public class ValidarPrimeiraPagRetorno{
	private static  WebDriver webDriver;
	private static carro consultaCarro;

	
	
	@Before
	public void iniciar() throws IOException{		
		platform.ChromePlatform carro = new platform.ChromePlatform();
		webDriver = carro.getLocalWebDriver();
	}

	@After
	public void fechar(){
		webDriver.close();
		webDriver.quit();
	}
	
	/**
	 * Validar todos os carros que aparecem na Primeira Pagina
	 * @author Kelly
	 * @throws Exception
	 */
	@Test
	public void ValidarPrimeiraPag() throws Exception {
	MassaExcelSeguroViagem massa= new MassaExcelSeguroViagem();

		Map<String, List<String>> tst = massa.obterDadosMassa();
		String marca = tst.get("Marca").toString().replaceAll("[\\[\\]]",  "");
		String modelo = tst.get("Modelo").toString().replaceAll("[\\[\\]]",  "");
		String ano = tst.get("Ano").toString().replaceAll("[\\[\\]]",  "");
		consultaCarro = new carro(webDriver);
		consultaCarro.selecionarMarca(Marca.valueOf(marca.toUpperCase()));
		consultaCarro.selecionarModelo(Modelo.valueOf(modelo.toUpperCase()));
		consultaCarro.selecionarAnoMinimo(AnoMinimo.valueOf(ano));
		consultaCarro.selecionarBuscar();
		
		consultaCarro.validarRetornoPag();
		System.out.print("");
		
	}
	

}