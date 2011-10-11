package effects;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginScreen extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Group root = new Group();
		Scene scene = new Scene(root, 200, 100, Color.WHITE);
		primaryStage.setScene(scene);

		final StackPane sp1 = new StackPane();
		sp1.setPrefSize(200, 100);

		final FlowPane fp1 = new FlowPane(Orientation.VERTICAL, 5, 5);
		sp1.getChildren().add(fp1);
		fp1.getChildren().add(new Label(""));
		final TextField textField = new TextField();
		textField.setPromptText("Enter user");
		addFocusEffet(textField);
		fp1.getChildren().add(textField);
		final PasswordField pwdField = new PasswordField();
		addFocusEffet(pwdField);
		pwdField.setPromptText("Enter password");
		fp1.getChildren().add(pwdField);
		final Button b1 = new Button("Log in");
		fp1.getChildren().add(b1);

//		final Button b2 = new Button("Button Two");
//		final Button b3 = new Button("Button Three");
//		final Button b4 = new Button("Button Four");
//		final Button b5 = new Button("Button Five");
	    
		b1.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override public void handle(ActionEvent e) {
				new Vibrate(pwdField, Orientation.HORIZONTAL).play();
	    		pwdField.clear();
	    	}
	    });
	    

		root.getChildren().add(sp1);

		primaryStage.setResizable(false);
		b1.requestFocus();
		primaryStage.show();

	}

	private void addMouseOverEffet(final Node target) {
		target.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						new Beat(target).play();
						// new Blur(target).play();
					}
				});
		target.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						new Beat(target).playReversed();
						// new Blur(target).playReversed();
					}
				});

	}

	private void addFocusEffet(final Node target) {
		target.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				if (arg0.getValue()) {
					new Beat(target).play();
				} else {
					new Beat(target).playReversed();
				}
			}
		});

	}

}
