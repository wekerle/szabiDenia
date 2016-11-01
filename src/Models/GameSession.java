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
        
    public int getLevelNumber() 
    {
        return levelNumber;
    }
    
    public GameSession(LevelModel level)
    {
        this.levelNumber=level.getLevelNumber();
        char[][] matrix=level.getMatrix();
        int height=matrix.length;
        int width=matrix[0].length;
        objects=new GameObject[height][width];
                
        int i=0,j=0;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                //# -fal
                //a -szabi
                //b -denia
                //c -festekDoboz
                //d -sziv
                //e -virag
                //f -ablak
                //g -lajtorja
                //' ' -levego
                //1 -felfal fentball
                //2 -felfal fentjobb
                //3 -felfal lentball
                //4 -felfal lentjobb
                
                GameObject gameObject=null;                
                switch(matrix[i][j])
                {
                    case '#':
                        gameObject=new Fal();
                        break;
                    case 'a':
                        gameObject=new Szabi();
                        break;
                    case 'b':
                        gameObject=new Denia();
                        break;
                    case 'c':
                        gameObject=new FestekDoboz();
                        break;
                    case 'd':
                        gameObject=new Sziv();
                        break;
                    case 'e':
                        gameObject=new Virag();
                        break;
                    case 'f':
                        gameObject=new Ablak();
                        break;
                    case 'g':
                        gameObject=new Lajtorja();
                        break;
                    case '1':
                        gameObject=new FelFalFentBal();
                        break;
                    case '2':
                        gameObject=new FelFalFentJobb();
                        break;
                    case '3':
                        gameObject=new FelFalLentBal();
                        break;
                    case '4':
                        gameObject=new FelFalLentJobb();
                        break;
                    case ' ':
                        gameObject=new Levego();
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
}
