package br.com.hapvida.controller;

import br.com.hapvida.model.Veterinario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
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
public class VeterinarioController implements Serializable {

    private Veterinario veterinario;
    private Client client = new Client();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @PostConstruct
    private void init() {
        novo();
    }

    public List<Veterinario> getVeterinarios() {
        WebResource wr = client.resource("http://localhost:8082/api/veterinarios");
        try {
            String json = wr.get(String.class);
            return gson.fromJson(json, new TypeToken<List<Veterinario>>() {
            }.getType());
        } catch (JsonSyntaxException | ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return null;
    }

    public void deletar(Veterinario veterinario) {
        try {
            WebResource wr = client.resource("http://localhost:8082/api/veterinario/" + veterinario.getId());
            wr.delete();
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    public void salvar() throws Exception {
        WebResource wr = client.resource("http://localhost:8082/api/veterinario");
        try {
            wr.type("application/json")
                    .accept("application/json")
                    .post(gson.toJson(veterinario));
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void modificar(ActionEvent evento) {
        veterinario = (Veterinario) evento.getComponent().getAttributes().get("veterinarioSelect");
    }

    public void novo() {
        veterinario = new Veterinario();
    }

    public void cadastrar() {
        novo();
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

}
