package br.com.hapvida.model.enumerated;

/**
 *
 * @author fernando
 */
public enum StatusConsulta {

    AGENDADA(0, "AGENDADA"), CANCELADA(1, "CANCELADA"), EMATENDIMENTO(2, "EM ATENDIMENTO"), FINALIZADA(3, "FINALIZADA");

    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    private StatusConsulta(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

}
