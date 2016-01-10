package pl.pwr.edu.view.main;


import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class MultipleTextArea {

    private Label leftName;
    private Label rightName;
    private TextArea left;
    private TextArea right;

    private HBox multipleTextArea;
    private VBox leftBox;
    private VBox rightBox;

    public MultipleTextArea(String leftName, String rightName) {
        this.leftName = new Label(leftName);
        this.rightName = new Label(rightName);
        left = new TextArea();
        right = new TextArea();
        multipleTextArea = new HBox(10);
        leftBox = new VBox(1);
        rightBox = new VBox(1);
    }

    public void initMultipleTextArea() {
        left.setPrefSize(150, 180);
        left.setEditable(false);
        leftBox.getChildren().addAll(leftName, left);

        right.setPrefSize(150, 180);
        right.setEditable(false);
        rightBox.getChildren().addAll(rightName, right);

        multipleTextArea.getChildren().addAll(leftBox, rightBox);
    }

    public Label getLeftName() {
        return leftName;
    }

    public Label getRightName() {
        return rightName;
    }

    public TextArea getLeft() {
        return left;
    }

    public TextArea getRight() {
        return right;
    }

    public HBox getMultipleTextArea() {
        return multipleTextArea;
    }

    public VBox getLeftBox() {
        return leftBox;
    }

    public VBox getRightBox() {
        return rightBox;
    }

    public void setLeftText(String leftText) { left.setText(leftText); }

    public void setRightText(String rightText) { right.setText(rightText); }
}
