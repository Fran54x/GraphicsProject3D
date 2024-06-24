package model;

public class OperationCalculations3D {
    // Attributes
    private double[][] originalPoints;
    private double[][] pointsXYZ;
    private double[][] transformMatrix;
    private double[][] projectedPoints;
    private int points;
    private  double xp,zp,yp;

    public OperationCalculations3D(double[][] originalPoints) {
        this.points = originalPoints.length;
        this.originalPoints = originalPoints;
        this.pointsXYZ = originalPoints;
        this.transformMatrix = new double[points][3];
        this.projectedPoints = new double[points][2];
    }

    public OperationCalculations3D(double xp, double yp, double zp, double[][] originalPoints) {
        this.points = originalPoints.length;
        this.originalPoints = originalPoints;
        this.pointsXYZ = new double[points][3];
        this.transformMatrix = new double[points][3];
        this.projectedPoints = new double[points][2];
        // Copying the input points to the class attribute
        for (int i = 0; i < points; i++) {
            this.originalPoints[i][0] = originalPoints[i][0];
            this.originalPoints[i][1] = originalPoints[i][1];
            this.originalPoints[i][2] = originalPoints[i][2];
        }
        this.pointsXYZ = originalPoints.clone();
        this.zp=zp;
        this.xp=xp;
        this.yp=yp;
        //printProjectedPoints();
    }
    // Methods for operation of 2D points

    public double[][] getProjectedPoints() {
        // Projecting the points
        for (int i = 0; i < points; i++) {
            double u = - (this.pointsXYZ[i][2] / this.zp);
            this.pointsXYZ[i][0] = this.pointsXYZ[i][0] + (this.xp * u);
            this.pointsXYZ[i][1] = this.pointsXYZ[i][1] + (this.yp * u);
        }
        return this.pointsXYZ;
    }
    public double[][] getProjectedPoints(double [][] tempPoints) {
        // Projecting the points
        for (int i = 0; i < points; i++) {
            double u = - (tempPoints[i][2] / this.zp);
            tempPoints[i][0] = tempPoints[i][0] + (this.xp * u);
            tempPoints[i][1] = tempPoints[i][1] + (this.yp * u);
        }
        this.pointsXYZ = tempPoints.clone();
        return this.pointsXYZ;
    }

    public double[][] getPointsXYZ() {
        return pointsXYZ;
    }

    public double[][] getTransformMatrix() { return transformMatrix; }

    public void setPointsXYZ(double[][] pointsXYZ) {
        this.points = pointsXYZ.length;
        this.pointsXYZ = pointsXYZ;
    }

    public double[][] getOriginalPoints() {
        return originalPoints;
    }

    // Translation method

    public double[][] translation(double tx, double ty, double tz) {
        double[][] matrixT = new double[4][4]; //all elements started in zero
        matrixT[0][0] = 1;
        matrixT[1][1] = 1;
        matrixT[2][2] = 1;
        matrixT[3][3] = 1;
        matrixT[0][3] = tx;
        matrixT[1][3] = ty;
        matrixT[2][3] = tz;
        double[][] matrixP = buildMatrixP();
        this.pointsXYZ = calculateMatrixProduct(matrixT, matrixP, 1);
        return pointsXYZ;
    }
    public double[][] translationWithPoints(double tx, double ty, double tz,double[][] tempPoints) {
        double[][] matrixT = new double[4][4]; //all elements started in zero
        matrixT[0][0] = 1;
        matrixT[1][1] = 1;
        matrixT[2][2] = 1;
        matrixT[3][3] = 1;
        matrixT[0][3] = tx;
        matrixT[1][3] = ty;
        matrixT[2][3] = tz;
        double[][] matrixP = buildMatrixPWithPoints(tempPoints);
        this.pointsXYZ = calculateMatrixProduct(matrixT, matrixP, 1);
        return pointsXYZ;
    }
    public double[][] translateOriginal(double tx, double ty, double tz) {
        double[][] matrixT = new double[4][4]; //all elements started in zero
        matrixT[0][0] = 1;
        matrixT[1][1] = 1;
        matrixT[2][2] = 1;
        matrixT[3][3] = 1;
        matrixT[0][3] = tx;
        matrixT[1][3] = ty;
        matrixT[2][3] = tz;
        double[][] matrixP = buildMatrixP();
        this.pointsXYZ = calculateMatrixProduct(matrixT, matrixP, 1);
        return pointsXYZ;
    }

    public double[][] scaling(double sx, double sy, double sz) {
        double[][] matrixS = new double[4][4]; //all elements started in zero
        matrixS[0][0] = sx;
        matrixS[1][1] = sy;
        matrixS[2][2] = sz;
        matrixS[3][3] = 1;
        double[][] matrixP = buildMatrixP();
        this.pointsXYZ = calculateMatrixProduct(matrixS, matrixP, 1);
        return pointsXYZ;
    }
    public double[][] scalingOriginal(double sx, double sy, double sz) {
        double[][] matrixS = new double[4][4]; //all elements started in zero
        matrixS[0][0] = sx;
        matrixS[1][1] = sy;
        matrixS[2][2] = sz;
        matrixS[3][3] = 1;
        double[][] matrixP = buildRotateMatrix();
        this.pointsXYZ = calculateMatrixProduct(matrixS, matrixP, 1);
        return pointsXYZ;
    }
    public double[][] scaling(double sx, double sy, double sz,double [][] tempPoints) {
        double[][] matrixS = new double[4][4]; //all elements started in zero
        matrixS[0][0] = sx;
        matrixS[1][1] = sy;
        matrixS[2][2] = sz;
        matrixS[3][3] = 1;
        double[][] matrixP = buildMatrixPWithPoints(tempPoints);
        this.pointsXYZ = calculateMatrixProduct(matrixS, matrixP, 1);
        return pointsXYZ;
    }

    public double[][] rotatingX(double angleInDegrees) {
        double[][] matrixR = new double[4][4]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees);
        System.out.println(angleInRadians);//degrees to radians
        matrixR[0][0] = 1;
        matrixR[1][1] = Math.cos(angleInRadians);
        matrixR[1][2] = Math.sin(angleInRadians);
        matrixR[2][1] = -Math.sin(angleInRadians);
        matrixR[2][2] = Math.cos(angleInRadians);
        matrixR[3][3] = 1;
        double[][] matrixP = buildRotateMatrix();
        this.pointsXYZ = calculateMatrixProduct(matrixR, matrixP, 31);
        return pointsXYZ;
    }

    public double[][] rotatingY(double angleInDegrees) {
        double[][] matrixR = new double[4][4]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees); //degrees to radians
        matrixR[0][0] = Math.cos(angleInRadians);
        matrixR[0][2] = -Math.sin(angleInRadians);
        matrixR[1][1] = 1;
        matrixR[2][0] = Math.sin(angleInRadians);
        matrixR[2][2] = Math.cos(angleInRadians);
        matrixR[3][3] = 1;
        double[][] matrixP = buildRotateMatrix();
        this.pointsXYZ = calculateMatrixProduct(matrixR, matrixP, 32);
        return pointsXYZ;
    }
    public double[][] rotatingYWithPoints(double angleInDegrees,double[][] tempPoints) {
        double[][] matrixR = new double[4][4]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees); //degrees to radians
        matrixR[0][0] = Math.cos(angleInRadians);
        matrixR[0][2] = -Math.sin(angleInRadians);
        matrixR[1][1] = 1;
        matrixR[2][0] = Math.sin(angleInRadians);
        matrixR[2][2] = Math.cos(angleInRadians);
        matrixR[3][3] = 1;
        double[][] matrixP = buildRotateMatrixWithPoints(tempPoints);
        this.pointsXYZ = calculateMatrixProduct(matrixR, matrixP, 32);
        return pointsXYZ;
    }
    public double[][] rotatingXWithPoints(double angleInDegrees,double[][] tempPoints) {
        double[][] matrixR = new double[4][4]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees);
        System.out.println(angleInRadians);//degrees to radians
        matrixR[0][0] = 1;
        matrixR[1][1] = Math.cos(angleInRadians);
        matrixR[1][2] = Math.sin(angleInRadians);
        matrixR[2][1] = -Math.sin(angleInRadians);
        matrixR[2][2] = Math.cos(angleInRadians);
        matrixR[3][3] = 1;
        double[][] matrixP = buildRotateMatrixWithPoints(tempPoints);
        this.pointsXYZ = calculateMatrixProduct(matrixR, matrixP, 32);
        return pointsXYZ;
    }
    public double[][] rotatingZWithPoints(double angleInDegrees,double[][] tempPoints) {
        double[][] matrixR = new double[4][4]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees); //degrees to radians
        matrixR[0][0] = Math.cos(angleInRadians);
        matrixR[0][1] = Math.sin(angleInRadians);
        matrixR[1][0] = -Math.sin(angleInRadians);
        matrixR[1][1] = Math.cos(angleInRadians);
        matrixR[2][2] = 1;
        matrixR[3][3] = 1;
        double[][] matrixP = buildRotateMatrixWithPoints(tempPoints);
        this.pointsXYZ = calculateMatrixProduct(matrixR, matrixP, 32);
        return pointsXYZ;
    }
    public double[][] rotatingZ(double angleInDegrees) {
        double[][] matrixR = new double[4][4]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees); //degrees to radians
        matrixR[0][0] = Math.cos(angleInRadians);
        matrixR[0][1] = Math.sin(angleInRadians);
        matrixR[1][0] = -Math.sin(angleInRadians);
        matrixR[1][1] = Math.cos(angleInRadians);
        matrixR[2][2] = 1;
        matrixR[3][3] = 1;
        double[][] matrixP = buildRotateMatrix();
        this.pointsXYZ = calculateMatrixProduct(matrixR, matrixP, 33);
        return pointsXYZ;
    }

    private double[][] buildMatrixP() {
        double[][] matrixP = new double[4][points];
        for(int i = 0; i < points; i++){
            matrixP[0][i] = pointsXYZ[i][0];
            matrixP[1][i] = pointsXYZ[i][1];
            matrixP[2][i] = pointsXYZ[i][2];
            matrixP[3][i] = 1;
        }
        return matrixP;
    }
    private double[][] buildMatrixPWithPoints(double [][]tempPoints) {
        double[][] matrixP = new double[4][points];
        for(int i = 0; i < points; i++){
            matrixP[0][i] = tempPoints[i][0];
            matrixP[1][i] = tempPoints[i][1];
            matrixP[2][i] = tempPoints[i][2];
            matrixP[3][i] = 1;
        }
        return matrixP;
    }
    private double[][] buildRotateMatrix() {
        double[][] matrixP = new double[4][points];
        for(int i = 0; i < points; i++){
            matrixP[0][i] = originalPoints[i][0];
            matrixP[1][i] = originalPoints[i][1];
            matrixP[2][i] = originalPoints[i][2];
            matrixP[3][i] = 1;
        }
        return matrixP;
    }
    private double[][] buildRotateMatrixWithPoints(double[][]tempPoints) {
        double[][] matrixP = new double[4][points];
        for(int i = 0; i < points; i++){
            matrixP[0][i] = tempPoints[i][0];
            matrixP[1][i] = tempPoints[i][1];
            matrixP[2][i] = tempPoints[i][2];
            matrixP[3][i] = 1;
        }
        return matrixP;
    }

    private double[][] calculateMatrixProduct(double[][] matrix, double[][] matrixP, int opc) {
        double[][] matrixT = new double[4][points];
        //formula P´= M*P
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < points; j++){
                for(int k = 0; k < 4; k++){
                    matrixT[i][j] += matrix[i][k] * matrixP[k][j];
                }
                //matrixT[i][j] += Math.round(matrixT[i][j]);
            }
        }

        //endpoints
        for(int i = 0; i < points; i++){
            for(int j = 0; j < 3; j++){
                transformMatrix[i][j] = matrixT[j][i];
            }
        }
        //printOperationPoints(opc);
        return transformMatrix;
    }

    public void printProjectedPoints() {
        // Print transformed points in 2D
        System.out.println("Points on dimension x, y");
        for (int i = 0; i < points; i++) {
            System.out.println(projectedPoints[i][0] + ", " + projectedPoints[i][1]);
        }
    }

    public void printOperationPoints(int opc) {
        String operation = "";
        switch (opc) {
            case 1 -> operation = "Traslating";
            case 2 -> operation = "Scaling";
            case 31 -> operation = "Rotating X";
            case 32 -> operation = "Rotating Y";
            case 33 -> operation = "Rotating Z";
            default -> operation = "";
        }
        System.out.println(operation + " Points");
        for (int i = 0; i < points; i++) {
            System.out.println(transformMatrix[i][0] + ", " + transformMatrix[i][1] + ", " + transformMatrix[i][2]);
        }
    }

    public void printPointsXYZ() {
        System.out.println("Points on dimension x, y");
        for (int i = 0; i < points; i++) {
            System.out.println(pointsXYZ[i][0] + ", " + pointsXYZ[i][1] + ", " + pointsXYZ[i][2]);
        }
    }

    public static void main(String[] args) {
        double[][] pointsXY = {
                {300, 150, 50},
                {350, 125, 50},
                {400, 150, 50},
                {450, 125, 50},
                {500, 150, 50},
                {450, 175, 50},
                {500, 200, 50},
                {450, 225, 50},//
                {300, 200, 50},
                {350, 175, 50},
                {400, 200, 50},
                {450, 175, 50},
                {500, 200, 50},
                {450, 225, 50},
                {500, 250, 50},
                {450, 275, 50}
        };
        OperationCalculations3D op = new OperationCalculations3D(pointsXY);
        op.translation(2, 3, 4);
        op.scaling(2, 2, 2);
        op.rotatingX(45);
        op.rotatingY(45);
        op.rotatingZ(45);
        op.printPointsXYZ();
    }
}
