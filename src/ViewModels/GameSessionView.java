/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Helpers.Enums;
import Models.GameObject;
import Models.GameSession;
import java.util.HashMap;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author tibor.wekerle
 */
public class GameSessionView extends HBox{
    private GridPane grid=new GridPane();
    private int fromAngel=0,toAngel = 0,height=0,width;
    private GameSession gameSession=null;
    private HashMap<GameObject,ImageView> gameObjectImageViewMap=new HashMap<GameObject,ImageView>();
    
    public GameSessionView(GameSession gameSession)
    {
        this.gameSession=gameSession;
        populateContent();
        
        grid.setFocusTraversable(true);
        grid.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event) 
            {
                Helpers.Enums.Direction direction=null;
                if (event.getCode() == KeyCode.DOWN) 
                {
                    direction=Enums.Direction.Le;
                }
                if (event.getCode() == KeyCode.UP) 
                {
                    direction=Enums.Direction.Fel;
                }
                if (event.getCode() == KeyCode.LEFT) 
                {
                    direction=Enums.Direction.Balra;
                }
                if (event.getCode() == KeyCode.RIGHT) 
                {
                    direction=Enums.Direction.Jobbra;
                }
                if(direction !=null)
                {
                    simulateNextStep(direction);                   
                }
            }
        });
    }   
    
    private void simulateNextStep(Helpers.Enums.Direction direction)
    {
        gameSession.getSzabi().destroyPath();
        Path path=gameSession.constrcutPath(direction);
        GameSessionView.this.simulateNextStepOnView(path);       
    }
    
    private void populateContent()
    {
        height=gameSession.getHeight();
        width=gameSession.getWidth();
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {                
                ImageView imageView = new ImageView();
                GameObject gameObject=gameSession.getGameObjectAt(i, j);
                
                if(gameObject!=null)
                {
                    imageView.setImage(gameSession.getGameObjectAt(i, j).getImage());                                       
                }
                grid.add(imageView,j,i);
                gameObjectImageViewMap.put(gameObject, imageView);
            }
        }
    
        this.getChildren().add(grid);       
    }
    
    private void simulateNextStepOnView(Path path)
    {
        GameObject szabi=gameSession.getSzabi();
        ImageView currentImageView=gameObjectImageViewMap.get(szabi);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000),currentImageView );
        
        
        
       // translateTransition.play();
        
       // Helpers.Enums.Irany oldIrany=irany;
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Helpers.Enums.Irany newIrany=GameSessionView.this.gameSession.getNewIrany(oldIrany);
                //if(newIrany!=null)
               // {
                    //GameSessionView.this.simulateNextStep(newIrany);
                //}
            }
        });
            
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(path);
        pathTransition.setNode(currentImageView);
        pathTransition.setCycleCount(1);
        pathTransition.play();
        
        
    }
}
