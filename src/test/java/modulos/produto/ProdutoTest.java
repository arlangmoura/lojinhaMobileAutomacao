package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("testes Mobile do Módulo de Produto")
public class ProdutoTest {

    private WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        // Abrir o App
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName", "Galaxy Note10+");
        capacidades.setCapability("platform","Android");
        capacidades.setCapability("udid","RX8MB006PJF");
        capacidades.setCapability("appPackage","com.lojinha");
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "D:\\Projetos\\PTQS\\Mobile\\apk nativo\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @DisplayName("Validação do valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() {
        // Fazer Login
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
        // Abrir o formulário de novo produto
                .acessarFormularioAdicaoNovoProduto()
        // Cadastrar um produto com valor inválido
                .informarNomeDoProduto("iPhone")
                .informarValorDoProduto("700001")
                .informarCoresDoProduto("preto")
                .submeterFormularioDeAdicaoComErro()
        // Validar que a mensagem de inválido foi apresentada
                .capturarMensagemApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @DisplayName("Validação do valor de Produto Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoPermitido() {
        // Fazer Login
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                // Abrir o formulário de novo produto
                .acessarFormularioAdicaoNovoProduto()
                // Cadastrar um produto com valor inválido
                .informarNomeDoProduto("Samsung")
                .informarValorDoProduto("500000")
                .informarCoresDoProduto("prata")
                .submeterFormularioDeAdicaoComErro()
                // Validar que a mensagem de inválido foi apresentada
                .capturarMensagemApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }
    @AfterEach
    public void afterEach() {
        //Vou fechar o navegador
        app.quit();
    }
}
