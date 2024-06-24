package view;

import model.*;

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

        double[][] shapeI = new double[][]{
                {50,50,100}, {150,50,100}, {150,50,200}, {50,50,200},
                {50,150,100}, {150,150,100}, {150,150,200}, {50,150,200},
                {250,50,100}, {250,50,200}, {250,150,100}, {250,150,200},
                {350,50,100}, {350,50,200}, {350,150,100}, {350,150,200},
                {450,50,100}, {450,50,200}, {450,150,100}, {450,150,200}
        };

        double[][] shapeL = new double[][]{
                {50,50,100}, {150,50,100}, {150,50,200}, {50,50,200},
                {50,150,100}, {150,150,100}, {150,150,200}, {50,150,200},
                {250,50,100}, {250,50,200}, {250,150,100}, {250,150,200},
                {350,50,100}, {350,50,200}, {350,150,100}, {350,150,200},
                {250,50,0}, {250,150,0}, {350,50,0}, {350,150,0}
        };
        //RotatingL cube3 = new RotatingL(v, shapeL, new Color(255, 255, 255), 200, 200, 1, 1, 4);
        RotatingI cube3 = new RotatingI(v, shapeI, new Color(255, 255, 255), 0, 100, 2, 2, 1);
        cube3.traslating(cont1);
        cube3.scaling(1,2,2);
        cube3.projecting();
        cube3.drawFigure();

        double[][] shape1 = new double[][]{
                {50, 0, 0}, {0, 30, 0}, {-50, 0, 0}, {0, -30, 0}, // Base
                {50, 0, 100}, {0, 30, 100}, {-50, 0, 100}, {0, -30, 100} // Parte superior
        };

        double[][] shape2 = new double[][]{
                {150, 50, 100}, {146.19, 50, 119.13}, {135.36, 50, 135.36}, {119.13, 50, 146.19}, {100, 50, 150},
                {80.87, 50, 146.19}, {64.64, 50, 135.36}, {53.81, 50, 119.13}, {50, 50, 100}, {53.81, 50, 80.87},
                {64.64, 50, 64.64}, {80.87, 50, 53.81}, {100, 50, 50}, {119.13, 50, 53.81}, {135.36, 50, 64.64},
                {146.19, 50, 80.87}, {150, 80, 100}, {146.19, 80, 119.13}, {135.36, 80, 135.36}, {119.13, 80, 146.19},
                {100, 80, 150}, {80.87, 80, 146.19}, {64.64, 80, 135.36}, {53.81, 80, 119.13}, {50, 80, 100},
                {53.81, 80, 80.87}, {64.64, 80, 64.64}, {80.87, 80, 53.81}, {100, 80, 50}, {119.13, 80, 53.81},
                {135.36, 80, 64.64}, {146.19, 80, 80.87},
        };

        Rhomboid rhomboid = new Rhomboid(v, shape1, new Color(255,255,255), 200, 200, 0, 1.5, 2);
        rhomboid.traslating(cont1);
        rhomboid.scaling(1.2, 1.2, 1.2);
        rhomboid.drawFigure();

        Nut nut = new Nut(v, shape2, new Color(255,255,255), 300, 200, 1, 2, 4);
        nut.traslating(cont1);
        nut.scaling(1.2, 1.2, 1.2);
        nut.drawFigure();

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
                {450, 225, 50},
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
        tcube2.setPosXYZ(0,500,0);
        tcube2.setSpeedXYZ(0,0,30);
        tcube2.traslating(cont1);
        tcube2.projecting();
        //tcube2.drawFigure(false);
    }
}
