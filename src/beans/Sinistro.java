package beans;

public class Sinistro {
    private String digitoSinistro;
    private static String sinistroEscolhido = "";

    public Sinistro() {
    }

    public void escolhaSinistro() {
        switch (digitoSinistro) {
            case "1":
                sinistroEscolhido = "Batida";
                break;
            case "2":
                sinistroEscolhido = "Pane Elétrica";
                break;
            case "3":
                sinistroEscolhido = "Desastres Naturais";
                break;
        }
    }

    public String getDigitoSinistro() {
        return digitoSinistro;
    }

    public void setDigitoSinistro(String digitoSinistro) {
        this.digitoSinistro = digitoSinistro;
    }

    public static String getSinistroEscolhido() {
        return sinistroEscolhido;
    }

    public void setSinistroEscolhido(String sinistroEscolhido) {
        Sinistro.sinistroEscolhido = sinistroEscolhido;
    }
}
