package model;

import view.FrameView;

import java.awt.*;

public class StaticCube extends Figure{

    public StaticCube(FrameView view){
        super(view);
    }

    public StaticCube(FrameView view, double[][] figurePoints2D, Color border) {
        super(view, figurePoints2D, border);
    }

    public StaticCube(FrameView view, double[][] figurePoints2D, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        super(view, figurePoints2D, border, positionX, positionY, xp, yp, zp);
    }

    @Override
    public void drawFigure() {
        view.drawDDALine((int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, (int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, (int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, (int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, (int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, (int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[1][0] + positionX, (int) super.figurePoints2D[1][1] + positionY, (int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[3][0] + positionX, (int) super.figurePoints2D[3][1] + positionY, (int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[2][0] + positionX, (int) super.figurePoints2D[2][1] + positionY, (int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, super.border);

        view.drawDDALine((int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, (int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[5][0] + positionX, (int) super.figurePoints2D[5][1] + positionY, (int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[6][0] + positionX, (int) super.figurePoints2D[6][1] + positionY, (int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints2D[7][0] + positionX, (int) super.figurePoints2D[7][1] + positionY, (int) super.figurePoints2D[4][0] + positionX, (int) super.figurePoints2D[4][1] + positionY, super.border);

        //faces
        Color darkBlue = new Color(14, 17, 36);
        Color purple = new Color(132, 66, 195);
        Color lowBlue = new Color(76, 124, 245);
        Color deepBlue = new Color(11, 93, 222);

        //face 1 (Bottom)
        double[][] face1 = {{super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[1][0], super.figurePoints2D[1][1]},
                {super.figurePoints2D[1][0], super.figurePoints2D[1][1]}, {super.figurePoints2D[2][0], super.figurePoints2D[2][1]},
                {super.figurePoints2D[2][0], super.figurePoints2D[2][1]}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]},
                {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face1[i][0] += positionX;
            face1[i][1] += positionY;
        }
        //view.drawFillPolygon(face1, deepBlue);

        //face 2 (Left)
        double[][] face2 = {{super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]},
                {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[4][0], super.figurePoints2D[4][1]},
                {super.figurePoints2D[4][0], super.figurePoints2D[4][1]}, {super.figurePoints2D[7][0], super.figurePoints2D[7][1]},
                {super.figurePoints2D[7][0], super.figurePoints2D[7][1]}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face2[i][0] += positionX;
            face2[i][1] += positionY;
        }
        //view.drawFillPolygon(face2, lowBlue);

        //face 3 (Front)
        double[][] face3 = {{super.figurePoints2D[2][0], super.figurePoints2D[2][1]}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]},
                {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[7][0], super.figurePoints2D[7][1]},
                {super.figurePoints2D[7][0], super.figurePoints2D[7][1]}, {super.figurePoints2D[6][0], super.figurePoints2D[6][1]},
                {super.figurePoints2D[6][0], super.figurePoints2D[6][1]}, {super.figurePoints2D[2][0], super.figurePoints2D[2][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face3[i][0] += positionX;
            face3[i][1] += positionY;
        }
        //view.drawFillPolygon(face3, lowBlue);

        //face 4 (Right)
        double[][] face4 = {{super.figurePoints2D[1][0], super.figurePoints2D[1][1]}, {super.figurePoints2D[2][0], super.figurePoints2D[2][1]},
                {super.figurePoints2D[2][0], super.figurePoints2D[2][1]}, {super.figurePoints2D[6][0], super.figurePoints2D[6][1]},
                {super.figurePoints2D[6][0], super.figurePoints2D[6][1]}, {super.figurePoints2D[5][0], super.figurePoints2D[5][1]},
                {super.figurePoints2D[5][0], super.figurePoints2D[5][1]}, {super.figurePoints2D[1][0], super.figurePoints2D[1][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face4[i][0] += positionX;
            face4[i][1] += positionY;
        }
        //view.drawFillPolygon(face4, lowBlue);

        //face 5 (Back)
        double[][] face5 = {{super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[1][0], super.figurePoints2D[1][1]},
                {super.figurePoints2D[1][0], super.figurePoints2D[1][1]}, {super.figurePoints2D[5][0], super.figurePoints2D[5][1]},
                {super.figurePoints2D[5][0], super.figurePoints2D[5][1]}, {super.figurePoints2D[4][0], super.figurePoints2D[4][1]},
                {super.figurePoints2D[4][0], super.figurePoints2D[4][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face5[i][0] += positionX;
            face5[i][1] += positionY;
        }
        //view.drawFillPolygon(face5, lowBlue);

        //face 6 (Top)
        double[][] face6 = {{super.figurePoints2D[4][0], super.figurePoints2D[4][1]}, {super.figurePoints2D[5][0], super.figurePoints2D[5][1]},
                {super.figurePoints2D[5][0], super.figurePoints2D[5][1]}, {super.figurePoints2D[6][0], super.figurePoints2D[6][1]},
                {super.figurePoints2D[6][0], super.figurePoints2D[6][1]}, {super.figurePoints2D[7][0], super.figurePoints2D[7][1]},
                {super.figurePoints2D[7][0], super.figurePoints2D[7][1]}, {super.figurePoints2D[4][0], super.figurePoints2D[4][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            face6[i][0] += positionX;
            face6[i][1] += positionY;
        }
        //view.drawFillPolygon(face6, darkBlue);

        //details
        //double lineDeepBlue
        //face 2 detail
        double[][] detailLineFace2 = {{super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[0][0], super.figurePoints2D[0][1]},
                {super.figurePoints2D[0][0], super.figurePoints2D[0][1]}, {super.figurePoints2D[4][0], accommodateMaskPosition(figurePoints2D[4][1], figurePoints2D[0][1], 4)},
                {super.figurePoints2D[4][0], accommodateMaskPosition(figurePoints2D[4][1], figurePoints2D[0][1], 4)}, {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)},
                {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            detailLineFace2[i][0] += positionX;
            detailLineFace2[i][1] += positionY;
        }
        view.drawPolygon(detailLineFace2, deepBlue);

        //face 2 detail
        double[][] detailLineFace3 = {{super.figurePoints2D[2][0], super.figurePoints2D[2][1]}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]},
                {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}, {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[0][1], 4)},
                {super.figurePoints2D[4][0], accommodateMaskPosition(figurePoints2D[4][1], figurePoints2D[0][1], 4)}, {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)},
                {super.figurePoints2D[7][0], accommodateMaskPosition(figurePoints2D[7][1], figurePoints2D[3][1], 4)}, {super.figurePoints2D[3][0], super.figurePoints2D[3][1]}};
        for (int i = 0; i < 8; i++) { //accommodate mask position
            detailLineFace2[i][0] += positionX;
            detailLineFace2[i][1] += positionY;
        }
        view.drawPolygon(detailLineFace2, deepBlue);

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
