package model;

import view.FrameView;

import java.awt.*;
import java.util.Arrays;

public class Nut extends Figure {

    public Nut(FrameView view){
        super(view);
    }

    public Nut(FrameView view, double[][] figurePoints3D, Color border) {
        super(view, figurePoints3D, border);
    }

    public Nut(FrameView view, double[][] figurePoints2D, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        super(view, figurePoints2D, border, positionX, positionY, xp, yp, zp);
    }

    @Override
    public void drawFigure() {

        for(int i = 0; i < figurePoints2D.length; i++){
            if(i != (figurePoints2D.length-1)){
                view.drawDDALine((int) super.figurePoints2D[i][0] + positionX, (int) super.figurePoints2D[i][1] + positionY, (int) super.figurePoints2D[i+1][0] + positionX, (int) super.figurePoints2D[i+1][1] + positionY, super.border);
            }
            else {
                view.drawDDALine((int) super.figurePoints2D[i][0] + positionX, (int) super.figurePoints2D[i][1] + positionY, (int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, super.border);
            }
        }

        int midpoint = figurePoints2D.length / 2;

        double[][] firstHalf = Arrays.copyOfRange(figurePoints2D, 0, midpoint);
        double[][] secondHalf = Arrays.copyOfRange(figurePoints2D, midpoint, figurePoints2D.length);

        Color brown = new Color(214, 155, 47);

        for (int j = 0; j < firstHalf.length; j++) { //accommodate mask position
            firstHalf[j][0] += positionX;
            firstHalf[j][1] += positionY;
            secondHalf[j][0] += positionX;
            secondHalf[j][1] += positionY;
        }
        view.drawFillPolygon(firstHalf, new Color(172, 130, 44));
        view.drawPolygon(firstHalf, new Color(92, 70, 26));
        view.drawFillPolygon(secondHalf, brown);
        view.drawPolygon(secondHalf, new Color(92, 70, 26));
        view.drawPolygon(firstHalf, new Color(92, 70, 26));

        for (int j = 0; j < firstHalf.length; j++) { //accommodate mask position
            firstHalf[j][0] -= positionX;
            firstHalf[j][1] -= positionY;
            secondHalf[j][0] -= positionX;
            secondHalf[j][1] -= positionY;
        }

        for (int i = 0; i < firstHalf.length ; i++) {
            view.drawDDALine((int) firstHalf[i][0] + positionX, (int) firstHalf[i][1] + positionY, (int) secondHalf[i][0] + positionX, (int) secondHalf[i][1] + positionY, new Color(92, 70, 26));
        }

    }

}
