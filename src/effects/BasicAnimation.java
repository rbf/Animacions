package effects;

import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public abstract class BasicAnimation implements Animation {

	Node target;
	Timeline timeline = new Timeline();
	double duration;
	
	public BasicAnimation(Node target) {
		this(target, 1000);
	}

	public BasicAnimation(Node target, int durationMillis) {
		this.target = target;
		this.duration = durationMillis;
	}

	@Override
	public void play() {
		timeline.setCycleCount(1);
		timeline.setAutoReverse(false);
		timeline.play();
	}

	@Override
	public void stop() {
		timeline.stop();
	}
	
	@Override
	public void loop(int times) {
		timeline.setCycleCount(times);
		timeline.setAutoReverse(true);
		timeline.play();
	}
	
	@Override
	public void loopIndefinitely() {
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.play();
	}

	@Override
	public void playReversed() {
		timeline.setCycleCount(2);
		timeline.setAutoReverse(true);
		timeline.playFrom(new Duration(duration));
	}

	
}
