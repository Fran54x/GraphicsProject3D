package model;

import view.FrameView;

import java.awt.*;

public class TranslatedCube extends Figure{
    public TranslatedCube(FrameView view){
        super(view);
    }

    public TranslatedCube(FrameView view, double[][] figurePoints3D, Color border) {
        super(view, figurePoints3D, border);
    }

    public TranslatedCube(FrameView view, double[][] figurePoints2D, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        super(view, figurePoints2D, border, positionX, positionY, xp, yp, zp);
    }

    @Override
    public void drawFigure() {
        view.drawDDALine((int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY,
                (int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY,
                (int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY,
                (int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY,
                (int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY,
                (int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY,
                (int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY,
                (int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY,
                (int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY,
                (int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY,
                (int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY,
                (int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY,
                (int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY,
                (int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY,
                (int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY,
                (int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY,
                (int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, (int) super.figurePoints2D[8][0] + positionX, (int) super.figurePoints2D[8][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, (int) super.figurePoints2D[9][0] + positionX, (int) super.figurePoints2D[9][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, (int) super.figurePoints2D[10][0] + positionX, (int) super.figurePoints2D[10][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, (int) super.figurePoints2D[11][0] + positionX, (int) super.figurePoints2D[11][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, (int) super.figurePoints2D[12][0] + positionX, (int) super.figurePoints2D[12][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, (int) super.figurePoints2D[13][0] + positionX, (int) super.figurePoints2D[13][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, (int) super.figurePoints2D[14][0] + positionX, (int) super.figurePoints2D[14][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, (int) super.figurePoints2D[15][0] + positionX, (int) super.figurePoints2D[15][1] + positionY, super.border);


        //faces
        Color yellow = new Color(206, 169, 50);
        Color obscureyellow = new Color(180, 145, 34);
        Color orange = new Color(195, 105, 66);
        Color white = new Color(255, 255, 255);
        Color deepBlue = new Color(11, 93, 222);
        //face 4 (Left)
        double[][] face4 = {{super.figurePoints2D[12][0], super.figurePoints2D[12][1]}, {super.figurePoints2D[13][0], super.figurePoints2D[13][1]},
                {super.figurePoints2D[13][0], super.figurePoints2D[13][1]}, {super.figurePoints2D[5][0], super.figurePoints2D[5][1]},
                {super.figurePoints2D[5][0], super.figurePoints2D[5][1]}, {super.figurePoints2D[4][0], super.figurePoints2D[4][1]},
                {super.figurePoints2D[4][0], super.figurePoints2D[4][1]}, {super.figurePoints2D[12][0], super.figurePoints2D[12][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face4[i][0] += positionX;
            face4[i][1] += positionY;
        }
        view.drawFillPolygon(face4, obscureyellow);
        //face 1 (Bottom)
        double[][] face1 = {
                {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[1][0], super.figurePoints2D[1][1]},
                {super.figurePoints2D[1][0], super.figurePoints2D[1][1]}, {super.figurePoints2D[2][0], super.figurePoints2D[2][1]},
                {super.figurePoints2D[2][0], super.figurePoints2D[2][1]}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]},
                {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[4][0], super.figurePoints2D[4][1]},
                {super.figurePoints2D[4][0], super.figurePoints2D[4][1]}, {super.figurePoints2D[5][0], super.figurePoints2D[5][1]},
                {super.figurePoints2D[5][0], super.figurePoints2D[5][1]}, {super.figurePoints2D[6][0], super.figurePoints2D[6][1]},
                {super.figurePoints2D[6][0], super.figurePoints2D[6][1]}, {super.figurePoints2D[7][0], super.figurePoints2D[7][1]},
                {super.figurePoints2D[7][0], super.figurePoints2D[7][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}
        };
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face1[i][0] += positionX;
            face1[i][1] += positionY;
        }
        view.drawFillPolygon(face1, yellow);

        //face 2 (Right)
        double[][] face2 = {{super.figurePoints2D[8][0], super.figurePoints2D[8][1]}, {super.figurePoints2D[15][0], super.figurePoints2D[15][1]},
                {super.figurePoints2D[15][0], super.figurePoints2D[15][1]}, {super.figurePoints2D[7][0], super.figurePoints2D[7][1]},
                {super.figurePoints2D[7][0], super.figurePoints2D[7][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]},
                {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[8][0], super.figurePoints2D[8][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face2[i][0] += positionX;
            face2[i][1] += positionY;
        }
        view.drawFillPolygon(face2, obscureyellow);
//
        //face 3 (Front)
        double[][] face3 = {{super.figurePoints2D[14][0], super.figurePoints2D[14][1]}, {super.figurePoints2D[15][0], super.figurePoints2D[15][1]},
                {super.figurePoints2D[15][0], super.figurePoints2D[15][1]}, {super.figurePoints2D[7][0], super.figurePoints2D[7][1]},
                {super.figurePoints2D[7][0], super.figurePoints2D[7][1]}, {super.figurePoints2D[6][0], super.figurePoints2D[6][1]},
                {super.figurePoints2D[6][0], super.figurePoints2D[6][1]}, {super.figurePoints2D[14][0], super.figurePoints2D[14][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face3[i][0] += positionX;
            face3[i][1] += positionY;
        }
        view.drawFillPolygon(face3, obscureyellow);
//

//
        //face 5 (Back)
//        double[][] face5 = {{super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[1][0], super.figurePoints2D[1][1]},
//                {super.figurePoints2D[1][0], super.figurePoints2D[1][1]}, {super.figurePoints2D[5][0], super.figurePoints2D[5][1]},
//                {super.figurePoints2D[5][0], super.figurePoints2D[5][1]}, {super.figurePoints2D[4][0], super.figurePoints2D[4][1]},
//                {super.figurePoints2D[4][0], super.figurePoints2D[4][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}};
//        for (int i = 0; i < 8; i++) { //accommodate mask position
//            face5[i][0] += positionX;
//            face5[i][1] += positionY;
//        }
//        view.drawFillPolygon(face5, white);
//
        //face 6 (Top)
        double[][] face6 = {{super.figurePoints2D[8][0], super.figurePoints2D[8][1]}, {super.figurePoints2D[9][0], super.figurePoints2D[9][1]},
                {super.figurePoints2D[9][0], super.figurePoints2D[9][1]}, {super.figurePoints2D[10][0], super.figurePoints2D[10][1]},
                {super.figurePoints2D[10][0], super.figurePoints2D[10][1]}, {super.figurePoints2D[11][0], super.figurePoints2D[11][1]},
                {super.figurePoints2D[11][0], super.figurePoints2D[11][1]}, {super.figurePoints2D[12][0], super.figurePoints2D[12][1]},
                {super.figurePoints2D[12][0], super.figurePoints2D[12][1]}, {super.figurePoints2D[13][0], super.figurePoints2D[13][1]},
                {super.figurePoints2D[13][0], super.figurePoints2D[13][1]}, {super.figurePoints2D[14][0], super.figurePoints2D[14][1]},
                {super.figurePoints2D[14][0], super.figurePoints2D[14][1]}, {super.figurePoints2D[15][0], super.figurePoints2D[15][1]},
                {super.figurePoints2D[15][0], super.figurePoints2D[15][1]}, {super.figurePoints2D[8][0], super.figurePoints2D[8][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face6[i][0] += positionX;
            face6[i][1] += positionY;
        }
        view.drawFillPolygon(face6, yellow);
//
//        //details
//        //double lineDeepBlue
//        //face 2 detail
//        double[][] detailLineFace2 = {{super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]},
//                {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[4][0], accommodateMaskPosition(figurePoints2D[4][1], figurePoints2D[0][1], 4)},
//                {super.figurePoints2D[4][0], accommodateMaskPosition(figurePoints2D[4][1], figurePoints2D[0][1], 4)}, {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)},
//                {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}};
//        for (int i = 0; i < 8; i++) { //accommodate mask position
//            detailLineFace2[i][0] += positionX;
//            detailLineFace2[i][1] += positionY;
//        }
//        view.drawPolygon(detailLineFace2, deepBlue);
//
//        //face 2 detail
//        double[][] detailLineFace3 = {{super.figurePoints2D[2][0], super.figurePoints2D[2][1]}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]},
//                {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[0][1], 4)},
//                {super.figurePoints2D[4][0], accommodateMaskPosition(figurePoints2D[4][1], figurePoints2D[0][1], 4)}, {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)},
//                {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}};
//        for (int i = 0; i < 8; i++) { //accommodate mask position
//            detailLineFace2[i][0] += positionX;
//            detailLineFace2[i][1] += positionY;
//        }
//        view.drawPolygon(detailLineFace2, deepBlue);

        //RAYO MQUIIN CUCHAO
//        double[][] detailLineFace2prueba = {{super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]},
//                {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[5][0], (figurePoints2D[5][1])},
//                {super.figurePoints2D[5][0], (figurePoints2D[5][1])}, {super.figurePoints2D[6][0], (figurePoints2D[6][1])},
//                {super.figurePoints2D[6][0], (figurePoints2D[6][1])}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}};
//        for (int i = 0; i < 4; i++) { //accommodate mask position
//            detailLineFace2prueba[i][0] += positionX;
//            detailLineFace2prueba[i][1] += positionY;
//        }
//        view.drawPolygon(detailLineFace2prueba, deepBlue);
    }

    public double accommodateMaskPosition(double highestPoint, double lowestPoint, int divisor) {
        highestPoint = ((highestPoint - lowestPoint) / divisor) + lowestPoint;
        return highestPoint;
    }
}
