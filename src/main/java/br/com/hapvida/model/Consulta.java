package br.com.hapvida.model;

import br.com.hapvida.model.enumerated.StatusConsulta;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class Consulta {

    private Long id;

    private Date dataConsulta;

    private StatusConsulta status;

    private Animal idAnimal;

    private Veterinario idVeterinario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Animal getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Animal idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Veterinario getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Veterinario idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
