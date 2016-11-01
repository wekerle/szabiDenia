package Models;


import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ronaldo
 */
public abstract class GameObject 
{
    protected GameSession gameSession=null;
    protected int fromX,toX,fromY,toY,currentI,currentJ;

    public void setGameSession(GameSession gameSession) 
    {
        this.gameSession = gameSession;
    }

    public int getFromX() 
    {
        return fromX;
    }

    public void setFromX(int fromX) 
    {
        this.fromX = fromX;
    }
    
    public int getCurrentI() 
    {
        return currentI;
    }

    public void setCurrentI(int currentI) 
    {
        this.currentI = currentI;
    }
    
    public int getCurrentJ() 
    {
        return currentJ;
    }

    public void setCurrentJ(int currentJ) 
    {
        this.currentJ = currentJ;
    }

    public int getToX() 
    {
        return toX;
    }

    public void setToX(int toX) 
    {
        this.toX = toX;
    }

    public int getFromY() 
    {
        return fromY;
    }

    public void setFromY(int fromY) 
    {
        this.fromY = fromY;
    }

    public int getToY() 
    {
        return toY;
    }

    public void setToY(int toY) 
    {
        this.toY = toY;
    }
    
    public abstract Image getImage();
}
