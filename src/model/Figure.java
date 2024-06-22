package model;

import view.FrameView;

import java.awt.*;
import java.lang.annotation.Inherited;

public abstract class Figure {

    protected double[][] figurePoints;
    protected Color border;
    protected Color background;
    protected int positionX;
    protected int positionY;
    protected FrameView view;

    protected double[][] traslatingPoints;
    protected double[][] scalingPoints;
    protected double[][] rotatingPoints;
    OperationCalculations operation;

    public Figure(FrameView view, double[][] figurePoints, Color border) {
        this.operation = new OperationCalculations(0, 0, 1, figurePoints);
        this.figurePoints = operation.getProjectedPoints();
        this.view = view;
        this.border = border;
    }

    public Figure(FrameView view, double[][] figurePoints, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        this.operation = new OperationCalculations(xp, yp, zp, figurePoints);
        this.figurePoints = operation.getProjectedPoints();
        this.view = view;
        this.border = border;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Figure(FrameView view, double[][] figurePoints, Color border, Color background, int positionX, int positionY, double xp, double yp, double zp) {
        this.operation = new OperationCalculations(0, 0, 0, figurePoints);
        this.figurePoints = operation.getProjectedPoints();
        this.view = view;
        this.figurePoints = figurePoints;
        this.border = border;
        this.background = background;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public double[][] getFigurePoints() {
        return figurePoints;
    }

    public void setFigurePoints(double[][] figurePoints) {
        this.figurePoints = figurePoints;
    }

    public void setBorder(Color border) {
        this.border = border;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getBorder() {
        return this.border;
    }

    public Color getBackground() {
        return this.background;
    }

    public void traslating(double tx, double ty) {
        this.figurePoints = operation.translation(tx, ty);
    }

    public void scaling(double scaleX, double scaleY) {
        this.figurePoints = this.operation.scaling(scaleX, scaleY);
    }

    public void drawFigure() {

    }
}
