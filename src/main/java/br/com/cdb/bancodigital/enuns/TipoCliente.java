package br.com.cdb.bancodigital.enuns;

public enum TipoCliente {
    COMUM(12.0),
    SUPER(8.0),
    PREMIUM(0.0);

    private double taxaManutencao;

    TipoCliente(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }
}

