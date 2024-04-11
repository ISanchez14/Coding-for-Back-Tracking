/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nqueens;            //telling the programing software to use the NQueens class
import java.util.Scanner;    //the import for reading inputs from user
public class NQueens         //class contains all the code
{
    public static void main(String[] args) 
    {
        Scanner reading=new Scanner(System.in);                    //User input for number of queens
        System.out.println("Enter the number of queens, n");    //Statement that the user will see
        int n=reading.nextInt();                                    //reading the input that the user gives
        char board[][]=new char[n][n];                    //creating the board with
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)                            //Filling the board - for the blank spaces
                board[i][j]='-';
        if(placingNQueens(board,0,n)) testing(board,n);      //in case the user puts an input that is too small and doesnt a solution
        else System.out.println("No solution exists");
    }
    public static void testing(char board[][], int n)        //filling the queens into the board to test if board will work
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(" "+board[i][j]+" ");
            System.out.println();
        }
    }
    public static boolean openSpaces(char board[][], int row, int column, int n)
    {                                                        //using predefined variables and testing for placement for queen in board
        int i,j;
        for(i=0;i<column;i++)                            //Testing for if a queen is present in a row
        {
            if(board[row][i]=='Q') return false;        //Move onto next loop for next testing place since queen is present
        }
        for(i=row,j=column; i>=0 && j>=0;i--,j--)        //Testing for if a queen is in the column
        {
            if(board[i][j]=='Q') return false;        // Move onto next loop for next testing place since queen is present
        }
        for(i=row,j=column; i<n && j>=0;i++,j--)        //testing for if a queen is in diagonal placement
        {
            if(board[i][j]=='Q') return false;            //Move onto next loop for next testing place since  queen is present
        }
        return true;
    }
    public static boolean placingNQueens(char board[][], int column, int n)        //Placeing the queen when the parameters are meet
    {
        if(column>=n) return true;
        for(int i=0;i<n;i++)
        {
            if(openSpaces(board,i,column,n))
            {
                board[i][column]='Q';
                if(placingNQueens(board, column+1,n)) return true;
                board[i][column]='-';
            }
        }
        return false;
    }
}
