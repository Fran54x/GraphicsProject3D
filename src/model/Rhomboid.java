package model;

import view.FrameView;

import javax.swing.text.View;
import java.awt.*;
import java.util.Arrays;

public class Rhomboid extends Figure {

    public Rhomboid (FrameView view){
        super(view);
    }

    public Rhomboid (FrameView view, double[][] figurePoints3D, Color border) {
        super(view, figurePoints3D, border);
    }

    public Rhomboid (FrameView view, double[][] figurePoints2D, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        super(view, figurePoints2D, border, positionX, positionY, xp, yp, zp);
    }

    @Override
    public void drawFigure() {

        double[][] gemPoints = this.figurePoints2D.clone();

        // Base
        view.drawDDALine((int) gemPoints[0][0] + positionX, (int) gemPoints[0][1] + positionY, (int) gemPoints[1][0] + positionX, (int) gemPoints[1][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[1][0] + positionX, (int) gemPoints[1][1] + positionY, (int) gemPoints[2][0] + positionX, (int) gemPoints[2][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[2][0] + positionX, (int) gemPoints[2][1] + positionY, (int) gemPoints[3][0] + positionX, (int) gemPoints[3][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[3][0] + positionX, (int) gemPoints[3][1] + positionY, (int) gemPoints[0][0] + positionX, (int) gemPoints[0][1] + positionY, super.border);
// Parte superior
        view.drawDDALine((int) gemPoints[4][0] + positionX, (int) gemPoints[4][1] + positionY, (int) gemPoints[5][0] + positionX, (int) gemPoints[5][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[5][0] + positionX, (int) gemPoints[5][1] + positionY, (int) gemPoints[6][0] + positionX, (int) gemPoints[6][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[6][0] + positionX, (int) gemPoints[6][1] + positionY, (int) gemPoints[7][0] + positionX, (int) gemPoints[7][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[7][0] + positionX, (int) gemPoints[7][1] + positionY, (int) gemPoints[4][0] + positionX, (int) gemPoints[4][1] + positionY, super.border);

// Conexiones verticales(int)
        view.drawDDALine((int) gemPoints[0][0] + positionX, (int) gemPoints[0][1] + positionY, (int) gemPoints[4][0] + positionX, (int) gemPoints[4][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[1][0] + positionX, (int) gemPoints[1][1] + positionY, (int) gemPoints[5][0] + positionX, (int) gemPoints[5][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[2][0] + positionX, (int) gemPoints[2][1] + positionY, (int) gemPoints[6][0] + positionX, (int) gemPoints[6][1] + positionY, super.border);
        view.drawDDALine((int) gemPoints[3][0] + positionX, (int) gemPoints[3][1] + positionY, (int) gemPoints[7][0] + positionX, (int) gemPoints[7][1] + positionY, super.border);

        for(int i = 0; i < figurePoints2D.length; i++){
            if(i != (figurePoints2D.length-1)){
                view.drawDDALine((int) super.figurePoints2D[i][0] + positionX, (int) super.figurePoints2D[i][1] + positionY, (int) super.figurePoints2D[i+1][0] + positionX, (int) super.figurePoints2D[i+1][1] + positionY, super.border);
            }
            else {
                view.drawDDALine((int) super.figurePoints2D[i][0] + positionX, (int) super.figurePoints2D[i][1] + positionY, (int) super.figurePoints2D[0][0] + positionX, (int) super.figurePoints2D[0][1] + positionY, super.border);
            }
        }

        Color deepGreen = new Color(23, 124, 21);
        Color greenLight = new Color(29, 174, 27);

        for(int i = 0; i < figurePoints2D.length; i++){
            figurePoints2D[i][0] += positionX;
            figurePoints2D[i][1] += positionY;
        }
        view.drawFillPolygon(figurePoints2D, deepGreen);

        double[][] details = {
                {figurePoints2D[0][0], figurePoints2D[0][1]}, {figurePoints2D[1][0], figurePoints2D[1][1]},
                {figurePoints2D[1][0], figurePoints2D[1][1]}, {figurePoints2D[2][0], figurePoints2D[2][1]},
                {figurePoints2D[2][0], figurePoints2D[2][1]}, {figurePoints2D[3][0], figurePoints2D[3][1]},
                {figurePoints2D[3][0], figurePoints2D[3][1]}, {figurePoints2D[0][0], figurePoints2D[0][1]}
        };
        view.drawFillPolygon(details, greenLight);
    }

}
