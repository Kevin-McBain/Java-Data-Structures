package queens;


/**
 * Write a description of class Position here.
 * 
 * @author Kevin McBain
 * @version (a version number or a date)
 */
public class Position
{
    int row, col;
    
    public Position(int r, int c)
    {
        row = r;
        col = c;
    }
    
    /**
     * @return true only if obj is a position
     * and has the same row and column as this position.
     */
    public boolean equals (Object obj)
    {
        if(obj == null || !(obj instanceof Position))
        { return false;}
        
        Position other = (Position) obj;
        return row == other.row && col == other.col;
    }
    
    /**
     * @return true only if this Position is attacking 
     * the other Position
     */
    public boolean isAttacking(Position other)
    {
        return sameRow(other) || sameCol(other) || majorDiag(other) || minorDiag(other);
    }
    
    private boolean sameRow(Position other)
    {
        return row == other.row;
    }
    private boolean sameCol(Position other)
    {
        return col == other.col;
    }
    private boolean majorDiag(Position other)
    {
        return row+col == other.row + other.col;
    }
    private boolean minorDiag(Position other)
    {
        return row-col == other.row - other.col;
    }
    
    public String toString()
    {
        return "(" + row + "," + col + ")\n";
    }
    
}
