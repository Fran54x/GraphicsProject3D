package view;

import model.StaticCube;
import model.TranslatedCube;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Scenary {
    private double actualTime;
    double[][] temPoints;
    private BufferedImage fondo;
    private FrameView v;

    public Scenary(FrameView view) {
        this.v = view;
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

    public void drawLevel(double cont1) {
        StaticCube cube = new StaticCube(v);
        cube.setBorder(new Color(255, 255, 255));
        //cube.drawFigure();
        temPoints = new double[][]{
                {300, 450, 50},
                {250, 475, 50},
                {200, 450, 50},
                {150, 475, 50},
                {100, 450, 50},
                {150, 425, 50},
                {100, 400, 50},
                {150, 375, 50},//
                {300, 500, 50},
                {250, 525, 50},
                {200, 500, 50},
                {150, 525, 50},
                {100, 500, 50},
                {150, 475, 50},
                {100, 450, 50},
                {150, 425, 50}
        };
        TranslatedCube tcube = new TranslatedCube(v,temPoints,new Color(255, 255, 255));
        //tcube.drawFigure(true);
        temPoints = new double[][]{
                {300, 150, 50},
                {350, 125, 50},
                {400, 150, 50},
                {450, 125, 50},
                {500, 150, 50},
                {450, 175, 50},
                {500, 200, 50},
                {450, 225, 50},//
                {300, 200, 50},
                {350, 175, 50},
                {400, 200, 50},
                {450, 175, 50},
                {500, 200, 50},
                {450, 225, 50},
                {500, 250, 50},
                {450, 275, 50}
        };
        TranslatedCube tcube2 = new TranslatedCube(v,temPoints,new Color(255, 255, 255));
        tcube2.setPosXYZ(1600,400,0);
        tcube2.setSpeedXYZ(10,10,3);
        tcube2.traslating(cont1);
        tcube2.projecting();
        tcube2.drawFigure(false);
    }
}
