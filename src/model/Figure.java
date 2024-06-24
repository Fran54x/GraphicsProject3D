package model;

import view.FrameView;

import java.awt.*;

public abstract class Figure {
    protected double speedX, speedY,speedZ;
    public double posX, posY,posZ;
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
        this.positionX = 50;
        this.positionY = 80;
        this.border = Color.BLACK;
    }

    public Figure(FrameView view, double[][] figurePoints3D, Color border) {
        this.operation = new OperationCalculations3D(0, 0, 1, figurePoints3D);
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

    public void traslating(double counter) {
        double tx = 0,ty,tz;
        tz = counter * getSpeedZ();
        ty = counter * getSpeedY();
        System.out.println(positionX+" : "+getPosX());
        if(positionX<getPosX())
            tx = counter * getSpeedX();
        this.figurePoints3D = operation.translation(tx,ty,tz);
    }
    public void projecting() {
        this.figurePoints2D = operation.getProjectedPoints();
    }

    public void scaling(double scaleX, double scaleY, double scaleZ) {
        this.figurePoints2D = this.operation.scaling(scaleX, scaleY, scaleZ);
    }

    public void rotatingX(){
        //this.figurePoints3D
    }

    public void drawFigure() {

    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }
    public double getSpeedZ() {
        return speedZ;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setSpeedXYZ(double speedX, double speedY,double speedZ) {
        this.speedX = speedX;
        this.speedY = speedY;
        this.speedZ = speedZ;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosXYZ(double posX,double posY,double posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
}
