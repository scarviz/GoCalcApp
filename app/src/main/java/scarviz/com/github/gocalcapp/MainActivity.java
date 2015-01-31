package scarviz.com.github.gocalcapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import go.Go;
import go.calc.Calc;


public class MainActivity extends ActionBarActivity {
	private class Operator{
		public static final int PLUS = 1;
		public static final int MINUS = 2;
		public static final int MULTI = 3;
		public static final int DIV = 4;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Go.init(getApplicationContext());

		(findViewById(R.id.btnPlus)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(Operator.PLUS);
			}
		});

		(findViewById(R.id.btnMinus)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(Operator.MINUS);
			}
		});

		(findViewById(R.id.btnMulti)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(Operator.MULTI);
			}
		});

		(findViewById(R.id.btnDiv)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(Operator.DIV);
			}
		});
	}

	private void calc(int operator){
		String val1 = ((TextView)findViewById(R.id.editText)).getText().toString();
		String val2 = ((TextView)findViewById(R.id.editText2)).getText().toString();

		int num1 = Integer.parseInt(val1);
		int num2 = Integer.parseInt(val2);

		String ret = "";
		switch (operator){
			case Operator.PLUS:
				ret = String.valueOf(Calc.Plus(num1, num2));
				break;
			case Operator.MINUS:
				ret = String.valueOf(Calc.Minus(num1, num2));
				break;
			case Operator.MULTI:
				ret = String.valueOf(Calc.Multi(num1, num2));
				break;
			case Operator.DIV:
				ret = String.valueOf(Calc.Div(num1, num2));
				break;
		}

		((TextView)findViewById(R.id.result)).setText(ret);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
