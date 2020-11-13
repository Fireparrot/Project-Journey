package projectjourney;

import java.awt.Color;

public class Func {
    
    private final static double PI = Math.PI;
    private final static double AR = 180/Math.PI;
    
    public static double clockAngle(double x, double y) {
        if(x != 0 || y != 0) {
            if(x >= 0){
                return Math.acos(y/Math.sqrt(x*x+y*y));
            } else {
                return 2*PI - Math.acos(y/Math.sqrt(x*x+y*y));
            }
        } else {
            return 0;
        }
    }
    
    public static boolean holeCube(int a, int b, int c) {
        return (a%2==1&&b%2==1)||(a%2==1&&c%2==1)||(b%2==1&&c%2==1);
    }
    
    public static int randInt(int a, int b) {
        return a + (int)(Math.random()*(b-a));
    }
    public static double rand(double a, double b) {
        return a + (Math.random()*(b-a));
    }
    
    public static double truncate(double d, int i) {
        return (double)((int)(d*Math.pow(10, i)))/Math.pow(10,i);
    }
    
    public static double[] getRGBArray(Color c) {
        double r = c.getRed();
        double g = c.getGreen();
        double b = c.getBlue();
        double[] ds = {r, g, b};
        return ds;
    }
    
    public static Color alphaColorOverlay(double r1, double g1, double b1, double a1, double r2, double g2, double b2, double a2) {
        return new Color((float)(r1*a1 + r2*a2)/255f, (float)(g1*a1 + g2*a2)/255f, (float)(b1*a1 + b2*a2)/255f);
    }
    public static Color alphaColorOverlay(Color c1, double a1, double r2, double g2, double b2, double a2) {
        return new Color((float)(c1.getRed()*a1 + r2*a2)/255f, (float)(c1.getGreen()*a1 + g2*a2)/255f, (float)(c1.getBlue()*a1 + b2*a2)/255f);
    }
    public static Color alphaColorOverlay(double r1, double g1, double b1, double a1, Color c2, double a2) {
        return new Color((float)(r1*a1 + c2.getRed()*a2)/255f, (float)(g1*a1 + c2.getGreen()*a2)/255f, (float)(b1*a1 + c2.getBlue()*a2)/255f);
    }
    public static Color alphaColorOverlay(Color c1, double a1, Color c2, double a2) {
        return new Color((float)(c1.getRed()*a1 + c2.getRed()*a2)/255f, (float)(c1.getGreen()*a1 + c2.getGreen()*a2)/255f, (float)(c1.getBlue()*a1 + c2.getBlue()*a2)/255f);
    }
    
    public static double square(double d) {
        return d*d;
    }
    
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(square(x2-x1) + square(y2-y1));
    }
    
    public static double between(double d1, double d2, double d3) {
        return (d2-d1)/(d3-d1);
    }
    
    public static double linearInterpolate(double d1, double d2, double w) {
        return (1-w)*d1 + w*d2;
    }
    public static double linearInterpolate(double d11, double d21, double d12, double d22, double w10, double w01) {
        return (1-w01)*(d11 + w10*(d21-d11)) + (w01)*(d12 + w10*(d22-d12));
    }
    public static double cubicInterpolate2(double d0, double d1, double d2, double d3, double w) {
        double P = (d3-d2) - (d0-d1);
        double Q = (d0-d1) - P;
        double R = d2-d0;
        double S = d1;
        return P*w*w*w + Q*w*w + R*w + S;
    }
    public static double cubicInterpolate(double d1, double d2, double w) {
        double P = 2*(d1-d2);
        double Q = 3*(d2-d1);
        double R = 0;
        double S = d1;
        return P*w*w*w + Q*w*w + R*w + S;
    }
    public static double cubicInterpolate2(double d00, double d10, double d20, double d30,
                                            double d01, double d11, double d21, double d31,
                                            double d02, double d12, double d22, double d32,
                                            double d03, double d13, double d23, double d33,
                                            double w10, double w01) {
        double P = cubicInterpolate2(d00, d10, d20, d30, w10);
        double Q = cubicInterpolate2(d01, d11, d21, d31, w10);
        double R = cubicInterpolate2(d02, d12, d22, d32, w10);
        double S = cubicInterpolate2(d03, d13, d23, d33, w10);
        
        return cubicInterpolate2(P, Q, R, S, w01);
    }
    public static double cubicInterpolate(  double d11, double d21, 
                                            double d12, double d22,
                                            double w10, double w01) {
        double Q = cubicInterpolate(d11, d21, w10);
        double R = cubicInterpolate(d12, d22, w10);
        
        return cubicInterpolate(Q, R, w01);
    }
    public static double cubicInterpolate(  double d111, double d211,
                                            double d121, double d221,
                                            double d112, double d212,
                                            double d122, double d222,
                                            double w100, double w010, double w001) {
        return cubicInterpolate(cubicInterpolate(cubicInterpolate(d111, d211, w100), cubicInterpolate(d121, d221, w100), w010),
                                cubicInterpolate(cubicInterpolate(d112, d212, w100), cubicInterpolate(d122, d222, w100), w010),
                                w001);
    }
    
    public static int ceiling(double d) {
        if((int)d == d) {
            return (int)d;
        } else if(d > 0) {
            return (int)d + 1;
        } else {
            return (int)d;
        }
    }
    public static int floor(double d) {
        if((int)d == d) {
            return (int)d;
        } else if(d > 0) {
            return (int)d;
        } else {
            return (int)d - 1;
        }
    }
    
    public static double log(double base, double d1) {
        return Math.log(d1)/Math.log(base);
    }
    
    public static double bigger(double d1, double d2) {
        return d1>d2?d1:d2;
    }
    public static double bigger(double d1, double d2, double d3) {
        return bigger(d1, bigger(d2,d3));
    }
    public static double smaller(double d1, double d2) {
        return d1<d2?d1:d2;
    }
    public static double smaller(double d1, double d2, double d3) {
        return smaller(d1, smaller(d2,d3));
    }
    
    public static double[][] randomMap(int sizeX, int sizeY) {
        double[][] map = new double[sizeX][sizeY];
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                map[i][j] = Math.random();
            }
        }
        return map;
    }
    public static double[][] randomMapSigned(int sizeX, int sizeY) {
        double[][] map = new double[sizeX][sizeY];
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                map[i][j] = rand(-1,1);
            }
        }
        return map;
    }
    public static double[][][] randomMap(int sizeX, int sizeY, int sizeZ) {
        double[][][] map = new double[sizeX][sizeY][sizeZ];
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int k = 0; k < sizeZ; k++) {
                    map[i][j][k] = Math.random();
                }
            }
        }
        return map;
    }
    public static double[][][] randomMap3DSigned(int sizeX, int sizeY, int sizeZ) {
        double[][][] map = new double[sizeX][sizeY][sizeZ];
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int k = 0; k < sizeZ; k++) {
                    map[i][j][k] = rand(-1,1);
                }
            }
        }
        return map;
    }
    
    public static double[][] perlin(int sizeX, int sizeY, int initStep, int finalStep, double persistence) {
        int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY)));
        double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][] map = new double[sizeX][sizeY];
        double[][][] map2 = new double[sizeX][sizeY][(int)smaller(finalStep, power2)-initStep+1];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            System.out.println();
            double[][] randomMap = randomMap((int)Math.pow(2,step) + 3, (int)Math.pow(2,step) + 3);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeY))) ); j++) {
                    
                    for(int m = 0; m < Math.pow(2, power2-step); m++) {
                        for(int n = 0; n < Math.pow(2, power2-step); n++) {
                            int x = i*(int)Math.pow(2, power2-step)+m;
                            int y = j*(int)Math.pow(2, power2-step)+n;
                            if(x < sizeX && y < sizeY) {
                                map2[x][y][step-initStep] = linearInterpolate(
                                        randomMap[i][j],
                                        randomMap[i+1][j],
                                        randomMap[i][j+1],
                                        randomMap[i+1][j+1],
                                        (double)m/Math.pow(2, power2-step),
                                        (double)n/Math.pow(2, power2-step)
                                )*Math.pow(1-persistence,step);
                            }
                        }
                    }
                    
                }
            }
        }
        
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int counter = 0; counter < map2[0][0].length; counter++) {
                    map[i][j] += map2[i][j][counter]/multiplier;
                }
            }
        }
        
        return map;
    }
    public static double[][] perlinCubic(int sizeX, int sizeY, int initStep, int finalStep, double persistence) {
        int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY)));
        double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][] map = new double[sizeX][sizeY];
        double[][][] map2 = new double[sizeX][sizeY][(int)smaller(finalStep, power2)-initStep+1];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            double[][] randomMap = randomMap((int)Math.pow(2,step) + 1, (int)Math.pow(2,step) + 1);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); j++) {
                    
                    for(int m = 0; m < Math.pow(2, power2-step); m++) {
                        for(int n = 0; n < Math.pow(2, power2-step); n++) {
                            int x = i*(int)Math.pow(2, power2-step)+m;
                            int y = j*(int)Math.pow(2, power2-step)+n;
                            if(x < sizeX && y < sizeY) {
                                map2[x][y][step-initStep] = cubicInterpolate(
                                        randomMap[i+0][j+0], randomMap[i+1][j+0],
                                        randomMap[i+0][j+1], randomMap[i+1][j+1],
                                        (double)m/Math.pow(2, power2-step), (double)n/Math.pow(2, power2-step))                 *Math.pow(1-persistence,step);
                            }
                        }
                    }
                    
                }
            }
        }
        
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int counter = 0; counter < map2[0][0].length; counter++) {
                    map[i][j] += map2[i][j][counter]/multiplier;
                }
            }
        }
        
        return map;
    }
    public static double[][] perlinCubic2(int sizeX, int sizeY, int initStep, int finalStep, double persistence) {
        int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY)));
        double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][] map = new double[sizeX][sizeY];
        double[][][] map2 = new double[sizeX][sizeY][(int)smaller(finalStep, power2)-initStep+1];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            System.out.println();
            double[][] randomMap = randomMap((int)Math.pow(2,step) + 3, (int)Math.pow(2,step) + 3);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeY))) ); j++) {
                    
                    for(int m = 0; m < Math.pow(2, power2-step); m++) {
                        for(int n = 0; n < Math.pow(2, power2-step); n++) {
                            int x = i*(int)Math.pow(2, power2-step)+m;
                            int y = j*(int)Math.pow(2, power2-step)+n;
                            if(x < sizeX && y < sizeY) {
                                map2[x][y][step-initStep] = cubicInterpolate2(
                                        randomMap[i+0][j+0], randomMap[i+1][j+0], randomMap[i+2][j+0], randomMap[i+3][j+0],
                                        randomMap[i+0][j+1], randomMap[i+1][j+1], randomMap[i+2][j+1], randomMap[i+3][j+1],
                                        randomMap[i+0][j+2], randomMap[i+1][j+2], randomMap[i+2][j+2], randomMap[i+3][j+2],
                                        randomMap[i+0][j+3], randomMap[i+1][j+3], randomMap[i+2][j+3], randomMap[i+3][j+3],
                                        (double)m/Math.pow(2, power2-step), (double)n/Math.pow(2, power2-step))                 *Math.pow(1-persistence,step);
                            }
                        }
                    }
                    
                }
            }
        }
        
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int counter = 0; counter < map2[0][0].length; counter++) {
                    map[i][j] += map2[i][j][counter]/multiplier;
                }
            }
        }
        
        return map;
    }
    public static double[][] perlinSigned(int sizeX, int sizeY, int initStep, int finalStep, double persistence) {
        int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY)));
        double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][] map = new double[sizeX][sizeY];
        double[][][] map2 = new double[sizeX][sizeY][(int)smaller(finalStep, power2)-initStep+1];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            double[][] randomMap = randomMapSigned((int)Math.pow(2,step) + 1, (int)Math.pow(2,step) + 1);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeY))) ); j++) {
                    
                    for(int m = 0; m < Math.pow(2, power2-step); m++) {
                        for(int n = 0; n < Math.pow(2, power2-step); n++) {
                            int x = i*(int)Math.pow(2, power2-step)+m;
                            int y = j*(int)Math.pow(2, power2-step)+n;
                            if(x < sizeX && y < sizeY) {
                                map2[x][y][step-initStep] = linearInterpolate(
                                        randomMap[i][j],
                                        randomMap[i+1][j],
                                        randomMap[i][j+1],
                                        randomMap[i+1][j+1],
                                        (double)m/Math.pow(2, power2-step),
                                        (double)n/Math.pow(2, power2-step)
                                )*Math.pow(1-persistence,step);
                            }
                        }
                    }
                    
                }
            }
        }
        
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int counter = 0; counter < map2[0][0].length; counter++) {
                    map[i][j] += map2[i][j][counter]/multiplier;
                }
            }
        }
        
        return map;
    }
    public static double[][] perlinCubicSigned(int sizeX, int sizeY, int initStep, int finalStep, double persistence) {
        int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY)));
        double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][] map = new double[sizeX][sizeY];
        double[][][] map2 = new double[sizeX][sizeY][(int)smaller(finalStep, power2)-initStep+1];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            double[][] randomMap = randomMapSigned((int)Math.pow(2,step) + 1, (int)Math.pow(2,step) + 1);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeY))) ); j++) {
                    
                    for(int m = 0; m < Math.pow(2, power2-step); m++) {
                        for(int n = 0; n < Math.pow(2, power2-step); n++) {
                            int x = i*(int)Math.pow(2, power2-step)+m;
                            int y = j*(int)Math.pow(2, power2-step)+n;
                            if(x < sizeX && y < sizeY) {
                                map2[x][y][step-initStep] = cubicInterpolate(
                                        randomMap[i+0][j+0], randomMap[i+1][j+0],
                                        randomMap[i+0][j+1], randomMap[i+1][j+1],
                                        (double)m/Math.pow(2, power2-step), (double)n/Math.pow(2, power2-step))                 *Math.pow(1-persistence,step);
                            }
                        }
                    }
                    
                }
            }
        }
        
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int counter = 0; counter < map2[0][0].length; counter++) {
                    map[i][j] += map2[i][j][counter]/multiplier;
                }
            }
        }
        
        return map;
    }
    public static double[][] perlinCubicSigned2(int sizeX, int sizeY, int initStep, int finalStep, double persistence) {
        int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY)));
        double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][] map = new double[sizeX][sizeY];
        double[][][] map2 = new double[sizeX][sizeY][(int)smaller(finalStep, power2)-initStep+1];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            double[][] randomMap = randomMapSigned((int)Math.pow(2,step) + 3, (int)Math.pow(2,step) + 3);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeY))) ); j++) {
                    
                    for(int m = 0; m < Math.pow(2, power2-step); m++) {
                        for(int n = 0; n < Math.pow(2, power2-step); n++) {
                            int x = i*(int)Math.pow(2, power2-step)+m;
                            int y = j*(int)Math.pow(2, power2-step)+n;
                            if(x < sizeX && y < sizeY) {
                                map2[x][y][step-initStep] = cubicInterpolate2(
                                        randomMap[i+0][j+0], randomMap[i+1][j+0], randomMap[i+2][j+0], randomMap[i+3][j+0],
                                        randomMap[i+0][j+1], randomMap[i+1][j+1], randomMap[i+2][j+1], randomMap[i+3][j+1],
                                        randomMap[i+0][j+2], randomMap[i+1][j+2], randomMap[i+2][j+2], randomMap[i+3][j+2],
                                        randomMap[i+0][j+3], randomMap[i+1][j+3], randomMap[i+2][j+3], randomMap[i+3][j+3],
                                        (double)m/Math.pow(2, power2-step), (double)n/Math.pow(2, power2-step))                 *Math.pow(1-persistence,step);
                            }
                        }
                    }
                    
                }
            }
        }
        
        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                for(int counter = 0; counter < map2[0][0].length; counter++) {
                    map[i][j] += map2[i][j][counter]/multiplier;
                }
            }
        }
        
        return map;
    }
    
    public static double[][][] perlinCubic(int sizeX, int sizeY, int sizeZ, int initStep, int finalStep, double persistence) {
        final int power2 = (int)Math.ceil(log(2, bigger(sizeX,sizeY,sizeZ)));
        final double multiplier = geometric(initStep, (int)smaller(finalStep, power2), 1-persistence);
        double[][][] map = new double[sizeX][sizeY][sizeZ];
        for(int step = initStep; step <= smaller(finalStep, power2); step++) {
            double[][][] randomMap = randomMap((int)Math.pow(2,step) + 1, (int)Math.pow(2,step) + 1, (int)Math.pow(2,step) + 1);
            for(int i = 0; i < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); i++) {
                for(int j = 0; j < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); j++) {
                    for(int k = 0; k < Math.pow( 2, smaller(step, Math.ceil(log(2,sizeX))) ); k++) {
                        
                        for(int m = 0; m < Math.pow(2, power2-step); m++) {
                            for(int n = 0; n < Math.pow(2, power2-step); n++) {
                                for(int l = 0; l < Math.pow(2, power2-step); l++) {
                                    int x = i*(int)Math.pow(2, power2-step)+m;
                                    int y = j*(int)Math.pow(2, power2-step)+n;
                                    int z = k*(int)Math.pow(2, power2-step)+l;
                                    if(x < sizeX && y < sizeY && z < sizeZ) {
                                        map[x][y][z] += cubicInterpolate(
                                                randomMap[i+0][j+0][k+0], randomMap[i+1][j+0][k+0],
                                                randomMap[i+0][j+1][k+0], randomMap[i+1][j+1][k+0],
                                                randomMap[i+0][j+0][k+1], randomMap[i+1][j+0][k+1],
                                                randomMap[i+0][j+1][k+1], randomMap[i+1][j+1][k+1],
                                                (double)m/Math.pow(2, power2-step), (double)n/Math.pow(2, power2-step), (double)l/Math.pow(2, power2-step))         *Math.pow(1-persistence,step)/multiplier;
                                    }
                                }
                            }
                        }
                        
                    }
                }
            }
            System.out.println("Step: " + step);
        }
        
        return map;
    }
    
    public static double geometric(int n0, int n, double r) {
        double ans = 0;
        for(int i = n0; i <= n; i++) {
            ans += Math.pow(r, i);
        }
        return ans;
    }
    
    public static double decimalDifference(double d) {
        return d - Math.floor(d);
    }
    
    public static double spherical(double low, double high, double d) {
        return Math.tan((2*(d-low)/(high-low)-1)*Math.PI/4);
    }
    
    public static double range(double[][] ds) {
        double high = ds[0][0];
        for(int i = 0; i < ds.length; i++) {
            for(int j = 0; j < ds[0].length; j++) {
                if(ds[i][j] > high) {high = ds[i][j];}
            }
        }
        double low = ds[0][0];
        for(int i = 0; i < ds.length; i++) {
            for(int j = 0; j < ds[0].length; j++) {
                if(ds[i][j] < low) {low = ds[i][j];}
            }
        }
        return high-low;
    }
    public static double highest(double[][] ds) {
        double high = ds[0][0];
        for(int i = 0; i < ds.length; i++) {
            for(int j = 0; j < ds[0].length; j++) {
                if(ds[i][j] > high) {high = ds[i][j];}
            }
        }
        return high;
    }
    public static double lowest(double[][] ds) {
        double low = ds[0][0];
        for(int i = 0; i < ds.length; i++) {
            for(int j = 0; j < ds[0].length; j++) {
                if(ds[i][j] < low) {low = ds[i][j];}
            }
        }
        return low;
    }
    
    public static double cloudExpCurve(double v){
        double c = v - 128;
        if(c < 0) {c=0;}
        return (Math.pow(0.99, c) * 255);
    }
    
}