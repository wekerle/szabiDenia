package Models;

import Helpers.Enums;
import java.util.ArrayList;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ronaldo
 */
public class GameSession 
{
    private GameObject[][] objects=null;
    private int levelNumber;
    private boolean lose=false;
    private SzabiDenia szabi=null;
        
    public int getLevelNumber() 
    {
        return levelNumber;
    }
    
    public GameSession(LevelModel level)
    {
        this.levelNumber=level.getLevelNumber();
        String[][] matrix=level.getMatrix();
        int height=matrix.length;
        int width=matrix[0].length;
        objects=new GameObject[height][width];
                
        int i=0,j=0;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                //ww -fal       
                //wb -felfal fentball
                //wd -felfal fentjobb
                //wp -felfal lentball
                //wq -felfal lentjobb
                //"  " -levego
                //sz -szabi
                //de -denia

                //fp -festekVederPiros
                //fz -festekVederZold
                //fk -festekVederKek
                //fl -festekVederLila
                //ff -festekVederFekete

                //ps -pirosSziv
                //zs -zoldSziv
                //ks -kekSziv
                //ls -lilaSziv
                //fs -feketeSziv

                //ns -nagySziv
                //la -lajtorja
                
                GameObject gameObject=null;                
                switch(matrix[i][j])
                {
                    case "ww":
                    case "wb":
                    case "wd":
                    case "wp":    
                    case "wq":
                        gameObject=new Wall(matrix[i][j]);
                        break;
                    case "fp":
                    case "fz":
                    case "fk":
                    case "fl":    
                    case "ff":
                        gameObject=new PaintBucket(matrix[i][j]);
                        break;
                    case "ps":
                    case "zs":
                    case "ks":
                    case "ls":    
                    case "fs":
                        gameObject=new Heart(matrix[i][j]);
                        break;
                    case "de":
                    case "sz":
                        gameObject=new SzabiDenia(matrix[i][j]);
                        this.szabi=(SzabiDenia)gameObject;
                        this.szabi.setCurrentX(25);
                        this.szabi.setCurrentY(25);
                        break;
                    case "la":
                        gameObject=new Ladder();
                        break;                    
                    case "  ":
                        gameObject=new Air();
                        break;
                    case "ns":
                        gameObject=new BigHeart();
                        break;
                }
                objects[i][j]=gameObject;
                gameObject.currentI=i;
                gameObject.currentJ=j;
                gameObject.setGameSession(this);
            }
        }
    }
    
    public int getWidth()
    {
        return objects[0].length;
    }
    
    public int getHeight()
    {
       return objects.length;
    }
    
    public GameObject getGameObjectAt(int x,int y)
    {
        return objects[x][y];
    }
        
    public SzabiDenia getSzabi()
    {
        return szabi;
    }
    
    public void simulateNextStepOnSession(int numberStepsI,int numberStepsJ,Helpers.Enums.Direction direction)
    {
        if(numberStepsI==0 && numberStepsJ==0)
        {
            return;
        }
        int i=szabi.getCurrentI();
        int j=szabi.getCurrentJ();
        GameObject temp=objects[i][j];
        objects[i][j]=objects[i+numberStepsI][j+numberStepsJ];
        objects[i+numberStepsI][j+numberStepsJ]=temp;
    }
        
    public Path constrcutPath(Helpers.Enums.Direction direction)
    {
        return szabi.constructPath(direction);
    }
}
