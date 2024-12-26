package com.example.educationalprojects.mineSweeper;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int rowNumber;
    int columnNumber;
    int minesNumber;
    String[][] board;
    String[][] minesBoard;
    int counterMines = 0;
    int row;
    int column;
    int correctAnswer = 0;

    public MineSweeper(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.minesNumber = (rowNumber * columnNumber) / 4;
        this.board = new String[rowNumber][columnNumber];
        this.minesBoard = new String[rowNumber][columnNumber];
    }

    void boardFill() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.columnNumber; j++) {
                this.board[i][j] = "-";
            }
        }
    }

    void showBoardFill() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.columnNumber; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void fillMinesArea() {
        Random rand = new Random();

        while (this.counterMines < this.minesNumber) {
            int r = rand.nextInt(this.rowNumber);
            int c = rand.nextInt(this.columnNumber);
            if (this.minesBoard[r][c] == null) {
                this.minesBoard[r][c] = "*"; // Place a mine
                this.counterMines++;
            }
        }

        // Initialize the rest of the minesBoard with "-"
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.columnNumber; j++) {
                if (this.minesBoard[i][j] == null) {
                    this.minesBoard[i][j] = "-";
                }
            }
        }
    }

    void showMinesArea() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.columnNumber; j++) {
                if (this.minesBoard[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(this.minesBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    void findMines() {
        int rowMinLimit = Math.max(0, this.row - 1);
        int rowMaxLimit = Math.min(this.row + 1, this.rowNumber - 1);
        int columnMinLimit = Math.max(0, this.column - 1);
        int columnMaxLimit = Math.min(this.column + 1, this.columnNumber - 1);
        int mineCount = 0;

        for (int i = rowMinLimit; i <= rowMaxLimit; i++) {
            for (int j = columnMinLimit; j <= columnMaxLimit; j++) {
                if (this.minesBoard[i][j] != null && this.minesBoard[i][j].equals("*")) {
                    mineCount++;
                }
            }
        }

        this.board[this.row][this.column] = Integer.toString(mineCount);
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        this.fillMinesArea();
        this.showMinesArea();
        this.boardFill();

        while (this.correctAnswer < (this.rowNumber * this.columnNumber) - this.minesNumber) {
            System.out.println("WELCOME TO MINESWEEPER ");
            this.showBoardFill();
            System.out.println("Enter the row area :");
            this.row = sc.nextInt();
            System.out.println("Enter the column area :");
            this.column = sc.nextInt();

            if (this.row >= 0 && this.row < this.rowNumber && this.column >= 0 && this.column < this.columnNumber) {
                if (!this.board[this.row][this.column].equals("-")) {
                    System.out.println("You already entered this area ");
                } else {
                    if (this.minesBoard[this.row][this.column].equals("*")) {
                        this.showMinesArea();
                        System.out.println("You lost the game !");
                        break;
                    } else {
                        this.findMines();
                        this.correctAnswer++;
                        if (this.correctAnswer == (this.rowNumber * this.columnNumber) - this.minesNumber) {
                            this.showBoardFill();
                            System.out.println("Congratulations ! ");
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Invalid row or column! Please enter again.");
            }
        }
    }
}
















