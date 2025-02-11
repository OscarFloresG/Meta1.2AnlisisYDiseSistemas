package org.example.intentocrud;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.*;

public class Main extends Application {
    private ListView<String> listaPersonas = new ListView<>();
    private Map<String, Integer> personaIdMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");

        TextField direccionField = new TextField();
        direccionField.setPromptText("Dirección");

        TextField telefonosField = new TextField();
        telefonosField.setPromptText("Teléfonos (separados por coma)");

        ComboBox<String> comboVehiculos = new ComboBox<>();
        comboVehiculos.getItems().addAll("Automóvil", "Camión de carga", "Vehículo marítimo", "Motocicleta", "Bicicleta");
        comboVehiculos.setPromptText("Selecciona un tipo de vehículo");

        Button agregarVehiculoBtn = new Button("Añadir Vehículo");

        ListView<String> listaVehiculos = new ListView<>();
        listaVehiculos.setPrefHeight(100);

        Button agregarBtn = new Button("Agregar Persona");
        Button actualizarBtn = new Button("Actualizar Persona");
        Button eliminarBtn = new Button("Eliminar Persona");

        actualizarLista();

        agregarVehiculoBtn.setOnAction(e -> {
            String vehiculoSeleccionado = comboVehiculos.getValue();
            if (vehiculoSeleccionado != null && !listaVehiculos.getItems().contains(vehiculoSeleccionado)) {
                listaVehiculos.getItems().add(vehiculoSeleccionado);
            }
        });

        agregarBtn.setOnAction(e -> {
            try {
                String nombre = nombreField.getText();
                String direccion = direccionField.getText();
                List<String> telefonos = Arrays.asList(telefonosField.getText().split(","));

                List<Vehiculo> vehiculos = new ArrayList<>();
                for (String vehiculoTipo : listaVehiculos.getItems()) {
                    vehiculos.add(new Vehiculo(0, 0, vehiculoTipo, ""));
                }

                PersonaDAO.insertarPersona(nombre, direccion, telefonos, vehiculos);

                listaVehiculos.getItems().clear();

                actualizarLista();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        actualizarBtn.setOnAction(e -> {
            try {
                String selectedPersona = listaPersonas.getSelectionModel().getSelectedItem();
                if (selectedPersona != null) {
                    int idPersona = personaIdMap.get(selectedPersona.split(" - ")[0]);
                    String nombre = nombreField.getText();
                    String direccion = direccionField.getText();
                    List<String> telefonos = Arrays.asList(telefonosField.getText().split(","));

                    List<Vehiculo> vehiculos = new ArrayList<>();
                    for (String vehiculoTipo : listaVehiculos.getItems()) {
                        vehiculos.add(new Vehiculo(0, 0, vehiculoTipo, ""));
                    }

                    PersonaDAO.actualizarPersona(idPersona, nombre, direccion, telefonos, vehiculos);
                    actualizarLista();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        eliminarBtn.setOnAction(e -> {
            try {
                String selectedPersona = listaPersonas.getSelectionModel().getSelectedItem();
                if (selectedPersona != null) {
                    int idPersona = personaIdMap.get(selectedPersona.split(" - ")[0]);
                    PersonaDAO.eliminarPersona(idPersona);
                    actualizarLista();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().addAll(nombreField, direccionField, telefonosField, comboVehiculos, agregarVehiculoBtn, listaVehiculos, agregarBtn, actualizarBtn, eliminarBtn, listaPersonas);

        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("Gestión de Personas y Vehículos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void actualizarLista() {
        try {
            List<Persona> personas = PersonaDAO.obtenerPersonas();
            listaPersonas.getItems().clear();
            personaIdMap.clear();

            for (Persona persona : personas) {
                String info = persona.getNombre() + " - " + persona.getDireccion() + " - " + String.join(", ", persona.getTelefonos());

                List<String> vehiculosInfo = new ArrayList<>();
                for (Vehiculo vehiculo : persona.getVehiculos()) {
                    vehiculosInfo.add(vehiculo.getTipo());
                }
                if (!vehiculosInfo.isEmpty()) {
                    info += " | Vehículos: " + String.join(", ", vehiculosInfo);
                }

                listaPersonas.getItems().add(info);
                personaIdMap.put(persona.getNombre(), persona.getId());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
