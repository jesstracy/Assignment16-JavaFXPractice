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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * Created by jessicatracy on 8/30/16.
 */
public class PracticeFX2 extends Application {
    private final double DEFAULT_WIDTH = 600;
    private final double DEFAULT_HEIGHT = 800;
    private double rectangleWidth = 15;
    private double rectangleHeight = 15;
    private boolean rectangleFlag = true;

    public void start(Stage primaryStage) {
        Group rootGroup = new Group();

        Canvas canvas = new Canvas(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        canvas.setFocusTraversable(true);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setLineWidth(2);

        graphicsContext.strokeText("Press space bar", 30, 30);

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                graphicsContext.clearRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                graphicsContext.setFill(Color.RED);
                graphicsContext.fillOval(event.getX(), event.getY(), 30, 30);
                graphicsContext.setFill(Color.ORANGE);
                graphicsContext.fillOval(event.getX() + 8, event.getY() + 8, 25, 25);
                graphicsContext.setFill(Color.YELLOW);
                graphicsContext.fillOval(event.getX() + 16, event.getY() + 16, 20, 20);
                graphicsContext.setFill(Color.GREEN);
                graphicsContext.fillOval(event.getX() + 24, event.getY() + 24, 15, 15);
                graphicsContext.setFill(Color.BLUE);
                graphicsContext.fillOval(event.getX() + 32, event.getY() + 32, 10, 10);
                graphicsContext.setFill(Color.PURPLE);
                graphicsContext.fillOval(event.getX() + 40, event.getY() + 40, 5, 5);
                graphicsContext.strokeText("Press space bar", 30, 30);
            }
        });

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
//                try {
                    if (event.getText().equalsIgnoreCase(" ")) ;
                        while (rectangleFlag) {
                            graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                            graphicsContext.strokeRoundRect(300, 400, rectangleWidth, rectangleHeight, 20, 20);
                            graphicsContext.rotate(10);
                            rectangleWidth += 1;
                            rectangleHeight += 1;
                            if (rectangleWidth > 300) {
                                rectangleFlag = false;
                            }
//                        Thread.sleep(200);
                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
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
