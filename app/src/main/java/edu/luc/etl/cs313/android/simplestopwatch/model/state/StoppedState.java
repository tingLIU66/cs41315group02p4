package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class StoppedState implements SimpleTimerState {

    public StoppedState(final SimpleTimerSMStateView sm) {
        this.sm = sm;
    }

    private final SimpleTimerSMStateView sm;

    @Override
    public void onIncrement() {
        sm.toIncrementState();
       // sm.updateButtonName();
    }
    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }

    @Override
    public int getValue()
    {
        return 0; //return sm.getValue();
    }

    @Override
    public void updateView() {
            sm.updateUIRuntime();
    }


    //@Override
    //public void onIncrement(){}

     @Override
     public void onCancel(){}  //do nothing

    @Override
    public void onStop(){}       //do nothing
}
