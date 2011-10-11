package effects;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.Node;
import javafx.util.Duration;

public class Beat extends BasicAnimation {

	public Beat(Node target) {
		super(target, 100);
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
						new KeyValue(target.scaleXProperty(), 1.2, Interpolator.EASE_BOTH),
						new KeyValue(target.scaleYProperty(), 1.2, Interpolator.EASE_BOTH),
						new KeyValue(target.opacityProperty(), 0.9, Interpolator.EASE_BOTH)
				)
		);
	
	}

}
