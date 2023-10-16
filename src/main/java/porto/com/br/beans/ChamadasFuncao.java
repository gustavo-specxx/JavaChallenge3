package porto.com.br.beans;

import java.util.ArrayList;
import java.util.Scanner;

import porto.com.br.dao.*;

public class ChamadasFuncao {
    
    public ChamadasFuncao() {}
    
    public void abreChamado(String documentoSegurado) {

        ChamadoDAO chamadoDAO = new ChamadoDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ApoliceDAO apoliceDAO = new ApoliceDAO();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Apolice> apolices = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        int validaCham = chamadoDAO.validaChamado(documentoSegurado);
        
        if(validaCham == 1) {
            System.out.println("Já existem chamados em aberto, deseja continuar? S/N");
            String decisao = scan.next();
            
            if(decisao.equalsIgnoreCase("N")) {
                // Retornar ao menu
                scan.close(); // Fechar o scanner
                return;
            }
        }
        
        System.out.println("Escreva sua apólice");
        
        int idx = 0;
        
        apolices = apoliceDAO.retornaApoliceSegurado("17355056000161"); 
        for(Apolice apolice : apolices) {
            System.out.println("===========================");
            System.out.println("idx " + idx);
            System.out.println("Cobertura......: " + apolice.getCoberturaApolice());
            System.out.println("Codigo.....: " + apolice.getCodApolice());
            System.out.println("Tipo.:" + apolice.getTipoApolice());
            idx++;
        }
        
        int indexApolice = scan.nextInt();
        
        int idApolice = apoliceDAO.retornaIdApolice(indexApolice, documentoSegurado);
        
        System.out.println(idApolice);
        System.out.println("Digite o número de acordo com a sua situação:\n1- Colisão, 2-Roubo/Furto, 3-Incêndio, 4-Desastres naturais, 5-Reparo vidros");        
        int tipoSinistro = scan.nextInt();

        System.out.println("Descreva o ocorrido:");
        String descricaoChamado = scan.next(); 
        veiculos = veiculoDAO.listaVeiculosApolice(documentoSegurado);

        System.out.println("Insira a placa do Veículo envolvido no acidente:");
        
        for(Veiculo veiculo : veiculos) {
            System.out.println("===========*=========*=======");
            System.out.println("Placa.......: " + veiculo.getPlaca());
            System.out.println("Modelo......: " + veiculo.getModeloVeiculo());
            System.out.println("Especificações.....:" + veiculo.getEspecificacoesVeiculo());
        }
        
        String veiculo = scan.next();
        
        Chamado chamado = new Chamado();//arrumar
        
        int idLocalSinistro = 1;
        chamadoDAO.insereChamado(chamado, descricaoChamado, idApolice, idLocalSinistro); 

        System.out.println("Chamado aberto com sucesso! Em breve retornaremos com atualizações");
        chamadoDAO.fechaConexao();
        
       // scan.close(); // Fechar o scanner no final do método
    }
    
    public void mostraChamados(String documentoSegurado) {
        ArrayList<Chamado> chamados = new ArrayList<>();
        
        ChamadoDAO chamadoDAO = new ChamadoDAO();
        
        chamados = chamadoDAO.retornaChamados(documentoSegurado);
        
        if(chamados.isEmpty()) {
            System.out.println("Não há chamados para mostrar.");
        } else {
            System.out.println("=========CHAMADOS=======");
            
            for(Chamado chamado : chamados) {
                int tipoSinistro = chamado.getTipoSinistro();
                String tipoSinistroTexto;

                switch (tipoSinistro) {
                    case 1:
                        tipoSinistroTexto = "Colisão";
                        break;
                    case 2:
                        tipoSinistroTexto = "Roubo/Furto";
                        break;
                    case 3:
                        tipoSinistroTexto = "Incêndio";
                        break;
                    case 4:
                        tipoSinistroTexto = "Desastre Natural";
                        break;
                    case 5:
                        tipoSinistroTexto = "Reparo de Vidros";
                        break;
                    default:
                        tipoSinistroTexto = "Não Identificado";
                        break;
                }
                
                System.out.println("Tipo Sinistro....: " + tipoSinistroTexto);
            }
        }
        
        chamadoDAO.fechaConexao();
    }
}
