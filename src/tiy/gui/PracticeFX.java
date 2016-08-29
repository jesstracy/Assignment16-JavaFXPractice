package tiy.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by jessicatracy on 8/29/16.
 */
public class PracticeFX extends Application {
    private final double DEFAULT_WIDTH = 600;
    private final double DEFAULT_HEIGHT = 800;

    public void start(Stage primaryStage) {
        Group rootGroup = new Group();

        Canvas canvas = new Canvas(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        canvas.setFocusTraversable(true);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setLineWidth(2);

        graphicsContext.strokeText("Type the letters A through H", 50, 50);

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                graphicsContext.clearRect(event.getX(), event.getY(), 25, 25);
//                graphicsContext.clearRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                graphicsContext.strokeRoundRect(event.getX(), event.getY(), 15, 15, 5, 5);
            }
        });

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getText().equalsIgnoreCase("A")) {
                    graphicsContext.setFill(Color.BISQUE);
                    graphicsContext.fillOval(200, 100, 80, 100);
                }

                if (event.getText().equalsIgnoreCase("B")) {
                    graphicsContext.setFill(Color.BLACK);
                    graphicsContext.fillOval(225, 140, 8, 8);
                    graphicsContext.fillOval(245, 140, 8, 8);
                }

                if (event.getText().equalsIgnoreCase("C")) {
                    graphicsContext.setFill(Color.RED);
//                    graphicsContext.fillArc(230, 164, 30, 20, 30, 240, ArcType.OPEN);
                    graphicsContext.fillRect(230, 164, 20, 5);
                }

                if (event.getText().equalsIgnoreCase("D")) {
                    graphicsContext.setLineWidth(8);
                    graphicsContext.strokeLine(210, 120, 310, 120);
                }

                if (event.getText().equalsIgnoreCase("E")) {
                    graphicsContext.setFill(Color.BLUE);
                    graphicsContext.fillArc(204, 90, 72, 55, 0, 180, ArcType.CHORD);
                }

                // body
                if (event.getText().equalsIgnoreCase("F")) {
                    graphicsContext.strokeLine(240, 205, 240, 400);
                }

                // legs
                if (event.getText().equalsIgnoreCase("G")) {
                    graphicsContext.strokeLine(240, 400, 290, 500);
                    graphicsContext.strokeLine(240, 400, 190, 500);
                }

                // arms
                if (event.getText().equalsIgnoreCase("H")) {
                    graphicsContext.strokeLine(240, 265, 290, 350);
                    graphicsContext.strokeLine(240, 265, 190, 350);
                }
            }
        });


        rootGroup.getChildren().add(canvas);
        Scene scene = new Scene(rootGroup, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
