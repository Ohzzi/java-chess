package chess.service;

import chess.controller.dto.request.MoveRequest;
import chess.controller.dto.response.ChessGameResponse;
import chess.controller.dto.response.StatusResponse;
import chess.domain.ChessGame;
import chess.domain.board.Board;
import chess.domain.board.Column;
import chess.domain.board.Position;
import chess.domain.board.Row;
import chess.domain.board.strategy.CreateCompleteBoardStrategy;

public class ChessService {

    private static final int ROW_INDEX = 0;
    private static final int COLUMN_INDEX = 1;

    private ChessGame chessGame;

    public void createGame() {
        this.chessGame = new ChessGame(new Board(new CreateCompleteBoardStrategy()));
    }

    public ChessGameResponse startGame() {
        chessGame.start();
        return new ChessGameResponse(chessGame);
    }

    public ChessGameResponse move(final MoveRequest moveRequest) {
        final Position start = parseStringToPosition(moveRequest.getStart());
        final Position target = parseStringToPosition(moveRequest.getTarget());
        chessGame.move(start, target);
        return new ChessGameResponse(chessGame);
    }

    public StatusResponse status() {
        return new StatusResponse(chessGame.createStatus());
    }

    public ChessGameResponse end() {
        chessGame.end();
        return new ChessGameResponse(chessGame);
    }

    private Position parseStringToPosition(final String rawPosition) {
        final String[] separatedPosition = rawPosition.split("");
        final Column column = Column.from(separatedPosition[ROW_INDEX]);
        final Row row = Row.from(separatedPosition[COLUMN_INDEX]);
        return new Position(column, row);
    }
}
