package beans;

public class Carga {
    private static String pesoCarga;
    private static String tipoCarga;
    
    public Carga() {
    }

    public static String getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(String pesoCarga) {
        Carga.pesoCarga = pesoCarga;
    }

    public static String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        Carga.tipoCarga = tipoCarga;
    }
}
