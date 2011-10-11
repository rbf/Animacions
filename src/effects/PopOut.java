package effects;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.Node;
import javafx.util.Duration;

public class PopOut extends BasicAnimation {

	public PopOut(Node target) {
		this(target, 500);
	}

	public PopOut(Node target, int durationMillis) {
		super(target, durationMillis);
		initAnimation();
	}

	private void initAnimation() {
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,
						new KeyValue(target.scaleXProperty(), 1),
						new KeyValue(target.scaleYProperty(), 1),
						new KeyValue(target.opacityProperty(), 1)
						
				),
				new KeyFrame(new Duration(duration),
						new KeyValue(target.scaleXProperty(), 6, Interpolator.EASE_BOTH),
						new KeyValue(target.scaleYProperty(), 6, Interpolator.EASE_BOTH),
						new KeyValue(target.opacityProperty(), 0, Interpolator.EASE_BOTH)
				)
		);
	}

	

}
