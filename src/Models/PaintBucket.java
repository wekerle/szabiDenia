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
    private String cod=null;
    
    public PaintBucket(String cod)
    {
        this.cod=cod;
        switch(cod){
            case "fp":
                image=new Image("/img/pirosVeder.png");
                break;
            case "fz":
                image=new Image("/img/zoldVeder.png");
                break;
            case "fk":
                image=new Image("/img/kekVeder.png");
                break;
            case "fl":
                image=new Image("/img/lilaVeder.png");
                break;
            case "ff":
                image=new Image("/img/feketeVeder.png");
                break;
        }
    }
    
    @Override
    public Image getImage() 
    {
        return image;
    }
    
    public String getCode()
    {
        return this.cod;
    }
    
}
