/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Models.GameObject;
import Models.GameSession;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private VBox vbox=new VBox();
    private int fromAngel=0,toAngel = 0,height=0,width;
    private GameSession gameSession=null;
    private HashMap<GameObject,ImageView> gameObjectImageViewMap=new HashMap<GameObject,ImageView>();
    
    public GameSessionView(GameSession gameSession)
    {
        this.gameSession=gameSession;
       // this.originalGameSession=(GameSession)gameSession.clone();
        populateContent();
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
        
        Image imageRestart=new Image("/img/restart.png");
        Button buttonRestart=new Button();
        buttonRestart.setGraphic(new ImageView(imageRestart));
        
        buttonRestart.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                grid.getChildren().clear(); 
                vbox.getChildren().clear(); 
                GameSessionView.this.getChildren().clear();
                populateContent();
            }
            
        });
       
        vbox.getChildren().add(grid);
        vbox.setAlignment(Pos.CENTER);
        
        Text text=new Text("Nivelul: "+ gameSession.getLevelNumber());
        text.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,32));
        
        VBox leftVB= new VBox();
        leftVB.getChildren().add(text);       
        leftVB.getChildren().add(buttonRestart);
        leftVB.setAlignment(Pos.TOP_LEFT); 
        leftVB.setPadding(new Insets(25, 75, 50, 25));
        leftVB.setSpacing(20);
        
        this.getChildren().add(leftVB);       
        this.getChildren().add(vbox);              
    }
}
