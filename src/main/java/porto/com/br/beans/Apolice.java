package porto.com.br.beans;

public class Apolice {
	
    private String tipoApolice;
    private String codApolice;
    private String coberturaApolice;
    private int idApolice;
    
    public Apolice(String tipoApolice, String codApolice, String coberturaApolice, int idApolice) {
        this.tipoApolice = tipoApolice;
        this.codApolice = codApolice;
        this.coberturaApolice = coberturaApolice;
        this.idApolice = idApolice;
    }
    
    public Apolice() {}

    public String getTipoApolice() {
        return tipoApolice;
    }

    public void setTipoApolice(String tipoApolice) {
        this.tipoApolice = tipoApolice;
    }

    public String getCodApolice() {
        return codApolice;
    }

    public void setCodApolice(String codApolice) {
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
