import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeController {

    @FXML
    private Button createCVButton;

    @FXML
    private void handleCreateCV() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("cv_form.fxml"));
            Stage stage = (Stage) createCVButton.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}