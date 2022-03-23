package chess;

import chess.domain.board.Board;

public class WebApplication {
	public static void main(String[] args) {
		// get("/", (req, res) -> {
		//     Map<String, Object> model = new HashMap<>();
		//     return render(model, "index.html");
		// });

		Chess chess = new Chess(Board.createInitialBoard());
		chess.start();
	}

	// private static String render(Map<String, Object> model, String templatePath) {
	//     return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	// }
}
