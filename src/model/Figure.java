package model;

import view.FrameView;

import java.awt.*;

public abstract class Figure {
    protected double speedX, speedY,speedZ;
    public double posX, posY,posZ;
    public double limitx,limity,limitz;
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
        this.figurePoints3D = new double[][] {
                {-50, -50, -50},
                {50, -50, -50},
                {50, -50, 50},
                {-50, -50, 50},
                {-50, 14, -50},
                {50, 14, -50},
                {50, 14, 50},
                {-50, 14, 50}
        };
        this.operation = new OperationCalculations3D(1, 10, 20, figurePoints3D);
        this.positionX = 50;
        this.positionY = 80;
        this.border = Color.BLACK;
    }

    public Figure(FrameView view, double[][] figurePoints3D, Color border) {
        this.figurePoints3D = figurePoints3D;
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

    public void traslating(double counter,double xdir,double ydir) {
        double tx = 0,ty = 0,tz = 0;
        posX+=1;
        posY+=1;
        posZ+=1;
        if(posZ<limitz)
            tz = counter + getSpeedZ();
        if(posY<limity)
            ty = counter*ydir + getSpeedY();
        if(posX<limitx)
            tx = counter*xdir + getSpeedX();
        this.figurePoints3D = operation.translation(tx,ty,tz);
    }
    public void traslatingWithPoints(double counter,double xdir,double ydir, double[][] tempPoints) {
        double tx = 0,ty = 0,tz = 0;
        posX+=1;
        posY+=1;
        posZ+=1;
        if(posZ<limitz)
            tz = counter + getSpeedZ();
        if(posY<limity)
            ty = counter*ydir + getSpeedY();
        if(posX<limitx)
            tx = counter*xdir + getSpeedX();
        this.figurePoints3D = operation.translationWithPoints(tx,ty,tz,tempPoints);
    }
    public void projecting() {
        this.figurePoints2D = operation.getProjectedPoints();
    }
    public void projecting(double [][] temPoints) {
        this.figurePoints2D = operation.getProjectedPoints(temPoints);
    }

    public double[][] scaling(double scaleX, double scaleY, double scaleZ) {
        this.figurePoints3D = this.operation.scaling(scaleX, scaleY, scaleZ);
        return figurePoints3D;
    }
    public double[][] scalingOriginal(double scaleX, double scaleY, double scaleZ) {
        this.figurePoints3D = this.operation.scalingOriginal(scaleX, scaleY, scaleZ);
        return figurePoints3D;
    }
    public double[][] scaling(double scaleX, double scaleY, double scaleZ,double [][] tempPoints) {
        this.figurePoints3D = this.operation.scaling(scaleX, scaleY, scaleZ,tempPoints);
        return figurePoints3D;
    }

    public void traslatingWithotMovement(int xt, double yt, int zt) {
        this.figurePoints3D = operation.translation(xt,yt,zt);
    }
    public double[][] traslatingWithotMovementWithPoints(int xt, double yt, int zt, double [][]tempPoints) {
        this.figurePoints3D = operation.translationWithPoints(xt,yt,zt,tempPoints);
        return figurePoints3D;
    }

    public void traslatingWithotMovementCounter(double counter, double xdir, double ydir) {
        double tx = 0,ty = 0,tz = 0;
        tz = counter + getSpeedZ();
        ty = counter*ydir + getSpeedY();
        tx = counter*xdir + getSpeedX();
        this.figurePoints3D = operation.translation(tx,ty,tz);
    }
    public void traslatingRotated(int xt, double yt, int zt) {
        this.figurePoints3D = operation.translateOriginal(xt,yt,zt);
    }


    public double[][] rotatingX(double counter){
        double tx = 0,ty = 0,tz = 0;
        posX+=1;
        if(posX<limitx)
            tx = counter + getSpeedX();
        this.figurePoints3D = operation.rotatingX(tx);
        return figurePoints3D;
    }
    public double[][] rotatingXWithPoints(double counter, double[][] tempPoints){
        double tx = 0,ty = 0,tz = 0;
        posX+=1;
        if(posX<limitx)
            tx = counter + getSpeedX();
        this.figurePoints3D = operation.rotatingXWithPoints(tx,tempPoints);
        return figurePoints3D;
    }
    public double[][] rotatingY(double counter){
        double tx = 0,ty = 0,tz = 0;
        posY+=1;
        if(posY<limity)
            ty = counter + getSpeedY();
        this.figurePoints3D = operation.rotatingY(ty);
        return this.figurePoints3D;
    }
    public double[][] rotatingYWithPoints(double counter,double[][] tempPoints){
        double tx = 0,ty = 0,tz = 0;
        posY+=1;
        if(posY<limity)
            ty = counter + getSpeedY();
        this.figurePoints3D = operation.rotatingYWithPoints(ty,tempPoints);
        return this.figurePoints3D;
    }
    public double[][] rotatingZ(double counter){
        double tx = 0,ty = 0,tz = 0;
        posZ+=1;
        if(posZ<limitz)
            tz = counter + getSpeedZ();
        this.figurePoints3D = operation.rotatingZ(tz);
        return this.figurePoints3D;
    }
    public double[][] rotatingZWithPoints(double counter, double[][] tempPoints){
        double tx = 0,ty = 0,tz = 0;
        posZ+=1;
        if(posZ<limitz)
            tz = counter + getSpeedZ();
        this.figurePoints3D = operation.rotatingZWithPoints(tz,tempPoints);
        return this.figurePoints3D;
    }
    public double[][] rotatingZNoMovement(double counter){
        double tx = 0,ty = 0,tz = 0;
        this.figurePoints3D = operation.rotatingZ(counter);
        return this.figurePoints3D;
    }
    public double[][] rotatingYNoMovement(double counter){
        double tx = 0,ty = 0,tz = 0;
        this.figurePoints3D = operation.rotatingY(counter);
        return this.figurePoints3D;
    }
    public double[][] rotatingYNoMovementWithPoints(double counter, double[][]tempPoints){
        double tx = 0,ty = 0,tz = 0;
        this.figurePoints3D = operation.rotatingYWithPoints(counter,tempPoints);
        return this.figurePoints3D;
    }
    public double[][] rotatingXNoMovementWithPoints(double counter, double[][]tempPoints){
        double tx = 0,ty = 0,tz = 0;
        this.figurePoints3D = operation.rotatingXWithPoints(counter,tempPoints);
        return this.figurePoints3D;
    }
    public double[][] rotatingZNoMovementWithPoints(double counter, double[][]tempPoints){
        double tx = 0,ty = 0,tz = 0;
        this.figurePoints3D = operation.rotatingZWithPoints(counter,tempPoints);
        return this.figurePoints3D;
    }
    public void rotatingXNoMovement(double counter){
        double tx = 0,ty = 0,tz = 0;
        this.figurePoints3D = operation.rotatingX(counter);
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

    public void setLimits(double posX,double posY,double posZ) {
        this.limitx = posX;
        this.limity = posY;
        this.limitz = posZ;
    }

    public void setSpeedZ(double speedZ) {
        this.speedZ = speedZ;
    }

    public double[][] getTraslatingPoints() {
        return traslatingPoints;
    }

    public void setTraslatingPoints(double[][] traslatingPoints) {
        this.traslatingPoints = traslatingPoints;
    }

    public double[][] getScalingPoints() {
        return scalingPoints;
    }

    public void setScalingPoints(double[][] scalingPoints) {
        this.scalingPoints = scalingPoints;
    }

    public double[][] getRotatingPoints() {
        return rotatingPoints;
    }

    public void setRotatingPoints(double[][] rotatingPoints) {
        this.rotatingPoints = rotatingPoints;
    }
}
