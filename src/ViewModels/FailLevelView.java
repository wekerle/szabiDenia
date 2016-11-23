/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Listener.LevelSelectedEventListener;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Ronaldo
 */
public class FailLevelView extends HBox {
    private VBox contentNode=new VBox();
    private LevelSelectedEventListener levelSelectedEvent=null;
    public void setLevelSelectedEventListener(LevelSelectedEventListener levelSelectedEvent) 
    {
        this.levelSelectedEvent = levelSelectedEvent;
    }
    
    public FailLevelView(int previousLevelNr)
    {
        ImageView imageView=new ImageView(new Image("/img/breakHeart.png"));
        contentNode.getChildren().add(imageView);
        
        Image imageHome=new Image("/img/home.png");
        Button buttonHome=new Button("Home", new ImageView(imageHome));  
        
        buttonHome.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event) {
                levelSelectedEvent.levelSelected(0);
            }
        });
        
        Image imageRestart=new Image("/img/restart.png");
        Button buttonRestart=new Button("Restart Level", new ImageView(imageRestart));  
        
        buttonRestart.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event) {
                levelSelectedEvent.levelSelected(previousLevelNr);
            }
        });
        
        HBox footerNode=new HBox();
        footerNode.getChildren().add(buttonHome);
        footerNode.getChildren().add(buttonRestart);
        footerNode.setAlignment(Pos.CENTER);
        footerNode.setSpacing(20);
        
        contentNode.getChildren().add(footerNode);
        
        this.getChildren().add(contentNode);
        this.setAlignment(Pos.CENTER);
    }
}
