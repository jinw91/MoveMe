package app.moveme.moveme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ViewFlipper;

/**
 * Created by Daniel on 1/14/2018.
 */

public class MoveeWorkflowActivity extends AppCompatActivity {


	private static final int MAX_MOVERS = 10;

	private ViewFlipper workflowVF;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movee_workflow);


		workflowVF = (ViewFlipper) findViewById(R.id.moveeVF);
		Button nextButton = (Button) findViewById(R.id.movee_schedule_location_button_next_step);
		Button backButton = (Button) findViewById(R.id.movee_scheduling_people_button_prev);
		NumberPicker numMovers = findViewById(R.id.movee_people_number_picker);


		numMovers.setMinValue(0);
		numMovers.setValue(1);
		numMovers.setMaxValue(MAX_MOVERS);


		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				workflowVF.setInAnimation(getApplicationContext(), R.anim.transition_in_from_right);
				workflowVF.setOutAnimation(getApplicationContext(), R.anim.transition_out_to_left);
				workflowVF.showNext();
			}
		});

		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				workflowVF.setInAnimation(getApplicationContext(), R.anim.transition_in_from_left);
				workflowVF.setOutAnimation(getApplicationContext(), R.anim.transition_out_to_right);
				workflowVF.showPrevious();
			}
		});

	}
}
