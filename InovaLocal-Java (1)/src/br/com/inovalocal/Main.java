package br.com.inovalocal;

import br.com.inovalocal.dao.ComunidadeDAO;
import br.com.inovalocal.dao.PontoAcessoDAO;
import br.com.inovalocal.dao.EquipamentoPLCDAO;
import br.com.inovalocal.model.Comunidade;
import br.com.inovalocal.model.PontoAcesso;
import br.com.inovalocal.model.EquipamentoPLC;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
    private static final PontoAcessoDAO pontoAcessoDAO = new PontoAcessoDAO();
    private static final EquipamentoPLCDAO equipamentoPLCDAO = new EquipamentoPLCDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("==============================");
            System.out.println(" BEM-VINDO AO SISTEMA INOVA LOCAL");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar Comunidade");
            System.out.println("2 - Listar Comunidades");
            System.out.println("3 - Cadastrar Ponto de Acesso");
            System.out.println("4 - Listar Pontos de Acesso");
            System.out.println("5 - Cadastrar Equipamento PLC");
            System.out.println("6 - Listar Equipamentos PLC");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine().trim();
            if (opcao.equals("0")) break;
            if (opcao.equals("1")) cadastrarComunidade();
            else if (opcao.equals("2")) listarComunidades();
            else if (opcao.equals("3")) cadastrarPontoAcesso();
            else if (opcao.equals("4")) listarPontosAcesso();
            else if (opcao.equals("5")) cadastrarEquipamentoPLC();
            else if (opcao.equals("6")) listarEquipamentosPLC();
            else System.out.println("Opção inválida.");
            System.out.println();
        }
        System.out.println("Encerrado.");
    }

    private static void cadastrarComunidade() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();
        System.out.print("População: ");
        int populacao = Integer.parseInt(scanner.nextLine());
        System.out.print("Situação de Conectividade: ");
        String situacao = scanner.nextLine();
        Comunidade c = new Comunidade(0, nome, localizacao, populacao, situacao);
        boolean ok = comunidadeDAO.inserir(c);
        System.out.println(ok ? "Comunidade cadastrada." : "Falha ao cadastrar.");
    }

    private static void listarComunidades() {
        List<Comunidade> lista = comunidadeDAO.listarTodos();
        if (lista.isEmpty()) System.out.println("Nenhum registro.");
        for (Comunidade c : lista) {
            System.out.println(c.getId() + " | " + c.getNome() + " | " + c.getLocalizacao() + " | " + c.getPopulacao() + " | " + c.getSituacaoConectividade());
        }
    }

    private static void cadastrarPontoAcesso() {
        System.out.print("ID da Comunidade: ");
        int idComunidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Local: ");
        String local = scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();
        System.out.print("Banda Disponível (Mbps): ");
        double banda = Double.parseDouble(scanner.nextLine());
        PontoAcesso p = new PontoAcesso(0, idComunidade, local, status, banda);
        boolean ok = pontoAcessoDAO.inserir(p);
        System.out.println(ok ? "Ponto de Acesso cadastrado." : "Falha ao cadastrar.");
    }

    private static void listarPontosAcesso() {
        List<PontoAcesso> lista = pontoAcessoDAO.listarTodos();
        if (lista.isEmpty()) System.out.println("Nenhum registro.");
        for (PontoAcesso p : lista) {
            System.out.println(p.getId() + " | " + p.getIdComunidade() + " | " + p.getLocal() + " | " + p.getStatus() + " | " + p.getBandaDisponivel());
        }
    }

    private static void cadastrarEquipamentoPLC() {
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = scanner.nextLine();
        System.out.print("Capacidade (Mbps): ");
        int capacidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Em uso (true/false): ");
        boolean emUso = Boolean.parseBoolean(scanner.nextLine());
        EquipamentoPLC e = new EquipamentoPLC(0, modelo, fabricante, capacidade, emUso);
        boolean ok = equipamentoPLCDAO.inserir(e);
        System.out.println(ok ? "Equipamento cadastrado." : "Falha ao cadastrar.");
    }

    private static void listarEquipamentosPLC() {
        List<EquipamentoPLC> lista = equipamentoPLCDAO.listarTodos();
        if (lista.isEmpty()) System.out.println("Nenhum registro.");
        for (EquipamentoPLC e : lista) {
            System.out.println(e.getId() + " | " + e.getModelo() + " | " + e.getFabricante() + " | " + e.getCapacidadeMbps() + " | " + e.isEmUso());
        }
    }
}