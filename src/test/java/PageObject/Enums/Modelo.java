package PageObject.Enums;
import org.openqa.selenium.By;

public enum Modelo {
	
	A4(By.xpath("//*[@id='sltModel']/..//span[text()='A4']"), "A4"), 
	A6(By.xpath("//*[@id='sltModel']/..//span[text()='A6']"), "A6");

	private Object[] option;

	Modelo(Object... vals) {
		option = vals;
	}

	public By getBy() {
		return (By) option[0];
	}

	public String getTexto() {
		return (String) option[1];
	}

}
