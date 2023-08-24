package beans;

public class Local {
    private static String rua;
    private static String numero;
    private static String bairro;
    private static String cep;

    public static String getRua() {
        return rua;
    }

    public static void setRua(String rua) {
        Local.rua = rua;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        Local.numero = numero;
    }

    public static String getBairro() {
        return bairro;
    }

    public static void setBairro(String bairro) {
        Local.bairro = bairro;
    }

    public static String getCep() {
        return cep;
    }

    public static void setCep(String cep) {
        Local.cep = cep;
    }
}
