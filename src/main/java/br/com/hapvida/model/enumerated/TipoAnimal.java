package br.com.hapvida.model.enumerated;

/**
 *
 * @author fernando
 */
public enum TipoAnimal {

    CACHORRO(0, "CACHORRO"), GATO(1, "GATO"), RAMISTER(2, "RAMISTER"), PEIXE(3, "PEIXE");

    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    private TipoAnimal(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

}
