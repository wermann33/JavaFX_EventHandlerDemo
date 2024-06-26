package net.wermann.eventhandlingdemowithkeyevent;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.wermann.eventhandlingdemowithkeyevent.presentationModels.EventHandlingModel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class EventHandlingController extends AbstractController {

    private EventHandlingModel model;
    @FXML
    CheckBox check;
    @FXML
    Button button;
    @FXML
    TextField txt;
    @FXML
    ListView<String> lst;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        model = new EventHandlingModel();

        lst.setItems(model.getPersons());

        applyBindings();
    }

    private void applyBindings() {
        check.selectedProperty().bindBidirectional(model.checkProperty());
        button.disableProperty().bind(model.disableBinding());
        //txt.textProperty().addListener((s) -> onTxtChanged());
        txt.setOnKeyReleased(this::onTxtChanged);
    }

    private void onTxtChanged(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            ObservableList<String> models = model.getPersons();
            models.add(txt.getText());
            txt.clear();;
        }
    }

    @FXML
    public void onButton() {
        Alert dialog = new Alert(Alert.AlertType.NONE, "Called from a event handler", ButtonType.OK);
        dialog.setTitle("Hello world!");
        dialog.showAndWait();
    }

//    @FXML
//    public void onTxtChanged() {
//        ObservableList<String> models = model.getPersons();
//        models.add(txt.getText());
//    }
}
