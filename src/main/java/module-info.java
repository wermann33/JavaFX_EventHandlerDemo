module net.wermann.eventhandlingdemowithkeyevent {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.wermann.eventhandlingdemowithkeyevent to javafx.fxml;
    exports net.wermann.eventhandlingdemowithkeyevent;
}