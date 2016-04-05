package edu.luc.etl.cs313.android.simplestopwatch.model;

import edu.luc.etl.cs313.android.simplestopwatch.common.SimpleTimerUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.DefaultClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.counter.BoundedCounterModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.counter.DefaultBoundedCounterModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.DefaultSimpleTimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.SimpleTimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.DefaultTimeModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the model facade.
 *
 * @author laufer
 */
public class ConcreteSimpleTimerModelFacade implements SimpleTimerModelFacade {

    private SimpleTimerStateMachine stateMachine;

    private ClockModel clockModel;

    private TimeModel timeModel;

    private BoundedCounterModel boundedcounterModel;

    public ConcreteSimpleTimerModelFacade() {
        timeModel = new DefaultTimeModel();
        clockModel = new DefaultClockModel();
        boundedcounterModel = new DefaultBoundedCounterModel(0,99);  //added 0n 4/4/2016
        stateMachine = new DefaultSimpleTimerStateMachine(timeModel, clockModel, boundedcounterModel);  ////added 0n 4/4/2016
        clockModel.setOnTickListener(stateMachine);
    }

    @Override
    public void onStart() {
        stateMachine.actionInit();
    }

    @Override
    public void setUIUpdateListener(final SimpleTimerUIUpdateListener listener) {
        stateMachine.setUIUpdateListener(listener);
    }

    @Override
    public int getValue() { return stateMachine.getValue();}   //added on 4/4/2016

    @Override
    public void onIncrement() {
        stateMachine.onIncrement();
    }

    @Override
    public void onCancel() {
        stateMachine.onCancel();
    }

    @Override
    public void onStop() {
        stateMachine.onStop();
    }

}
