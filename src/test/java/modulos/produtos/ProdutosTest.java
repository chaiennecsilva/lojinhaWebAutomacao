package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {

    //dentro do escopo da classe declara um atributo
    private WebDriver navegador;

    @BeforeEach
    //todo os testes que eu quero que seja executado antes de cada teste
    public void beforeEach(){
        //Abrir o navegador(setar uma propriedade para falar que é o chromedriver que vai ser intermediario entre nosso script e o brower)
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");

        //usar a variavel da classe que foi criada acima fora do metodo [WebDriver navegador = new ChromeDriver()]
        this.navegador = new ChromeDriver();

        //Vou maximar a tela
        this.navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrão de até 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){
       //Fazer login:instaciar a LoginPage com o metodo que a gente criou ficando assim mais claro o codigo
        String mensagemApresentada = new LoginPage(navegador)
              .informarOUsuario("admin")
                .informarASenha("admin")
                    .submeterFormularioDeLogin()
                        .acessarFormularioAdicaoNovoProduto()
                                .informarNomeProduto("Macbook Pro")
                                        .informarValorProduto("0")
                                                .informarCoresProduto("red, black")
                                                    .submeterFormularioDeAdicaoComErro()
                                                            .capturarMensagemApresentada();

        //Resumindo: abra a pagina de login, informe o usuario e a senha, e submeta o formulario de login. Acesse o formulario de adicao de um
        //novo produto e preencha os dados pedidos e submetada com erro. E no final me da ai a mgs apresentada(caputura ela e joga na msg toast).
        //E dentro de assetions eu quero que apareca essa mgs apresentada.

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor acima de sete mil")
    public void testNaoEPermitidoRegistrarUmProdutoComValorAcimaDeSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeProduto("Macbook Max")
                .informarValorProduto("7.000.01")
                .informarCoresProduto("red, black")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        //Resumindo: abra a pagina de login, informe o usuario e a senha, e submeta o formulario de login. Acesse o formulario de adicao de um
        //novo produto e preencha os dados pedidos e submetada com erro. E no final me da ai a mgs apresentada(caputura ela e joga na msg toast).
        //E dentro de assetions eu quero que apareca essa mgs apresentada.

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na faixa de 0,01 a 7.000,00")
    public void testPossoAdicionarProdutosQueEstejamNaFaixaDeUmcentavoASeteMilReiais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeProduto("Iphone 13 MAX")
                .informarValorProduto("5,000.13")
                .informarCoresProduto("red, gold")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de 0,01 ")
    public void testPossoAdicionarProdutosComValorDeUmCentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeProduto("Iphone 13 MAX")
                .informarValorProduto("0.01")
                .informarCoresProduto("red, gold")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de 7.000.00 ")
    public void testPossoAdicionarProdutosComValorDeSeteMilReais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeProduto("Iphone 13 MAX")
                .informarValorProduto("70000")
                .informarCoresProduto("red, gold")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }
    //sera executado apos os testes
    @AfterEach
    public void afterEach(){
        //Vou fechar o navegador
        //navegador.quit();
    }

}
