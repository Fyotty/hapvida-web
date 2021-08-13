package br.com.hapvida.controller;

import br.com.hapvida.model.Tutor;
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
public class TutorController implements Serializable {

    private Tutor tutor;
    private Client client = new Client();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
    @PostConstruct
    private void init() {
        novo();
    }

    public List<Tutor> getTutores() {
        WebResource wr = client.resource("http://localhost:8082/api/tutores");
        try {
            String json = wr.get(String.class);
            return gson.fromJson(json, new TypeToken<List<Tutor>>() {
            }.getType());
        } catch (JsonSyntaxException | ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return null;
    }

    public void deletar(Tutor tutor) {
        try {
            WebResource wr = client.resource("http://localhost:8082/api/tutor/" + tutor.getId());
            wr.delete();
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    public void salvar() throws Exception {
        WebResource wr = client.resource("http://localhost:8082/api/tutor");
        try {
            wr.type("application/json")
                    .accept("application/json")
                    .post(gson.toJson(tutor));
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void modificar(ActionEvent evento) {
        tutor = (Tutor) evento.getComponent().getAttributes().get("tutorSelect");
    }

    public void novo() {
        tutor = new Tutor();
    }

    public void cadastrar() {
        novo();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

}
