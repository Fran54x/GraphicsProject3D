package model;

public class OperationCalculations {
    // Attributes
    private double[][] pointsXY;
    private double[][] pointsXYZ;
    private double[][] transformMatrix;
    private double[][] projectedPoints;
    private int points;

    public OperationCalculations(double[][] pointsXY) {
        this.points = pointsXY.length;
        this.pointsXY = pointsXY;
        this.transformMatrix = new double[points][2];
    }

    public OperationCalculations(double xp, double yp, double zp, double[][] pointsXYZ) {
        this.points = pointsXYZ.length;
        this.pointsXY = new double[points][2];
        this.pointsXYZ = pointsXYZ;
        this.transformMatrix = new double[points][2];
        this.projectedPoints = new double[points][2];

        // Copying the input points to the class attribute
        for (int i = 0; i < points; i++) {
            this.pointsXYZ[i][0] = pointsXYZ[i][0];
            this.pointsXYZ[i][1] = pointsXYZ[i][1];
            this.pointsXYZ[i][2] = pointsXYZ[i][2];
        }

        // Projecting the points
        for (int i = 0; i < points; i++) {
            double u = - (this.pointsXYZ[i][2] / zp);
            this.projectedPoints[i][0] = this.pointsXYZ[i][0] + (xp * u);
            this.projectedPoints[i][1] = this.pointsXYZ[i][1] + (yp * u);
        }
        this.pointsXY = this.projectedPoints.clone();
        //printProjectedPoints();
    }

    // Methods for operation of 2D points

    public double[][] getProjectedPoints() {
        return projectedPoints;
    }

    public double[][] getPointsXY() {
        return pointsXY;
    }

    public double[][] getTransformMatrix() { return transformMatrix; }

    public void setPointsXY(double[][] pointsXY) {
        this.points = pointsXY.length;
        this.pointsXY = pointsXY;
    }

    public void setPointsXYZ(double[][] pointsXYZ) {
        this.points = pointsXYZ.length;
        this.pointsXYZ = pointsXYZ;
    }

    // Translation method

    public double[][] translation(double tx, double ty) {
        double[][] matrixT = new double[3][3]; //all elements started in zero
        matrixT[0][0] = 1;
        matrixT[1][1] = 1;
        matrixT[2][2] = 1;
        matrixT[0][2] = tx;
        matrixT[1][2] = ty;
        double[][] matrixP = buildMatrixP();
        return calculateMatrixProduct(matrixT, matrixP, 1);
    }

    public double[][] scaling(double sx, double sy) {
        double[][] matrixS = new double[3][3]; //all elements started in zero
        matrixS[0][0] = sx;
        matrixS[1][1] = sy;
        matrixS[2][2] = 1;
        double[][] matrixP = buildMatrixP();
        return calculateMatrixProduct(matrixS, matrixP, 2);
    }

    public double[][] rotating(double angleInDegrees) {
        double[][] matrixR = new double[3][3]; //all elements started in zero
        double angleInRadians = Math.toRadians(angleInDegrees); //degrees to radians
        matrixR[0][0] = Math.cos(angleInRadians);
        matrixR[0][1] = -Math.sin(angleInRadians);
        matrixR[1][0] = Math.sin(angleInRadians);
        matrixR[1][1] = Math.cos(angleInRadians);
        matrixR[2][2] = 1;
        double[][] matrixP = buildMatrixP();
        return calculateMatrixProduct(matrixR, matrixP, 3);
    }

    private double[][] buildMatrixP() {
        double[][] matrixP = new double[3][points];
        for(int i = 0; i < points; i++){
            matrixP[0][i] = pointsXY[i][0];
            matrixP[1][i] = pointsXY[i][1];
            matrixP[2][i] = 1;
        }
        return matrixP;
    }

    private double[][] calculateMatrixProduct(double[][] matrix, double[][] matrixP, int opc) {
        double[][] matrixT = new double[3][points];
        //formula P´= M*P
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < points; j++){
                for(int k = 0; k < 3; k++){
                    matrixT[i][j] += matrix[i][k] * matrixP[k][j];
                }
                //matrixT[i][j] += Math.round(matrixT[i][j]);
            }
        }

        //endpoints
        for(int i = 0; i < points; i++){
            for(int j = 0; j < 2; j++){
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
            case 3 -> operation = "Rotating";
            default -> operation = "";
        }
        System.out.println(operation + " Points");
        for (int i = 0; i < points; i++) {
            System.out.println(transformMatrix[i][0] + ", " + transformMatrix[i][1]);
        }
    }

    public void printPointsXY() {
        System.out.println("Points on dimension x, y");
        for (int i = 0; i < points; i++) {
            System.out.println(pointsXY[i][0] + ", " + pointsXY[i][1]);
        }
    }

    public static void main(String[] args) {
        double[][] pointsXY = {{2, 5}, {5, 5}, {7, 8} , {4, 4}};
        OperationCalculations op = new OperationCalculations(pointsXY);
        //op.translation(0.5, 0.25);
        //op.printPointsXY();

        //op.setPointsXY(pointsXY);
        //op.scaling(0.5, 0.25);
        //op.printPointsXY();

        //op.setPointsXY(pointsXY);
        op.rotating(45);
        op.printPointsXY();
    }
}
