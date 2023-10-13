package porto.com.br.beans;

public class Apolice {
	
    private String tipoApolice;
    private int codApolice;
    private String coberturaApolice;
    private int idApolice;
    
    public Apolice(String tipoApolice, int codApolice, String coberturaApolice, int idApolice) {
        this.tipoApolice = tipoApolice;
        this.codApolice = codApolice;
        this.coberturaApolice = coberturaApolice;
        this.idApolice = idApolice;
    }

    // Métodos getters e setters
    public String getTipoApolice() {
        return tipoApolice;
    }

    public void setTipoApolice(String tipoApolice) {
        this.tipoApolice = tipoApolice;
    }

    public int getCodApolice() {
        return codApolice;
    }

    public void setCodApolice(int codApolice) {
        this.codApolice = codApolice;
    }

    public String getCoberturaApolice() {
        return coberturaApolice;
    }

    public void setCoberturaApolice(String coberturaApolice) {
        this.coberturaApolice = coberturaApolice;
    }

    public int getIdApolice() {
        return idApolice;
    }

    public void setIdApolice(int idApolice) {
        this.idApolice = idApolice;
    }
}
