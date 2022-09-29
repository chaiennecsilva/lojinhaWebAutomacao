package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
    //atribuito da classe privado que representa seu navegador (SEMPRE TEM QUE TER)
    private WebDriver navegador;


    //construtor da classe que recebe o estado atual do seu navegador e passa pra dentro dessa classe aqui (SEMPRE TEM QUE TER)
    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }


    public FormularioDeAdicaoDeProdutoPage informarNomeProduto(String produtoNome){
        navegador.findElement(By.cssSelector("label[for='produtonome']")).click();//clicar no campo nome do produto
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);//digitar no campo o nome do produto a ser add de forma dinamica

        return this;

    }

    public FormularioDeAdicaoDeProdutoPage informarValorProduto(String produtoValor){
        navegador.findElement(By.cssSelector("label[for='produtovalor']")).click();//clicar no campo valor do produto
        navegador.findElement(By.id("produtovalor")).sendKeys(produtoValor);//digitar o valor 0 no campo valor do produto de forma dinamica

        return this;
    }

    public  FormularioDeAdicaoDeProdutoPage informarCoresProduto(String produtoCores){
        navegador.findElement(By.cssSelector("label[for='produtocores']")).click();//clicar no campo cores do produto
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);//digitar as cores dos produtos no campo de forma dinamica

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro(){
        //Vou submeter o formulario com erro devido a RN do valor
        navegador.findElement(By.cssSelector("button[type='submit']")).click();//clicar no botão de enviar o formulario

        return  new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoDeProdutoPage submeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();//clicar no botão de enviar o formulario

        return new FormularioDeEdicaoDeProdutoPage(navegador);

    }
}


