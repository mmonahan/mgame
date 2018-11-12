package org.mmonahan.mgame.lib;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Move;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

public interface Piece {

    String getID();

    Player getOwner();

    Move makeMove(Player player, Board board, Position fromPosition, Position toPosition);
}
