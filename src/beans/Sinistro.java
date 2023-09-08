package beans;

public class Sinistro {
    private String digitoSinistro;
    private static String sinistroEscolhido = "";

    public Sinistro() {
    }

    public void escolhaSinistro() {
        switch (digitoSinistro) {
            case "1":
                sinistroEscolhido = "Colisão";
                break;
            case "2":
                sinistroEscolhido = "Roubo/Furto";
                break;
            case "3":
                sinistroEscolhido = "Incêndio";
                break;
            case "4":
            	sinistroEscolhido = "Desastre Natural";
            	break;
            case "5":
            	sinistroEscolhido = "Reparo de Vidros";
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
