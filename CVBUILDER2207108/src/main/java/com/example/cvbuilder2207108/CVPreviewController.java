import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class CVPreviewController {

    @FXML private Label nameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label addressLabel;
    @FXML private TextFlow educationText;
    @FXML private TextFlow skillsText;
    @FXML private TextFlow experienceText;
    @FXML private TextFlow projectsText;

    public void setCVData(CVData cvData) {

        nameLabel.setText(cvData.getFullName());
        emailLabel.setText(cvData.getEmail());
        phoneLabel.setText(cvData.getPhone());
        addressLabel.setText(cvData.getAddress());


        educationText.getChildren().clear();
        educationText.getChildren().add(new Text(cvData.getEducation()));


        skillsText.getChildren().clear();
        skillsText.getChildren().add(new Text(cvData.getSkills()));


        experienceText.getChildren().clear();
        experienceText.getChildren().add(new Text(cvData.getExperience()));


        projectsText.getChildren().clear();
        projectsText.getChildren().add(new Text(cvData.getProjects()));
    }

    @FXML
    private void handleBackToHome() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stage = (Stage) nameLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}