/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Helpers.Enums;
import Listener.HeartColoringListener;
import Models.BigHeart;
import Models.GameObject;
import Models.GameSession;
import Models.Heart;
import Models.PaintBucket;
import Models.Szabi;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author tibor.wekerle
 */
public class GameSessionView extends HBox implements HeartColoringListener{
    private GridPane grid=new GridPane();
    private int fromAngel=0,toAngel = 0,height=0,width;
    private GameSession gameSession=null;
    private HashMap<GameObject,ImageView> gameObjectImageViewMap=new HashMap<GameObject,ImageView>();
    private HashMap<ImageView,GameObject> imageViewGameObjectMap=new HashMap<ImageView,GameObject>();
    private ArrayList<ImageView> imageViewHearts=new ArrayList<ImageView>();
    private ArrayList<ImageView> imageViewPaintBuckets=new ArrayList<ImageView>();
    private ArrayList<ImageView> imageViewBigHearts=new ArrayList<ImageView>();
        
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
                
                if(gameObject instanceof PaintBucket)
                {
                    imageViewPaintBuckets.add(imageView);
                }
                
                if(gameObject instanceof Heart)
                {
                    imageViewHearts.add(imageView);
                }
                
                if(gameObject instanceof BigHeart)
                {
                    imageViewBigHearts.add(imageView);
                }
                
                grid.add(imageView,j,i);
                gameObjectImageViewMap.put(gameObject, imageView);
                imageViewGameObjectMap.put(imageView,gameObject);
            }
        }
    
        this.getChildren().add(grid);       
    }
    
    private void simulateNextStepOnView(Path path)
    {
        GameObject szabi=gameSession.getSzabi();
        ImageView szabiImageView=gameObjectImageViewMap.get(szabi);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000),szabiImageView );
        
        
        
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
        pathTransition.setNode(szabiImageView);
        pathTransition.setCycleCount(1);
        pathTransition.play();
        
        
        
        szabiImageView.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable,
                    Bounds oldValue, Bounds newValue) {
                
                    Bounds boundsInParent = szabiImageView.getBoundsInParent();
                    Bounds actualBounds = new BoundingBox(boundsInParent.getMinX()+1, boundsInParent.getMinY()+1,
                    boundsInParent.getWidth()-2, boundsInParent.getHeight()-2);
                
                    for(ImageView imageView:imageViewPaintBuckets)
                    {
                        if(actualBounds.intersects(imageView.getBoundsInParent()))
                        {
                            ((Szabi)szabi).setColor(((PaintBucket)imageViewGameObjectMap.get(imageView)).getColor());
                        }
                    }
                    for(ImageView imageView:imageViewHearts)
                    {
                        if(actualBounds.intersects(imageView.getBoundsInParent()))
                        {
                            Heart heart=(Heart)imageViewGameObjectMap.get(imageView);
                           
                            if(!heart.isColored() && ((Szabi)szabi).getColor()==heart.getColor())
                            {
                                heart.setColored(true);
                                imageView.setImage(heart.getColoredImage());
                            }
                        }
                    }
                    for(ImageView imageView:imageViewBigHearts)
                    {
                        if(actualBounds.intersects(imageView.getBoundsInParent()))
                        {
                            System.out.println("nagySziv");
                        }
                    }
            }
        });
        
        
    }
     
    @Override
    public void heartColoring(Heart heart) {
        ImageView currentImageView=gameObjectImageViewMap.get(heart);
        currentImageView.setImage(new Image("/img/letraKicsi.png"));
    }
}
