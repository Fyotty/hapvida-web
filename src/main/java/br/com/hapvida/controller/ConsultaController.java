package br.com.hapvida.controller;

import br.com.hapvida.model.Consulta;
import br.com.hapvida.model.enumerated.StatusConsulta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author fernando
 */
@Named
@ViewScoped
public class ConsultaController implements Serializable {

    private Consulta consulta;
    private Client client = new Client();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private List<StatusConsulta> status;

    @PostConstruct
    private void init() {
        this.status = Arrays.asList(StatusConsulta.values());
        novo();
    }

    public List<Consulta> getConsultas() {
        WebResource wr = client.resource("http://localhost:8082/api/consultas");
        try {
            String json = wr.get(String.class);
            return gson.fromJson(json, new TypeToken<List<Consulta>>() {
            }.getType());
        } catch (JsonSyntaxException | ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return null;
    }

    public void deletar(Consulta consulta) {
        try {
            WebResource wr = client.resource("http://localhost:8082/api/consulta/" + consulta.getId());
            wr.delete();
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    public void salvar() throws Exception {
        WebResource wr = client.resource("http://localhost:8082/api/consulta");
        try {
            wr.type("application/json")
                    .accept("application/json")
                    .post(gson.toJson(consulta));
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void modificar(ActionEvent evento) {
        consulta = (Consulta) evento.getComponent().getAttributes().get("consultaSelect");
    }

    public void novo() {
        consulta = new Consulta();
    }

    public void cadastrar() {
        novo();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<StatusConsulta> getStatus() {
        return status;
    }

    public void setStatus(List<StatusConsulta> status) {
        this.status = status;
    }

}
