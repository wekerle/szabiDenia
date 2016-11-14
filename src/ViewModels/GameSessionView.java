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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
                Helpers.Enums.Irany irany=null;
                if (event.getCode() == KeyCode.DOWN) 
                {
                    irany=Enums.Irany.Le;
                }
                if (event.getCode() == KeyCode.UP) 
                {
                    irany=Enums.Irany.Fel;
                }
                if (event.getCode() == KeyCode.LEFT) 
                {
                    irany=Enums.Irany.Balra;
                }
                if (event.getCode() == KeyCode.RIGHT) 
                {
                    irany=Enums.Irany.Jobbra;
                }
                if(irany !=null)
                {
                    simulateNextStep(irany);                   
                }
            }
        });
    }   
    
    private void simulateNextStep(Helpers.Enums.Irany irany)
    {
        int numberOfStepsI=gameSession.getNumberOfStepsI(irany);
        int numberOfStepsJ=gameSession.getNumberOfStepsJ(irany);

        gameSession.simulateNextStepOnSession(numberOfStepsI,numberOfStepsJ,irany);
        GameSessionView.this.simulateNextStepOnView(numberOfStepsI,numberOfStepsJ,irany);
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
    
    private void simulateNextStepOnView(int numberOfStepsI,int numberOfStepsJ,Helpers.Enums.Irany irany)
    {
        GameObject szabi=gameSession.getSzabi();
        ImageView currentImageView=gameObjectImageViewMap.get(szabi);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000),currentImageView );
        
        if(numberOfStepsJ !=0 && (irany==Enums.Irany.Balra || irany==Enums.Irany.Jobbra))
        {
            szabi.setToX(szabi.getFromX()+numberOfStepsJ*50);
            translateTransition.setFromX(szabi.getFromX());
            translateTransition.setToX(szabi.getToX());
            szabi.setFromX(szabi.getToX());

            szabi.setCurrentJ(szabi.getCurrentJ()+numberOfStepsJ);
        }else if(numberOfStepsI !=0 && (irany==Enums.Irany.Fel || irany==Enums.Irany.Le))
        {
            szabi.setToY(szabi.getFromY()+numberOfStepsI*50);
            translateTransition.setFromY(szabi.getFromY());
            translateTransition.setToY(szabi.getToY());
            szabi.setFromY(szabi.getToY());

            szabi.setCurrentI(szabi.getCurrentI()+numberOfStepsI);
        }
        
        translateTransition.play();
        
        Helpers.Enums.Irany oldIrany=irany;
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Helpers.Enums.Irany newIrany=GameSessionView.this.gameSession.getNewIrany(oldIrany);
                if(newIrany!=null)
                {
                    GameSessionView.this.simulateNextStep(newIrany);
                }
            }
        });

    }
}
