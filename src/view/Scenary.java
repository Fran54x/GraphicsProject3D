package view;

import model.RotatingI;
import model.StaticCube;
import model.TranslatedCube;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Scenary {
    Boolean scaleFlag1;
    private Boolean rflag1;
    private double actualTime;
    double[][] temPoints;
    private BufferedImage fondo;
    double realCounter;
    private FrameView v;
    TranslatedCube tcube2;
    TranslatedCube tcube;
    StaticCube cube1,cube2,cube3,cube4,cube5,cube6,cube7,cube8,cube9,cube10,cube11,cube12,
            cube13,cube14,cube15,cube16,cube17,cube18,cube19,cube20;
    RotatingI Icube;
    StaticCube mainCharacter;
    public Scenary(FrameView view) {
        scaleFlag1 = true;
        rflag1=true;
        this.v = view;
        setStaticCubes();
        mainCharacter = new StaticCube(v);
        mainCharacter.rotatingYNoMovement(45);
        mainCharacter.setSpeedXYZ(.2,.2,0);
        mainCharacter.setLimits(27,27,27);
        mainCharacter.setPosXYZ(0,0,0);
        mainCharacter.scaling(.22,.26,.29);
        mainCharacter.setMode(true);
        mainCharacter.traslatingWithotMovement(200,620,500);
        mainCharacter.projecting();

        temPoints = new double[][] {
                {100, -27.8125, 0},
                {50, -2.8125, 0},
                {0, -27.8125, 0},
                {-50, -2.8125, 0},
                {-100, -27.8125, 0},
                {-50, -52.8125, 0},
                {-100, -77.8125, 0},
                {-50, -102.8125, 0}, // cara de arriba
                {100, 22.1875, 0},
                {50, 47.1875, 0},
                {0, 22.1875, 0},
                {-50, 47.1875, 0},
                {-100, 22.1875, 0},
                {-50, -2.8125, 0},
                {-100, -27.8125, 0},
                {-50, -52.8125, 0} // cara de abajo
        };
        tcube = new TranslatedCube(v,temPoints,new Color(255, 255, 255));
        tcube.scaling(.5,.5,0);
        tcube.traslatingWithotMovement(212,316,0);
        tcube.setPosXYZ(0,0,0);
        tcube.setLimits(28,28,0);
        tcube.setSpeedXYZ(.50,.12,0);

        temPoints = new double[][]{
                {-112.5, -37.5, 50},
                {-62.5, -62.5, 50},
                {-12.5, -37.5, 50},
                {37.5, -62.5, 50},
                {87.5, -37.5, 50},
                {37.5, -12.5, 50},
                {87.5, 12.5, 50},
                {37.5, 37.5, 50},
                {-112.5, 12.5, 50},
                {-62.5, -12.5, 50},
                {-12.5, 12.5, 50},
                {37.5, -12.5, 50},
                {87.5, 12.5, 50},
                {37.5, 37.5, 50},
                {87.5, 62.5, 50},
                {37.5, 87.5, 50}
        };
        tcube2 = new TranslatedCube(v,temPoints,new Color(255, 255, 255));
        tcube2.scaling(.45,.45,0);
        tcube2.traslatingWithotMovement(294,400,0);
        tcube2.setPosXYZ(0,0,0);
        tcube2.setLimits(28,28,0);
        tcube2.setSpeedXYZ(.37,.32,0);
//        for (int i =0;i<28;i++){
//            realCounter+=.1;
//            tcube2.traslating(realCounter,1,-1);
//        }
        temPoints = new double[][]{
                {-225, -50, -12.5}, {-125, -50, -12.5}, {-125, -50, 87.5}, {-225, -50, 87.5},
                {-225, 50, -12.5}, {-125, 50, -12.5}, {-125, 50, 87.5}, {-225, 50, 87.5},
                {-25, -50, -12.5}, {-25, -50, 87.5}, {-25, 50, -12.5}, {-25, 50, 87.5},
                {75, -50, -12.5}, {75, -50, 87.5}, {75, 50, -12.5}, {75, 50, 87.5},
                {175, -50, -12.5}, {175, -50, 87.5}, {175, 50, -12.5}, {175, 50, 87.5},
                {75, -100, -112.5}, {75, 0, -112.5}, {175, -100, -112.5}, {175, 0, -112.5}
        };
        Icube = new RotatingI(v,temPoints,new Color(255,255,255));
        temPoints = Icube.scaling(.32,.32,.32);
        temPoints = Icube.rotatingZNoMovementWithPoints(180,temPoints);
        temPoints = Icube.rotatingYNoMovementWithPoints(40,temPoints);
        Icube.setRotatingPoints(Icube.rotatingXNoMovementWithPoints(40,temPoints));
        temPoints = Icube.traslatingWithotMovementWithPoints(365,270,1,temPoints);
        Icube.setPosXYZ(0,0,0);
        Icube.setLimits(1000,1000,1000);
        Icube.setSpeedXYZ(.1,15,.1);
    }



    public BufferedImage drawNightStage() {
        URL url = getClass().getResource("/images/fondo.png");
        try {
            assert url != null;
            fondo = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return fondo;
    }

    public void drawLevel(double incrementCounter, double actualTime) {
        drawSet1Cubes();
        if(actualTime>0&&actualTime<27){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,1,-1);
        }
        if(actualTime == 27){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(1,-.3,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(34,34,33);
        }
        if(actualTime>28&&actualTime<62){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,1,1);
        }
        if(actualTime == 62){
            mainCharacter.setSpeedXYZ(1.3,-.1,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(23,23,33);
            realCounter = 0;
        }
        if(actualTime>62&&actualTime<85){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,1,-1);
        }
        if (actualTime==85){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(-.5,.2,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(20,20,33);
        }
        if(actualTime>85&&actualTime<105){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,-1,-1);
        }
        if (actualTime==105){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(-1.3,.20,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(40,40,33);
        }
        if(actualTime>550&&actualTime<590){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,-1,-1);
        }
        if (actualTime==590){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(-1.3,.20,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(45,45,33);
        }
        if(actualTime>1050&&actualTime<1095){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,-1,-1);
        }
        if (actualTime==1095){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(1.3,-.1,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(45,45,33);
        }
        if(actualTime>2040&&actualTime<2085){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,1,1);
        }
        if (actualTime==2085){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(-1.3,.20,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(45,45,33);
        }

        if (actualTime>500 && actualTime <530){
            realCounter += 0.1;
            tcube2.traslating(realCounter,1,-1);
            tcube.traslating(realCounter,1,-1);
        }
        if (actualTime==530){
            realCounter = 0;
            tcube2.setPosXYZ(0,0,0);
            tcube2.setSpeedXYZ(-.3,-.4,0);
            tcube.setPosXYZ(0,0,0);
            tcube.setSpeedXYZ(-.6,-.1,0);
        }
        if (actualTime>1000 && actualTime <1030){
            realCounter += 0.1;
            tcube2.traslating(realCounter,-1,1);
            tcube.traslating(realCounter,-1,1);
            //temPoints = tcube.rotatingX(incrementCounter);
            rflag1 = true;
        }
        if(rflag1){
            //Icube.traslatingWithotMovementWithPoints(300,300,0,Icube.getRotatingPoints());
            rflag1 = false;
        }
        if (actualTime==1030){
            realCounter = 0;
            tcube2.setPosXYZ(0,0,0);
            tcube2.setSpeedXYZ(.37,.32,0);
            tcube.setPosXYZ(0,0,0);
            tcube.setSpeedXYZ(.50,.12,0);
        }
        if (actualTime>1500 && actualTime <1530){
            realCounter += 0.1;
            tcube2.traslating(realCounter,1,-1);
            tcube.traslating(realCounter,1,-1);
            //Icube.setRotatingPoints(Icube.rotatingZWithPoints(realCounter, Icube.getRotatingPoints()));
            rflag1 = true;
        }
        if(rflag1){
            //Icube.traslatingWithotMovementWithPoints(300,300,0,Icube.getRotatingPoints());
            rflag1 = false;
        }
        if (actualTime==1530){
            realCounter = 0;
            tcube2.setPosXYZ(0,0,0);
            tcube2.setSpeedXYZ(-.3,-.4,0);
            tcube.setPosXYZ(0,0,0);
            tcube.setSpeedXYZ(-.6,-.1,0);
        }
        if (actualTime>2000 && actualTime <2030){
            realCounter += 0.1;
            tcube2.traslating(realCounter,-1,1);
            tcube.traslating(realCounter,-1,1);
            //temPoints = tcube.rotatingX(incrementCounter);
            rflag1 = true;
        }
        if (actualTime==2030){
            realCounter = 0;
            tcube2.setPosXYZ(0,0,0);
            tcube2.setSpeedXYZ(-.3,-.4,0);
            tcube.setPosXYZ(0,0,0);
            tcube.setSpeedXYZ(-.6,-.1,0);
        }
        if (actualTime==2500){
            realCounter = 0;
        }
        if (actualTime>2500 && actualTime <3500){
            realCounter += 0.1;
            temPoints = Icube.scalingOriginal(.32,.32,.32);
            temPoints = Icube.rotatingZNoMovementWithPoints(180,temPoints);
            temPoints = Icube.rotatingYNoMovementWithPoints(40,temPoints);
            temPoints = Icube.rotatingXNoMovementWithPoints(40,temPoints);
            temPoints = Icube.rotatingYWithPoints(realCounter,temPoints);
            //temPoints = Icube.rotatingXWithPoints(realCounter,temPoints);
            temPoints = Icube.traslatingWithotMovementWithPoints(365,270,1,temPoints);
        }
        if (actualTime==3500){
            realCounter = 0;
            mainCharacter.setSpeedXYZ(.50,.12,0);
            mainCharacter.setPosXYZ(0,0,0);
            mainCharacter.setLimits(45,45,33);
        }
        if (actualTime>3500 && actualTime <3545){
            realCounter += 0.1;
            mainCharacter.traslating(realCounter,1,-1);
        }


        tcube2.projecting();
        tcube2.drawFigure(false);
        drawSet2Cubes();
        tcube.projecting();
        tcube.drawFigure(true);
        drawSet3Cubes();

        Icube.projecting(temPoints);
        Icube.drawFigure();

        mainCharacter.drawFigure();
    }

    private void drawSet2Cubes() {
        cube8.drawFigure();
        cube9.drawFigure();
        cube10.drawFigure();
        cube11.drawFigure();
        cube12.drawFigure();
        //cube13.drawFigure();
    }
    private void drawSet3Cubes() {
        cube13.drawFigure();
        cube14.drawFigure();
        cube15.drawFigure();
        cube16.drawFigure();
        cube17.drawFigure();
    }

    private void drawSet1Cubes() {
        cube1.drawFigure();
        cube2.drawFigure();
        cube4.drawFigure();
        cube3.drawFigure();
        cube5.drawFigure();
        cube6.drawFigure();
        cube7.drawFigure();
    }

    private void setStaticCubes() {
        //plataforma1
        cube1 = new StaticCube(v);
        cube1.rotatingYNoMovement(45);
        cube1.scaling(.35,.35,.4);
        cube1.traslatingRotated(200,600,500);
        cube1.projecting();
        cube2 = new StaticCube(v);
        cube2.rotatingYNoMovement(45);
        cube2.scaling(.35,.35,.4);
        cube2.traslatingRotated(225,585,500);
        cube2.projecting();
        //plataforma2
        cube3 = new StaticCube(v);
        cube3.rotatingYNoMovement(45);
        cube3.scaling(.35,.35,.4);
        cube3.traslatingRotated(302,549,390);
        cube3.projecting();
        cube4 = new StaticCube(v);
        cube4.rotatingYNoMovement(45);
        cube4.scaling(.35,.35,.4);
        cube4.traslatingRotated(335,618,500);
        cube4.projecting();
        cube5 = new StaticCube(v);
        cube5.rotatingYNoMovement(45);
        cube5.scaling(.35,.35,.4);
        cube5.traslatingRotated(352,549,390);
        cube5.projecting();
        cube6 = new StaticCube(v);
        cube6.rotatingYNoMovement(45);
        cube6.scaling(.35,.35,.4);
        cube6.traslatingRotated(377,535,390);
        cube6.projecting();
        cube7 = new StaticCube(v);
        cube7.rotatingYNoMovement(45);
        cube7.scaling(.35,.35,.4);
        cube7.traslatingRotated(350,520,390);
        cube7.projecting();
        //plataforma3
        cube8 = new StaticCube(v);
        cube8.rotatingYNoMovement(45);
        cube8.scaling(.35,.35,.4);
        cube8.traslatingRotated(271,528,500);
        cube8.projecting();
        cube9 = new StaticCube(v);
        cube9.rotatingYNoMovement(45);
        cube9.scaling(.35,.35,.4);
        cube9.traslatingRotated(245,513,500);
        cube9.projecting();
        cube10 = new StaticCube(v);
        cube10.rotatingYNoMovement(45);
        cube10.scaling(.35,.35,.4);
        cube10.traslatingRotated(228,504,500);
        cube10.projecting();
        cube11 = new StaticCube(v);
        cube11.rotatingYNoMovement(45);
        cube11.scaling(.35,.35,.4);
        cube11.traslatingRotated(245,494,500);
        cube11.projecting();
        cube12 = new StaticCube(v);
        cube12.rotatingYNoMovement(45);
        cube12.scaling(.35,.35,.4);
        cube12.traslatingRotated(269,480,500);
        cube12.projecting();
        //Plataforma4
        cube13 = new StaticCube(v);
        cube13.rotatingYNoMovement(45);
        cube13.scaling(.35,.35,.4);
        cube13.traslatingRotated(135,451,500);
        cube13.projecting();
        cube14 = new StaticCube(v);
        cube14.rotatingYNoMovement(45);
        cube14.scaling(.35,.35,.4);
        cube14.traslatingRotated(109,436,500);
        cube14.projecting();
        cube15 = new StaticCube(v);
        cube15.rotatingYNoMovement(45);
        cube15.scaling(.35,.35,.4);
        cube15.traslatingRotated(90,425,500);
        cube15.projecting();
        cube16 = new StaticCube(v);
        cube16.rotatingYNoMovement(45);
        cube16.scaling(.35,.35,.4);
        cube16.traslatingRotated(65,411,500);
        cube16.projecting();
        cube17 = new StaticCube(v);
        cube17.rotatingYNoMovement(45);
        cube17.scaling(.35,.35,.4);
        cube17.traslatingRotated(135,425,500);
        cube17.projecting();
        //Plataforma5
        cube18 = new StaticCube(v);
        cube18.rotatingYNoMovement(45);
        cube18.scaling(.35,.35,.4);
        cube18.traslatingRotated(115,431,500);
        cube18.projecting();
        cube19 = new StaticCube(v);
        cube19.rotatingYNoMovement(45);
        cube19.scaling(.35,.35,.4);
        cube19.traslatingRotated(115,431,500);
        cube19.projecting();
    }
}
