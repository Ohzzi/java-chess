package chess.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.domain.board.Column;
import chess.domain.board.Position;
import chess.domain.board.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueenTest {

    @DisplayName("입력된 방향에 대해")
    @Nested
    class DirectionTest {

        @DisplayName("유효하지 않으면 예외를 반환한다.")
        @Test
        void invalid_Direction() {
            Position current = new Position(Column.a, Row.FIRST);
            Position invalidTarget = new Position(Column.b, Row.THIRD);
            Queen queen = new Queen(Color.BLACK);

            assertThatThrownBy(() -> queen.findValidDirection(current, invalidTarget));
        }

        @DisplayName("유효하면 방향 객체를 반환한다.")
        @Test
        void valid_Direction() {
            Position current = new Position(Column.a, Row.FIRST);
            Position target = new Position(Column.c, Row.THIRD);
            Queen queen = new Queen(Color.BLACK);

            Direction actual = queen.findValidDirection(current, target);

            assertThat(actual).isEqualTo(Direction.NE);
        }
    }
}
