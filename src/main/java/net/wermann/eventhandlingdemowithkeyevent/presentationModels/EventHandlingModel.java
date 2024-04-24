package net.wermann.eventhandlingdemowithkeyevent.presentationModels;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EventHandlingModel {

    private BooleanProperty check = new SimpleBooleanProperty(false);
    private BooleanBinding disable = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return !check.get();
        }
    };

    public EventHandlingModel() {
        check.addListener((observable, oldValue, newValue) -> disable.invalidate());
    }

    public BooleanProperty checkProperty() {
        return check;
    }

    public BooleanBinding disableBinding() {
        return disable;
    }

    private ObservableList<String> persons = FXCollections
            .observableArrayList("Maria", "Peter");

    public ObservableList<String> getPersons() {
        return persons;
    }
}
