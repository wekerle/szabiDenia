/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szabidenia;

import Models.LevelModel;
import java.util.ArrayList;


//loveercase es trim a similarty setbe
//test similarity
/**
 *
 * @author Ronaldo
 */
public class DataCollector
{
    private ArrayList<LevelModel> levels=new ArrayList<LevelModel>();
    
    public DataCollector()
    {
        constructLevels();
        //ww -fal       
        //wb -felfal fentball
        //wd -felfal fentjobb
        //wp -felfal lentball
        //wq -felfal lentjobb
        //"  " -levego
        //sz -szabi
        //de -denia

        //fp -festekVederPiros
        //fz -festekVederZold
        //fk -festekVederKek
        //fl -festekVederLila
        //ff -festekVederFekete

        //ps -pirosSziv
        //zs -zoldSziv
        //ks -kekSziv
        //ls -lilaSziv
        //fs -feketeSziv

        //ns -NagySziv
        //ab -ablak
        //la -lajtorja
        
    }
    
    private void constructLevels()
    {
        String[][] matrix1={
            {"  ","ww","ww","ww","ww","ww","ww","ww","ww","ww","  "},
            {"  ","ww","ww","wp","  ","  ","  ","wq","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","wp","  ","ww","ww","ww","ww","ww","  ","wq","ww"},
            {"ww","  ","  ","ww","ww","ww","ww","ww","  ","  ","ww"},
            {"ww","wb","  ","ww","ww","ww","ww","ww","  ","wd","ww"},
            {"ww","ww","  ","  ","  ","  ","  ","  ","  ","ww","ww"},
            {"  ","ww","ww","wb","  ","  ","  ","wd","ww","ww","  "},
            {"  ","ww","ww","ww","ww","ww","ww","ww","ww","ww","  "},
        };
        LevelModel level1=new LevelModel(matrix1, 1, 1);
        levels.add(level1);
        
        String[][] matrix2={
            {"ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
            {"ww","  ","  ","  ","  ","  ","  ","  ","  ","  ","ww"},
            {"ww","  ","  ","  ","  ","  ","  ","  ","  ","la","ww"},
            {"ww","  ","  ","  ","  ","  ","  ","  ","  ","la","ww"},
            {"ww","  ","  ","  ","  ","  ","  ","  ","  ","la","ww"},
            {"ww","  ","  ","  ","  ","  ","  ","  ","  ","la","ww"},
            {"ww","  ","  ","  ","  ","  ","  ","  ","  ","la","ww"},
            {"ww","wp","  ","  ","  ","  ","  ","  ","  ","la","ww"},
            {"ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level2=new LevelModel(matrix2, 2, 2);
        levels.add(level2);
        
        String[][] matrix3={
            {"ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
            {"ww","wd","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","aa","ww"},
            {"aa","  ","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","  ","f"},
            {"ww","wp","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","wq","ww"},
            {"ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
            {"ww","  ","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
            {"ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
            {"ww","wd","  ","  ","  ","  ","  ","gg","  ","  ","  ","  ","  ","3","ww"},
            {"f","  ","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","  ","f"},
            {"ww","wp","  ","  ","  ","  ","  ","ww","  ","  ","  ","  ","  ","wq","ww"},
            {"ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level3=new LevelModel(matrix3, 3, 3);
        levels.add(level3);
        
        String[][] matrix4={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level4=new LevelModel(matrix4, 4, 4);
        levels.add(level4);
        
        String[][] matrix5={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level5=new LevelModel(matrix5, 5, 5);
        levels.add(level5);
        
        String[][] matrix6={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level6=new LevelModel(matrix6, 6, 6);
        levels.add(level6);
        
        String[][] matrix7={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level7=new LevelModel(matrix7, 7, 7);
        levels.add(level7);
        
        String[][] matrix8={
           {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level8=new LevelModel(matrix8, 8, 8);
        levels.add(level8);
        
        String[][] matrix9={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level9=new LevelModel(matrix9, 9, 9);
        levels.add(level9);
        
        String[][] matrix10={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level10=new LevelModel(matrix10, 10, 10);
        levels.add(level10);
        
        String[][] matrix11={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level11=new LevelModel(matrix11, 11, 11);
        levels.add(level11);
        
        String[][] matrix12={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level12=new LevelModel(matrix12, 12, 12);
        levels.add(level12);
        
        String[][] matrix13={
           {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level13=new LevelModel(matrix13, 13, 13);
        levels.add(level13);
        
        String[][] matrix14={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level14=new LevelModel(matrix14, 14, 14);
        levels.add(level14);
        
        String[][] matrix15={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level15=new LevelModel(matrix15, 15, 15);
        levels.add(level15);
        
        String[][] matrix16={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level16=new LevelModel(matrix16, 16, 16);
        levels.add(level16);
        
        String[][] matrix17={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level17=new LevelModel(matrix17, 17, 17);
        levels.add(level17);
        
        String[][] matrix18={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level18=new LevelModel(matrix18, 18, 18);
        levels.add(level18);
        
        String[][] matrix19={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level19=new LevelModel(matrix19, 19, 19);
        levels.add(level19);
        
        String[][] matrix20={
            {"ww","ww","ww","ww","ww","ww","ww","ww"},
            {"ww","  ","  ","c","c","  ","  ","ww"},
            {"  ","  ","  ","ww","ww","  ","  ","  "},
            {"ww","  ","ww","ww","ww","ww","  ","ww"},
            {"ww","  ","ww","ww","ww","ww","  ","ww"},
            {"ww","c","  ","ww","ww","  ","c","ww"},
            {"ww","b","  ","ww","ww","  ","a","ww"},
            {"ww","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level20=new LevelModel(matrix20, 20, 20);
        levels.add(level20);
        
        String[][] matrix21={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level21=new LevelModel(matrix21, 21, 21);
        levels.add(level21);
        
        String[][] matrix22={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level22=new LevelModel(matrix22, 22, 22);
        levels.add(level22);
        
        String[][] matrix23={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level23=new LevelModel(matrix23, 23, 23);
        levels.add(level23);
        
        String[][] matrix24={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level24=new LevelModel(matrix24, 24, 24);
        levels.add(level24);
        
        String[][] matrix25={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level25=new LevelModel(matrix25, 25, 25);
        levels.add(level25);
        
        String[][] matrix26={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level26=new LevelModel(matrix26, 26, 26);
        levels.add(level26);
        
        String[][] matrix27={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level27=new LevelModel(matrix27, 27, 27);
        levels.add(level27);
        
        String[][] matrix28={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level28=new LevelModel(matrix28, 28, 28);
        levels.add(level28);
        
        String[][] matrix29={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level29=new LevelModel(matrix29, 29, 29);
        levels.add(level29);
        
        String[][] matrix30={
            {"  ","ww","ww","ww","ww","ww","ww","  "},
            {"ww","ww","  ","  ","  ","  ","ww","ww"},
            {"  ","  ","  ","  ","  ","  ","ww","ww"},
            {"ww","  ","  ","  ","  ","b","ww","ww"},
            {"ww","  ","  ","  ","  ","ww","ww","ww"},
            {"ww","b","  ","  ","  ","  ","ww","ww"},
            {"ww","ww","  ","  ","  ","a","ww","ww"},
            {"  ","ww","ww","ww","ww","ww","ww","ww"},
        };
        LevelModel level30=new LevelModel(matrix30, 30, 30);
        levels.add(level30);
        
    }
    
    public ArrayList<LevelModel>  getLevels()
    {
        return levels;
    }
    
}
