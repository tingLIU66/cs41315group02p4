package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class AlarmState implements SimpleTimerState {

    public AlarmState(final SimpleTimerSMStateView sm) {
        this.sm = sm;
    }

    private final SimpleTimerSMStateView sm;

    @Override
    public void onStop() {
        sm.stopBeeping();
        sm.updateButtonName();
        sm.toStoppedState();
    }

    @Override
    public void onBeep() {
        sm.beep();
    }

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.ALARM;
    }
}
    @Override
    public void onIncrement(){}
    public void onCancel(){}
    //public void onStop(){}