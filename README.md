# Queens problem
The queens problem is as followed:
If you have an n x n chess board, how can you distribute n queens so they cannot attack each other.

This is a Java program that gives all possible solutions to the problem via backtracking implementation.

## General logic
* Create an n x n integer array with all values set to 0. The numbers represent how many queens can move to that spot.
* In each column, check if any spot is safe to place a queen. If it is, mark that spot and then increment every index in the same row, column, or diagonal.
* Make recursive calls to check the next column. If all columns have a queen set, print the board.
* Once all choices for a column have been exhausted, return to the previous column.