/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Listener.LevelSelectedEventListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
public class FinishLevelView extends HBox {
    private VBox contentNode=new VBox();
    private LevelSelectedEventListener levelSelectedEvent=null;
    public void setLevelSelectedEventListener(LevelSelectedEventListener levelSelectedEvent) 
    {
        this.levelSelectedEvent = levelSelectedEvent;
    }
    
    public FinishLevelView(int previousLevelNr)
    {
        if(previousLevelNr<6)
        {
            ImageView imageView=new ImageView(getImageByLevelNumber(previousLevelNr));
            contentNode.getChildren().add(imageView);
        }
       
        Image imageNext=new Image("/img/next.png");
        Button buttonNext=new Button("Next Level", new ImageView(imageNext));
        
        buttonNext.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event) {
                levelSelectedEvent.levelSelected(previousLevelNr+1);
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
        footerNode.getChildren().add(buttonRestart);
        footerNode.getChildren().add(buttonNext);
        footerNode.setAlignment(Pos.CENTER);
        footerNode.setSpacing(20);
        
        contentNode.getChildren().add(footerNode);
        
        this.getChildren().add(contentNode);
        this.setAlignment(Pos.CENTER);
    }
    
    private Image getImageByLevelNumber(int previousLevelNumber)
    {
        Image image=null;
        switch(previousLevelNumber)
        {
            case 1:
                image= new Image("/img/1.png");
                break;
            case 2:
                image= new Image("/img/2.png");
                break;
            case 3:
                image= new Image("/img/3.png");
                break;
            case 4:
                image= new Image("/img/4.png");
                break;
            case 5:
                image= new Image("/img/5.png");
                break;
            case 6:
                image= new Image("/img/6.png");
                break;
            case 7:
                image= new Image("/img/7.png");
                break;
            case 8:
                image= new Image("/img/8.png");
                break;
            case 9:
                image= new Image("/img/9.png");
                break;
            case 10:
                image= new Image("/img/10.png");
                break;
        }
        
        return image;
    }
}
