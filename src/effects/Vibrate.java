package effects;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.util.Duration;

public class Vibrate extends BasicAnimation {

	private int steps = 20;
	private double maxDelta = 3;
	private Orientation orientation = null;
	
	public Vibrate(Node target) {
		this(target, null);
	}
	
	
	public Vibrate(Node target, Orientation orientation) {
		super(target, 500);
		this.orientation = orientation;
		initAnimation();
	}
	
	

	private void initAnimation() {
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,
						new KeyValue(target.translateXProperty(), 0),
						new KeyValue(target.translateYProperty(), 0)
				),
				new KeyFrame(new Duration(duration),
						new KeyValue(target.translateXProperty(), 0),
						new KeyValue(target.translateYProperty(), 0)
				)
				);

		for (int i = 0; i < steps - 1; i++) {
			double deltaX = 0;
			double deltaY = 0;
			if(orientation == null) {
				deltaX = 2*maxDelta * Math.random() - maxDelta;
				deltaY = 2*maxDelta * Math.random() - maxDelta;
			} else if (orientation == Orientation.HORIZONTAL) {
				deltaX = Math.pow(-1, i) * maxDelta;
			} else if (orientation == Orientation.VERTICAL) {
				deltaY = Math.pow(-1, i) * maxDelta;
			}
			final Duration stepDuration = new Duration((i+1)*(duration/(double)(steps)));
			KeyValue[] keyValues = new KeyValue[2];
			if(orientation == null || orientation == Orientation.HORIZONTAL) {
				keyValues[0] = new KeyValue(target.translateXProperty(), deltaX);
			}
			if(orientation == null || orientation == Orientation.VERTICAL) {
				keyValues[1] = new KeyValue(target.translateYProperty(), deltaY);
			}
			KeyFrame keyFrame = new KeyFrame(stepDuration, keyValues);
			timeline.getKeyFrames().add(keyFrame);
		}
	}
	
	

}
