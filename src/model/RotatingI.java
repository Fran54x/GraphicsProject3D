package model;

import view.FrameView;

import java.awt.*;

public class RotatingI extends Figure {

    public RotatingI(FrameView view){
        super(view);
    }

    public RotatingI(FrameView view, double[][] figurePoints2D, Color border) {
        super(view, figurePoints2D, border);
    }

    public RotatingI(FrameView view, double[][] figurePoints2D, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        super(view, figurePoints2D, border, positionX, positionY, xp, yp, zp);
    }

    public void drawFigure() {
        // Bloque 1
        view.drawDDALine((int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, (int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, (int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, (int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, (int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, (int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, (int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, (int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, (int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, (int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, (int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, (int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, (int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, (int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, (int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, (int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, (int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY, super.border);

// Bloque 2
        view.drawDDALine((int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY, (int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY, (int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY, (int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY, (int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY, (int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY, (int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY, (int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY, (int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY, (int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY, (int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY, (int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY, (int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY, super.border);

// Bloque 3
        view.drawDDALine((int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY, (int) super.figurePoints2D[16][0] + positionX, (int) super.figurePoints2D[16][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY, (int) super.figurePoints2D[19][0] + positionX, (int) super.figurePoints2D[19][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[18][0] + positionX, (int) super.figurePoints2D[18][1] + positionY, (int) super.figurePoints2D[19][0] + positionX, (int) super.figurePoints2D[19][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[18][0] + positionX, (int) super.figurePoints2D[18][1] + positionY, (int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[16][0] + positionX, (int) super.figurePoints2D[16][1] + positionY, (int) super.figurePoints2D[17][0] + positionX, (int) super.figurePoints2D[17][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[16][0] + positionX, (int) super.figurePoints2D[16][1] + positionY, (int) super.figurePoints2D[18][0] + positionX, (int) super.figurePoints2D[18][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY, (int) super.figurePoints2D[17][0] + positionX, (int) super.figurePoints2D[17][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[19][0] + positionX, (int) super.figurePoints2D[19][1] + positionY, (int) super.figurePoints2D[17][0] + positionX, (int) super.figurePoints2D[17][1] + positionY, super.border);

        //color
        Color skyBlue = new Color(56, 176, 255);
        Color darkBlue = new Color(6, 59, 128);
        //Color orange = new Color(182, 84, 36);
        //Color lowOrange = new Color(222, 186, 179);
        Color white = new Color(255, 255, 255);



        double[][] f1 = new double[][]{
                {figurePoints2D[0][0], figurePoints2D[0][1]}, {figurePoints2D[16][0], figurePoints2D[16][1]},
                {figurePoints2D[16][0], figurePoints2D[16][1]}, {figurePoints2D[18][0], figurePoints2D[18][1]},
                {figurePoints2D[18][0], figurePoints2D[18][1]}, {figurePoints2D[4][0], figurePoints2D[4][1]},
                {figurePoints2D[4][0], figurePoints2D[4][1]}, {figurePoints2D[0][0], figurePoints2D[0][1]},
        };
        for (int i = 0; i < f1.length; i++) { //accommodate mask position
            f1[i][0] += positionX;
            f1[i][1] += positionY;
        }
        view.drawFillPolygon(f1, darkBlue);

        double[][] f2 = new double[][]{
                {figurePoints2D[4][0], figurePoints2D[4][1]}, {figurePoints2D[18][0], figurePoints2D[18][1]},
                {figurePoints2D[18][0], figurePoints2D[18][1]}, {figurePoints2D[19][0], figurePoints2D[19][1]},
                {figurePoints2D[19][0], figurePoints2D[19][1]}, {figurePoints2D[7][0], figurePoints2D[7][1]},
                {figurePoints2D[7][0], figurePoints2D[7][1]}, {figurePoints2D[4][0], figurePoints2D[4][1]},
        };
        for (int i = 0; i < f2.length; i++) { //accommodate mask position
            f2[i][0] += positionX;
            f2[i][1] += positionY;
        }
        view.drawFillPolygon(f2, darkBlue);

        double[][] f3 = new double[][]{
                {figurePoints2D[7][0], figurePoints2D[7][1]}, {figurePoints2D[19][0], figurePoints2D[19][1]},
                {figurePoints2D[19][0], figurePoints2D[19][1]}, {figurePoints2D[17][0], figurePoints2D[17][1]},
                {figurePoints2D[17][0], figurePoints2D[17][1]}, {figurePoints2D[3][0], figurePoints2D[3][1]},
                {figurePoints2D[3][0], figurePoints2D[3][1]}, {figurePoints2D[7][0], figurePoints2D[7][1]},
        };
        for (int i = 0; i < f3.length; i++) { //accommodate mask position
            f3[i][0] += positionX;
            f3[i][1] += positionY;
        }
        view.drawFillPolygon(f3, darkBlue);

        double[][] f4 = new double[][]{
                {figurePoints2D[0][0], figurePoints2D[0][1]}, {figurePoints2D[3][0], figurePoints2D[3][1]},
                {figurePoints2D[3][0], figurePoints2D[3][1]}, {figurePoints2D[17][0], figurePoints2D[17][1]},
                {figurePoints2D[17][0], figurePoints2D[17][1]}, {figurePoints2D[16][0], figurePoints2D[16][1]},
                {figurePoints2D[16][0], figurePoints2D[16][1]}, {figurePoints2D[0][0], figurePoints2D[0][1]},
        };
        for (int i = 0; i < f4.length; i++) { //accommodate mask position
            f4[i][0] += positionX;
            f4[i][1] += positionY;
        }
        view.drawFillPolygon(f4, skyBlue);

        double[][] f5 = new double[][]{
                {figurePoints2D[0][0], figurePoints2D[0][1]}, {figurePoints2D[3][0], figurePoints2D[3][1]},
                {figurePoints2D[3][0], figurePoints2D[3][1]}, {figurePoints2D[7][0], figurePoints2D[7][1]},
                {figurePoints2D[7][0], figurePoints2D[7][1]}, {figurePoints2D[4][0], figurePoints2D[4][1]},
                {figurePoints2D[4][0], figurePoints2D[4][1]}, {figurePoints2D[0][0], figurePoints2D[0][1]},
        };
        for (int i = 0; i < f5.length; i++) { //accommodate mask position
            f5[i][0] += positionX;
            f5[i][1] += positionY;
        }
        view.drawFillPolygon(f5, skyBlue);

        double[][] f6 = new double[][]{
                {figurePoints2D[16][0], figurePoints2D[16][1]}, {figurePoints2D[17][0], figurePoints2D[17][1]},
                {figurePoints2D[17][0], figurePoints2D[17][1]}, {figurePoints2D[19][0], figurePoints2D[19][1]},
                {figurePoints2D[19][0], figurePoints2D[19][1]}, {figurePoints2D[18][0], figurePoints2D[18][1]},
                {figurePoints2D[18][0], figurePoints2D[18][1]}, {figurePoints2D[16][0], figurePoints2D[16][1]},
        };
        for (int i = 0; i < f6.length; i++) { //accommodate mask position
            f6[i][0] += positionX;
            f6[i][1] += positionY;
        }
        view.drawFillPolygon(f6, skyBlue);
    }
}