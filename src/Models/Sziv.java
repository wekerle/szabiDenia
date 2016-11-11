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
public class Sziv extends GameObject{

    private Image image=null;
    
    public Sziv(String cod)
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
