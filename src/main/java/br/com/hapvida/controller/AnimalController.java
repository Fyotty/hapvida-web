package br.com.hapvida.controller;

import br.com.hapvida.model.Animal;
import br.com.hapvida.model.enumerated.TipoAnimal;
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
public class AnimalController implements Serializable {

    private Animal animal;
    private Client client = new Client();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private List<TipoAnimal> tipoAnimal;

    @PostConstruct
    private void init() {
        this.tipoAnimal = Arrays.asList(TipoAnimal.values());
        novo();
    }

    public List<Animal> getAnimais() {
        WebResource wr = client.resource("http://localhost:8082/api/animais");
        try {
            String json = wr.get(String.class);
            return gson.fromJson(json, new TypeToken<List<Animal>>() {
            }.getType());
        } catch (JsonSyntaxException | ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return null;
    }

    public void deletar(Animal animal) {
        try {
            WebResource wr = client.resource("http://localhost:8082/api/animal/" + animal.getId());
            wr.delete();
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    public void salvar() throws Exception {
        WebResource wr = client.resource("http://localhost:8082/api/animal");
        try {
            wr.type("application/json")
                    .accept("application/json")
                    .post(gson.toJson(animal));
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void modificar(ActionEvent evento) {
        animal = (Animal) evento.getComponent().getAttributes().get("animalSelect");
    }

    public void novo() {
        animal = new Animal();
    }

    public void cadastrar() {
        novo();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<TipoAnimal> getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(List<TipoAnimal> tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

}
