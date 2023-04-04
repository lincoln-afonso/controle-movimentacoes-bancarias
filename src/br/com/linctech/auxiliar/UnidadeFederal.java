package br.com.linctech.auxiliar;

public enum UnidadeFederal {
    AC("ACRE"),
    AP("AMAPA"),
    AL("ALAGOAS"),
    AM("AMAZONAS"),
    BA("BAHIA"),
    CE("CEARA"),
    DF("DISTRITO FEDERAL"),
    ES("ESPIRITO SANTO"),
    GO("GOIAS"),
    MA("MARANHAO"),
    MT("MATO GROSSO"),
    MS("MATO GROSSO DO SUL"),
    MG("MINAS GERAIS"),
    PA("PARA"),
    PB("PARAIBA"),
    PR("PARANA"),
    PE("PERNAMBUCO"),
    PI("PIAUI"),
    RR("RORAIMA"),
    RO("RONDONIA"),
    RJ("RIO DE JANEIRO"),
    RN("RIO GRANDE DO NORTE"),
    RS("RIO GRANDE DO SUL"),
    SC("SANTA CATARINA"),
    SP("SAO PAULO"),
    SE("SERGIPE"),
    TO("TOCANTINS");

    private String descricao;

    UnidadeFederal(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}