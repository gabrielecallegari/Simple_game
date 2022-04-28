package com.example.sample_game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    ImageView iw=new ImageView();
    SpostaImg image1,image2;
    Random random=new Random();
    ImageView iw2=new ImageView();
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                System.exit(0);
            }
        });
        image1=new SpostaImg((int)primaryStage.getHeight(),(int)primaryStage.getWidth());
        image2=new SpostaImg((int)primaryStage.getHeight(),(int)primaryStage.getWidth());

        Timer t=startTimer();
        Image img=new Image("pirata.jpg");
        iw=new ImageView(img);
        iw.setFitHeight(50);
        iw.setFitWidth(30);
        Image img2=new Image("poliziotto.jpg");
        iw2=new ImageView(img2);
        iw2.setFitHeight(50);
        iw2.setFitWidth(30);
        image2.setY(50);
        root.getChildren().add(iw);
        root.getChildren().add(iw2);
    }
    private Timer startTimer(){
        Timer timer=new Timer("giacomo");
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    int result=random.nextInt(4);
                    switch(result){
                        case 0:
                            image1.top();
                            iw.setY(image1.getY());
                            break;

                        case 1:
                            image1.bottom();
                            iw.setY(image1.getY());
                            break;

                        case 2:
                            image1.left();
                            iw.setX(image1.getX());
                            break;

                        case 3:
                            image1.right();
                            iw.setX(image1.getX());
                            break;
                    }
                    result= random.nextInt(3);
                    switch(result){
                        case 0:
                            image2.top();
                            iw2.setY(image2.getY());
                            break;

                        case 1:
                            image2.bottom();
                            iw2.setY(image2.getY());
                            break;

                        case 2:
                            image2.left();
                            iw2.setX(image2.getX());
                            break;

                        case 3:
                            image2.right();
                            iw2.setX(image2.getX());
                            break;
                    }
                });

            }
        };
        long delay=0;
        long period=1000;
        timer.schedule(task,delay,period);
        return timer;
    }


    public static void main(String[] args) {
        launch();
    }
}