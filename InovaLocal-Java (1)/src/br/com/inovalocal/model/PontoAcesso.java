package br.com.inovalocal.model;

public class PontoAcesso {
    private int id;
    private int idComunidade;
    private String local;
    private String status;
    private double bandaDisponivel;

    public PontoAcesso() {}

    public PontoAcesso(int id, int idComunidade, String local, String status, double bandaDisponivel) {
        this.id = id;
        this.idComunidade = idComunidade;
        this.local = local;
        this.status = status;
        this.bandaDisponivel = bandaDisponivel;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdComunidade() { return idComunidade; }
    public void setIdComunidade(int idComunidade) { this.idComunidade = idComunidade; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getBandaDisponivel() { return bandaDisponivel; }
    public void setBandaDisponivel(double bandaDisponivel) { this.bandaDisponivel = bandaDisponivel; }
}