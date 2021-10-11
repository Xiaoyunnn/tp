package seedu.address.ui;

import java.util.Comparator;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.model.lesson.Lesson;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;
    private LessonListPanel lessonListPanel;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label parentPhone;
    @FXML
    private Label parentEmail;
    @FXML
    private Label address;
    @FXML
    private Label outstandingFee;
    @FXML
    private Label school;
    @FXML
    private Label acadStream;
    @FXML
    private Label remark;
    @FXML
    private FlowPane tags;
    @FXML
    private StackPane lessonListPanelPlaceholder;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        address.setText("Address: " + person.getAddress().value);

        if (person.getPhone().isEmpty()) {
            phone.setManaged(false);
        } else {
            phone.setText("Phone: " + person.getPhone().value);
        }

        if (person.getEmail().isEmpty()) {
            email.setManaged(false);
        } else {
            email.setText("Email: " + person.getEmail().value);
        }

        if (person.getParentPhone().isEmpty()) {
            parentPhone.setManaged(false);
        } else {
            parentPhone.setText("Parent Phone: " + person.getParentPhone().value);
        }

        if (person.getParentEmail().isEmpty()) {
            parentEmail.setManaged(false);
        } else {
            parentEmail.setText("Parent Email: " + person.getParentEmail().value);
        }

        if (person.getSchool().isEmpty()) {
            school.setManaged(false);
        } else {
            school.setText("School: " + person.getSchool().value);
        }

        if (person.getAcadStream().isEmpty()) {
            acadStream.setManaged(false);
        } else {
            acadStream.setText("Academic Stream: " + person.getAcadStream().value);
        }

        if (person.getRemark().isEmpty()) {
            remark.setManaged(false);
        } else {
            remark.setText("Remark: " + person.getRemark().value);
        }

        if (person.getFee().isEmpty()) {
            outstandingFee.setManaged(false);
        } else {
            outstandingFee.setText("Outstanding Fees: $" + person.getFee().value);
        }

        if (person.getTags().isEmpty()) {
            tags.setManaged(false);
        } else {
            person.getTags().stream()
                    .sorted(Comparator.comparing(tag -> tag.tagName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        }

        if (person.getLessons().isEmpty()) {
            lessonListPanelPlaceholder.setManaged(false);
        } else {
            lessonListPanel = new LessonListPanel(getObservableListLessons(person.getLessons()));
            lessonListPanelPlaceholder.getChildren().add(lessonListPanel.getRoot());
        }
    }

    private ObservableList<Lesson> getObservableListLessons(Set<Lesson> lessonSet) {
        ObservableList<Lesson> lessonObservableList = FXCollections.observableArrayList();
        lessonSet.forEach(lesson -> lessonObservableList.add(lesson));
        return lessonObservableList;
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
