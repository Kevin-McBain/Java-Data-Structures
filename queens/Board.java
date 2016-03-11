package queens;
import list.*;


/**
 * I chess Board can have 0 or more queens in 
 * different positions
 * 
 * @author KWM
 * @version (a version number or a date)
 */
public class Board
{
    List <Position> queens; //These are the positions in which queens have been placed
    
    public Board()
    {
        queens = new LinkedList<Position>();
    }
    
    /** Copy Constructor **/
    public Board(Board b)
    {
        queens = new LinkedList<Position> (b.queens);
    }
    
    /**
     * Add a queen at the given position to this board
     */
    public void addQueen(Position p)
    {
        queens.add(p);
    }
    
    /**
     * Remove the queen in position p, from this Board
     */
    public void removeQueen(Position p)
    {
        queens.remove(p);
    }
    
    /**
     * @return true only if a queen on this Board is attacking some other queen
     */
    public boolean check()
    {
        Position p, other;
        Iterator<Position> itty1 = queens.iterator(),
                           itty2;
                           
        while(itty1.hasNext())
        {
            p = itty1.next();
            itty2 = queens.iterator();
            while(itty2.hasNext())
            {
                other = itty2.next();
                if(! p.equals(other))
                    if(p.isAttacking(other))
                        return true;
             
             }
         }
         return false;
    }
    
    public String toString()
    {
        String result = "";
        
        for(int row = 0; row <Game.SIZE; row++)
        {
            for(int col = 0; col < Game.SIZE; col++)
            {
                 if(queens.contains(new Position(row,col)))
                    result += 'Q';
                else
                    result += '.';
                }
            result += '\n';
        }
        return result;             
            
    }
}
