package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class RunningState implements SimpleTimerState {

    public RunningState(final SimpleTimerSMStateView sm) {
        this.sm = sm;
    }

    private final SimpleTimerSMStateView sm;

    @Override
    public void actionStart();

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
        sm.buttonChgToStop();
        sm.toAlarmState();
    }

    @Override
    public void actionUpdateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.RUNNING;
    }
}
