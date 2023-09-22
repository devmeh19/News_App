package com.gtappdevelopers.news;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static String API_KEY="a854fbe6889644c9876782fbdef65ee6";
    private static String TAG="MainActivity";


    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;


    private ArrayList<NewsArticle> mArticleList;

    private ArticleAdapter mArticleAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AndroidNetworking.initialize(getApplicationContext());


        AndroidNetworking.setParserFactory(new JacksonParserFactory());

        mProgressBar=(ProgressBar)findViewById(R.id.progressbar_id);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview_id);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mArticleList=new ArrayList<>();


        get_news_from_api();
    }

    public void get_news_from_api(){

        mArticleList.clear();


        AndroidNetworking.get("https://newsapi.org/v2/top-headlines")
                .addQueryParameter("country", "in")
                .addQueryParameter("apiKey",API_KEY)
                .addHeaders("token", "1234")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener(){
                    @Override
                    public void onResponse(JSONObject response) {

                        mProgressBar.setVisibility(View.GONE);



                    };