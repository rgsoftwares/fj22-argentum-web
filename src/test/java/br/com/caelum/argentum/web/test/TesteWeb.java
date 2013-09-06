package br.com.caelum.argentum.web.test;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteWeb {

	@Test
	public void testar() {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost.com.br:8080/fj22-argentum-web/index.xhtml");
		
		WebElement titulo = driver.findElement(By.id("j_idt6:titulo"));
		
		titulo.sendKeys("");
		
		titulo.submit();
		
		boolean existeMensagem = driver.getPageSource().contains("Erro de vali");
		
		Assert.assertTrue(existeMensagem);
		
		driver.close();
		
		
	}
	
}
