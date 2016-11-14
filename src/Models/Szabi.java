/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Helpers.Enums;
import javafx.scene.image.Image;

/**
 *
 * @author tibor.wekerle
 */
public class Szabi extends GameObject{

    private Image image=new Image("/img/people.png");
    
    @Override
    public Image getImage() 
    {
        return image;
    }
    
    public int getNumberOfStepsI(Enums.Irany irany, int iPos, int jPos) 
    {
        int tempI=iPos;
        int numberOfSteps=0;
        GameObject neighbor=null;
        
        switch(irany)
        {
            case Jobbra:
            case Balra:
                break;
            case Fel:                 
                neighbor=getNeighbor(irany, tempI, jPos);
                while(!(neighbor instanceof Fal))
                {
                    tempI--;
                    numberOfSteps--;
                    neighbor=getNeighbor(irany, tempI, jPos);
                }
                if(((Fal)neighbor).getCode().compareTo("wq")==0 || ((Fal)neighbor).getCode().compareTo("wp")==0)
                {
                    numberOfSteps--;
                }
                break;
            case Le:
                neighbor=getNeighbor(irany, tempI, jPos);
                while(!(neighbor instanceof Fal))
                {
                    tempI++;
                    numberOfSteps++;
                    neighbor=getNeighbor(irany, tempI, jPos);
                }
                if(((Fal)neighbor).getCode().compareTo("wd")==0 || ((Fal)neighbor).getCode().compareTo("wb")==0)
                {
                    numberOfSteps++;
                }
                break;
        }
        return numberOfSteps;
    }

    public int getNumberOfStepsJ(Enums.Irany irany, int iPos, int jPos)
    {
        int tempJ=jPos;
        int numberOfSteps=0;
        GameObject neighbor=null;
        
        switch(irany)
        {
            case Fel:
            case Le:
                break;
            case Jobbra:                 
                neighbor=getNeighbor(irany, iPos, tempJ);
                while(!(neighbor instanceof Fal))
                {
                    tempJ++;
                    numberOfSteps++;
                    neighbor=getNeighbor(irany, iPos, tempJ);
                }
                if(((Fal)neighbor).getCode().compareTo("wd")==0 || ((Fal)neighbor).getCode().compareTo("wq")==0)
                {
                    numberOfSteps++;
                }
                break;
            case Balra:
                neighbor=getNeighbor(irany, iPos, tempJ);
                while(!(neighbor instanceof Fal))
                {
                    tempJ--;
                    numberOfSteps--;
                    neighbor=getNeighbor(irany, iPos, tempJ);
                }
                if(((Fal)neighbor).getCode().compareTo("wb")==0 || ((Fal)neighbor).getCode().compareTo("wp")==0)
                {
                    numberOfSteps--;
                }
                break;
        }
        return numberOfSteps;
    }
    
    protected GameObject getNeighbor(Enums.Irany irany,int i,int j)
    {       
        switch(irany)
        {
            case Fel:
                i--;
                break;
            case Le:
                i++;
                break;
            case Jobbra:
                j++;
                break;
            case Balra:
                j--;
                break;
        }
        return gameSession.getGameObjectAt(i,j);
    }
}
