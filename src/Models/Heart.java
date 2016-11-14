/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Listener.HeartColoringListener;
import javafx.scene.image.Image;

/**
 *
 * @author tibor.wekerle
 */
public class Heart extends GameObject{

    private Image image=null;
    private boolean isColored=false;
    private HeartColoringListener heartColoringListener=null;
    
    public void setHeartColoringListener(HeartColoringListener heartColoringListener)
    {
        this.heartColoringListener=heartColoringListener;
    }
    public void colorHeart()
    {
        this.heartColoringListener.heartColoring(this);
    }
    
    public Heart(String cod)
    {
        switch(cod){
            case "ps":
                image=new Image("/img/pirosSzivUres.png");
                break;
            case "zs":
                image=new Image("/img/zoldSzivUres.png");
                break;
            case "ks":
                image=new Image("/img/kekSzivUres.png");
                break;
            case "ls":
                image=new Image("/img/lilaSzivUres.png");
                break;
            case "fs":
                image=new Image("/img/feketeSzivUres.png");
                break;
        }
    }
    
    @Override
    public Image getImage() 
    {
        return image;
    }
    
}
