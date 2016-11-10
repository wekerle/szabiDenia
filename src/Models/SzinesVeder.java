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
public class SzinesVeder extends GameObject{
    private Image image=null;
    
    public SzinesVeder(Helpers.Enums.Szin szin){
        switch(szin)
        {
            case Piros:
                image=new Image("/img/pirosVeder.png");
                break;
            case Fekete:
                image=new Image("/img/feketeVeder.png");
                break;
            case Kek:
                image=new Image("/img/kekVeder.png");
                break;
            case Lila:
                image=new Image("/img/lilaVeder.png");
                break;
            case Narancs:
                image=new Image("/img/narancsVeder.png");
                break;
            case Zold:
                image=new Image("/img/lilaVeder.png");
                break;
        }
    }
    @Override
    public Image getImage() 
    {
        return image;
    }
}
