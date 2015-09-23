// 
// Name: Lee, Jong 
// Project: #3 
// Due: 12/9/14 
// Course: CS 331
// 
// Description: 
// Project 3 requires us to implement the iterative version of matrix multiplication
// and Strassen's algorithm and compare the two algorithms.
//

public class MatrixMultiplication{

//The iterative version of matrix multiplication
  public int[][] classic(int [][] a, int [][] b) {
    int number = a.length;
    int [][] c = new int[number][number];

    for (int i = 0; i < number; ++i) {
      for (int j = 0; j < number; ++j) {
        for (int k = 0; k < number; ++k) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }


  //Implement the divide and conquer algorithm
  public int[][] divideConquer(int[][] a, int[][] b){
    int number = a.length;
    int d = number / 2;
    int [][] c = new int[number][number];

    if (number == 1) {
      c[0][0] = a[0][0] * b[0][0];
    }
    
    else {

      int [][][][] x = new int[2][4][d][d];
      int [][][] z = new int[4][d][d];
      this.split(x,a,b);

      z[0] = add(divideConquer(x[0][0],x[1][0]), divideConquer(x[0][1],x[1][2]));
      z[1] = add(divideConquer(x[0][0],x[1][1]), divideConquer(x[0][1],x[1][3]));
      z[2] = add(divideConquer(x[0][2],x[1][0]), divideConquer(x[0][3],x[1][2]));
      z[3] = add(divideConquer(x[0][2],x[1][1]), divideConquer(x[0][3],x[1][3]));

      c = reconstruct(z);
    }

    return c;
  }

  //Strassen Algorithm
  public int[][] strassen(int [][] a, int [][] b) {
    int number = a.length;
    int q = number / 2;
    int [][] c = new int[number][number];

    if (number == 1) {
      c[0][0] = a[0][0] * b[0][0];
    }
    else {

      int [][][][] x = new int[2][4][q][q];
      int [][][] p = new int[7][q][q];
      int [][][] z = new int[4][q][q];
      this.split(x,a,b);

      p[0] = strassen(add(x[0][0], x[0][3]), add(x[1][0], x[1][3]));
      p[1] = strassen(add(x[0][2], x[0][3]), x[1][0]);
      p[2] = strassen(x[0][0], subtract(x[1][1], x[1][3]));
      p[3] = strassen(x[0][3], subtract(x[1][2], x[1][0]));
      p[4] = strassen(add(x[0][0], x[0][1]), x[1][3]);
      p[5] = strassen(subtract(x[0][2], x[0][0]), add(x[1][0], x[1][1]));
      p[6] = strassen(subtract(x[0][1], x[0][3]), add(x[1][2], x[1][3]));

      z[0] = add(subtract(add(p[0],p[3]),p[4]),p[6]);
      z[1] = add(p[2],p[4]);
      z[2] = add(p[1],p[3]);
      z[3] = add(subtract(add(p[0],p[2]),p[1]),p[5]);
    
      c = reconstruct(z);
    }
  
    return c;
  }

  //Splits the matrices
  public void split(int [][][][] m, int [][] a, int [][] b) {
    int n = m[0][0].length;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        m[0][0][i][j] = a[i][j];
        m[0][1][i][j] = a[i][j+n];
        m[0][2][i][j] = a[i+n][j];
        m[0][3][i][j] = a[i+n][j+n];
        m[1][0][i][j] = b[i][j];
        m[1][1][i][j] = b[i][j+n];
        m[1][2][i][j] = b[i+n][j];
        m[1][3][i][j] = b[i+n][j+n];
      }  
    }
  }

  //Adding the elements in the matrix
  public int[][] add(int [][] a, int [][] b) {
    int n = a.length;
    int [][] c = new int[n][n];
    
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    return c;
  }

  //Subtracting the elements in the matrix
  public int[][] subtract(int [][] a, int [][] b) {
    int n = a.length;
    int [][] c = new int[n][n];
    
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        c[i][j] = a[i][j] - b[i][j];
      }
    }
    return c;
  }

  //Reconstruct the matrix back together
  public int[][] reconstruct(int [][][] m) {
    int q = m[0].length;
    int n = q * 2;
    int [][] z = new int[n][n];

    for (int i = 0; i < q; ++i) {
      for (int j = 0; j < q; ++j) {
        z[i][j] = m[0][i][j];
        z[i][j+q] = m[1][i][j];
        z[i+q][j] = m[2][i][j];
        z[i+q][j+q] = m[3][i][j];  
      }
    }
    return z;
  }

  //Print the matrix
  public void print(int [][] m) {
    for (int [] i : m) {
      for (int j : i) {
        System.out.printf("%d ",j);
      } 
      System.out.println();
    }
  }

  //Generate the matrices
  public int [][] generate(int number, int seed) {
    int [][] z = new int[number][number];
    for (int i = 0; i < number; ++i) {
      for (int j = 0; j < number; ++j) {
        z[i][j] = seed;
      }
    }
    return z;
  }

  public static void main(String[] args) {
    MatrixMultiplication matrix = new MatrixMultiplication();
    long start;
    long end;
    long time;
    int size = 0;
    int max = 13;
    int [][] a;
    int [][] b;


//    System.out.println("------------Iterative Algorithm------------");
//    for(int i = 1; i < max; ++i) {
//      size = (int) Math.pow(2,i);
//      a = matrix.generate(size, 2);
//      b = matrix.generate(size, 2);
//
//      start = System.currentTimeMillis();
//      matrix.classic(a,b);
//      end = System.currentTimeMillis();
//      time = end - start;
//      
//      System.out.printf("Size: %4d | Execution Time: %8d ns\n", size, time);
//    }

//    System.out.println("------------Divide and Conquer Algorithm------------");
//    for (int i = 1; i < max; ++i) {
//      size = (int) Math.pow(2,i);
//      a = matrix.generate(size, 2);
//      b = matrix.generate(size, 2);
//
//      start = System.currentTimeMillis();
//      matrix.divideConquer(a,b);
//      end = System.currentTimeMillis();
//      time = end - start;
//      
//      System.out.printf("Size: %4d | Execution Time: %8d ms\n", size, time);
//    }

    System.out.println("------------Strassen's Algorithm------------");
    for (int i = 1; i < max; ++i) {
      size = (int)Math.pow(2,i);
      a = matrix.generate(size, 2);
      b = matrix.generate(size, 2);

      start = System.currentTimeMillis();
      matrix.strassen(a,b);
      end = System.currentTimeMillis();
      time = end - start;
      
      System.out.printf("Size: %4d | Execution Time: %8d ms\n", size, time);
    }

  }
  }