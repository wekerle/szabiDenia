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
public class FelFalLentBal extends GameObject{

    private Image image=new Image("/img/falLentBal.png");
    
    @Override
    public Image getImage() 
    {
        return image;
    }
    
}