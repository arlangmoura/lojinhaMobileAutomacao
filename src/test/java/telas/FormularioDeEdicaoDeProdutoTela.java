package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeEdicaoDeProdutoTela extends BaseTela {

    public FormularioDeEdicaoDeProdutoTela(WebDriver app) {
        super(app);
    }

    public String capturarMensagemApresentada() {
        return capturarToast();
    }
}
