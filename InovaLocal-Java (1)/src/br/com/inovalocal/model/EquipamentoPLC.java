package br.com.inovalocal.model;

public class EquipamentoPLC {
    private int id;
    private String modelo;
    private String fabricante;
    private int capacidadeMbps;
    private boolean emUso;

    public EquipamentoPLC() {}

    public EquipamentoPLC(int id, String modelo, String fabricante, int capacidadeMbps, boolean emUso) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidadeMbps = capacidadeMbps;
        this.emUso = emUso;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public int getCapacidadeMbps() { return capacidadeMbps; }
    public void setCapacidadeMbps(int capacidadeMbps) { this.capacidadeMbps = capacidadeMbps; }

    public boolean isEmUso() { return emUso; }
    public void setEmUso(boolean emUso) { this.emUso = emUso; }
}