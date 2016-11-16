/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.scene.image.Image;

/**
 *
 * @author tibor.wekerle
 */
public class BigHeart extends GameObject{

    private Image image=new Image("/img/forgoSziv.gif");
    private boolean isCollected=false;
    
    @Override
    public Image getImage() 
    {
        return image;
    }
    
    public boolean isCollected()
    {
        return this.isCollected;
    }
    
    public void setIsCollected(boolean isCollected)
    {
        this.isCollected=isCollected;
    }
    
}
