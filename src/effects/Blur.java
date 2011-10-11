package effects;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.Node;
import javafx.scene.effect.BoxBlur;
import javafx.util.Duration;

public class Blur extends BasicAnimation {

	private int steps = 10;
	private double blur = 3;
	
	public Blur(Node target) {
		super(target, 400);
		initAnimation();
	}

	private void initAnimation() {
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.ZERO,
						new KeyValue(target.effectProperty(), null)
				));

		for (int i = 0; i < steps; i++) {
			double currentBlur = (i+1)*(blur/(double)(steps));
			timeline.getKeyFrames().add(
					new KeyFrame(
							new Duration((i+1)*(duration/(double)(steps))),
							new KeyValue(target.effectProperty(), new BoxBlur(currentBlur, currentBlur, 3))
							)
			);					
		}
	}

}
