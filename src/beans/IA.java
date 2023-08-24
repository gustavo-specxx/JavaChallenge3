package beans;

public class IA {
    private static String modalSelecionado;

    public void selecionarModal() {
        switch (Sinistro.getDigitoSinistro()) { 
            case "1":
                setModalSelecionado("Guincho Plataforma");
                break;
            case "2":
                setModalSelecionado("Guincho Especializado");
                break;
            case "3":
                setModalSelecionado("Guincho Rotativo");
                break;
        }
    }

    public String getModalSelecionado() {
        return modalSelecionado;
    }

    public void setModalSelecionado(String modalSelecionado) {
        IA.modalSelecionado = modalSelecionado;
    }
}
