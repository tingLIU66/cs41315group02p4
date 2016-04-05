package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class RunningState implements SimpleTimerState {

    public RunningState(final SimpleTimerSMStateView sm) {
        this.sm = sm;
    }

    private final SimpleTimerSMStateView sm;

    @Override
    public void actionStart(){};

    @Override
    public void onTick() {
        sm.decrement();
        sm.toRunningState();
    }

    @Override
    public void onCancel() {
        sm.toStoppedState();
        sm.actionReset();
    }

    @Override
    public void onTimeUp() {
        sm.actionStop();
        sm.beep();
        sm.updateButtonName();
        sm.toAlarmState();
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.RUNNING;
    }

    @Override
    public void onIncrement(){}

    // @Override
    // public void onCancel(){}

    @Override
    public void onStop(){}

}

