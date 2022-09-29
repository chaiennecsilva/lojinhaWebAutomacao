package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    //atribuito da classe privado que representa seu navegador (SEMPRE TEM QUE TER)
    private WebDriver navegador;


    //construtor da classe que recebe o estado atual do seu navegador e passa pra dentro dessa classe aqui (SEMPRE TEM QUE TER)
    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }


    public FormularioDeAdicaoDeProdutoPage acessarFormularioAdicaoNovoProduto(){
        navegador.findElement(By.cssSelector("a[href='http://165.227.93.41/lojinha-web/v2/produto/novo']")).click();//clicar no link add produto

        return new FormularioDeAdicaoDeProdutoPage(navegador);//informar o nome da nova pagina e o construtor que no caso é navegador
    }


    //quando usar esse metodo ele vai retornar um texto que está na msg
    public String capturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();//identificar a mgs atraves da classe toast e class rounded
    }


}
