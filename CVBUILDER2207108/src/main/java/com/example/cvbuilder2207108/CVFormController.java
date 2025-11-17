import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class CVFormController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;
    @FXML private TextArea educationArea;
    @FXML private TextArea skillsArea;
    @FXML private TextArea experienceArea;
    @FXML private TextArea projectsArea;

    @FXML
    private void handleGenerateCV() {

        if (nameField.getText().isEmpty() || emailField.getText().isEmpty()) {
            showAlert("Error", "Please fill in at least Name and Email fields.");
            return;
        }

        try {

            CVData cvData = new CVData();
            cvData.setFullName(nameField.getText());
            cvData.setEmail(emailField.getText());
            cvData.setPhone(phoneField.getText());
            cvData.setAddress(addressField.getText());
            cvData.setEducation(educationArea.getText());
            cvData.setSkills(skillsArea.getText());
            cvData.setExperience(experienceArea.getText());
            cvData.setProjects(projectsArea.getText());


            FXMLLoader loader = new FXMLLoader(getClass().getResource("cv_preview.fxml"));
            Parent root = loader.load();

            CVPreviewController previewController = loader.getController();
            previewController.setCVData(cvData);

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not generate CV preview.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}