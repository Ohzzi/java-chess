package chess.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.domain.board.Column;
import chess.domain.board.Position;
import chess.domain.board.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RookTest {

    @DisplayName("입력된 방향에 대해")
    @Nested
    class DirectionTest {

        @DisplayName("유효하지 않으면 예외를 반환한다.")
        @Test
        void invalid_Direction() {
            Position current = new Position(Column.a, Row.FIRST);
            Position invalidTarget = new Position(Column.b, Row.THIRD);
            Rook rook = new Rook(Color.BLACK);

            assertThatThrownBy(() -> rook.findValidDirection(current, invalidTarget));
        }

        @DisplayName("유효하면 방향 객체를 반환한다.")
        @Test
        void valid_Direction() {
            Position current = new Position(Column.a, Row.FIRST);
            Position target = new Position(Column.a, Row.THIRD);
            Rook rook = new Rook(Color.BLACK);

            Direction actual = rook.findValidDirection(current, target);

            assertThat(actual).isEqualTo(Direction.N);
        }
    }
}
