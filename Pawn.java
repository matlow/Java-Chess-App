public class Pawn extends Piece {
  public Pawn() {
    super();
    super.setType(Piece.PAWN);
  }
  
  public Pawn(int x, int y, int w) {
    super(x, y, w);
    super.setType(Piece.PAWN);
  }
  
  public Pawn(int x, int y, int w, int team) {
    super(x, y, w, team);
    super.setType(Piece.PAWN);
  }
  
  public boolean getValidSquares(int oldX, int oldY, int newX, int newY,
      Team team, Piece[][] board) {
    int dx = newX - oldX;
    int dy = newY - oldY;
    
    if (team.color == Team.WHITE) {
      if ((dx == 0) && (dy == -1) && board[newX - 1][newY - 1] == null) {
        return true;
      }
      else if (((dx == 0) && (oldY == 7) && (newY == 5)) &&
          board[newX - 1][newY - 1] == null
          && board[newX - 1][newY - 2] == null) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      if ((dx == 0) && (dy == 1) && board[newX - 1][newY - 1] == null) {
        return true;
      }
      else if (((dx == 0) && (oldY == 2) && (newY == 4)) &&
          board[newX - 1][newY - 1] == null
          && board[newX - 1][newY - 2] == null) {
        return true;
      }
      else {
        return false;
      }
    }
  }

  public boolean getAttackSquares(int oldX, int oldY, int newX, int newY,
      Team team, Piece[][] board) {
    int dx = newX - oldX;
    int dy = newY - oldY;
    
    if (team.color == Team.WHITE) {
      if (((dx == 1) || (dx == -1)) && (dy == -1)
          && (board[newX - 1][newY - 1] != null)
          && (board[newX - 1][newY - 1].getTeam() != team.color)) {
        return true;
      }
    }
    else {
      if (((dx == 1) || (dx == -1)) && (dy == 1)
          && (board[newX - 1][newY - 1] != null)
          && (board[newX - 1][newY - 1].getTeam() != team.color)) {
        return true;
      }
    }
    
    return false;
  }
}
