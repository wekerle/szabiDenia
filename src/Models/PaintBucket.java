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
public class PaintBucket extends GameObject{

    private Image image=null;
    private Helpers.Enums.Color color=null;
    
    public PaintBucket(String cod)
    {
        switch(cod){
            case "fp":
                this.color=Helpers.Enums.Color.Red;
                image=new Image("/img/pirosVeder.png");
                break;
            case "fz":
                this.color=Helpers.Enums.Color.Green;
                image=new Image("/img/zoldVeder.png");
                break;
            case "fk":
                this.color=Helpers.Enums.Color.Blue;
                image=new Image("/img/kekVeder.png");
                break;
            case "fl":
                this.color=Helpers.Enums.Color.Purple;
                image=new Image("/img/lilaVeder.png");
                break;
        }
    }
    
    @Override
    public Image getImage() 
    {
        return image;
    }

    public Helpers.Enums.Color getColor()
    {
        return this.color;
    }
}
