package model;

import view.FrameView;

import java.awt.*;
import java.util.ArrayList;

public class Cube extends Figure{

    public Cube(FrameView view, double[][] figurePoints, Color border) {
        super(view, figurePoints, border);
    }

    public Cube(FrameView view, double[][] figurePoints, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        super(view, figurePoints, border, positionX, positionY, xp, yp, zp);
    }

    @Override
    public void drawFigure() {
        view.drawDDALine((int) super.figurePoints[0][0] + positionX, (int) super.figurePoints[0][1] + positionY, (int) super.figurePoints[1][0] + positionX, (int) super.figurePoints[1][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[1][0] + positionX, (int) super.figurePoints[1][1] + positionY, (int) super.figurePoints[2][0] + positionX, (int) super.figurePoints[2][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[2][0] + positionX, (int) super.figurePoints[2][1] + positionY, (int) super.figurePoints[3][0] + positionX, (int) super.figurePoints[3][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[3][0] + positionX, (int) super.figurePoints[3][1] + positionY, (int) super.figurePoints[0][0] + positionX, (int) super.figurePoints[0][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[0][0] + positionX, (int) super.figurePoints[0][1] + positionY, (int) super.figurePoints[4][0] + positionX, (int) super.figurePoints[4][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[1][0] + positionX, (int) super.figurePoints[1][1] + positionY, (int) super.figurePoints[5][0] + positionX, (int) super.figurePoints[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[3][0] + positionX, (int) super.figurePoints[3][1] + positionY, (int) super.figurePoints[7][0] + positionX, (int) super.figurePoints[7][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[2][0] + positionX, (int) super.figurePoints[2][1] + positionY, (int) super.figurePoints[6][0] + positionX, (int) super.figurePoints[6][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[4][0] + positionX, (int) super.figurePoints[4][1] + positionY, (int) super.figurePoints[5][0] + positionX, (int) super.figurePoints[5][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[5][0] + positionX, (int) super.figurePoints[5][1] + positionY, (int) super.figurePoints[6][0] + positionX, (int) super.figurePoints[6][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[6][0] + positionX, (int) super.figurePoints[6][1] + positionY, (int) super.figurePoints[7][0] + positionX, (int) super.figurePoints[7][1] + positionY, super.border);
        view.drawDDALine((int) super.figurePoints[7][0] + positionX, (int) super.figurePoints[7][1] + positionY, (int) super.figurePoints[4][0] + positionX, (int) super.figurePoints[4][1] + positionY, super.border);
    }
}
