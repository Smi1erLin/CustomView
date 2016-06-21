package echohce.cn.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import echohce.cn.customview.view.WeiboLoadingView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private WeiboLoadingView loadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        loadingView = (WeiboLoadingView) findViewById(R.id.loadingView);

        loadingView.setProgress(60);
    }
}
