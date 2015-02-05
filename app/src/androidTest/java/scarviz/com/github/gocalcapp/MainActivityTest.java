package scarviz.com.github.gocalcapp;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private MainActivity mActivity;
	private Instrumentation mInstrumentation;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
		mInstrumentation = getInstrumentation();

		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				EditText ed1 = (EditText)mActivity.findViewById(R.id.editText);
				EditText ed2 = (EditText)mActivity.findViewById(R.id.editText2);

				ed1.setText("3");
				ed2.setText("5");
			}
		});
		mInstrumentation.waitForIdleSync();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testOnClickPlus(){
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Button btn = (Button)mActivity.findViewById(R.id.btnPlus);
				btn.callOnClick();
			}
		});
		mInstrumentation.waitForIdleSync();

		TextView tv = (TextView)mActivity.findViewById(R.id.result);
		String result = tv.getText().toString();
		assertEquals("8", result);
	}

	public void testOnClickMinus(){
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Button btn = (Button)mActivity.findViewById(R.id.btnMinus);
				btn.callOnClick();
			}
		});
		mInstrumentation.waitForIdleSync();

		TextView tv = (TextView)mActivity.findViewById(R.id.result);
		String result = tv.getText().toString();
		assertEquals("-2", result);
	}

	public void testOnClickMulti(){
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Button btn = (Button)mActivity.findViewById(R.id.btnMulti);
				btn.callOnClick();
			}
		});
		mInstrumentation.waitForIdleSync();

		TextView tv = (TextView)mActivity.findViewById(R.id.result);
		String result = tv.getText().toString();
		assertEquals("15", result);
	}

	public void testOnClickDiv(){
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Button btn = (Button)mActivity.findViewById(R.id.btnDiv);
				btn.callOnClick();
			}
		});
		mInstrumentation.waitForIdleSync();

		TextView tv = (TextView)mActivity.findViewById(R.id.result);
		String result = tv.getText().toString();
		assertEquals("0.6", result);
	}
}