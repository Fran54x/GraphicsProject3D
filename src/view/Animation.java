package view;

import model.Cube;
import model.OperationCalculations;

import java.awt.*;

public class Animation {

    //attributes
    public FrameView view;
    public double frame;
    public double scaleX;
    public double scaleY;

    public Boolean limit = false;
    public double cont1;
    public double cont2;
    public int alpha;

    public Animation(FrameView view) {
        this.view = view;
        this.frame = 0;
        this.scaleX = 0;
        this.scaleY = 0;
        this.cont1 = 0;
        this.cont2 = 0;
        this.alpha = 0;
    }

    public void menuGame(){
        Color white = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);
        Color dark_blue = new Color(7, 18, 76);
        Color red = new Color(255, 0, 0);
        Color light_blue = new Color(7, 122, 214);

        frame+=0.003;
        scaleX+=0.003;
        scaleY+=0.003;
        cont1-=0.02;
        cont2+=0.01;

        double[][] c1 = {{50,50,50}, {150,50,50}, {150,50,150}, {50,50,150} ,{50,150,50}, {150,150,50}, {150,150,150}, {50,150,150}};
        Cube cube1 = new Cube(view, c1, white, 300, 150, cont1, cont2, 3);

        double[][] c2 = {{50,50,50}, {150,50,50}, {150,50,150}, {50,50,150} ,{50,150,50}, {150,150,50}, {150,150,150}, {50,150,150}};
        Cube cube2 = new Cube(view, c2, red, -20, 300, cont1, cont2, 3);

        double[][] c3 = {{50,50,50}, {150,50,50}, {150,50,150}, {50,50,150} ,{50,150,50}, {150,150,50}, {150,150,150}, {50,150,150}};
        Cube cube3 = new Cube(view, c2, red, 380, 360, cont1, cont2, 3);

        if(cont1 < 1.5 && cont2 < 3 && limit == false){
            if(alpha < 255) {
                alpha += 1;
            }

            cube1.setBorder(new Color(alpha, 18, 76));
            cube1.scaling(0.6, 0.6);
            cube1.drawFigure();

            cube1.setPositionX(10);
            cube1.setPositionY(500);
            cube1.scaling(0.6, 0.6);
            cube1.drawFigure();

            cube2.setBorder(new Color(7, alpha, 76));
            cube2.scaling(0.4, 0.4);
            cube2.drawFigure();

            cube2.setPositionX(250);
            cube2.setPositionY(240);
            cube2.setBorder(new Color(7, alpha, 76));
            cube2.scaling(0.2, 0.2);
            cube2.drawFigure();

            cube3.setBorder(new Color(7, 18, alpha));
            cube3.scaling(0.5, 0.5);
            cube3.drawFigure();

        } else {
            limit = true;
            if(alpha > 8) {
                alpha -= 1;
            }

            cube1 = new Cube(view, c1, new Color(alpha, 18, 76), 300, 150, cont1, cont2, 3);
            cube1.scaling(0.6, 0.6);
            cube1.drawFigure();

            cube1.setPositionX(10);
            cube1.setPositionY(500);
            cube1.scaling(0.6, 0.6);
            cube1.drawFigure();

            cube2.setBorder(new Color(7, alpha, 76));
            cube2.scaling(0.4, 0.4);
            cube2.drawFigure();

            cube2.setPositionX(cube2.getPositionX());
            cube2.setPositionY(cube2.getPositionY());
            cube2.setBorder(new Color(7, alpha, 76));
            cube2.scaling(0.2, 0.2);
            cube2.drawFigure();

            cube3.setBorder(new Color(7, 18, alpha));
            cube3.scaling(0.4, 0.4);
            cube3.drawFigure();
        }
    }
}
