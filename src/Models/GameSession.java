package Models;

import Helpers.Enums;
import java.util.ArrayList;

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
    private Szabi szabi=null;
        
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
                //ab -ablak
                //la -lajtorja
                
                GameObject gameObject=null;                
                switch(matrix[i][j])
                {
                    case "ww":
                    case "wb":
                    case "wd":
                    case "wp":    
                    case "wq":
                        gameObject=new Fal(matrix[i][j]);
                        break;
                    case "fp":
                    case "fz":
                    case "fk":
                    case "fl":    
                    case "ff":
                        gameObject=new FestekVeder(matrix[i][j]);
                        break;
                    case "ps":
                    case "zs":
                    case "ks":
                    case "ls":    
                    case "fs":
                        gameObject=new Sziv(matrix[i][j]);
                        break;
                    case "sz":
                        gameObject=new Szabi();
                        this.szabi=(Szabi)gameObject;
                        break;
                    case "de":
                        gameObject=new Denia();
                        break;
                    case "ab":
                        gameObject=new Ablak();
                        break;
                    case "la":
                        gameObject=new Lajtorja();
                        break;                    
                    case "  ":
                        gameObject=new Levego();
                        break;
                    case "ns":
                        gameObject=new NagySziv();
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
    
    public int getNumberOfStepsI(Helpers.Enums.Irany irany)
    {
        return szabi.getNumberOfStepsI(irany, szabi.getCurrentI(), szabi.getCurrentJ());
    }
    
    public int getNumberOfStepsJ(Helpers.Enums.Irany irany)
    {
        return szabi.getNumberOfStepsJ(irany, szabi.getCurrentI(), szabi.getCurrentJ());
    }
    
    public Szabi getSzabi()
    {
        return szabi;
    }
    
    public void simulateNextStepOnSession(int numberStepsI,int numberStepsJ,Helpers.Enums.Irany irany)
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
    
    public Helpers.Enums.Irany getNewIrany(Helpers.Enums.Irany regiIrany)
    {
        GameObject gameObject=szabi.getNeighbor(regiIrany, szabi.getCurrentI(), szabi.getCurrentJ());
        
        Helpers.Enums.Irany nextIrany=null;
        if(gameObject instanceof Fal)
        {
           String cod=((Fal) gameObject).getCode();
           
           switch(cod){
                case "ww":
                    nextIrany=null;
                   break;
                case "wd":
                    if(regiIrany==Helpers.Enums.Irany.Jobbra)
                    {
                        nextIrany=Enums.Irany.Fel;
                    }else if(regiIrany==Enums.Irany.Le)
                    {
                        nextIrany=Enums.Irany.Balra;
                    }
                   break;
                case "wb":
                    if(regiIrany==Helpers.Enums.Irany.Balra)
                    {
                        nextIrany=Enums.Irany.Fel;
                    }else if(regiIrany==Enums.Irany.Le)
                    {
                        nextIrany=Enums.Irany.Jobbra;
                    }
                   break;
                case "wp":
                    if(regiIrany==Helpers.Enums.Irany.Balra)
                    {
                        nextIrany=Enums.Irany.Le;
                    }else if(regiIrany==Enums.Irany.Fel)
                    {
                        nextIrany=Enums.Irany.Jobbra;
                    }
                   break;
                case "wq":
                    if(regiIrany==Helpers.Enums.Irany.Jobbra)
                    {
                        nextIrany=Enums.Irany.Le;
                    }else if(regiIrany==Enums.Irany.Fel)
                    {
                        nextIrany=Enums.Irany.Balra;
                    }
                   break;
           }
        }
        
        return nextIrany;
    }
}
