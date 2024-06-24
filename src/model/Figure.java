package model;

import view.FrameView;

import java.awt.*;

public abstract class Figure {

    protected double[][] figurePoints3D;
    protected double[][] figurePoints2D;
    protected Color border;
    protected Color background;
    protected int positionX;
    protected int positionY;
    protected FrameView view;

    protected double[][] traslatingPoints;
    protected double[][] scalingPoints;
    protected double[][] rotatingPoints;
    OperationCalculations3D operation;

    public Figure(FrameView view) {
        this.view = view;
        this.figurePoints3D = new double[][]{{50,50,50}, {150,50,50}, {150,50,150}, {50,50,150} ,{50,150,50}, {150,150,50}, {150,150,150}, {50,150,150}};
        this.operation = new OperationCalculations3D(-5, 2, 10, figurePoints3D);
        this.figurePoints2D = operation.getProjectedPoints();
        this.positionX = 50;
        this.positionY = 80;
        this.border = Color.BLACK;
    }

    public Figure(FrameView view, double[][] figurePoints3D, Color border) {
        this.operation = new OperationCalculations3D(0, 0, 1, figurePoints3D);
        this.figurePoints2D = operation.getProjectedPoints();
        this.view = view;
        this.border = border;
    }

    public Figure(FrameView view, double[][] figurePoints3D, Color border, int positionX, int positionY, double xp, double yp, double zp) {
        this.operation = new OperationCalculations3D(xp, yp, zp, figurePoints3D);
        this.figurePoints2D = operation.getProjectedPoints();
        this.view = view;
        this.border = border;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Figure(FrameView view, double[][] figurePoints3D, Color border, Color background, int positionX, int positionY, double xp, double yp, double zp) {
        this.operation = new OperationCalculations3D(0, 0, 0, figurePoints3D);
        this.figurePoints2D = operation.getProjectedPoints();
        this.view = view;
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

    public double[][] getFigurePoints3D() {
        return figurePoints3D;
    }

    public void setFigurePoints3D(double[][] figurePoints) {
        this.figurePoints3D = figurePoints;
    }

    public double[][] getFigurePoints2D() {
        return figurePoints2D;
    }

    public void setFigurePoints2D(double[][] figurePoints) {
        this.figurePoints2D = figurePoints;
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

    public void traslating(double tx, double ty, double tz) {
        this.figurePoints2D = operation.translation(tx, ty, tz);
    }

    public void scaling(double scaleX, double scaleY, double scaleZ) {
        this.figurePoints2D = this.operation.scaling(scaleX, scaleY, scaleZ);
    }

    public void rotatingX(){
        //this.figurePoints3D
    }

    public void drawFigure() {

    }
}
